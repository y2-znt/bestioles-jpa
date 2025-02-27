package com.example.Bestioles.repository;

import com.example.Bestioles.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
    List<Person> findByFirstnameOrLastname(String firstname, String lastname);

    List<Person> findByAgeGreaterThanEqual(Integer age);
}
