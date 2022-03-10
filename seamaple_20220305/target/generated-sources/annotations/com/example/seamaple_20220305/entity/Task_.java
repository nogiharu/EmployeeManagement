package com.example.seamaple_20220305.entity;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Task.class)
public abstract class Task_ {

	public static volatile SingularAttribute<Task, String> area;
	public static volatile SingularAttribute<Task, LocalDate> updateDate;
	public static volatile SingularAttribute<Task, String> name;
	public static volatile SingularAttribute<Task, Boolean> deleteFlg;
	public static volatile SingularAttribute<Task, Integer> employeeId;
	public static volatile SingularAttribute<Task, Integer> customers;
	public static volatile SingularAttribute<Task, Department> department;
	public static volatile SingularAttribute<Task, Integer> sales;

	public static final String AREA = "area";
	public static final String UPDATE_DATE = "updateDate";
	public static final String NAME = "name";
	public static final String DELETE_FLG = "deleteFlg";
	public static final String EMPLOYEE_ID = "employeeId";
	public static final String CUSTOMERS = "customers";
	public static final String DEPARTMENT = "department";
	public static final String SALES = "sales";

}

