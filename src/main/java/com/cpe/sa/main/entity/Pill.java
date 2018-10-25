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

    @OneToMany(cascade = CascadeType.ALL, mappedBy="pill")
    @JsonIgnore
    private List<Inform> inform = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="pill")
    @JsonIgnore
    private List<MedicineData> medicineData = new ArrayList<>();

    

    protected Pill() {}

    public Pill(String name) {
        this.name = name;
    }
}