package ec.com.simuladorexamen.service;

import org.springframework.transaction.annotation.Transactional;

import ec.com.simuladorexamen.entity.Usuario;

public interface UsuarioService extends GenericService<Usuario, String> {
	@Transactional
	public void actualizar(Usuario usuario);

	@Transactional
	public void enviarContrasena(Usuario usuario);

	@Transactional
	public void insertar(Usuario usuario);

	@Transactional(readOnly = true)
	public Usuario obtenerParaComprobacion(String numeroDocumento, String nombre, String apellidoPaterno,
			String apellidoMaterno, Integer carrera);

	@Transactional(readOnly = true)
	public Usuario obtenerPorCedula(String cedula);

	@Transactional(readOnly = true)
	public Usuario obtenerPorEmail(String email);

	@Transactional
	public Usuario obtenerParaLogin();

	@Transactional
	public Usuario obtenerParaLogout();

}