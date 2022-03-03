package com.example.demo.entity;


import java.sql.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import lombok.Data;


@Entity
@Data
public class Employee {
    @Id
    private Integer id;
    private String name;
    private Integer gender;
    private String password;
    private String email;
    private String phone;
    private Date registDate;

    @ManyToOne
    private Department departmentId;

    @OneToOne(mappedBy = "employeeId")
    private Task task;
}