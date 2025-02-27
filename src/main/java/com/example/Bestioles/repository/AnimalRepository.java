package com.example.Bestioles.repository;

import com.example.Bestioles.model.Animal;
import com.example.Bestioles.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Integer> {
    List<Animal> findBySpecies(Species species);

    List<Animal> findByColorIn(List<String> colors);

}
