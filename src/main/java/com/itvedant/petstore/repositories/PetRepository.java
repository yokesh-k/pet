package com.itvedant.petstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.itvedant.petstore.entities.Pet;

public interface PetRepository 
    extends JpaRepository<Pet, Integer>{
    List<Pet> getByAgeLessThan(Integer value);

    @Query(value = "select * from pet p where p.type = ?1", nativeQuery = true)
    List<Pet> byType(String value);
}
