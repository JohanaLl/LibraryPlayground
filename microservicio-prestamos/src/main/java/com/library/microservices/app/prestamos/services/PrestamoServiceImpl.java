package com.library.microservices.app.prestamos.services;

import org.springframework.stereotype.Service;

import com.library.microservices.app.commons.services.CommonServiceImpl;
import com.library.microservices.app.prestamos.entity.Prestamo;
import com.library.microservices.app.prestamos.repository.PrestamoRepository;

@Service
public class PrestamoServiceImpl extends CommonServiceImpl<Prestamo, PrestamoRepository> implements PertamoService{

}
