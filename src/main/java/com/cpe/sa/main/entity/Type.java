package com.cpe.sa.main.entity;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "Type")
public class Type{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long typeId;
    String typeName;

    protected Type(){}

    public Type(String name){
        this.typeName = name;
    }


}