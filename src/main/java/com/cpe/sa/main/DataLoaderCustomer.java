package com.cpe.sa.main;

import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoaderCustomer implements ApplicationRunner {

    @Autowired private DiseaseRepository diseaseRepository;
    @Autowired private PrefixRepository prefixRepository;
    @Autowired private SexRepository sexRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        SexEntity sexEntity0 = new SexEntity();
        SexEntity sexEntity1 = new SexEntity();
        PrefixEntity prefixEntity0 = new PrefixEntity();
        PrefixEntity prefixEntity1 = new PrefixEntity();
        PrefixEntity prefixEntity2 = new PrefixEntity();
        PrefixEntity prefixEntity3 = new PrefixEntity();
        PrefixEntity prefixEntity4 = new PrefixEntity();

        DiseaseEntity diseaseEntity0 = new DiseaseEntity();
        DiseaseEntity diseaseEntity1 = new DiseaseEntity();
        DiseaseEntity diseaseEntity2 = new DiseaseEntity();
        DiseaseEntity diseaseEntity3 = new DiseaseEntity();
        DiseaseEntity diseaseEntity4 = new DiseaseEntity();
        DiseaseEntity diseaseEntity5 = new DiseaseEntity();
        DiseaseEntity diseaseEntity6 = new DiseaseEntity();

        sexEntity0.setSex("ชาย");
        sexEntity1.setSex("หญิง");
        sexRepository.save(sexEntity0);
        sexRepository.save(sexEntity1);

        prefixEntity0.setPrefix("เด็กชาย");
        prefixEntity1.setPrefix("เด็กหญิง");
        prefixEntity2.setPrefix("นาย");
        prefixEntity3.setPrefix("นางสาว");
        prefixEntity4.setPrefix("นาง");

        prefixRepository.save(prefixEntity0);
        prefixRepository.save(prefixEntity1);
        prefixRepository.save(prefixEntity2);
        prefixRepository.save(prefixEntity3);
        prefixRepository.save(prefixEntity4);

        diseaseEntity0.setAllergy("ไม่มี");
        diseaseEntity1.setAllergy("ยากลุ่มซัลฟา");
        diseaseEntity2.setAllergy("อินซูลิน");
        diseaseEntity3.setAllergy("ไอโอดีน");
        diseaseEntity4.setAllergy("แอสไพริน");
        diseaseEntity5.setAllergy("ยาต้านชัก");
        diseaseEntity6.setAllergy("ผลิตภัณฑ์จากเกสรผึ้ง");

        diseaseRepository.save(diseaseEntity0);
        diseaseRepository.save(diseaseEntity1);
        diseaseRepository.save(diseaseEntity2);
        diseaseRepository.save(diseaseEntity3);
        diseaseRepository.save(diseaseEntity4);
        diseaseRepository.save(diseaseEntity5);

        diseaseRepository.findAll().forEach(System.out::println);
        prefixRepository.findAll().forEach(System.out::println);
        sexRepository.findAll().forEach(System.out::println);
    }

}