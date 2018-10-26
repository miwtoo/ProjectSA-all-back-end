package com.cpe.sa.main.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
public class PillController{
    @Autowired private PillRepository pillRepository;

    @GetMapping("/pill")
    public List<Pill> allpill(){
        return pillRepository.findAll();
    }

    @PostMapping("/pill")
    public Pill newHistory(Pill newPill, @RequestBody() Map<String,String> body) {  
        newPill.setName(body.get("name"));
        newPill.setPrice(Float.valueOf(body.get("price")));

        return pillRepository.save(newPill);
    }
}