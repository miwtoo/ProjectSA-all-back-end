package com.cpe.sa.main;

import java.util.stream.Stream;

import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class DataloderMedicine implements ApplicationRunner {

    @Autowired UserRepository userRepository;
    @Autowired TypeRepository typeRepository;
    @Autowired MedicineRepository medicineRepository ;
    @Autowired MedicineDataRepository medicineDataRepository;


    @Override
    public void run(ApplicationArguments args) throws Exception {


        Stream.of("-","Paracetamol").forEach(medicineName -> {
            medicineRepository.save(new Medicine(medicineName));
        });
        medicineRepository.findAll().forEach(System.out::println);

        Stream.of("-","ยาสามัญทั่วไป","ยาควบคุม","ยาบำรุงร่างกาย","ผลิตภัณฑ์บำรุงความงาม").forEach(typeName -> {
            typeRepository.save(new Type(typeName));
        });
        typeRepository.findAll().forEach(System.out::println);
	}
    
}