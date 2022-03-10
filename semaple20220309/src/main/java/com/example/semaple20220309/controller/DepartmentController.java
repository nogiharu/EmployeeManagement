package com.example.semaple20220309.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.example.semaple20220309.dao.CalculationDAO;
import com.example.semaple20220309.dto.Calculation;
import com.example.semaple20220309.entity.Department;

import com.example.semaple20220309.repository.DepartmentRepository;
import com.example.semaple20220309.repository.TaskRepository;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

   
    private final HttpSession session;
    private final TaskRepository taskRepository;
    private final CalculationDAO calcDAO;


    @GetMapping("/department")
    public String showDepartment(Model model, Department department) {
        session.invalidate();
        List<Department> departmentList = departmentRepository.findAll();

       List<Calculation> calcList = calcDAO.findByJPQL();
       for (Calculation calculation : calcList) {
           System.out.println("[AVG]"+calculation.getAverage());
           System.out.println("[TOTAL]"+calculation.getTotal());
           System.out.println("[COUNT]"+calculation.getCount());
           System.out.println("[NAME]"+calculation.getName());
           System.out.println("[ID]"+calculation.getId());
       }
       //System.out.println("[SIZE]"+calcList.size());
   
       // model.addAttribute("departmentList", departmentList);
        model.addAttribute("calcList", calcDAO.findByJPQL());
   
        return "departmentList";
    }

    @PostMapping("/department/regist")
    public String registDepartment(Department department, Model model) {
        departmentRepository.save(department);
        return "redirect:/department";
    }
}