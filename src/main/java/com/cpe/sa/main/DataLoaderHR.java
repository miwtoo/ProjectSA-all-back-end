package com.cpe.sa.main;

import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoaderHR implements ApplicationRunner {

    @Autowired private departmentrepos Departmentrepos;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Departmentrepos.save(new Department("ขาย"));
		Departmentrepos.save(new Department("จัดของ"));
		Departmentrepos.save(new Department("ส่งของ"));
		Departmentrepos.findAll().forEach(System.out::println);
	}
    
}