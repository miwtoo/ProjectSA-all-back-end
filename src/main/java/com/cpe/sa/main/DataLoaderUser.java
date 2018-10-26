package com.cpe.sa.main;

import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoaderUser implements ApplicationRunner {

    @Autowired private UserRepository userRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        userRepository.save(new User("miwtoo","1234567","Miwtoo"));
        userRepository.save(new User("miwtree","00000000","Miwtree"));
        userRepository.save(new User("miwfour","111222333","Miwfour"));
        userRepository.findAll().forEach(System.out::println);
	}
    
}