package com.example.semaple20220309.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Calculation {
    private String name;
    private Integer id;
    private long total;
    private double average;
    private long count;
    
    
}