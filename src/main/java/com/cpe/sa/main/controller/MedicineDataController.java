package com.cpe.sa.main.controller;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.cpe.sa.main.entity.*;
import com.cpe.sa.main.repository.*;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class MedicineDataController{
    @Autowired private MedicineDataRepository medicineDataRepository;
    @Autowired private UserRepository userRepository;
    @Autowired private PillRepository pillRepository;
    @Autowired private TypePillrepository typePillRepository;

    @GetMapping("/MedicineData")
    public Collection<MedicineData> items(){
        return medicineDataRepository.findAll();
    }

    @GetMapping("/MedicineData/{dataID}")
    public Optional<MedicineData> takeinMedicineDataByid(@PathVariable Long dataID ){
        return medicineDataRepository.findById(dataID);
    }

    @PostMapping("/MedicineData/addMedicineData")
    public MedicineData newMedicineData(MedicineData newMedicineData,@RequestBody() Map<String,Object> body) {
        Optional<User> user = userRepository.findById(Long.valueOf(body.get("user").toString()));
        Optional<TypePill> type = typePillRepository.findById(Long.valueOf(body.get("type").toString()));
        Optional<Pill> medicine = pillRepository.findById(Long.valueOf(body.get("medicine").toString()));


        newMedicineData.setUser(user.get());
        newMedicineData.setType(type.get());
        newMedicineData.setPill(medicine.get());

        newMedicineData.setBrand(body.get("brandName").toString());
        newMedicineData.setDetail(body.get("detail").toString());

        return medicineDataRepository.save(newMedicineData);
    }
    

    //=============User====================
    @GetMapping("/User")
    public Collection<User> user(){
        return userRepository.findAll();
    }
    
    @GetMapping("/User/{userID}")
    public Optional<User> takeinUserByid(@PathVariable Long userID ){
        return userRepository.findById(userID);
    }

    //=============Medicine=================
     @GetMapping("/Medicine")
     public Collection<Pill> Medicine(){
         return pillRepository.findAll();
     }
     @GetMapping("/Medicine/{medicineID}")
     public Optional<Pill> takeinMedicineByid(@PathVariable Long medicineID ){
         return pillRepository.findById(medicineID);
     }

    @PostMapping("/Medicine/addMedicine/{medicineName}")
    public Pill newMedicine(@PathVariable String medicineName){
        Pill newMedicine = new Pill(medicineName);
        return pillRepository.save(newMedicine);
    }

    //=============Type==================
    @GetMapping("/TypePill")
    public List<TypePill> Type(){
        return typePillRepository.findAll();
    }
    @GetMapping("/TypePill/{typeID}")
    public Optional<TypePill> takeinTypeByid(@PathVariable Long typeID ){
        return typePillRepository.findById(typeID);
    }
    @PostMapping("/TypePill/addType/{typeName}")
    public TypePill newType(@PathVariable String typeName){
        TypePill newType = new TypePill(typeName); 
        return typePillRepository.save(newType); 
    }
}
