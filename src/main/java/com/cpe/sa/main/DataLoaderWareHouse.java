package com.cpe.sa.main;

import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoaderWareHouse implements ApplicationRunner {

    @Autowired private CategoryRepository categoryRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private UnitRepository unitRepository;
    @Autowired private TypeRepository typeRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        userRepository.save(new User("Miwtoo", "CEO"));
        userRepository.save(new User("Miwtree", "Pharmacy"));
        userRepository.save(new User("Miwfour", "Pharmacy"));
        userRepository.findAll().forEach(System.out::println);


        categoryRepository.save(new Category("ยา"));
        categoryRepository.save(new Category("ทั่วไป"));
        categoryRepository.findAll().forEach(System.out::println);

        unitRepository.save(new Unit("กล่อง"));
        unitRepository.save(new Unit("เม็ด"));
        unitRepository.save(new Unit("แผง"));
        unitRepository.findAll().forEach(System.out::println);

        typeRepository.save(new Type("เพิ่มสินค้า"));
        typeRepository.save(new Type("เบิกสินค้า"));
        typeRepository.findAll().forEach(System.out::println);
	}
    
}