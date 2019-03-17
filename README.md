# miniProcessing
miniProcessing is a program written in Java for an example of working with a MySQL database.


Package db содержит файлы для добавления необходимых таблиц в базу данных. (данные для примера)

Class Tusson (package device) предоставляет следующие методы:
verification - проверяет соответствует ли pin карты pin , который находится в БД;
balance - предоставляет баланс по карте;
p2p - перевод суммы со счета первой карты на счет второй карты.

Class InternetBank (package dbservices) - позволяет через командную строку добавлять/читать/удалять данные из БД посредством классов находящихся в package dbEntityManager.

package dbEntityManager содержит:
EntityController - абстрактный класс для описания методов с сущностями и БД.
ClientController - методы для записи/чтения/изменения/удаления сущности client в БД.
AccountController - методы для записи/чтения/изменения/удаления сущности account в БД.
CardController - методы для записи/чтения/изменения/удаления сущности card в БД.

package DBEntity содержит сущности:
- client (данные клиента);
- account (данные счета);
- card (данные карты);

В классе Main можно проверить работу программы.
