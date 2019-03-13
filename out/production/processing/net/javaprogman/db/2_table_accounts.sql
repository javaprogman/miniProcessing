CREATE TABLE `accounts` 
(
    id int unsigned auto_increment primary key,
    account_number varchar(40) not null unique,
    amount int not null default 0,
    client_id int unsigned,
    foreign key (client_id) references clients(id) on delete set null
); 




insert into accounts (account_number, amount, client_id) 
values ('ACC1234', 250, 1);
insert into accounts (account_number, amount, client_id) 
values ('ACC7894', 50, 2);
insert into accounts (account_number, amount, client_id) 
values ('ACC9999', 0 , 3);