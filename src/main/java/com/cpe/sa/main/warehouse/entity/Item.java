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
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;
    private float price;
    private int amount;

    @ManyToOne
    @JoinColumn(name="type_id")
    private TypeList type;

    @OneToMany(mappedBy = "itemId")
    @JsonIgnore
    private List<Withdraw> withdraws = new ArrayList<>();


    public Item(){}

    public Item(Long itemId){
        this.itemId = itemId;
    }

    public Item(String itemName, float price,int amount, Long type) {
        this.itemName = itemName;
        this.price = price;
        this.amount = amount;

        TypeList list = new TypeList();
        list.setTypeId(type);
        this.type = list;
    }
}