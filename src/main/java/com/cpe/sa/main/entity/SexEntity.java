package com.cpe.sa.main.entity;
import lombok.*;
import javax.persistence.*;
import java.util.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;

@Entity
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor

@Table(name="Sex")
public class SexEntity {
    @Id
    @GeneratedValue

    private  Long sexid;
    private @NonNull String sex;

   

}
