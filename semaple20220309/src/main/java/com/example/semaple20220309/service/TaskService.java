package com.example.semaple20220309.service;


import java.util.List;

import com.example.semaple20220309.entity.Employee;
import com.example.semaple20220309.entity.Task;


public interface TaskService {
	void taskSave(Employee employee);
	List<Task> findFlg(Integer id,boolean flg);
}
