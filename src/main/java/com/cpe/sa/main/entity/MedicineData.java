package com.cpe.sa.main.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Data
@Table(name = "MedicineData")
public class MedicineData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private @NonNull String brand;
    private @NonNull String detail; //สรรพคุณ

    @ManyToOne()
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne()
    @JoinColumn(name = "typeId")
    private TypePill type;

    @ManyToOne()
    @JoinColumn(name = "medicineId")
    private Pill pill;



    public MedicineData(String brand,String detail) {
        User user = new User();
        Pill pill = new Pill();
        TypePill type = new TypePill();
        this.brand = brand;
        this.detail = detail;
    }

}