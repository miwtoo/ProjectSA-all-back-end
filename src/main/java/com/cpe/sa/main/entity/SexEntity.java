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

    //@OneToMany(mappedBy="profilesid") //delete Cascade
   // private List<ProfilesEntity> comments = new ArrayList<ProfilesEntity>();

    //@OneToMany(fetch = FetchType.EAGER,orphanRemoval = true,cascade = CascadeType.PERSIST)
   // @JoinColumn(name="sexid", referencedColumnName="sexid", insertable = true)
    //private List<ProfilesEntity> comments = new ArrayList<ProfilesEntity>();

}
