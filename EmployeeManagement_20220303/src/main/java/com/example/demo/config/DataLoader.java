package com.example.demo.config;

import java.sql.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repositoy.DepartmentRepository;
import com.example.demo.repositoy.EmployeeRepository;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class DataLoader implements CommandLineRunner {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public void run(String... args) throws Exception {

        Department department1 = departmentRepository.getById(1);
        Department department2 = departmentRepository.getById(2);

        Employee emp4 = new Employee();
        emp4.setEmail("opqrs@co.ho.jp");
        emp4.setGender(0);
        emp4.setPhone("090-0909-8088");
        emp4.setRegistDate(Date.valueOf("2025-09-17"));
        emp4.setName("あかり");
        emp4.setPassword("123");
        emp4.setId(1);
        emp4.setDepartmentId(department1);
        employeeRepository.save(emp4);

        emp4 = new Employee();
        emp4.setEmail("opqrs@co.ho.jp");
        emp4.setGender(0);
        emp4.setPhone("090-0909-8088");
        emp4.setRegistDate(Date.valueOf("2025-09-17"));
        emp4.setName("太郎");
        emp4.setPassword("123");
        emp4.setId(2);
        emp4.setDepartmentId(department2);
        employeeRepository.save(emp4);

        emp4 = new Employee();
        emp4.setEmail("opqrs@co.ho.jp");
        emp4.setGender(0);
        emp4.setPhone("090-0909-8088");
        emp4.setRegistDate(Date.valueOf("2025-09-17"));
        emp4.setName("山田");
        emp4.setPassword("123");
        emp4.setId(3);
        emp4.setDepartmentId(department2);
        employeeRepository.save(emp4);

        emp4 = new Employee();
        emp4.setEmail("opqrs@co.ho.jp");
        emp4.setGender(0);
        emp4.setPhone("090-0909-8088");
        emp4.setRegistDate(Date.valueOf("2025-09-17"));
        emp4.setName("金子");
        emp4.setPassword("123");
        emp4.setId(4);
        emp4.setDepartmentId(department1);
        employeeRepository.save(emp4);

    }

}