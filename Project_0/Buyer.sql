drop table if exists Buyers;
create table if not exists Buyers(
	id serial primary key,
	username varchar(20) unique not null,
	b_passwarod varchar(20) not null,
	b_name varchar(20) not null
);

drop table if exists Sellers;
create table if not exists Sellers(
	id serial primary key,
	s_username varchar(20) unique not null,
	s_passwarod varchar(20) not null,
	s_name varchar(20) not NULL,
	s_seller boolean
);

drop table if exists Albums;
create table if not exists Albums(
	id serial primary key,
	title varchar(50),
	artist varchar(50),
	price decimal(5,2) 
);

insert into Albums (title, artist, price) values ('Kill by Inches', 'Shay Snell', 25.11);
insert into Albums (title, artist, price) values ('Cuenca Crime, The (Crimen de Cuenca, El)', 'Darrin Treswell', 19.95);
insert into Albums (title, artist, price) values ('Last Song, The', 'Brendis Rowley', 26.35);
insert into Albums (title, artist, price) values ('Redacted', 'Shirlee Hruska', 27.33);
insert into Albums (title, artist, price) values ('12 Dates of Christmas', 'Crosby Kindell', 23.95);
insert into Albums (title, artist, price) values ('Sorry, Haters', 'Falkner Yerrill', 21.31);
insert into Albums (title, artist, price) values ('With Love... from the Age of Reason', 'Loutitia McOrkill', 26.46);
insert into Albums (title, artist, price) values ('Tintin and I', 'Andonis Tranmer', 21.91);
insert into Albums (title, artist, price) values ('No Where No One (Hich Koja Hich Kas)', 'Perkin Antonin', 28.16);
insert into Albums (title, artist, price) values ('Shogun''s Ninja (Ninja bugeicho momochi sandayu)', 'Vickie Kerslake', 25.19);