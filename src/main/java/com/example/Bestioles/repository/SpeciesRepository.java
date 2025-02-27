package com.example.Bestioles.repository;

import com.example.Bestioles.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Integer> {
    Species findFirstByCommonName(String commonName);

    List<Species> findByLatinName(String latinName);

    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllOrderedByCommonName();

    @Query("SELECT s FROM Species s WHERE (s.commonName) LIKE (CONCAT('%', :keyword, '%'))")
    List<Species> findByCommonNameLike(@Param("keyword") String keyword);

}
