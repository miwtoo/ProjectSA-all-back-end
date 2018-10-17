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
    @Autowired private UnitRepository unitRepository;
    @Autowired private TypeRepository typeRepository;
    @Autowired private ItemRepository itemRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        categoryRepository.save(new Category("ยา"));
        categoryRepository.save(new Category("ทั่วไป"));
        categoryRepository.findAll().forEach(System.out::println);

        unitRepository.save(new Unit("กล่อง"));
        unitRepository.save(new Unit("เม็ด"));
        unitRepository.save(new Unit("แผง"));
        unitRepository.findAll().forEach(System.out::println);

        typeRepository.save(new Type("นำเข้า"));
        typeRepository.save(new Type("เบิก"));
        typeRepository.findAll().forEach(System.out::println);

        itemRepository.save(new Item("Item 1", 123.2f, 1L));
        itemRepository.save(new Item("Item 2", 456.1f, 1L));
        itemRepository.save(new Item("Item 2", 999.3f, 2L));
        itemRepository.findAll().forEach(System.out::println);
	}
    
}