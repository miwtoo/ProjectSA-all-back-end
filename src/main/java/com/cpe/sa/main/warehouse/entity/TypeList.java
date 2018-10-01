package com.cpe.sa.main.warehouse.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "Type_List")
public class TypeList {
    @Id
    @GeneratedValue
    @Column(name = "type_id")
    private Long typeId;

    private String type;

    public TypeList(){}

    public TypeList(String type){
        this.type = type;
    }
}
