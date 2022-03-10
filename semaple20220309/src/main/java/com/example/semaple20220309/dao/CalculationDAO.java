package com.example.semaple20220309.dao;

import java.util.List;

import com.example.semaple20220309.dto.Calculation;

public interface CalculationDAO {

    List<Calculation> findByCriteria();
    List<Calculation> findByJPQL();
}