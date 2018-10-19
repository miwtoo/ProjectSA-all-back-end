package com.cpe.sa.main.entity;

import java.util.*;
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
@Table(name="Prefix")

public class PrefixEntity {
    @Id
    @GeneratedValue

    private  Long prefixid;
    private @NonNull String prefix;

}
