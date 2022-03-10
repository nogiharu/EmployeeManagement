package com.example.semaple20220309.dao;

import java.util.List;

import com.example.semaple20220309.entity.Employee;
import com.example.semaple20220309.form.EmployeeQuery;

public interface EmployeeDAO {
    List<Employee> findByCriteria(EmployeeQuery employeeQuery);
}