package com.example.seamaple_20220305.dao;

import java.math.BigInteger;
import java.util.List;

import com.example.seamaple_20220305.dto.Calc;

public interface CalcrationDAO {
    List<Calc> criteria();
    List<Calc> JPQL();
}