package com.cpe.sa.main.warehouse.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.*;

import lombok.*;

@Entity
@Data
@Table(name = "Take_in")
public class TakeIn{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne()
    @JoinColumn(name="user_id")
    private User user_id;

    @ManyToOne()
    @JoinColumn(name="item_id")
    private Item item_id;

    private int amount;
    private  time;
    private Date date;

    protected TakeIn() {}

    

    public TakeIn(Long user_id , Long item_id, int amount){
    
        User user = new User(user_id);
        Item item = new Item(item_id);

        this.user_id = user;
        this.item_id = item;
        this.amount = amount;


        this.time = new Date();
        this.date = new Date();
    }

}
