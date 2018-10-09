package com.cpe.sa.main.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;


import com.cpe.sa.main.entity.Category;
import com.cpe.sa.main.entity.History;
import com.cpe.sa.main.entity.Item;
import com.cpe.sa.main.entity.Unit;
import com.cpe.sa.main.entity.User;
import com.cpe.sa.main.entity.Type;
import com.cpe.sa.main.repository.CategoryRepository;
import com.cpe.sa.main.repository.HistoryRepository;
import com.cpe.sa.main.repository.ItemRepository;
import com.cpe.sa.main.repository.TypeRepository;
import com.cpe.sa.main.repository.UnitRepository;
import com.cpe.sa.main.repository.UserRepository;

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
@RequestMapping("/item")
public class ItemController{
    @Autowired private ItemRepository itemRepository;
    @Autowired private CategoryRepository categoryRepository;
    @Autowired private HistoryRepository historyRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private TypeRepository typeRepository;
    @Autowired private UnitRepository unitRepository;

    @GetMapping()
    public List<Item> items(){
        return itemRepository.findAll();
    }

    @PostMapping("/{itemName}/{price}/{categoryId}")
    public Item newItem(Item newItem, @PathVariable String itemName,@PathVariable Float price, @PathVariable Long categoryId) {
        Optional<Category> category = categoryRepository.findById(categoryId);
        
        newItem.setItemName(itemName);
        newItem.setPrice(price);
        newItem.setCategory(category.get());

        return itemRepository.save(newItem);
    }

    @PostMapping("/{itemId}")
    public History newHistory(History newHistory,@PathVariable Long itemId, @RequestBody() Map<String,Object> body) {  
        Optional<Item> item = itemRepository.findById(itemId);
        
        Optional<User> user = userRepository.findById((Long.valueOf( body.get("user").toString() )));
        Optional<Type> type = typeRepository.findById(1L);
        Optional<Unit> unit = unitRepository.findById((Long.valueOf( body.get("unit").toString() )));

        

        newHistory.setItem(item.get());

        newHistory.setUser(user.get());
        newHistory.setType(type.get());
        newHistory.setUnit(unit.get());
        
        newHistory.setAmount( Float.valueOf(body.get("amount").toString()));
        newHistory.setDate(new Date());
        newHistory.setTime(new Date());

        return historyRepository.save(newHistory);
    }
}