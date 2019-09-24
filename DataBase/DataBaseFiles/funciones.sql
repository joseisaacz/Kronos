USE `KRONOS`;
DROP procedure IF EXISTS insertAccord;
DELIMITER $$
USE `KRONOS`$$
CREATE PROCEDURE insertAccord (IN accNumber VARCHAR(45), IN incorDate DATE, 
IN deadLine DATE, IN sessionDate DATE, IN type_id
CHAR(1), IN observations longtext, IN publics TINYINT(4),
IN notified TINYINT(4), IN states INT)
BEGIN
INSERT INTO T_ACCORD (ACCNUMBER, INCORDATE, 
DEADLINE, SESSIONDATE, OBSERVATIONS, PUBLIC, NOTIFIED,  STATE, TYPE_ID) 
VALUES (accNumber, incorDate, deadLine, sessionDate, observations, publics, notified, states, type_id);
commit; 
END$$
DELIMITER ;

USE `KRONOS`;
DROP procedure IF EXISTS insertAccPdf;
DELIMiTER $$
USE `KRONOS`$$
create procedure insertAccPdf(
in accord varchar(45), in url varchar(100))
begin
insert into T_ACCPDF (ACCORD, URL) values (accord, url);
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
create procedure searchAccordType(in type_id char(1)
)
begin
select ACCNUMBER, INCORDATE, 
DEADLINE, SESSIONDATE, TYPE_ID, OBSERVATIONS, PUBLIC, NOTIFIED,  STATE, T_ACCPDF.URL  from T_ACCORD, T_ACCPDF where ACCNUMBER= T_ACCPDF.ACCORD and TYPE_ID = type_id;
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
DEADLINE, SESSIONDATE, TYPE_ID, OBSERVATIONS, PUBLIC, NOTIFIED,  STATE, T_ACCPDF.URL  from T_ACCORD, T_ACCPDF where ACCNUMBER= T_ACCPDF.ACCORD and ACCNUMBER = accNumber;
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
DEADLINE, SESSIONDATE, TYPE_ID, OBSERVATIONS, PUBLIC, NOTIFIED,  STATE, T_ACCPDF.URL  from T_ACCORD, T_ACCPDF where ACCNUMBER= T_ACCPDF.ACCORD and INCORDATE = incorDate;
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
DEADLINE, SESSIONDATE, TYPE_ID, OBSERVATIONS, PUBLIC, NOTIFIED,  STATE, T_ACCPDF.URL  from T_ACCORD, T_ACCPDF where ACCNUMBER= T_ACCPDF.ACCORD and SESSIONDATE = sessionDate;
end$$
DELIMITER ; 

USE `KRONOS`;
DROP procedure IF EXISTS deleteAccord;
DELIMITER $$
USE `KRONOS`$$
create procedure deleteAccord(in accord varchar(45)  
)
begin
delete from T_USERACC where ACCORD = accord;
delete from T_ACCPDF where ACCORD = accord;
delete from T_ACCORD where ACCNUMBER = accord; 
end$$
DELIMITER ; 

DROP TABLE IF EXISTS `KRONOS`.`T_DELETEDACCORDS` ;

CREATE TABLE IF NOT EXISTS `KRONOS`.`T_DELETEDACCORDS` (
  `ACCORD` VARCHAR(45) NOT NULL,
  action VARCHAR(50) DEFAULT NULL
  )
ENGINE = InnoDB;


USE `KRONOS`;
DROP procedure IF EXISTS deleteAccord;
DELIMITER $$
USE `KRONOS`$$
CREATE DEFINER = CURRENT_USER TRIGGER `KRONOS`.`T_ACCORD_BEFORE_DELETE` BEFORE DELETE ON `T_ACCORD` FOR EACH ROW
BEGIN
insert into T_DELETEDACCORDS SET action = 'delete', T_ACCORD.ACCNUMBER= OLD.ACCNUMBER;
END$$
DELIMITER ; 

USE `KRONOS`;
DROP procedure IF EXISTS searchAllAccords;
DELIMITER $$
USE `KRONOS`$$
create procedure searchAllAccords()
begin
select ACCNUMBER, INCORDATE, 
DEADLINE, SESSIONDATE, TYPE_ID, OBSERVATIONS, PUBLIC, NOTIFIED,  STATE, T_ACCPDF.URL  from T_ACCORD, T_ACCPDF where ACCNUMBER= T_ACCPDF.ACCORD;
end$$
DELIMITER ; 

USE `KRONOS`;
DROP procedure IF EXISTS searchTempUser;
DELIMITER $$
USE `KRONOS`$$
create procedure searchTempUser( in email varchar(45))
begin
select NAME, EMAIL  from T_TEMPUSER where EMAIL= email; 
end$$
DELIMITER ; 