package com.cpe.sa.main.controller;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class InFormController {
    @Autowired
    private ProfilesRepository customerRepository;
    @Autowired
    private PillRepository pillRepository;
    @Autowired
    private Usedrepository usedrepository;
    @Autowired
    private InformRepository informrepository;
    @Autowired
    private MessageRepository messageRepository;


    @GetMapping("/message")
    public Collection<Message> Informs() {
        return messageRepository.findAll();
    }

    @GetMapping("/inform")
    public Collection<Inform> Inform() {
        return informrepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/inform/{date}")
    public List<com.cpe.sa.main.entity.Inform> getOneInform(@PathVariable Date date) {
        return informrepository.findAll();
    }

    @PostMapping("/inform")
    public void newInform(Inform newInform, @RequestBody() Map<String, Object> body) {
        Pill pill = pillRepository.findByName(body.get("pill").toString());
        ProfilesEntity cus = customerRepository.findByTelephonenumber(body.get("customer").toString());
        Message message =  messageRepository.findByMessage(body.get("message").toString());

        newInform.setPill(pill);
        newInform.setMessage(message);
        newInform.setCustomer(cus);
        newInform.setDate(new Date(Long.valueOf(body.get("date").toString())));

         informrepository.save(newInform);
        System.out.println(body);
    }

}