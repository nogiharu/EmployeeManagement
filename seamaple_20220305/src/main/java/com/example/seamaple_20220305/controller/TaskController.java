package com.example.seamaple_20220305.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.seamaple_20220305.entity.Employee;
import com.example.seamaple_20220305.entity.Task;
import com.example.seamaple_20220305.repository.DepartmentRepository;
import com.example.seamaple_20220305.repository.EmployeeRepository;
import com.example.seamaple_20220305.repository.TaskRepository;
import com.example.seamaple_20220305.service.TaskService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class TaskController {
	private final TaskRepository taskRepository;
	private final DepartmentRepository departmentRepository;
	private final EmployeeRepository employeeRepository;

	@GetMapping("/task/{id}")
	public String showTask(@PathVariable int id, Model model) {

		List<Task> taskList = departmentRepository.getById(id).getTaskList();
		// List<Task> taskList = taskRepository.findByDepartmentId(id);

		model.addAttribute("taskList", taskList);

		return "taskList";
	}

	@GetMapping("/task/update/{employeeId}")
	public String showUpdateTask(@PathVariable int employeeId, Task task, Model model) {
		task = taskRepository.getById(employeeId);

		model.addAttribute("task", task);
		return "taskForm";
	}

	@PostMapping("/task/update/do")
	public String updateTask(Task task, Model model) {
		taskRepository.save(task);
		return "redirect:/task/" + task.getDepartment().getId();
	}

	@GetMapping("/task/delete/{employeeId}")
	public String deleteTask(@PathVariable int employeeId, Model model) {

		Task task = taskRepository.getById(employeeId);
		System.out.println(task);
		task.setDeleteFlg(false);
		taskRepository.save(task);
		employeeRepository.deleteById(employeeId);
		return "redirect:/task/" + task.getDepartment().getId();
	}
}
