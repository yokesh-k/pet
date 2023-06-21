package com.itvedant.petstore.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itvedant.petstore.dtos.RegisterUserDto;
import com.itvedant.petstore.entities.Product;
import com.itvedant.petstore.entities.User;
import com.itvedant.petstore.repositories.ProductRepository;
import com.itvedant.petstore.repositories.UserRepository;

@Service
public class UserService {
    // private Map<Integer, User> users = new HashMap<>();
    // private AtomicInteger atomic = new AtomicInteger();

    @Autowired
    private UserRepository repository;

    // @Autowired
    // private ProductRepository productRepository;

    public User registerUser(RegisterUserDto registerUserDto) {
        User user = new User();
        // user.setId(atomic.incrementAndGet());
        user.setFirstName(registerUserDto.getFirstName());
        user.setLastName(registerUserDto.getLastName());
        user.setEmail(registerUserDto.getEmail());
        user.setPassword(registerUserDto.getPassword());
        user.setMobile(registerUserDto.getMobile());
        // users.put(user.getId(), user);

        repository.save(user);

        // productRepository.save(new Product());

        return user;
    }    

    public List<User> getAll(){
        return repository.findAll();
    }

    public User getById(Integer id){
        // return repository.findById(id).get();
        return repository.findById(id).orElse(null);
    }

    public void deleteUser(Integer id){
        repository.deleteById(id);
    }

    public User updateUser(Integer id, User user){
        user.setId(id);
        return repository.save(user);
    }

    public List<User> findByFirstName(String firstName){
        return this.repository.findByFirstName(firstName);
    }

    public List<User> findByEmail(String email){
        return this.repository.findByEmailContaining(email);
    }
}
