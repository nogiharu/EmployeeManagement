package com.example.demo.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;
import com.example.demo.service.TaskService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class TaskController {
	private final TaskRepository taskRepository;
	private final TaskService taskService;

	@GetMapping("/")
	public String showDepartment(Model model) {
		List<Task> departmentList = taskRepository.findAll();
		Map<Integer, Integer> totalSales = taskService.sum();
		System.out.println(totalSales);
		model.addAttribute("totalSales ", totalSales);
		model.addAttribute("departmentList",departmentList);
		return "departmentList";
	}

	@GetMapping("/e")
	public String showTask(Model model,Task task) {
		List<Task> taskList = taskRepository.findAll();
		model.addAttribute("taskList", taskList);
		return "taskList";
	}

	@PostMapping
	public String updateTask() {
		return "";
	}
}
