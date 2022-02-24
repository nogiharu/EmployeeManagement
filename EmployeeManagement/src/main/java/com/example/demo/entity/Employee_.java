package com.example.demo.entity;

import java.sql.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Employee.class)
public abstract class Employee_ {

	public static volatile SingularAttribute<Employee, String> password;
	public static volatile SingularAttribute<Employee, Integer> gender;
	public static volatile SingularAttribute<Employee, String> phone;
	public static volatile SingularAttribute<Employee, String> name;
	public static volatile SingularAttribute<Employee, Integer> Id;
	public static volatile SingularAttribute<Employee, String> email;
	public static volatile SingularAttribute<Employee, Date> registDate;

	public static final String PASSWORD = "password";
	public static final String GENDER = "gender";
	public static final String PHONE = "phone";
	public static final String NAME = "name";
	public static final String ID = "Id";
	public static final String EMAIL = "email";
	public static final String REGIST_DATE = "registDate";

}

