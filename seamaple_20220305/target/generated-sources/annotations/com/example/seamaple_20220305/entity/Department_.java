package com.example.seamaple_20220305.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Department.class)
public abstract class Department_ {

	public static volatile SingularAttribute<Department, String> name;
	public static volatile ListAttribute<Department, Task> taskList;
	public static volatile SingularAttribute<Department, Integer> id;

	public static final String NAME = "name";
	public static final String TASK_LIST = "taskList";
	public static final String ID = "id";

}

