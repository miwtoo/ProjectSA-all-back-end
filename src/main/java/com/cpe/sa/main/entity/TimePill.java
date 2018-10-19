package com.cpe.sa.main.entity;
import javax.persistence.*;
import lombok.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Data
public class TimePill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String timepill;

    public TimePill() {}

    public TimePill(String timepill) {
        this.timepill = timepill;

    }

}
