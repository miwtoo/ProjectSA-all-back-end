package com.cpe.sa.main.entity;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Getter @Setter
public class Orders {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private Integer amount;

    @ManyToOne
    private Pill pill;
    
    @ManyToOne
    @JsonIgnore
    private Receipt receipt;


    protected Orders(){}

}
