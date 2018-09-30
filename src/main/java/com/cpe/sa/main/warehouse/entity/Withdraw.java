package com.cpe.sa.main.warehouse.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.*;
import lombok.*;

@Entity
@Getter @Setter
@Table(name = "Withdraw")
public class Withdraw {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user_id;

    @ManyToOne()
    @JoinColumn(name="item_id")
    private Item item_id;

    private Integer withdraw_amount; // ใช้ int แล้ว error ว่าเห็นเป็น null
    private Timestamp time;
    private Date date;

    protected Withdraw() {}

    public Withdraw(Long user_id , Long item_id, Integer withdraw_amount){
    
        User user = new User(user_id);
        Item item = new Item(item_id);

        this.user_id = user;
        this.item_id = item;
        this.withdraw_amount = withdraw_amount;

        this.date = new Date();
        this.time = new Timestamp(System.currentTimeMillis());
    }
}