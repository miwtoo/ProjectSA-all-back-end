package com.cpe.sa.main.entity;

import javax.persistence.Entity;
import javax.persistence.*;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
@Table(name = "Used")
public class Used {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;
        private String useds;

        protected Used() {}

        public Used(String useds) {
                this.useds = useds;
        }
}