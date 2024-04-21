package com.library.microservices.app.prestamos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan({"com.library.microservices.app.commonusuarios.entity",
			 "com.library.microservices.app.prestamos.entity"})
public class MicroservicioPrestamosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioPrestamosApplication.class, args);
	}

}
