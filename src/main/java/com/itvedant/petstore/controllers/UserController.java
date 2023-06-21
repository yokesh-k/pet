package com.itvedant.petstore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.itvedant.petstore.dtos.RegisterUserDto;
import com.itvedant.petstore.entities.User;
import com.itvedant.petstore.services.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/users")
    public ResponseEntity<?> registerUser(@RequestBody @Valid RegisterUserDto registerUserDto){
        return new ResponseEntity<>(this.userService.registerUser(registerUserDto),
                        HttpStatus.CREATED);
    }

    @GetMapping("/users")
    public ResponseEntity<?> getAll(){
        //return ResponseEntity.ok(this.userService.getAll());
        return new ResponseEntity<>(this.userService.getAll(), 
                        HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        User userExists = this.userService.getById(id);
        if(userExists != null)
            return new ResponseEntity<>(userExists, HttpStatus.OK);
        else   
            return new ResponseEntity<>("User Does Not Exists", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Integer id){
        User userExists = this.userService.getById(id);
        if(userExists != null){
            this.userService.deleteUser(id);
            return new ResponseEntity<>("User Deleted Successfully", HttpStatus.OK);
        }
        else   
            return new ResponseEntity<>("User Does Not Exists", HttpStatus.NOT_FOUND);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Integer id, @RequestBody User user){
        User userExists = this.userService.getById(id);
        if(userExists != null){
            return new ResponseEntity<>(this.userService.updateUser(id, user), HttpStatus.OK);
        }
        else   
            return new ResponseEntity<>("User Does Not Exists", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/users/searchbyfname")
    public ResponseEntity<?> findByFirstName
                (@RequestParam("firstname") String firstName){
        List<User> users = this.userService.findByFirstName(firstName);
        if(users.isEmpty())
            return new ResponseEntity<>("No user exists with this name",
                    HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(this.userService.findByFirstName(firstName),
                    HttpStatus.OK);
    }

    @GetMapping("/users/searchbyemail")
    public ResponseEntity<?> findByEmail
                (@RequestParam String email){
        List<User> users = this.userService.findByEmail(email);
        if(users.isEmpty())
            return new ResponseEntity<>("No user exists with this email",
                    HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
