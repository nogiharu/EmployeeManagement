package com.example.demo.entity;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Task {

	private Integer department_id;

	private String department_name;

	@Id
	private Integer employee_id;

	private String name;

	private String area;

	private Integer sales;

	private Integer customers;

	private Date update_date;

	private boolean delete_flg;
}