-- This is a single line comment.

/*
 Multi-line 
 Comment
 
 
 naming convention is snake_case, due to the lack of case sensitivity
*/

--Creating a schema
--create schema company;

drop table if exists employees;
create table if not exists employees(
	e_id serial primary key,
	e_name varchar(50) not null,
	e_username varchar(50) unique,
	e_password varchar(50) not null,
	e_role varchar(50),
	man_e_id integer references employees(e_id)
);

--alter table if exists employees 
--	alter column e-name set data type varchar(75);

drop table if exists tasks;
create table if not exists tasks(
	id serial primary key,
	t_name varchar(30),
	t_description text,
	t_completion varchar(20),
	t_due_date date,
	t_assign_date date default current_date,
	t_assigned_emp integer references employees(e_id)
);

insert into tasks (t_name, t_description, t_completion, t_assigned_emp) values ('laundey', 'washing clothes', 'new', 1);

insert into employees (e_name, e_username, e_password, e_role) values ('Andi', 'adunan0', 'aJPiteCeR', 'Project Manager');
insert into employees (e_name, e_username, e_password, e_role) values ('Rebecca', 'rdigman1', 'ueox4cer8f', 'Systems Administrator III');
insert into employees (e_name, e_username, e_password, e_role) values ('Gage', 'gmcfetridge2', 'I1b2B4l', 'Health Coach III');
insert into employees (e_name, e_username, e_password, e_role) values ('Elenore', 'ederges3', 'Zf2WSxOM', 'Accounting Assistant I');
insert into employees (e_name, e_username, e_password, e_role) values ('Jacinta', 'jrowell4', 'LJxHzw3ApL', 'Marketing Assistant');
insert into employees (e_name, e_username, e_password, e_role) values ('Laurice', 'lbirbeck5', '8DIZUvjvy', 'Administrative Officer');
insert into employees (e_name, e_username, e_password, e_role) values ('Regan', 'rbing6', 'oqks5zWwfzZG', 'Systems Administrator II');
insert into employees (e_name, e_username, e_password, e_role) values ('Taddeusz', 'tblampey7', 'A1FfBz', 'Biostatistician I');
insert into employees (e_name, e_username, e_password, e_role) values ('Elspeth', 'enewbatt8', 'iTQBiGEp2g', 'Speech Pathologist');
insert into employees (e_name, e_username, e_password, e_role) values ('Maynard', 'mshillington9', 'XKXHr8mxe', 'Health Coach IV');

update employees set man_e_id = 1;
update employees set man_e_id = 5 where length(e_role) >17;

update employees set e_name = 'Davey', e_username = 'Agrin', e_password = '4head', e_role = 'Student', man_e_id = 2 where e_id = 11;

update employees set e_name = 'Ddre',e_username = 'VentHero' where e_id = 11;

delete from employees where e_id = 15;

select t.t_name, t.t_description, t.t_completion, e.e_name
	from tasks t
	join employees e 
	on t.t_assigned_emp = e.e_id 
	where t.id =1;

--Retrieve all task assigned to this employee
select * from task where t_assigned_emp = 1;