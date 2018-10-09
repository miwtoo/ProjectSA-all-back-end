package com.cpe.sa.main.controller;

import java.util.List;

import com.cpe.sa.main.entity.Category;
import com.cpe.sa.main.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/category")
public class CategoryController{
    @Autowired private CategoryRepository categoryRepository;

    @GetMapping()
    public List<Category> categories(){
        return categoryRepository.findAll();
    }
}