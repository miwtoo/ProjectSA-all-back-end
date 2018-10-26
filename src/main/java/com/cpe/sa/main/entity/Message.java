package com.cpe.sa.main.entity;

import javax.persistence.*;
import lombok.*;

@Entity
@Data
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String message;

    public Message() {
    }

    public Message(String message) {
        this.message = message;
    }
}