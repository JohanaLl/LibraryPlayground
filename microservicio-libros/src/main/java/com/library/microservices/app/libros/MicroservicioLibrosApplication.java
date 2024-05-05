package com.library.microservices.app.libros;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
@EntityScan({"com.library.microservices.app.commonlibros.entity"})
public class MicroservicioLibrosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioLibrosApplication.class, args);
	}

}
