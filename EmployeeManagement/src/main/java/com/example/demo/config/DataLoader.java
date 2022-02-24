package com.example.demo.config;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Employee;
import com.example.demo.repositoy.EmployeeRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner{

    private final EmployeeRepository repository;

    @Override
    public void run(String... args) throws Exception {
        Employee emp = new Employee(1, "太郎", 0, "123", "abcdef@co.jp", "090-0909-8888", Date.valueOf("2010-10-12"));
        repository.save(emp);
        emp = new Employee(2, "あゆみ", 1, "123", "ghij@co.go.jp", "070-0939-8888", Date.valueOf("2015-03-12"));
        repository.save(emp);
        emp = new Employee(3, "次郎", 0, "123", "klmn@co.jo.jp", "080-0909-8988", Date.valueOf("2020-12-01"));
        repository.save(emp);
        emp = new Employee(4, "あかり", 1, "123", "opqrs@co.ho.jp", "090-0909-8088", Date.valueOf("2025-09-17"));
        repository.save(emp);
    }

}