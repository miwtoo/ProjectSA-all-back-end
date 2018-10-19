package com.cpe.sa.main.entity;
import javax.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
public class TypePill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String type;

    public TypePill() {
    }

    public TypePill(String type) {
        this.type = type;

    }

}