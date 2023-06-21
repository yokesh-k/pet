package com.itvedant.petstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.itvedant.petstore.entities.User;

@Repository
public interface UserRepository 
    extends JpaRepository<User, Integer> {
    
    List<User> findByFirstName(String firstName);    

    List<User> findByEmailContaining(String email);
}
