package com.example.seamaple_20220305.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.seamaple_20220305.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}