package ec.com.simuladorexamen.controller;

import static ec.com.simuladorexamen.utilidades.UtilsAplicacion.presentaMensaje;

import java.io.Serializable;

import javax.faces.application.FacesMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import ec.com.simuladorexamen.entity.Usuario;
import ec.com.simuladorexamen.service.UsuarioService;
import ec.com.simuladorexamen.utilidades.UtilsAplicacion;

@Controller
@Scope("session")
public class ObtenerContrasenaBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioService usuarioService;

	private String email;

	public void obtenerContrasena() {
		if (email.isEmpty()) {
			presentaMensaje(FacesMessage.SEVERITY_WARN, "INGRESE SU CORREO ELECTRÓNICO");
		} else {
			Usuario usuario = usuarioService.obtenerObjeto("select u from Usuario u where u.email=?1",
					new Object[] { email.trim().toLowerCase() }, false, new Object[] {});
			if (usuario == null) {
				Usuario u = new Usuario();
				u.setEmail(email);
				usuarioService.insertar(u);
				usuario = u;
			}
			usuarioService.enviarContrasena(usuario);
			presentaMensaje(FacesMessage.SEVERITY_INFO, "LA CONTRASEÑA FUE ENVIADA AL CORREO REGISTRADO");
			UtilsAplicacion.redireccionar("login.jsf");
		}
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}