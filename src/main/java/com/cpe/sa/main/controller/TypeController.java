package com.cpe.sa.main.controller;

import java.util.List;

import com.cpe.sa.main.entity.Type;
import com.cpe.sa.main.repository.TypeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/type")
public class TypeController{
    @Autowired private TypeRepository typeRepository;

    @GetMapping()
    public List<Type> types(){
        return typeRepository.findAll();
    }
}