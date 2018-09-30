package com.cpe.sa.main.warehouse.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Getter @Setter
@Table(name = "Item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    private String item_name;
    private float price;
    private int amount;

    @ManyToOne
    @JoinColumn(name="type_id")
    private TypeList type;

    @OneToMany(mappedBy = "item_id")
    @JsonIgnore
    private List<Withdraw> withdraws = new ArrayList<>();


    public Item(){}

    public Item(Long item_id){
        this.item_id = item_id;
    }

    public Item(String item_name, float price,int amount, Long type) {
        this.item_name = item_name;
        this.price = price;
        this.amount = amount;

        TypeList list = new TypeList();
        list.setType_id(type);
        this.type = list;
    }
}