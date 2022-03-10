package com.example.semaple20220309.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.semaple20220309.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
}