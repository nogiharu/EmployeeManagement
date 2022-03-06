package com.example.seamaple_20220305.controller;


import java.util.List;


import com.example.seamaple_20220305.entity.Department;

import com.example.seamaple_20220305.repository.DepartmentRepository;
import com.example.seamaple_20220305.repository.EmployeeRepository;
import com.example.seamaple_20220305.repository.TaskRepository;
import com.example.seamaple_20220305.service.DepartmentService;
import com.example.seamaple_20220305.service.TaskService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRepository departmentRepository;
    private final TaskRepository taskRepository;
    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;
    private final TaskService taskService;

    @GetMapping("/")
    public String showDepartment(Model model) {

        /* if (employeeRepository.findAll().size() > 0) {
            taskService.taskSave();
        } */

        List<Department> departmentList = departmentRepository.findAll();


        model.addAttribute("salesTotal", departmentService.salesTotal());
        model.addAttribute("salesAverage", departmentService.salesAverage());
        model.addAttribute("departmentList", departmentList);
        return "departmentList";
    }
}