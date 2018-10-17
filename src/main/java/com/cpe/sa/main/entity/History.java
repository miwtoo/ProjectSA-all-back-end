package com.cpe.sa.main.entity;

import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
public class History {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private Float amount; // ใช้ int แล้ว error ว่าเห็นเป็น null
    private Date date;

    @ManyToOne()
    private User user;

    @ManyToOne()
    private Item item;

    @ManyToOne()
    private Type type;

    @ManyToOne()
    private Unit unit;

    protected History(){}

    public History(Long userId, Long itemId , Long unitId , String date, String time , Float amount){
        this.user = new User(userId);
    }

}