package com.example.demo.repositoy;

import com.example.demo.entity.Task;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Integer>{
    
}