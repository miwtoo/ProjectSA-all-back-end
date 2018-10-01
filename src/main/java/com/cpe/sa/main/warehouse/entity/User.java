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
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "user_name")
    private String userName;
    private String position;

    @OneToMany(mappedBy = "userId")
    @JsonIgnore
    private List<Withdraw> withdraws = new ArrayList<>();

    protected User(){}

    public User(Long userId){
        this.userId = userId;
    }

    public User(String userName, String position){
        this.userName = userName;
        this.position = position;
    }

}
