drop table customer if exists;

create table customer(
	id int auto_increment primary key,
	login varchar(100) NOT NULL unique,
	password varchar(100) NOT NULL
);

insert into customer values(null,'taro','123');
insert into customer values(null,'hanako','234');
insert into customer values(null,'kaho','345');