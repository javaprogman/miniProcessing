CREATE TABLE `accounts` 
(

  `cln_key` int(11) unsigned NOT NULL,
  `acc_key` int(11) unsigned NOT NULL PRIMARY KEY AUTO_INCREMENT,
  `account` varchar(20) NOT NULL UNIQUE,
  `amount` Double DEFAULT NULL
); 


alter table  accounts add constraint fk_accounts_clients foreign key(cln_key) references clients(cln_key);






insert into accounts (cln_key, account, amount) 
values (1,'ACC1234', 250);
insert into accounts (cln_key, account, amount) 
values (2,'ACC7894', 50);
insert into accounts (cln_key, account, amount) 
values (3,'ACC9999', 0);