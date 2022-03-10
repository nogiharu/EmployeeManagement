package com.example.semaple20220309.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.example.semaple20220309.entity.Employee;
import com.example.semaple20220309.entity.Task;
import com.example.semaple20220309.repository.DepartmentRepository;
import com.example.semaple20220309.repository.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
	private final TaskRepository taskRepository;
	private final DepartmentRepository departmentRepository;

	@Override
	public void taskSave(Employee employee) {

		//初期値セット
		int total = departmentRepository.findAll().size();
		Task task = new Task();
		task.setDeleteFlg(true);
		task.setEmployeeId(employee.getId());
		task.setName(employee.getName());
		task.setUpdateDate(LocalDate.now());
		task.setCustomers((int) (Math.random() * 10));
		// 営業課をランダムで振り分け
		task.setDepartment(departmentRepository.getById((int) (Math.random() * total) + 1));
		// 売上をランダムで振り分け
		task.setSales((int) (Math.random() * 10000));
		//task.setSales(0);
		taskRepository.save(task);
	}

	@Override
	public List<Task> findFlg(Integer id,boolean flg) {
		// 該当課の社員リストを取得
		List<Task> taskList = departmentRepository.getById(id).getTaskList();
		// 格納リストを準備
		List<Task> taskFlgList = new ArrayList<>();

		// flgが true なら => DeleteFlgを true のみ指定 => リストに追加
		taskList.stream().filter(t -> flg).filter(t -> t.getDeleteFlg()).forEach(taskFlgList::add);
		// flgが false なら => DeleteFlgを false のみ指定 => リストに追加
		taskList.stream().filter(f -> !flg).filter(f -> !f.getDeleteFlg()).forEach(taskFlgList::add);
		
		return taskFlgList;
	}

}
