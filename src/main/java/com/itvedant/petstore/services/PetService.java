package com.itvedant.petstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.petstore.entities.Pet;
import com.itvedant.petstore.repositories.PetRepository;

@Service
public class PetService {
    
    @Autowired
    private PetRepository petRepository;

    //Create 
    public Pet addPet(Pet pet){
        return this.petRepository.save(pet);
    }

    //Read All Records
    public List<Pet> getAll(){
        return this.petRepository.findAll();
    }

    //Read One Record
    public Pet getById(Integer id){
        return this.petRepository.findById(id).orElse(null);
    }

    //Delete 
    public void deletePet(Integer id){
        this.petRepository.deleteById(id);
    }

    //Update
    public Pet updatePet(Integer id, Pet pet){
        pet.setId(id);
        return this.petRepository.save(pet);
    }

    public List<Pet> getByAge(Integer value){
        return this.petRepository.getByAgeLessThan(value);
    }

    public List<Pet> getByType(String value){
        return this.petRepository.byType(value);
    }
}
