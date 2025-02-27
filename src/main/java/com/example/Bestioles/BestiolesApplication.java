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
import java.util.Set;

@SpringBootApplication
public class BestiolesApplication implements CommandLineRunner {

	private PersonRepository personRepository;
	private AnimalRepository animalRepository;
	private SpeciesRepository speciesRepository;

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

//		// Création des espèces
//		Species chien = new Species("Canis lupus", "Chien");
//		Species chat = new Species("Felis catus", "Chat");
//		speciesRepository.save(chien);
//		speciesRepository.save(chat);
//
//		// Création des animaux
//		Animal rex = new Animal("Rex", "Marron", "Mâle", chien);
//		Animal garfield = new Animal("Garfield", "Orange", "Mâle", chat);
//		animalRepository.save(rex);
//		animalRepository.save(garfield);
//
//		// Création des personnes
//		Person alice = new Person(25, "Alice", "Dupont", "alice", "alice");
//		Person bob = new Person(30, "Bob", "Martin", "bob", "bob");
//		personRepository.save(alice);
//		personRepository.save(bob);
//
//		// Liste des personnes
//		System.out.println("Liste des personnes avant supression : ");
//		List<Person> persons = personRepository.findAll();
//		persons.forEach(System.out::println);
//
//		// Liste des animaux
//		System.out.println("Liste des animaux avant supression : ");
//		List<Animal> animals = animalRepository.findAll();
//		animals.forEach(System.out::println);
//
//		// Liste des especes
//		System.out.println("Liste des especes avant supression : ");
//	    List<Species> species = speciesRepository.findAll();
//		species.forEach(System.out::println);
//
//		// Premiere personne
//		String person1 = personRepository.findById(1).toString();
//		System.out.println("Première personne : " + person1);
//
//		// Premier animal
//		String animal1 = animalRepository.findById(1).toString();
//		System.out.println("Premier animal : " + animal1);
//
//		// Premiere espece
//		String species1 = speciesRepository.findById(1).toString();
//		System.out.println("Première espece : " + species1);
//
//		// Suppression d'une personne
//		personRepository.deleteById(9);
//
//		// Suppression d'un animal
//		animalRepository.deleteById(20);
//
//		// Suppression d'une espece
//		speciesRepository.deleteById(17);
//
//		// Liste des personnes après supression
//		System.out.println("Liste des personnes après supression : ");
//		persons = personRepository.findAll();
//		persons.forEach(System.out::println);
//
//		// Liste des animaux après supression
//		System.out.println("Liste des animaux après supression : ");
//		animals = animalRepository.findAll();
//		animals.forEach(System.out::println);
//
//		// Liste des especes après supression
//		System.out.println("Liste des especes après supression : ");
//		species = speciesRepository.findAll();
//		species.forEach(System.out::println);

		// Recherche d'une espèce par nom commun
		Species species = speciesRepository.findFirstByCommonName("Lapin");
		System.out.println("Première espèce trouvée : " + species);

		// Recherche d'espèces par nom latin
		List<Species> matchingSpecies = speciesRepository.findByLatinName("chat");
		System.out.println("Espèces correspondantes : " + matchingSpecies);

		// Recherche d'une personne par nom ou prénom
		List<Person> peopleByName = personRepository.findByFirstnameOrLastname("Sophie", "Nero");
		System.out.println("Personne par nom ou prénom : " + peopleByName);

		// Recherche de personnes par âge supérieur ou égal à 30
		List<Person> adults = personRepository.findByAgeGreaterThanEqual(30);
		System.out.println("Personnes âgées de 30 ans ou plus : " + adults);

		// Recherche des animaux d'une espèce donnée
		Species chat = speciesRepository.findById(1).orElse(null);
		List<Animal> chats = animalRepository.findBySpecies(chat);
		System.out.println("Animaux de l'espèce Chien : " + chats);

		// Recherche des animaux dont la couleur est dans une liste donnée
		List<String> couleurs = List.of("Blanc");
		List<Animal> couleurAnimal = animalRepository.findByColorIn(couleurs);
		System.out.println("Animaux avec couleur : " + couleurAnimal);

		// Afficher toutes les espèces triées par nom commun
		List<Species> orderedSpecies = speciesRepository.findAllOrderedByCommonName();
		System.out.println("Espèces triées par nom commun : " + orderedSpecies);

		// Rechercher les espèces dont le nom commun contient "Chat"
		List<Species> speciesLike = speciesRepository.findByCommonNameLike("Chat");
		System.out.println("Espèces correspondant au mot-clé 'Chat' : " + speciesLike);

		// Rechercher les personnes entre 20 et 50 ans
		List<Person> personsByAge = personRepository.findByAgeBetween(20, 50);
		System.out.println("Personnes entre 20 et 50 ans : " + personsByAge);

		Animal animal = animalRepository.findById(1).orElse(null);
		List<Person> personsWithAnimal = personRepository.findByAnimal(animal);
		System.out.println("Personnes possédant l'animal " + animal.getName() + " : " + personsWithAnimal);
	}
}