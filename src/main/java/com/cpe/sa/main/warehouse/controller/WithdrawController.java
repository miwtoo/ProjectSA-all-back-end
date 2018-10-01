package com.cpe.sa.main.warehouse.controller;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

import com.cpe.sa.main.warehouse.entity.Item;
import com.cpe.sa.main.warehouse.entity.User;
import com.cpe.sa.main.warehouse.entity.Withdraw;
import com.cpe.sa.main.warehouse.repository.ItemRepository;
import com.cpe.sa.main.warehouse.repository.UserRepository;
import com.cpe.sa.main.warehouse.repository.WithDrawRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/withdraw")
@CrossOrigin("http://localhost:4200")
public class WithdrawController{
    @Autowired private WithDrawRepository withDrawRepository;
    @Autowired private ItemRepository itemRepository;
    @Autowired private UserRepository userRepository;

    
    public WithdrawController(WithDrawRepository withDrawRepository){
        this.withDrawRepository = withDrawRepository;
    }

    @GetMapping()
    public Collection<Withdraw> withdraws(){
        return withDrawRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Withdraw> takeinByid(@PathVariable Long id ){
        return withDrawRepository.findById(id);
    }

    @PostMapping("{user_id}/{item_id}/{withdraw_amount}")
    public Withdraw Add(Withdraw newWithdraw, @PathVariable Long user_id, @PathVariable Long item_id, @PathVariable Integer withdraw_amount) {

        Optional<User> user = userRepository.findById(user_id);
        Optional<Item> item = itemRepository.findById(item_id);

        newWithdraw.setUserId(user.get());
        newWithdraw.setItemId(item.get());
        if((item.get().getAmount()- withdraw_amount) >= 0)
            item.get().setAmount(item.get().getAmount()- withdraw_amount);
        else
            return null;
        newWithdraw.setDate(new Date());
        
        
        return withDrawRepository.save(newWithdraw);
    }
}