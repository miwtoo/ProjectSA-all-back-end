package com.cpe.sa.main.entity;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.List;
import java.util.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Pill")
public class Pill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    private Used used;

    @ManyToOne
    private TypePill typePill;

    @ManyToOne
    private TimePill timePills;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Inform> inform = new ArrayList<>();

    protected Pill() {
    }

    public Pill(String name) {
        this.name = name;
    }
}