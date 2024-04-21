package com.library.microservices.app.prestamos.repository;

import org.springframework.data.repository.CrudRepository;

import com.library.microservices.app.prestamos.entity.Prestamo;


public interface PrestamoRepository extends CrudRepository<Prestamo, Long>{

}
