package com.cpe.sa.main.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;
import java.util.Date;
import java.time.format.DateTimeFormatter;


@Entity
@Data
@Table(name="personnel")
public class personnel {
    @Id
    @GeneratedValue
    private  @NonNull Long personid;
    private  @NonNull String name;
    private  @NonNull String phone ;
    private  @NonNull String addrees;
    private  @NonNull String email;
    private  @NonNull Long ssid;
    @Temporal(TemporalType.DATE)
    private  @NonNull Date birthday;

    private  @NonNull String username;
    private  @NonNull String password;



    protected personnel(){}

    public personnel(String name,String phone,String addrees,String email,Long ssid,Date birthday,Long personid , String userName, String passWord)

    {


        this.personid=personid;
        this.name=name;
        this.phone=phone;
        this.addrees=addrees;
        this.birthday = birthday ;
        this.email=email;
        this.ssid=ssid;
        this.password=passWord;
        this.username=userName;





    }
}
