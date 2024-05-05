package com.library.microservices.app.prestamos.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.library.microservices.app.commons.services.CommonServiceImpl;
import com.library.microservices.app.prestamos.entity.Prestamo;
import com.library.microservices.app.prestamos.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl extends CommonServiceImpl<Prestamo, PrestamoRepository> implements PrestamoService{

	/**
	 * Método para buscar prestamos por el id de usuario
	 * @param id
	 * @return List
	 */
	public List<Prestamo> findPrestamosByUserId(Long id)
	{
		return repository.findPrestamosByUserId(id);
	}
}
