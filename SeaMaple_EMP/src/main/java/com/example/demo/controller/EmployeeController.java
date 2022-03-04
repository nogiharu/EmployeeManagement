package com.example.demo.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.dao.EmployeeDAO;
import com.example.demo.entity.Employee;
import com.example.demo.form.EmployeeForm;
import com.example.demo.form.EmployeeQuery;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.valition.Groups;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class EmployeeController {
    private final EmployeeRepository employeeRepository;
    private final HttpSession session;
    private final EmployeeDAO dao;

    // 新規登録画面表示
    @GetMapping("/employee/regist")
    public String showRegist(EmployeeForm employeeForm) {
        // 新規登録用の"regist"をセッションに格納
        session.setAttribute("mode", "regist");
        return "registForm";
    }

    // 新規登録処理
    @PostMapping("/employee/regist/do")
    public String regist(@Validated(Groups.class) EmployeeForm employeeForm,
            BindingResult result) {
        if (result.hasErrors()) {
            return "registForm";
        } else {
            // エラーがなければ新規登録後、リダイレクト
            Employee employee = employeeForm.toEntity();
            employeeRepository.save(employee);

            //

            return "redirect:/employee";
        }
    }

    // 社員一覧画面を表示
    @GetMapping("/employee")
    public String showEmployee(EmployeeQuery employeeQuery, Model model) {
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employeeList", employeeList);
        return "employeeList";
    }

    // 更新画面を表示
    @GetMapping("/employee/{id}")
    public String employeeById(@PathVariable int id, Model model) {
        // 更新用の"update"をセッションに格納
        session.setAttribute("mode", "update");
        Employee employee = employeeRepository.findById(id).get();
        // Employee -> EmployeeFormへ変換
        model.addAttribute("employeeForm", new EmployeeForm(employee));
        return "registForm";
    }

    // 更新処理
    @PostMapping("/employee/update")
    public String updateEmployee(@Validated EmployeeForm employeeForm,
            BindingResult result) {
        if (result.hasErrors()) {
            return "registForm";
        } else {
            // エラーがなければ更新後、リダイレクト
            Employee employee = employeeForm.toEntity();
            employeeRepository.save(employee);
            return "redirect:/employee";
        }
    }

    // 削除処理
    @GetMapping("/employee/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        employeeRepository.deleteById(id);
        return "redirect:/employee";
    }

    // 検索処理
    @PostMapping("/employee/query")
    public String queryEmployee(EmployeeQuery employeeQuery, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "employeeList";
        } else {
            List<Employee> employeeList = dao.findByCriteria(employeeQuery);
            model.addAttribute("employeeList", employeeList);
            return "employeeList";
        }
    }
}