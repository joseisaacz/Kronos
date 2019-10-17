USE `KRONOS` ;

DROP TABLE IF EXISTS `KRONOS`.`T_ROLE` ;
CREATE TABLE IF NOT EXISTS `KRONOS`.`T_ROLE` (
ROLE_NAME varchar(45),
constraint pk1 primary key(ROLE_NAME)
);

DROP TABLE IF EXISTS `KRONOS`.`T_USERROLE` ;
CREATE TABLE IF NOT EXISTS `KRONOS`.`T_USERROLE` (
USER_NAME varchar(45),
ROLE_NAME varchar(45),
constraint pk1 primary key(USER_NAME,ROLE_NAME),
constraint fk1 foreign key (USER_NAME) references T_USER(T_TEMPUSER),
constraint fk2 foreign key (ROLE_NAME) references T_ROLE(ROLE_NAME)
);


