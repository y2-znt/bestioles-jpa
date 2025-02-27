package com.example.Bestioles.repository;

import com.example.Bestioles.model.Animal;
import com.example.Bestioles.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByFirstnameOrLastname(String firstname, String lastname);

    List<Person> findByAgeGreaterThanEqual(Integer age);

    @Query("SELECT p FROM Person p WHERE p.age BETWEEN :minAge AND :maxAge")
    List<Person> findByAgeBetween(@Param("minAge") int minAge, @Param("maxAge") int maxAge);

    @Query("SELECT DISTINCT p FROM Person p JOIN p.animals a WHERE a = :animal")
    List<Person> findByAnimal(@Param("animal") Animal animal);

}
