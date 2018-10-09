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
    @Temporal(TemporalType.DATE)
    private Date date;

    @Temporal(TemporalType.TIME)
    private Date time;

    @ManyToOne()
    private User user;

    @ManyToOne()
    private Item item;

    @ManyToOne()
    private Type type;

    @ManyToOne()
    private Unit unit;

    /* public void setUser(Long id){
         User user = new User();
         user.setId(id);

         this.user = user;
    }


   public void setType(Long id){
        Type type = new Type();
        type.setId(id);

        this.type = type;
    }

    public void setUnit(Long id){
        Unit unit = new Unit();
        unit.setId(id);

        this.unit = unit;
    } */

}