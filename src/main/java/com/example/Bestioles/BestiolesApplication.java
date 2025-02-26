package com.example.Bestioles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BestiolesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BestiolesApplication.class, args);

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("bestioles");
		EntityManager em = emf.createEntityManager();

	}

}
