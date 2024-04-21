package com.library.microservices.app.prestamos.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.library.microservices.app.commons.controllers.CommonController;
import com.library.microservices.app.prestamos.entity.Prestamo;
import com.library.microservices.app.prestamos.services.PertamoService;

@RestController
@RequestMapping("/api/prestamos")
public class PrestamoController extends CommonController<Prestamo, PertamoService>{

	@PutMapping("/id")
	public ResponseEntity<?> editar(@RequestBody Prestamo prestamo, @PathVariable Long id) {
		Optional<Prestamo> optPrestamo = this.service.findById(id);
		
		if (!optPrestamo.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		
		Prestamo prestamoDB = optPrestamo.get();
		prestamoDB.setEndDate(prestamo.getEndDate());
		
		return ResponseEntity.status(HttpStatus.CREATED).body(this.service.save(prestamoDB));
	}
}
