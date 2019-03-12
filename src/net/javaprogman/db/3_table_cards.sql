CREATE TABLE `cards` 
(
  `cardNumber` varchar(16) NOT NULL PRIMARY KEY,
  `pin` varchar(4) DEFAULT NULL,
  `acc_key` int(11) unsigned NOT NULL
); 


alter table  cards add constraint fk_card_accounts foreign key(acc_key) references accounts(acc_key);






insert into cards (cardNumber, pin, acc_key) 
values ('0000001234', null,1);
insert into cards (cardNumber, pin, acc_key) 
values ('0000019876', 1234,2);
insert into cards (cardNumber, pin, acc_key) 
values ('0000099999', 7777,3);