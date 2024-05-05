package com.library.microservices.app.prestamos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.microservices.app.commons.controllers.CommonController;
import com.library.microservices.app.prestamos.entity.Prestamo;
import com.library.microservices.app.prestamos.services.PrestamoService;


@RestController
@RequestMapping("/api/prestamo")
public class PrestamoController extends CommonController<Prestamo, PrestamoService>{

	 
	@PutMapping("/{id}")
	public ResponseEntity<?> editar(@RequestBody Prestamo prestamo, @PathVariable Long id) {
		Optional<Prestamo> optPrestamo = this.service.findById(id);
		
		if (!optPrestamo.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Prestamo prestamoDB = optPrestamo.get();
		prestamoDB.setEndDate(prestamo.getEndDate());
		prestamoDB.setUser(prestamo.getUser());
		prestamoDB.setDescription(prestamo.getDescription());
		prestamoDB.setState(prestamo.isState());
		prestamoDB.setPenalty(prestamo.getPenalty());
		prestamoDB.setBooksQuantity(prestamo.getBooksQuantity());
		prestamoDB.setBooks(prestamo.getBooks());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(prestamoDB));
	}
	
	/**
	 * Método para buscar prestamos por el id de usuario
	 */
	@GetMapping("/findByUser/{id}")
	public ResponseEntity<?> findPrestamosByUserId(@PathVariable Long id) {
		List<Prestamo> prestamos = this.service.findPrestamosByUserId(id);
		return ResponseEntity.ok(prestamos);
	}
}
