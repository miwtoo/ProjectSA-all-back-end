package com.cpe.sa.main;

import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoaderWareHouse implements ApplicationRunner {

    @Autowired private UnitRepository unitRepository;
    @Autowired private TypeRepository typeRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {

        unitRepository.save(new Unit("กล่อง"));
        unitRepository.save(new Unit("เม็ด"));
        unitRepository.save(new Unit("แผง"));
        unitRepository.findAll().forEach(System.out::println);

        typeRepository.save(new Type("นำเข้า"));
        typeRepository.save(new Type("เบิก"));
        typeRepository.findAll().forEach(System.out::println);
	}
    
}