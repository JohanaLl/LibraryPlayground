package com.library.microservices.app.libros.controllers;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
}
