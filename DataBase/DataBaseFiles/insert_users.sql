insert into T_TEMPUSER(NAME,EMAIL) values ('Concejo Municipal','concejomunicipal@sanpablo.go.cr');
insert into T_TEMPUSER(NAME,EMAIL) values ('Secretaria de Alcaldia','alcaldia@sanpablo.go.cr');
insert T_DEPARTMENT (ID,NAME) values (1,'SUPERUSER');
ALTER TABLE T_USER change PASSWORD PASSWORD VARCHAR(100);
insert into T_USER (T_TEMPUSER,PASSWORD,DEPARTMENT) values ('concejomunicipal@sanpablo.go.cr',SHA2('concejo',256),1);
insert into T_USER (T_TEMPUSER,PASSWORD,DEPARTMENT) values ('alcaldia@sanpablo.go.cr',SHA2('alcaldia',256),1);
insert into T_ROLE values ('Concejo Municipal');
insert into T_ROLE values ('Secretaria de Alcaldia');
insert into T_USERROLE (USER_NAME,ROLE_NAME) values ('concejomunicipal@sanpablo.go.cr','Concejo Municipal');
insert into T_USERROLE (USER_NAME,ROLE_NAME) values ('alcaldia@sanpablo.go.cr','Secretaria de Alcaldia');

USE `KRONOS`;
DROP procedure IF EXISTS getUserRole;
DELIMITER $$
USE `KRONOS`$$
create procedure getUserRole( in _user varchar(45), in _password varchar(100))
begin
SELECT USER_NAME, ROLE_NAME, T_USER.DEPARTMENT FROM T_USERROLE,T_USER WHERE T_USERROLE.USER_NAME=_user AND (T_USER.T_TEMPUSER=_user
AND T_USER.PASSWORD=_password); 
end$$
DELIMITER ;

