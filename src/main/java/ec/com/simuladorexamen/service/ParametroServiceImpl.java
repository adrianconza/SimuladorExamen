package ec.com.simuladorexamen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.com.simuladorexamen.dao.ParametroDao;
import ec.com.simuladorexamen.entity.Parametro;

@Service
public class ParametroServiceImpl implements ParametroService {

	@Autowired
	private ParametroDao parametroDao;

	public void actualizar(Parametro parametro) {
		parametroDao.actualizar(parametro);
	}

	public Parametro obtener() {
		return parametroDao.obtenerObjeto("select p from Parametro p where p.id=1", new Object[] {}, false,
				new Object[] {});
	}
}
