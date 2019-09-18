USE `KRONOS`;
DROP procedure IF EXISTS insertAccord;
DELIMITER $$
USE `KRONOS`$$
CREATE PROCEDURE insertAccord (IN accNumber VARCHAR(45), IN incorDate DATE, 
IN deadLine DATE, IN sessionDate DATE, IN typpe
VARCHAR(45), IN observations longtext, IN publics TINYINT(4),
IN notified TINYINT(4), IN states CHAR(1))
BEGIN
INSERT INTO T_ACCORD (ACCNUMBER, INCORDATE, 
DEADLINE, SESSIONDATE, TYPE, OBSERVATIONS, PUBLIC, NOTIFIED,  STATE) 
VALUES (accNumber, incorDate, deadLine, sessionDate, typpe, observations, publics, notified, states);
commit; 
END$$
DELIMITER ;

USE `KRONOS`;
DROP procedure IF EXISTS insertAccPdf;
DELIMiTER $$
USE `KRONOS`$$
create procedure insertAccPdf(
in accNumber varchar(45), in url varchar(100));
begin
insert into T_ACCPDF (ACCNUMBER, URL) values (accNumber, url);
commit;  
end$$ 
DELIMITER ;

USE `KRONOS`;
DROP procedure IF EXISTS insertTempUser;
DELIMITER $$
USE `KRONOS`$$
create procedure insertTempUser(
in namee varchar(45), in email varchar(45))
begin
insert into T_TEMPUSER (NAME, EMAIL) values (namee, email);
commit; 
end$$
DELIMITER ;

USE `KRONOS`;
DROP procedure IF EXISTS insertUserAcc;
DELIMITER $$
USE `KRONOS`$$
create procedure insertUserAcc(
in tempuser varchar(45), in accord varchar(45))
begin
insert into T_USERACC (TEMPUSER, ACCORD) values (tempuser, accord);
commit; 
end$$
DELIMITER ;

USE `KRONOS`;
DROP procedure IF EXISTS searchAccordType;
DELIMITER $$
USE `KRONOS`$$
create procedure searchAccordType(in typpe varchar(45)
)
begin
select ACCNUMBER, INCORDATE, 
DEADLINE, SESSIONDATE, TYPE, OBSERVATIONS, PUBLIC, NOTIFIED,  STATE from T_ACCORD where TYPE like (typpe);
end$$
DELIMITER ;

USE `KRONOS`;
DROP procedure IF EXISTS searchAccordNumber;
DELIMITER $$
USE `KRONOS`$$
create procedure searchAccordNumber(in accNumber varchar(45)
)
begin
select ACCNUMBER, INCORDATE, 
DEADLINE, SESSIONDATE, TYPE, OBSERVATIONS, PUBLIC, NOTIFIED,  STATE from T_ACCORD where ACCNUMBER like (accNumber);
end$$
DELIMITER ; 

USE `KRONOS`;
DROP procedure IF EXISTS searchAccordIncorDate;
DELIMITER $$
USE `KRONOS`$$
create procedure searchAccordIncorDate(in incorDate  date
)
begin
select ACCNUMBER, INCORDATE, 
DEADLINE, SESSIONDATE, TYPE, OBSERVATIONS, PUBLIC, NOTIFIED,  STATE from T_ACCORD where INCORDATE = incorDate;
end$$
DELIMITER ; 

USE `KRONOS`;
DROP procedure IF EXISTS searchAccordsessionDate;
DELIMITER $$
USE `KRONOS`$$
create procedure searchAccordsessionDate(in sessionDate date
)
begin
select ACCNUMBER, INCORDATE, 
DEADLINE, SESSIONDATE, TYPE, OBSERVATIONS, PUBLIC, NOTIFIED,  STATE from T_ACCORD where SESSIONDATE = sessionDate;
end$$
DELIMITER ; 