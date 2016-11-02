use maven;
create table if not exists t_user(
id int auto_increment primary key,
username varchar(20),
password varchar(20)
);