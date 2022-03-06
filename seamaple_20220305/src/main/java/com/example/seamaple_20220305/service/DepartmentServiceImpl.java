package com.example.seamaple_20220305.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

import java.util.stream.Collectors;


import com.example.seamaple_20220305.entity.Department;
import com.example.seamaple_20220305.entity.Task;
import com.example.seamaple_20220305.repository.DepartmentRepository;


import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;

    @Override
    public List<Integer> salesTotal() {

        List<Department> departments = departmentRepository.findAll();
        List<Integer> totalList = new ArrayList<>();
        for (int i = 0; i < departments.size(); i++) {
            List<Task> tasks = departments.get(i).getTaskList();
            totalList.add(i, tasks.stream()
                    .mapToInt(t -> t.getSales())
                    .sum());
        }
        return totalList;
    }

    @Override
    public List<Integer> salesAverage() {
        List<Department> departments = departmentRepository.findAll();
        Double[] averageArray = new Double[departments.size()];
        
        for (int i = 0; i < departments.size(); i++) {
            List<Task> tasks = departments.get(i).getTaskList();
            try {
                averageArray[i] = tasks.stream()
                        .mapToInt(t -> t.getSales())
                        .average()
                        .getAsDouble();
            } catch (NoSuchElementException e) {
                averageArray[i] = 0.0;
            }
        }
        List<Integer> averageList = Arrays.stream(averageArray).map(x -> new BigDecimal(x).intValue())
                .collect(Collectors.toList());
        return averageList;
    }

}
