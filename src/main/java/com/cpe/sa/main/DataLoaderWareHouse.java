package com.cpe.sa.main;

import com.cpe.sa.main.warehouse.entity.*;
import com.cpe.sa.main.warehouse.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataLoaderWareHouse implements ApplicationRunner {

    private final TypeListRepository typeListRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;
    private final TakeInRepository takeInRepository;

    @Autowired
    public DataLoaderWareHouse(TypeListRepository typeListRepository, ItemRepository itemRepository, UserRepository userRepository, TakeInRepository takeInRepository){
        this.typeListRepository = typeListRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.takeInRepository = takeInRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        typeListRepository.save(new TypeList("เวชสำอาง/ครีมบำรุงผิว"));
        typeListRepository.save(new TypeList("ผลิตภัณฑ์เสริมอาหาร"));
        typeListRepository.save(new TypeList("สมุนไพรยาแผนโบราณ"));
        typeListRepository.findAll().forEach(System.out::println);

        itemRepository.save(new Item("Item 1",255.598f,1,  1L));
        itemRepository.save(new Item("Item 2",588.754f,10, 2L));
        itemRepository.save(new Item("Item 3",455.55548f,4, 1L));
        itemRepository.findAll().forEach(System.out::println);


        userRepository.save(new User("Miwtoo", "CEO"));
        userRepository.save(new User("Miwtree", "Pharmacy"));
        userRepository.save(new User("Miwfour", "Pharmacy"));
        userRepository.findAll().forEach(System.out::println);
        
        takeInRepository.save(new TakeIn(1L, 2L, 5 ));
        takeInRepository.save(new TakeIn(1L, 3L, 5 ));
        takeInRepository.save(new TakeIn(2L, 1L, 5 ));
        takeInRepository.save(new TakeIn(2L, 2L, 5 ));
        takeInRepository.save(new TakeIn(3L, 2l, 5 ));
        takeInRepository.save(new TakeIn(2L, 3L, 5 ));
        takeInRepository.save(new TakeIn(3L, 1L, 5 ));
        takeInRepository.save(new TakeIn(3L, 3l, 5 ));
        takeInRepository.findAll().forEach(System.out::println);

	}
    
}