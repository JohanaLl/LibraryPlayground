package com.library.microservices.app.libros.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.library.microservices.app.commonlibros.entity.Libro;

public interface LibroRepository extends  CrudRepository<Libro, Long> {

	/**
	 * Método para encontrar libros según el autor
	 * @param name
	 * @return
	 */
	@Query(value = "SELECT l FROM Libro l WHERE l.author LIKE %?1%")
	public List<Libro> findBooksByAuthor(String author);
}
