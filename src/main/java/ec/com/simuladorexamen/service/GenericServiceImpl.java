package ec.com.simuladorexamen.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ec.com.simuladorexamen.dao.GenericDao;

public class GenericServiceImpl<T, K extends Serializable> implements GenericService<T, K>, Serializable {

	private static final long serialVersionUID = 1L;

	@Autowired
	private GenericDao<T, K> genericDao;

	public List<T> obtenerLista(String consulta, Object[] valoresConsulta, Integer registrosMax, boolean mensaje,
			Object[] valoresInicializar) {
		return genericDao.obtenerLista(consulta, valoresConsulta, registrosMax, mensaje, valoresInicializar);
	}

	public List<T> obtenerListaDirecta(String consulta, Object[] valoresConsulta, Integer registrosMax, boolean mensaje,
			Object[] valoresInicializar) {
		return genericDao.obtenerListaDirecta(consulta, valoresConsulta, registrosMax, mensaje, valoresInicializar);
	}

	public List<T> obtenerPorSql(String consulta, Class<T> type) {
		return genericDao.obtenerPorSql(consulta, type);
	}

	public T obtenerObjeto(String consulta, Object[] valoresConsulta, boolean mensaje, Object[] valoresInicializar) {
		return genericDao.obtenerObjeto(consulta, valoresConsulta, mensaje, valoresInicializar);
	}
}