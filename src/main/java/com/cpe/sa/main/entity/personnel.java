package com.cpe.sa.main.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;
@Entity
@Data
@Table(name="personnel")
public class personnel {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)

    private  @NonNull Long personid;
    private  @NonNull String name;
    private  @NonNull String phone ;
    private  @NonNull String addrees;
    private  @NonNull String email;
    private  @NonNull String ssid;
    private  @NonNull String birthday;

    public personnel(Long personid){
        this.personid = personid;
    }

    protected personnel(){}
 
    public personnel(String name,String phone,String addrees,String email,String ssid,String birthday)
    {
        this.name=name;
        this.phone=phone;
        this.addrees=addrees;
        this.birthday=birthday;
        this.email=email;
        this.ssid=ssid;
    } 
}
