package com.cpe.sa.main.entity;

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
    private Long id;

    private String itemName;
    private Float price;

    @ManyToOne
    private Category category;

    @OneToMany(mappedBy = "item")
    @JsonIgnore
    private List<History> histories = new ArrayList<>();

    protected Item(){}

    public Item(String itemName, Float price, Long category){
        this.itemName = itemName;
        this.price = price;

        Category c = new Category();
        c.setId(category);

        this.category = c;
    }
}