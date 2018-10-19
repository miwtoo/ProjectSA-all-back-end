package com.cpe.sa.main.controller;
import java.util.Collection;
import java.util.Map;
import java.util.stream.Collectors;

import com.cpe.sa.main.entity.DiseaseEntity;
import com.cpe.sa.main.entity.PrefixEntity;
import com.cpe.sa.main.entity.ProfilesEntity;
import com.cpe.sa.main.entity.SexEntity;
import com.cpe.sa.main.repository.DiseaseRepository;
import com.cpe.sa.main.repository.PrefixRepository;
import com.cpe.sa.main.repository.ProfilesRepository;
import com.cpe.sa.main.repository.SexRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@EnableAutoConfiguration
@RestController
@CrossOrigin("http://localhost:4200")
public class RegisterCustomerController {
    @Autowired
    private ProfilesRepository profilesRepository;
    @Autowired
    private DiseaseRepository diseaseRepository;
    @Autowired
    private PrefixRepository prefixRepository;
    @Autowired
    private SexRepository sexRepository;

    @GetMapping("/prefix")
    public Collection<PrefixEntity> prefixapi() {
        return prefixRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/sex")
    public Collection<SexEntity> sexapi() {
        return sexRepository.findAll().stream().collect(Collectors.toList());
    }

    @GetMapping("/disease")
    public Collection<DiseaseEntity> diseaseapi() {
        return diseaseRepository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping("/add")
    @ResponseBody
    public void newProfiles(@RequestBody() Map<String, Object> body) {
        
        ProfilesEntity profilesEntity = new ProfilesEntity();
        PrefixEntity prefixEntity = prefixRepository.findByPrefix(body.get("prefix").toString());
        SexEntity sexEntity = sexRepository.findBySex(body.get("sex").toString());
        DiseaseEntity diseaseEntity = diseaseRepository.findByAllergy(body.get("allergy").toString());
        profilesEntity.setPrefix(prefixEntity);
        profilesEntity.setFirstname(body.get("fname").toString());
        profilesEntity.setLastname(body.get("lname").toString());
        profilesEntity.setTelephonenumber(body.get("tel").toString());
        profilesEntity.setSex(sexEntity);
        profilesEntity.setDisease(diseaseEntity);
        profilesRepository.save(profilesEntity);
      
        
    }


}