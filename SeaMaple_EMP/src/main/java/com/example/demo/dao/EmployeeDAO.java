package com.example.demo.dao;

import java.util.List;

import com.example.demo.entity.Employee;
import com.example.demo.form.EmployeeQuery;

public interface EmployeeDAO {
    List<Employee> findByCriteria(EmployeeQuery employeeQuery);
}