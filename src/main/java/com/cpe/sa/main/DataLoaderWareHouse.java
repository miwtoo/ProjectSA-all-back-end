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
    private final WithDrawRepository withDrawRepository;

    @Autowired
    public DataLoaderWareHouse(TypeListRepository typeListRepository, ItemRepository itemRepository, UserRepository userRepository, WithDrawRepository withDrawRepository){
        this.typeListRepository = typeListRepository;
        this.itemRepository = itemRepository;
        this.userRepository = userRepository;
        this.withDrawRepository = withDrawRepository;
    }


    @Override
    public void run(ApplicationArguments args) throws Exception {
        typeListRepository.save(new TypeList("เวชสำอาง/ครีมบำรุงผิว"));
        typeListRepository.save(new TypeList("ผลิตภัณฑ์เสริมอาหาร"));
        typeListRepository.save(new TypeList("สมุนไพรยาแผนโบราณ"));
        typeListRepository.findAll().forEach(System.out::println);

        itemRepository.save(new Item("Item 1",255.598f,5,  1L));
        itemRepository.save(new Item("Item 2",588.754f,10, 2L));
        itemRepository.save(new Item("Item 3",455.55548f,4, 1L));
        itemRepository.findAll().forEach(System.out::println);


        userRepository.save(new User("Miwtoo", "CEO"));
        userRepository.save(new User("Miwtree", "Pharmacy"));
        userRepository.save(new User("Miwfour", "Pharmacy"));
        userRepository.findAll().forEach(System.out::println);
        
        withDrawRepository.save(new Withdraw(1L, 2L, 5 ));
        withDrawRepository.save(new Withdraw(1L, 3L, 5 ));
        withDrawRepository.save(new Withdraw(2L, 1L, 5 ));
        withDrawRepository.save(new Withdraw(2L, 2L, 5 ));
        withDrawRepository.save(new Withdraw(3L, 2l, 5 ));
        withDrawRepository.save(new Withdraw(2L, 3L, 5 ));
        withDrawRepository.save(new Withdraw(3L, 1L, 5 ));
        withDrawRepository.save(new Withdraw(3L, 3l, 5 ));
        withDrawRepository.findAll().forEach(System.out::println);

	}
    
}