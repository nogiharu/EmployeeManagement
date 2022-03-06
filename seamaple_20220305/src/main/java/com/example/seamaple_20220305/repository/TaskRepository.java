package com.example.seamaple_20220305.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.seamaple_20220305.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

/* 	public static final String QUERY_BASE = "SELECT"
			// + " DISTINCT"
			+ " t.department_id,"
			// + " d.name,"
			+ " t.employee_id,"
			+ " e.name,"
			+ " t.area,"
			+ " t.sales,"
			+ " t.customers,"
			+ " t.update_date,"
			+ " t.delete_flg"
			+ " FROM task t "
			+ " INNER JOIN employee e "
			+ " ON e.id = t.employee_id";
	// + " INNER JOIN department d";
	// + " ON t.department_id = d.id"
	// + " GROUP BY t.department_id"
	// + " ORDER BY d.id";
	public static final String QUERY_DEPARTMENT_ID = QUERY_BASE
			+ " WHERE"
			+ " t.department_id =  :department_id"
			+ " ORDER BY e.id ASC";

	@Query(value = QUERY_BASE, nativeQuery = true)
	List<Task> findAll();

	@Query(value = QUERY_DEPARTMENT_ID, nativeQuery = true)
	List<Task> findByDepartmentId(@Param("department_id") Integer department_id); */

}
