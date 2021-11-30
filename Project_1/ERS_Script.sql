drop table if exists ERS_REIMBURSEMENTS;
drop table if exists ERS_USERS;
drop table if exists ERS_USER_ROLES;
drop table if exists ERS_REIMBURSEMENT_STATUS;
drop table if exists ERS_REIMBURSEMENT_TYPES;

drop table if exists ERS_USER_ROLES;
create table if not exists ERS_USER_ROLES(
ERS_USER_ROLE_ID serial not null primary key,
USER_ROLE varchar(10) not null
);

insert into ERS_USER_ROLES (USER_ROLE) values ('Admin');
insert into ERS_USER_ROLES (USER_ROLE) values ('FM');
insert into ERS_USER_ROLES (USER_ROLE) values ('E');

drop table if exists ERS_USERS;
create table if not exists ERS_USERS(
ERS_USERS_ID serial primary key not null,
ERS_USERNAME varchar(50) unique not null,
ERS_PASSWORD varchar(50) not null,
USER_FIRST_NAME varchar(100)not null,
USER_LAST_NAME varchar(100)not null,
USER_EMAIL varchar(150) unique not null,
USER_ROLE_ID integer not null references ERS_USER_ROLES(ERS_USER_ROLE_ID)
);

insert into ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) values ('Admin', 'Apass','Admin','Nimda','admin@gmail.com',1);
insert into ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) values ('Fman', 'Fpass','Finamcial','Manager','fm@gmail.com',2);
insert into ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) values ('Emp1', 'Epass','Emp','Loyee','emp1@gmail.com',3);
insert into ERS_USERS (ERS_USERNAME, ERS_PASSWORD, USER_FIRST_NAME, USER_LAST_NAME, USER_EMAIL, USER_ROLE_ID) values ('Emp2', 'Epass','Emp','Loyee','emp2@gmail.com',3);

drop table if exists ERS_REIMBURSEMENT_STATUS;
create table if not exists ERS_REIMBURSEMENT_STATUS(
REIMB_STATUS_ID serial primary key not null,
REIMB_STATUS varchar(10) not null
);

drop table if exists ERS_REIMBURSEMENT_TYPES;
create table if not exists ERS_REIMBURSEMENT_TYPES(
REIMB_TYPE_ID serial primary key not null,
REIMB_TYPE varchar(10) not null
);

insert into ERS_REIMBURSEMENT_STATUS (REIMB_STATUS) values ('Pending');
insert into ERS_REIMBURSEMENT_STATUS (REIMB_STATUS) values ('Approved');
insert into ERS_REIMBURSEMENT_TYPES (REIMB_TYPE) values ('Relocation');

drop table if exists ERS_REIMBURSEMENTS;
create table if not exists ERS_REIMBURSEMENTS(
REIMB_ID serial primary key not null,
REIMB_AMOUNT decimal(7,2) not null,
REIMB_SUBMITTED timestamp not null,
REIMB_RESOLVED timestamp,
REIMB_DESCRIPTION varchar(250), --Could maybe use text
--REIMB_RECEIPT blob, --Not sure how this works yet
REIMB_AUTHOR integer references ERS_USERS(ERS_USERS_ID) not null,
REIMB_RESOLVER integer references ERS_USERS(ERS_USERS_ID) not null,
REIMB_STATUS_ID integer references ERS_REIMBURSEMENT_STATUS(REIMB_STATUS_ID) not null,
REIMB_TYPE_ID integer references ERS_REIMBURSEMENT_TYPES(REIMB_TYPE_ID) not null
);

insert into ERS_REIMBURSEMENTS (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) values (156.45, current_timestamp,current_timestamp,'Test', 4, 2, 1, 1);
insert into ERS_REIMBURSEMENTS (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) values (235.65, current_timestamp,current_timestamp,'Test1', 3, 1, 1, 1);
insert into ERS_REIMBURSEMENTS (REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, REIMB_AUTHOR, REIMB_RESOLVER, REIMB_STATUS_ID, REIMB_TYPE_ID) values (300.65, current_timestamp,current_timestamp,'Test2', 4, 1, 1, 1);

--select *
--	from
--	ERS_USERS U left join ERS_USER_ROLES R
--	on U.USER_ROLE_ID = R.ERS_USER_ROLE_ID
--
--select * from ers_users full join ers_user_roles on user_role_id = ers_user_roles.ers_user_role_id where ers_users_id = 1;

--select 
--	U.ers_username Author,
--	M.ers_username Resolver 
--from ERS_REIMBURSEMENTS R
--	left join ERS_USERS U on R.REIMB_AUTHOR = U.ers_users_id 
--	left join ERS_USERS M on R.REIMB_RESOLVER = M.ers_users_id 
	
select REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, U.ers_username Author, M.ers_username Resolver, S.REIMB_STATUS_ID, S.reimb_status Status, T.REIMB_TYPE_ID, T.reimb_type R_Type 
	from ERS_REIMBURSEMENTS R 
	left join ERS_USERS U on R.REIMB_AUTHOR = U.ers_users_id 
	left join ERS_USERS M on R.REIMB_RESOLVER = M.ers_users_id
	left join ERS_REIMBURSEMENT_STATUS S on R.REIMB_STATUS_ID = S.REIMB_STATUS_ID
	left join ERS_REIMBURSEMENT_TYPES T on R.REIMB_TYPE_ID = T.REIMB_TYPE_ID where R.reimb_status_id = 1;
	

select * from ers_reimbursements where reimb_id = 1;
	
select REIMB_ID, REIMB_AMOUNT, REIMB_SUBMITTED, REIMB_RESOLVED, REIMB_DESCRIPTION, U.ers_username Author, M.ers_username Resolver, S.REIMB_STATUS_ID, S.reimb_status Status, T.REIMB_TYPE_ID, T.reimb_type R_Type 
	from ERS_REIMBURSEMENTS R 
	left join ERS_USERS U on R.REIMB_AUTHOR = U.ers_users_id 
	left join ERS_USERS M on R.REIMB_RESOLVER = M.ers_users_id
	left join ERS_REIMBURSEMENT_STATUS S on R.REIMB_STATUS_ID = S.REIMB_STATUS_ID
	left join ERS_REIMBURSEMENT_TYPES T on R.REIMB_TYPE_ID = T.REIMB_TYPE_ID where REIMB_AUTHOR = 4;	
	
	
update ERS_REIMBURSEMENTS set REIMB_AMOUNT = 235.65,REIMB_SUBMITTED = '2021-11-19 17:00:25.803', REIMB_RESOLVED = '2021-11-19 17:00:25.803',REIMB_DESCRIPTION = 'Test1', REIMB_AUTHOR = 3, REIMB_RESOLVER = 1, REIMB_STATUS_ID = 2, REIMB_TYPE_ID = 1 where REIMB_ID = 3;	
	
	
	
	

