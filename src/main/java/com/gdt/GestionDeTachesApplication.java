package com.gdt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//@SpringBootApplication(exclude = SecurityAutoConfiguration.class ) // permet d'ignorer toute la couche de sécurité
@SpringBootApplication // permet d'ignorer toute la couche de sécurité
@EnableTransactionManagement
public class GestionDeTachesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionDeTachesApplication.class, args);
	}

}
