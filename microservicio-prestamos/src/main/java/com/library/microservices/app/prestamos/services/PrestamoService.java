package com.library.microservices.app.prestamos.services;

import java.util.List;

import com.library.microservices.app.commons.services.CommonService;
import com.library.microservices.app.prestamos.entity.Prestamo;

public interface PrestamoService extends CommonService<Prestamo> {

	/**
	 * Método para buscar prestamos por el id de usuario
	 * @param id
	 * @return List
	 */
	public List<Prestamo> findPrestamosByUserId(Long id);
}
