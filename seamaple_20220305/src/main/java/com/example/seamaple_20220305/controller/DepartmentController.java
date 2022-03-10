package com.example.seamaple_20220305.controller;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;

import com.example.seamaple_20220305.dao.CalcrationDAO;

import com.example.seamaple_20220305.entity.Department;
import com.example.seamaple_20220305.entity.Task;

import com.example.seamaple_20220305.repository.DepartmentRepository;
import com.example.seamaple_20220305.repository.EmployeeRepository;
import com.example.seamaple_20220305.repository.TaskRepository;

import com.example.seamaple_20220305.service.TaskService;

import org.springframework.data.domain.Example;
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
    private final TaskService taskService;
    private final CalcrationDAO calcrationDAO;

   // private final Calcration calcration;

    @GetMapping("/")
    public String showDepartment(Model model, Task task) {
        //Cal cal = calcration.findByCalcration();

        //System.out.println(cal);

        //Calc calc = calcrationDAOImpl.list();
        calcrationDAO.JPQL().stream().forEach(System.out::println);

        List<Department> departmentList = departmentRepository.findAll();

        model.addAttribute("calc", calcrationDAO.criteria());
        model.addAttribute("departmentList", departmentList);
        return "departmentList";
    }
}