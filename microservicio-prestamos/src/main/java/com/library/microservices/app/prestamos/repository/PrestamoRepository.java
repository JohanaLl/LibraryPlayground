package com.library.microservices.app.prestamos.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.library.microservices.app.prestamos.entity.Prestamo;


public interface PrestamoRepository extends CrudRepository<Prestamo, Long>{

	/**
	 * Método para buscar prestamos por el id de usuario
	 * @param id
	 * @return List
	 */
	@Query(value = "SELECT p FROM Prestamo p JOIN FETCH p.user u WHERE u.id = ?1")
	public List<Prestamo> findPrestamosByUserId(Long id);
	
}
