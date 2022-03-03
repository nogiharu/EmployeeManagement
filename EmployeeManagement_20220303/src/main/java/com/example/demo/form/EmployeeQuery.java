package com.example.demo.form;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import lombok.Data;

@Data
public class EmployeeQuery {
    
    private Integer gender;
    private String email;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dateFrom;
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dateTo;

    public EmployeeQuery() {
        setGender(-1);
        setEmail("");
    }
}