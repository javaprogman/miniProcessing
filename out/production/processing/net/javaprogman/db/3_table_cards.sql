CREATE TABLE `cards` 
(
  cardNumber varchar(16) NOT NULL PRIMARY KEY,
  pin varchar(4) DEFAULT NULL,
  account_id int(11) unsigned,
  foreign key (account_id) references accounts(id) on delete set null,
  client_id int unsigned,
  foreign key (client_id) references clients(id) on delete set null
); 






insert into cards (cardNumber, pin, account_id, client_id) 
values ('0000001234', null, 1, 1);
insert into cards (cardNumber, pin, account_id, client_id) 
values ('0000019876', 1234, 2, 2);
insert into cards (cardNumber, pin, account_id, client_id) 
values ('0000099999', 7777, 3, 3);