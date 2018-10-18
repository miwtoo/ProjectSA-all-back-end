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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("/history")
public class WareHouseController{
    @Autowired private HistoryRepository historyRepository;
    @Autowired private ItemRepository itemRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private TypeRepository typeRepository;
    @Autowired private UnitRepository unitRepository;
    @Autowired private CategoryRepository categoryRepository;

    @GetMapping()
    public List<History> histories(){
        return historyRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<History> historiesOne(@PathVariable Long id){
        return historyRepository.findById(id);
    }

    @PostMapping()
    public History newHistory(History newHistory, @RequestBody() Map<String,Object> body) {  
        Optional<Item> item = itemRepository.findById((Long.valueOf( body.get("item").toString() )));
        
        Optional<User> user = userRepository.findById((Long.valueOf( body.get("user").toString() )));
        Optional<Type> type = typeRepository.findById((Long.valueOf( body.get("type").toString() )));
        Optional<Unit> unit = unitRepository.findById((Long.valueOf( body.get("unit").toString() )));

        

        newHistory.setItem(item.get());

        newHistory.setUser(user.get());
        newHistory.setType(type.get());
        newHistory.setUnit(unit.get());
        
        newHistory.setAmount( Float.valueOf(body.get("amount").toString()));

        newHistory.setDate(new Date());

        return historyRepository.save(newHistory);
    }

    
    //----------Category---------
    @GetMapping()
    public List<Category> categories(){
        return categoryRepository.findAll();
    }

    //----------Item------------------

    @GetMapping()
    public List<Item> items(){
        return itemRepository.findAll();
    }

    @GetMapping("/name")
    public Item itemsName(@PathVariable String name){
        return itemRepository.findByItemName(name);
    }

    //----------Type----------------

    @GetMapping()
    public List<Type> types(){
        return typeRepository.findAll();
    }

    //-------Unit----------------

    @GetMapping()
    public List<Unit> units(){
        return unitRepository.findAll();
    }

}