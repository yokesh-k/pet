package com.itvedant.petstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.itvedant.petstore.entities.Pet;
import com.itvedant.petstore.services.PetService;

import jakarta.validation.Valid;

@Controller
public class PetController {

    @Autowired
    private PetService petService;

    @PostMapping("/pets")
    public ResponseEntity<?> addPet(@RequestBody @Valid Pet pet){
        return new ResponseEntity<>(this.petService.addPet(pet)
        , HttpStatus.CREATED);
    }

    @GetMapping("/pets")
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(this.petService.getAll(),
            HttpStatus.OK);
    }

    @GetMapping("/pets/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        Pet exists = this.petService.getById(id);
        if(exists != null)
            return new ResponseEntity<>(exists, HttpStatus.OK);
        else
            return new ResponseEntity<>("Pets of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/pets/{id}")
    public ResponseEntity<?> deletePet(@PathVariable Integer id){
        Pet exists = this.petService.getById(id);
        if(exists != null){
            this.petService.deletePet(id);
            return new ResponseEntity<>("Pet Deleted", HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Pets of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }

    @PutMapping("/pets/{id}")
    public ResponseEntity<?> updatePet(@PathVariable Integer id,
                                @RequestBody @Valid Pet pet){
        Pet exists = this.petService.getById(id);
        if(exists != null){
            return new ResponseEntity<>(this.petService.updatePet(id, pet), 
                HttpStatus.OK);
        }
        else
            return new ResponseEntity<>("Pets of this id does not exists", 
                HttpStatus.NOT_FOUND);
    }

    @GetMapping("/pets/searchbyage")
    public ResponseEntity<?> getByAge(Integer value){
        List<Pet> pets = this.petService.getByAge(value);
        if(pets.isEmpty())
            return new ResponseEntity<>("No pets exists for this criteria", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @GetMapping("/pets/searchbytype")
    public ResponseEntity<?> getByType(@RequestParam String value){
        List<Pet> pets = this.petService.getByType(value);
        if(pets.isEmpty())
            return new ResponseEntity<>("No pets exists for this criteria", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
}
