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
public class WareHouseController{
    @Autowired private HistoryRepository historyRepository;
    @Autowired private PillRepository itemRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private StatusRepository statusRepository;
    @Autowired private UnitRepository unitRepository;

    @GetMapping("/history")
    public List<History> histories(){
        return historyRepository.findAll();
    }

    @GetMapping("/history/{id}")
    public Optional<History> historiesOne(@PathVariable Long id){
        return historyRepository.findById(id);
    }

    @PostMapping("/history")
    public History newHistory(History newHistory, @RequestBody() Map<String,Object> body) {  
        Optional<Pill> item = itemRepository.findById((Long.valueOf( body.get("item").toString() )));
        
        Optional<User> user = userRepository.findById((Long.valueOf( body.get("user").toString() )));
        Optional<Status> status = statusRepository.findById((Long.valueOf( body.get("type").toString() )));
        Optional<Unit> unit = unitRepository.findById((Long.valueOf( body.get("unit").toString() )));

        

        newHistory.setItem(item.get());

        newHistory.setUser(user.get());
        newHistory.setStatus(status.get());
        newHistory.setUnit(unit.get());
        
        newHistory.setAmount( Float.valueOf(body.get("amount").toString()));

        newHistory.setDate(new Date());

        return historyRepository.save(newHistory);
    }

    //----------Type----------------

    @GetMapping("/type")
    public List<Status> types(){
        return statusRepository.findAll();
    }

    //-------Unit----------------

    @GetMapping("/unit")
    public List<Unit> units(){
        return unitRepository.findAll();
    }

}