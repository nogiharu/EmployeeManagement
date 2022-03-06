package com.example.seamaple_20220305.dao;

import java.util.List;

import com.example.seamaple_20220305.entity.Employee;
import com.example.seamaple_20220305.form.EmployeeQuery;

public interface EmployeeDAO {
    List<Employee> findByCriteria(EmployeeQuery employeeQuery);
}