create table if not exists Buyer(
	id serial primary key,
	username varchar(20) unique not null,
	b_passwarod varchar(20) not null,
	b_name varchar(20) not null
);

