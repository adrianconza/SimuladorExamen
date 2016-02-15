package ec.com.simuladorexamen.service;

import org.springframework.transaction.annotation.Transactional;

import ec.com.simuladorexamen.entity.Usuario;

public interface EnvioCorreoService {

	@Transactional
	public void enviarContraseñaIngresoExamen(Usuario usuario, String contrasena);

}