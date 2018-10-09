package com.cpe.sa.main.entity;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;

@Entity
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    private String userName;
    private String position;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<History> histories = new ArrayList<>();

    protected User(){}

    public User(Long userId){
        this.id = userId;
    }

    public User(String userName, String position){
        this.userName = userName;
        this.position = position;
    }

}
