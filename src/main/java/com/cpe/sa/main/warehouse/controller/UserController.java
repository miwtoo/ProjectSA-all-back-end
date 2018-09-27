package com.cpe.sa.main.warehouse.controller;

import java.util.Collection;
import java.util.Optional;

import com.cpe.sa.main.warehouse.entity.User;
import com.cpe.sa.main.warehouse.repository.UserRepository;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin("http://localhost:4200")
public class UserController{
    private UserRepository repo;

    public UserController(UserRepository repo){
        this.repo = repo;
    }

    @GetMapping()
    public Collection<User> user(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<User> takeinByid(@PathVariable Long id ){
        return repo.findById(id);
    }
}