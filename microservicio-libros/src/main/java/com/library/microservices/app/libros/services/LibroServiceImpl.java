package com.library.microservices.app.libros.services;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.library.microservices.app.commonlibros.entity.Libro;
import com.library.microservices.app.commons.services.CommonServiceImpl;
import com.library.microservices.app.libros.repository.LibroRepository;

@Service
public class LibroServiceImpl extends CommonServiceImpl<Libro, LibroRepository> implements LibroService {

	/**
	 * Método para encontrar libros según el autor
	 * @param name
	 * @return
	 */
	public List<Libro> findBooksByAuthor(String author)
	{
		return repository.findBooksByAuthor(author);
	}
}
