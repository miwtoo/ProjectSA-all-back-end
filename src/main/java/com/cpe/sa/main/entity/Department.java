package com.cpe.sa.main.entity;
import javax.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Data
@Table(name="department")

public class Department {
    @Id()
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private  @NonNull Long deploy_id;
    private  @NonNull String deploy_name;

    protected Department(){}

    public Department( String deploy_name){
        this.deploy_name=deploy_name;
    }
}


