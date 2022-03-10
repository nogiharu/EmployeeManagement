package com.example.seamaple_20220305.dto;

import java.math.BigDecimal;

import org.hibernate.type.BigDecimalType;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data

public class Calc {
    private long total;

    public Calc(long l) {
      total = l;
    }
}