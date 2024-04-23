drop table if exists my_user;

create table my_user(
                     id bigint auto_increment primary key ,
                     name varchar(255),
                     gender char(1),
                     job varchar(20)
);

insert into my_user(name, gender, job) VALUES ('Danvers', 'F', 'CAPTAIN MARVEL');
