package com.cpe.sa.main.warehouse.controller;

import java.util.Collection;
import java.util.Optional;

import javax.validation.Valid;

import com.cpe.sa.main.warehouse.entity.Item;
import com.cpe.sa.main.warehouse.entity.TypeList;
import com.cpe.sa.main.warehouse.repository.ItemRepository;
import com.cpe.sa.main.warehouse.repository.TypeListRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
    @Autowired  private ItemRepository itemRepository;
    @Autowired  private TypeListRepository typeListRepository;

    
    public ItemController(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    @GetMapping()
    public Collection<Item> item(){
        return itemRepository.findAll();
    }

    @PostMapping("/{name}/{price}/{amount}/{typeId}")
    public Item Add(Item newItem, @PathVariable String name, @PathVariable float price, @PathVariable int amount, @PathVariable Long typeId) {
        Optional<TypeList> type = typeListRepository.findById(typeId);

        newItem.setItem_name(name);
        //newItem.setPrice(price); ไม่ใส่ก็ทำงาน ไม่รู้ทำไม 55555
        //newItem.setAmount(amount);
        newItem.setType(type.get());
        
        return itemRepository.save(newItem);
    }

}