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
@RequestMapping("/salenote")
public class SalenoteController{
    @Autowired ReceiptRepository receiptRepository;
    @Autowired OrdersRepository ordersRepository;

    @Autowired private UserRepository userRepository;
    @Autowired private PillRepository pillRepository;

    @GetMapping("/receipt")
    public List<Receipt> allReceipts(){
        return receiptRepository.findAll();
    }

    @GetMapping("/orders")
    public List<Orders> allOrders() {
        return ordersRepository.findAll();
    }

    @PostMapping("/receipt/{userid}")
    public Receipt addReceipt(Receipt newReceipt, @PathVariable Long userid){

        Optional<User> user = userRepository.findById(userid);

        newReceipt.setUser(user.get());
        newReceipt.setDate(new Date());

        return receiptRepository.save(newReceipt);
    }

    @PostMapping("/orders")
    public Orders addOrders(Orders newOrders, @RequestBody Map<String,String> body){

        Pill pill = pillRepository.findByName(body.get("pill"));
        Optional<Receipt> receipt = receiptRepository.findById(Long.valueOf(body.get("receipt")));


        newOrders.setReceipt(receipt.get());
        newOrders.setPill(pill);
        newOrders.setAmount(Integer.valueOf(body.get("amount")));

        return ordersRepository.save(newOrders);
    }

}