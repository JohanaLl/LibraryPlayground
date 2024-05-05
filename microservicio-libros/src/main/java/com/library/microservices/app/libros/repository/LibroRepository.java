package com.library.microservices.app.libros.repository;

import org.springframework.data.repository.CrudRepository;

import com.library.microservices.app.commonlibros.entity.Libro;

public interface LibroRepository extends  CrudRepository<Libro, Long> {

}
