package com.cpe.sa.main.entity;
import javax.persistence.*;

import org.springframework.context.annotation.Profile;

import lombok.*;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Table(name = "inform")
public class Inform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private Date date;

    @ManyToOne
    @NonNull
    private ProfilesEntity customer;

    @ManyToOne
    @NonNull
    private Pill pill;

    protected Inform() {
    }

}