drop table if exists ERS_USER_ROLES;
create table if not exists ERS_USER_ROLES(
ERS_USER_ROLE_ID serial not null primary key,
USER_ROLE varchar(10) not null
);



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
REMI_TYPE_ID integer references ERS_REIMBURSEMENT_TYPES(REIMB_TYPE_ID) not null
);


