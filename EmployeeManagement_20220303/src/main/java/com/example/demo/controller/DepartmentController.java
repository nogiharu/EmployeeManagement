package com.example.demo.controller;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repositoy.DepartmentRepository;
import com.example.demo.repositoy.EmployeeRepository;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class DepartmentController {
    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;
    
    @GetMapping("/department")
    public String showDepartment(Model model) {

        List<Department> deplist = departmentRepository.findAll();
        List<Employee> empList = departmentRepository.findById(1).get().getEmployees();
        System.out.println(empList.size());
        model.addAttribute("departmentList", departmentRepository.findAll());
       
        /* model.addAttribute("employee", employeeRepository.findAll()); */
        return "departmentList";
    }
}