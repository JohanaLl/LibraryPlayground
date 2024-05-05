package com.library.microservices.app.libros.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.library.microservices.app.commonlibros.entity.Libro;
import com.library.microservices.app.commons.services.CommonService;

public interface LibroService extends CommonService<Libro>{

	/**
	 * Método para encontrar libros según el autor
	 * @param name
	 * @return
	 */
	public List<Libro> findBooksByAuthor(String author);
}
