package ec.com.simuladorexamen.service;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.simuladorexamen.entity.Usuario;
import ec.com.simuladorexamen.utilidades.UtilsAplicacion;
import ec.com.simuladorexamen.utilidades.UtilsMail;

@Service
public class EnvioCorreoServiceImpl implements EnvioCorreoService, Serializable {
	private static final long serialVersionUID = 1L;

	@Autowired
	private ParametroService parametroService;

	public void enviarContraseñaIngresoExamen(Usuario usuario, String contrasena) {
		String asunto = "CONTRASEÑA PARA EL INGRESO AL SIMULADOR";

		String detalle = "Estimad@ \n\nReciba un atento saludo.\n\nContraseña temporal: " + contrasena;
		try {
			UtilsAplicacion.actualizar(this.parametroService.obtener());
			UtilsMail.envioCorreo(usuario.getEmail(), asunto, detalle, null, UtilsAplicacion.parametro);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
