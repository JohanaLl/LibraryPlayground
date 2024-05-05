package com.library.microservices.app.libros.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.microservices.app.commonlibros.entity.Libro;
import com.library.microservices.app.commons.controllers.CommonController;
import com.library.microservices.app.libros.services.LibroService;

@RestController
@RequestMapping("/api/libros")
public class LibroController extends CommonController<Libro, LibroService>{

	@PutMapping("/{id}")
	public ResponseEntity<?> edit(@PathVariable Long id, @RequestBody Libro libro) {
		Optional<Libro> libroOp = service.findById(id);
		
		if (!libroOp.isPresent()) 
			return ResponseEntity.notFound().build();
		
		Libro libroDB = libroOp.get();
		libroDB.setTitle(libro.getTitle());
		libroDB.setAuthor(libro.getAuthor());
		libroDB.setCategory(libro.getCategory());
		libroDB.setReference(libro.getReference());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(service.save(libroDB));
	}
	
	/**
	 * Método para encontrar libros según el autor
	 * @param name
	 * @return
	 */
	@GetMapping("/booksByAuthor/{authorName}")
	public ResponseEntity<?> findBooksByAuthor(@PathVariable("authorName") String author) {
		List<Libro> libros = this.service.findBooksByAuthor(author);
		return ResponseEntity.ok(libros);
	}
}
