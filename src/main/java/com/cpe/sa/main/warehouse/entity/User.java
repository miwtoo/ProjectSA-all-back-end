package com.cpe.sa.main.warehouse.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Getter @Setter
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long user_id;

    private String user_name;
    private String position;

    @OneToMany(mappedBy = "user_id")
    @JsonIgnore
    private List<Withdraw> withdraws = new ArrayList<>();

    protected User(){}

    public User(Long user_id){
        this.user_id = user_id;
    }

    public User(String user_name, String position){
        this.user_name = user_name;
        this.position = position;
    }

}
