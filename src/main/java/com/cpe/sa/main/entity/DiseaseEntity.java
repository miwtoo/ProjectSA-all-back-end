package com.cpe.sa.main.entity;

import lombok.*;
import javax.persistence.*;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity
@Data
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@Table(name="Disease")
public class DiseaseEntity {
    @Id
    @GeneratedValue
    private
    Long diseaseid;
    private @NonNull String allergy;

}

