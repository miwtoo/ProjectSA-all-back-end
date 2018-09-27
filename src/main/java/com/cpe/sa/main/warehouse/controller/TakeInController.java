package com.cpe.sa.main.warehouse.controller;

import java.util.Collection;
import java.util.Optional;


import com.cpe.sa.main.warehouse.entity.TakeIn;
import com.cpe.sa.main.warehouse.repository.TakeInRepository;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/take-in")
@CrossOrigin("http://localhost:4200")
public class TakeInController{
    private TakeInRepository repo;

    public TakeInController(TakeInRepository repo){
        this.repo = repo;
    }

    @GetMapping()
    public Collection<TakeIn> takeinAll(){
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Optional<TakeIn> takeinByid(@PathVariable Long id ){
        return repo.findById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String Add(TakeIn takeIn){
        repo.save(takeIn);

        return "CREATE";
    }
}