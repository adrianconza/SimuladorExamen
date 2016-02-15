package ec.com.simuladorexamen.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

public interface GenericService<T, K extends Serializable> {

	@Transactional(readOnly = true)
	public List<T> obtenerLista(String consulta, Object[] valoresConsulta, Integer registrosMax, boolean mensaje,
			Object[] valoresInicializar);

	@Transactional(readOnly = true)
	public List<T> obtenerListaDirecta(String consulta, Object[] valoresConsulta, Integer registrosMax, boolean mensaje,
			Object[] valoresInicializar);

	@Transactional(readOnly = true)
	public List<T> obtenerPorSql(String consulta, Class<T> type);

	@Transactional(readOnly = true)
	public T obtenerObjeto(String consulta, Object[] valoresConsulta, boolean mensaje, Object[] valoresInicializar);
}