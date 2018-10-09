package com.cpe.sa.main.controller;

import java.util.List;

import com.cpe.sa.main.entity.User;
import com.cpe.sa.main.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/user")
public class UserController{
    @Autowired private UserRepository userRepository;

    @GetMapping()
    public List<User> users(){
        return userRepository.findAll();
    }
}