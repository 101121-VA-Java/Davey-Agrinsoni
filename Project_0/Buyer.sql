drop table if exists Buyers;
create table if not exists Buyers(
	id serial primary key,
	b_username varchar(20) unique not null,
	b_password varchar(20) not null,
	b_name varchar(20) not null
);

insert into Buyers (b_username, b_password, b_name) values ('bgerlack0', 'fUcik8z', 'Benny');
insert into Buyers (b_username, b_password, b_name) values ('fjeary1', 'XY6R9By6NF', 'Faulkner');
insert into Buyers (b_username, b_password, b_name) values ('pshadbolt2', 'Y4D7eovL5M', 'Perry');
insert into Buyers (b_username, b_password, b_name) values ('pcanfield3', 'y58bAeG', 'Patric');
insert into Buyers (b_username, b_password, b_name) values ('bdivall4', 'OhdkQA', 'Bryn');
insert into Buyers (b_username, b_password, b_name) values ('alorimer5', 'DAhFti82DOll', 'Allen');
insert into Buyers (b_username, b_password, b_name) values ('cbrough6', 'aG6LUowyz', 'Clementius');
insert into Buyers (b_username, b_password, b_name) values ('dpheasey7', '8O3bw8', 'Danie');
insert into Buyers (b_username, b_password, b_name) values ('lpiers8', '1o7VQB', 'L;urette');
insert into Buyers (b_username, b_password, b_name) values ('aaizikov9', 'fCiIyZLk', 'Aylmer');

delete from Buyers where id = 13;

select * from Buyers where b_username = 'Bob';

drop table if exists Sellers;
create table if not exists Sellers(
	id serial primary key,
	s_username varchar(20) unique not null,
	s_password varchar(20) not null,
	s_name varchar(20) not null,
	s_seller boolean
);

insert into Sellers (s_username, s_password, s_name, s_seller) values ('mgingedale0', 'kvFbK41lJXK', 'Marijo', true);
insert into Sellers (s_username, s_password, s_name, s_seller) values ('bfacher1', 'G7S0SX3eH3', 'Bobbie', false);
insert into Sellers (s_username, s_password, s_name, s_seller) values ('nwallicker2', 'DoNS1gi', 'Nerti', true);
insert into Sellers (s_username, s_password, s_name, s_seller) values ('skeeton3', 'Ca2NYNq0YZ', 'Simmonds', false);
insert into Sellers (s_username, s_password, s_name, s_seller) values ('jabramson4', 't7OsBTqADR', 'Jayson', false);
insert into Sellers (s_username, s_password, s_name, s_seller) values ('apidon5', 'sDqO2CquAd4', 'Anna-diana', false);
insert into Sellers (s_username, s_password, s_name, s_seller) values ('akohrt6', 'Qv4gHPPK', 'Afton', true);
insert into Sellers (s_username, s_password, s_name, s_seller) values ('cfulop7', 'CH8VpE42ZDW', 'Candi', true);
insert into Sellers (s_username, s_password, s_name, s_seller) values ('rmacneill8', 'nhDrR4j9', 'Ranique', true);
insert into Sellers (s_username, s_password, s_name, s_seller) values ('ctriplett9', 'XpnB7L2DdEc', 'Catherin', true);

drop table if exists Albums;
create table if not exists Albums(
	id serial primary key,
	title varchar(50),
	artist varchar(50),
	price decimal(5,2) 
);

insert into Albums (title, artist, price) values ('Frederhythm2', 'frederic', 25.11);
insert into Albums (title, artist, price) values ('何者', 'Polkadot Stingray', 28.16);
insert into Albums (title, artist, price) values ('Intro Bonito', 'Kero Kero Bonito', 26.35);
insert into Albums (title, artist, price) values ('SMILE', 'tofubeats', 27.33);
insert into Albums (title, artist, price) values ('CITY2CITY', 'tofubeats', 23.95);
insert into Albums (title, artist, price) values ('Moe Moe', 'Moe Shop', 21.31);
insert into Albums (title, artist, price) values ('Slice of Life', 'cute girls doing cute things', 26.46);
insert into Albums (title, artist, price) values ('METROPOLIS.exe', 'ミカヅキBIGWAVE', 21.91);
insert into Albums (title, artist, price) values ('A Million Miles Away', 'Macross 82-99', 28.16);
insert into Albums (title, artist, price) values ('Bae', 'Yung Bae', 25.19);
insert into Albums (title, artist, price) values ('おとぎ', 'Eve', 25.19);


delete from Albums where id = 10;

select * from Albums;
select distinct on (title) id, title, artist, price from Albums order by title;

drop table if exists Bags;
create table if not exists Bags(
	id serial primary key,
	buyer_id integer references Buyers(id),
	title varchar(50),
	artist varchar(50),
	price decimal(5,2),
	paid boolean
);

insert into Bags ( buyer_id, title, artist, price, paid) values (1,1);
delete from Bags where 
update Bags set paid = true where id = 1;
select * from Bags where id = 4;
