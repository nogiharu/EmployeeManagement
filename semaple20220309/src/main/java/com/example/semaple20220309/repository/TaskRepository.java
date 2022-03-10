package com.example.semaple20220309.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.example.semaple20220309.entity.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {

	public static final String QUERY_BASE = "SELECT"
			+ " t.department_id,"
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

	public static final String QUERY_DEPARTMENT_ID = QUERY_BASE
			+ " WHERE"
			+ " t.department_id =  :department_id"
			+ " ORDER BY e.id ASC";

	@Query(value = QUERY_BASE, nativeQuery = true)
	List<Task> findAll();

	@Query(value = QUERY_DEPARTMENT_ID, nativeQuery = true)
	List<Task> findByDepartmentId(@Param("department_id") Integer department_id);

	public static final String QUERY_CALC = "select "
	+ " sum(if(delete_flg, sales,0 )),"
	+ " round(avg(if(delete_flg, sales,0 ))),"
	+ " count(delete_flg or null) "
	+ " from task "
	+ " group by department_id";
	@Query(value = QUERY_CALC,nativeQuery = true)
	List<Object> cac();

}
