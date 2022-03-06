package com.example.seamaple_20220305.service;

import org.springframework.stereotype.Service;


import com.example.seamaple_20220305.entity.Employee;
import com.example.seamaple_20220305.entity.Task;
import com.example.seamaple_20220305.repository.DepartmentRepository;
import com.example.seamaple_20220305.repository.EmployeeRepository;
import com.example.seamaple_20220305.repository.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
	private final TaskRepository taskRepository;
	private final EmployeeRepository employeeRepository;
	private final DepartmentRepository departmentRepository;

	@Override
	public void taskSave(Employee employee) {

		/* List<Employee> employeeList = employeeRepository.findAll();
		List<Department> departments = departmentRepository.findAll();

		for (int i = 0; i < employeeList.size(); i++) {
			int id = employeeList.get(i).getId();
			String name = employeeList.get(i).getName();
			Task task = new Task();

			int total = departments.size();
			task.setDeleteFlg(true);
			task.setEmployeeId(id);
			task.setName(name);
			task.setDepartment(departmentRepository.getById((int) (Math.random() * total) + 1));
			task.setSales((int) (Math.random() * 10000));
			taskRepository.save(task);
		} */

		int total = departmentRepository.findAll().size();
            Task task = new Task();
            task.setDeleteFlg(true);
            task.setEmployeeId(employee.getId());
            task.setName(employee.getName());
            task.setDepartment(departmentRepository.getById((int)(Math.random() * total)+1));
            task.setSales((int)(Math.random() * 10000));
            taskRepository.save(task);
	}

}
