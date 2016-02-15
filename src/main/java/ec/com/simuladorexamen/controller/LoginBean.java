package ec.com.simuladorexamen.controller;

import java.io.IOException;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;

import ec.com.simuladorexamen.entity.Usuario;
import ec.com.simuladorexamen.service.ParametroService;
import ec.com.simuladorexamen.service.UsuarioService;
import ec.com.simuladorexamen.utilidades.UtilsAplicacion;

@Controller
@Scope("session")
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private ParametroService parametroService;

	private Usuario usuario;

	public Usuario getUsuario() {
		return usuario;
	}

	@PostConstruct
	public void init() {
		usuario = usuarioService.obtenerParaLogin();
		UtilsAplicacion.actualizar(parametroService.obtener());
	}

	public void logout() {
		SecurityContextHolder.clearContext();
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect("/exetasi/views/publicas/login.jsf");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}