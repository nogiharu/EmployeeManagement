package com.example.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Task;
import com.example.demo.repository.TaskRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
	private final TaskRepository taskRepository;

	@Override
	public Map<Integer, Integer> sum() {
		List<Task> taskList = taskRepository.findAll();


		int sum1 = taskList.stream().filter(t -> t.getDepartment_id() ==1).mapToInt(t -> t.getSales()).sum();
		int sum2 = taskList.stream().filter(t -> t.getDepartment_id() ==2).mapToInt(t -> t.getSales()).sum();
		int sum3 = taskList.stream().filter(t -> t.getDepartment_id() ==3).mapToInt(t -> t.getSales()).sum();
		int sum4 = taskList.stream().filter(t -> t.getDepartment_id() ==4).mapToInt(t -> t.getSales()).sum();

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(1, sum1);
		map.put(2, sum2);
		map.put(3, sum3);
		map.put(4, sum4);

		return map;
	}

}
