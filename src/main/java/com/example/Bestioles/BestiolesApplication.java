package com.example.Bestioles;

import com.example.Bestioles.model.Animal;
import com.example.Bestioles.model.Person;
import com.example.Bestioles.model.Species;
import com.example.Bestioles.repository.AnimalRepository;
import com.example.Bestioles.repository.PersonRepository;
import com.example.Bestioles.repository.SpeciesRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class BestiolesApplication implements CommandLineRunner {

	private final PersonRepository personRepository;
	private final AnimalRepository animalRepository;
	private final SpeciesRepository speciesRepository;

	@Autowired
	public BestiolesApplication(PersonRepository personRepository, AnimalRepository animalRepository, SpeciesRepository speciesRepository) {
		this.personRepository = personRepository;
		this.animalRepository = animalRepository;
		this.speciesRepository = speciesRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(BestiolesApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Liste des personnes : ");
		List<Person> persons = personRepository.findAll();
		persons.forEach(System.out::println);
		System.out.println("Liste des animaux : ");
		List<Animal> animals = animalRepository.findAll();
		animals.forEach(System.out::println);
		System.out.println("Liste des especes : ");
	    List<Species> species = speciesRepository.findAll();
		species.forEach(System.out::println);
	}
}