package com.cpe.sa.main.warehouse.entity;

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
    private User userId;

    @ManyToOne()
    @JoinColumn(name="item_id")
    private Item itemId;

    private Integer withdraw_amount; // ใช้ int แล้ว error ว่าเห็นเป็น null

    private Date date;

    protected Withdraw() {}

    public Withdraw(Long userId , Long itemId, Integer withdraw_amount){
    
        User user = new User(userId);
        Item item = new Item(itemId);

        this.userId = user;
        this.itemId = item;
        this.withdraw_amount = withdraw_amount;

        this.date = new Date();
    }
}