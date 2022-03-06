package com.example.seamaple_20220305.entity;


import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Employee {
    @Id
    private Integer Id;
    private String name;
    private Integer gender;
    private String password;
    private String email;
    private String phone;
    private Date registDate;

}