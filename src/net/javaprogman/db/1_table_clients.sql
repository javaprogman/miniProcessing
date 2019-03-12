CREATE TABLE `clients` 
(
  
  `cln_key` int(11) UNSIGNED NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `name` varchar(40) NOT NULL,
  `passport` varchar(16) NOT NULL,
  `birthdate` date NOT NULL,
  `sex` varchar(10) NOT NULL
  );

alter table  clients add constraint fk_clients foreign key(sex) references sex(sex);






insert into clients (name, passport, birthdate, sex) 
values ('Alexander Vod', 'MP12345','1984-03-10', 'MALE');
insert into clients (name, passport, birthdate, sex) 
values ('Mihail Kun', 'MP987665','1987-11-12', 'MALE');
insert into clients (name, passport, birthdate, sex) 
values ('That same','MP000000','1999-10-27', 'FEMALE');