package com.cpe.sa.main.entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
@Entity
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name="Profiles")
public class ProfilesEntity {
    @Id
    @GeneratedValue
    private  Long profilesid;
    @Column(name="telephonenumber",unique = true)
    private @NonNull String telephonenumber;
    private @NonNull String firstname;
    private @NonNull String lastname;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = SexEntity.class)
    @JoinColumn(name="sexid",insertable = true)
    private @NonNull SexEntity sex;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = PrefixEntity.class)
    @JoinColumn(name="prefixid",insertable = true)
    private @NonNull PrefixEntity prefix;

    @ManyToOne(fetch = FetchType.EAGER, targetEntity = DiseaseEntity.class)
    @JoinColumn(name="diseaseid",insertable = true)
    private @NonNull DiseaseEntity disease;
}
