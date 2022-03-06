

insert into employee(id,email,gender,name,password,phone,regist_date) values(1,'p@p',0,'山崎','1111','090-0000-0000','2020-09-09');
insert into employee(id,email,gender,name,password,phone,regist_date) values(2,'p@p',0,'山田','1111','090-0300-0000','2020-06-09');
insert into employee(id,email,gender,name,password,phone,regist_date) values(3,'p@p',0,'山辺','1111','090-0400-0000','2020-05-09');
insert into employee(id,email,gender,name,password,phone,regist_date) values(4,'p@p',0,'山岸','1111','090-0050-0000','2020-04-09');
insert into employee(id,email,gender,name,password,phone,regist_date) values(5,'p@p',0,'矢沢','1111','090-0050-0000','2020-04-09');



insert into task(area,customers,delete_flg,department_id,department_name,employee_id,sales,update_date) values ('東京',3,0,1,'営業1',1,3000,'2020-10-09');
insert into task(area,customers,delete_flg,department_id,department_name,employee_id,sales,update_date) values ('東京',3,0,2,'営業2',2,3000,'2020-10-09');
insert into task(area,customers,delete_flg,department_id,department_name,employee_id,sales,update_date) values ('東京',3,0,3,'営業3',3,3000,'2020-10-09');
insert into task(area,customers,delete_flg,department_id,department_name,employee_id,sales,update_date) values ('東京',3,0,4,'営業4',4,3000,'2020-10-09');
insert into task(area,customers,delete_flg,department_id,department_name,employee_id,sales,update_date) values ('東京',3,0,4,'営業1',5,3000,'2020-10-09');



select t.employee_id,e.name,t.area,t.sales,t.customers,t.update_date,d.name from task t left join employee e on e.id = t.employee_id left join department d on t.department_id = d.id;


SELECT t.department_id,t.employee_id,e.name,t.area,t.sales,t.customers,t.update_date,t.delete_flg FROM task t INNER JOIN employee e on e.id = t.employee_id;

SELECT t.department_id,t.employee_id,e.name,t.area,t.sales,t.customers,t.update_date,t.delete_flg FROM task t INNER JOIN employee e on e.id = t.employee_id where t.department_id =1 ;