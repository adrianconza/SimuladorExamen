package ec.com.simuladorexamen.service;

import org.springframework.transaction.annotation.Transactional;

import ec.com.simuladorexamen.entity.Parametro;

public interface ParametroService {
	@Transactional
	public void actualizar(Parametro parametro);

	@Transactional
	public Parametro obtener();

}
