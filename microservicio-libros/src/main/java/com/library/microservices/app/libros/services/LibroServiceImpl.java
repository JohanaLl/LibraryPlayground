package com.library.microservices.app.libros.services;

import org.springframework.stereotype.Service;

import com.library.microservices.app.commonlibros.entity.Libro;
import com.library.microservices.app.commons.services.CommonServiceImpl;
import com.library.microservices.app.libros.repository.LibroRepository;

@Service
public class LibroServiceImpl extends CommonServiceImpl<Libro, LibroRepository> implements LibroService {

}
