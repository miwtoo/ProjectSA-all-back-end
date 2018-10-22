package com.cpe.sa.main.controller;
import java.util.Collection;
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
    @Autowired private MedicineRepository medicineRepository;
    @Autowired private TypeRepository typeRepository;

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
        Optional<Type> type = typeRepository.findById(Long.valueOf(body.get("type").toString()));
        Optional<Medicine> medicine = medicineRepository.findById(Long.valueOf(body.get("medicine").toString()));


        newMedicineData.setUser(user.get());
        newMedicineData.setType(type.get());
        newMedicineData.setMedicine(medicine.get());

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
     public Collection<Medicine> Medicine(){
         return medicineRepository.findAll();
     }
     @GetMapping("/Medicine/{medicineID}")
     public Optional<Medicine> takeinMedicineByid(@PathVariable Long medicineID ){
         return medicineRepository.findById(medicineID);
     }

    @PostMapping("/Medicine/addMedicine/{medicineName}")
    public Medicine newMedicine(@PathVariable String medicineName){
        Medicine newMedicine = new Medicine(medicineName);
        return medicineRepository.save(newMedicine);
    }

    //=============Type==================
    @GetMapping("/Type")
    public Collection<Type> Type(){
        return typeRepository.findAll();
    }
    @GetMapping("/Type/{typeID}")
    public Optional<Type> takeinTypeByid(@PathVariable Long typeID ){
        return typeRepository.findById(typeID);
    }
    @PostMapping("/Type/addType/{typeName}")
    public Type newType(@PathVariable String typeName){
        Type newType = new Type(typeName); 
        return typeRepository.save(newType); 
    }
}
