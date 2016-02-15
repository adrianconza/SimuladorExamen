package ec.com.simuladorexamen.service;

import static ec.com.simuladorexamen.utilidades.UtilSeguridad.generadorContrasena;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import ec.com.simuladorexamen.dao.UsuarioDao;
import ec.com.simuladorexamen.entity.Usuario;

@Service
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario, String> implements UsuarioService, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private UsuarioDao usuarioDao;

	@Autowired
	private ParametroService parametroService;

	@Autowired
	private EnvioCorreoService envioCorreoService;

	public void actualizar(Usuario usuario) {
		usuarioDao.actualizar(usuario);
	}

	public boolean compararClave(String clave1, String clave2) {
		return clave1.compareTo(clave2) == 0 ? true : false;
	}

	public void enviarContrasena(Usuario usuario) {
		String contrasena = generadorContrasena(15);
		usuario.setPassword(generarClave(contrasena));
		usuarioDao.actualizar(usuario);
		envioCorreoService.enviarContraseñaIngresoExamen(usuario, contrasena);

	}

	public String generarClave(String clave) {
		ShaPasswordEncoder shaPasswordEncoder = new ShaPasswordEncoder(256);
		return shaPasswordEncoder.encodePassword(clave, null);
	}

	public void insertar(Usuario usuario) {
		usuario.setRol("ESTU");
		usuarioDao.insertar(usuario);
	}

	public Usuario obtenerParaComprobacion(String numeroDocumento, String nombre, String apellidoPaterno,
			String apellidoMaterno, Integer carrera) {
		return usuarioDao.obtenerObjeto(
				"select u from Usuario u inner join u.estudiantesPeriodos ep inner join ep.periodoExamen pe inner join pe.carrera c where u.id=?1 and lower(u.nombre)=?2 and lower(u.apellidoPaterno)=?3 and lower(u.apellidoMaterno)=?4 and c.id=?5",
				new Object[] { numeroDocumento.trim(), nombre.trim().toLowerCase(),
						apellidoPaterno.trim().toLowerCase(), apellidoMaterno.trim().toLowerCase(), carrera },
				false, new Object[] {});
	}

	public Usuario obtenerPorCedula(String cedula) {
		return usuarioDao.obtenerObjeto(
				"select u from Usuario u left join fetch u.docentesAsignaturas da where u.id=?1",
				new Object[] { cedula.trim() }, false, new Object[] {});
	}

	public Usuario obtenerPorEmail(String email) {
		return usuarioDao.obtenerObjeto("select u from Usuario u where u.email=?1", new Object[] { email.trim() },
				false, new Object[] {});
	}

	public Usuario obtenerParaLogin() {
		return usuarioDao.obtenerObjeto("select u from Usuario u where u.email=?1",
				new Object[] { SecurityContextHolder.getContext().getAuthentication().getName().trim().toLowerCase() },
				false, new Object[] {});
	}

	public Usuario obtenerParaLogout() {
		return usuarioDao.obtenerObjeto("select u from Usuario u where u.email=?1",
				new Object[] { SecurityContextHolder.getContext().getAuthentication().getName().trim().toLowerCase() },
				false, new Object[] {});
	}

}