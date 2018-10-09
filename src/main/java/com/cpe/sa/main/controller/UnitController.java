package com.cpe.sa.main.controller;

import java.util.List;

import com.cpe.sa.main.entity.Unit;
import com.cpe.sa.main.repository.UnitRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/unit")
public class UnitController{
    @Autowired private UnitRepository unitRepository;

    @GetMapping()
    public List<Unit> units(){
        return unitRepository.findAll();
    }
}