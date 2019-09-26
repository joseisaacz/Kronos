insert into T_TYPE (ID, DESCRIPTION) values ('A', 'admin municipal');
insert into T_TYPE (ID, DESCRIPTION) values ('B', 'auditoria interna');
insert into T_TYPE (ID, DESCRIPTION) values ('C', 'lic');
insert into T_TYPE (ID, DESCRIPTION) values ('D', 'obras');
insert into T_TYPE (ID, DESCRIPTION) values ('E', 'plan regulador');
insert into T_TYPE (ID, DESCRIPTION) values ('F', 'hacienda');
insert into T_TYPE (ID, DESCRIPTION) values ('G', 'juridicos');
insert into T_TYPE (ID, DESCRIPTION) values ('H', 'sociales');
insert into T_TYPE (ID, DESCRIPTION) values ('I', 'ambiente');
insert into T_TYPE (ID, DESCRIPTION) values ('J', 'varios');


insert into T_STATE (ID, DESCRIPTION)values (0, 'cumplido');
insert into T_STATE (ID, DESCRIPTION)values (1, 'incumplido');
insert into T_STATE (ID, DESCRIPTION)values (2, 'pendiente');
insert into T_STATE (ID, DESCRIPTION)values (3, 'recibido');
insert into T_STATE (ID, DESCRIPTION)values (4, 'desestimado');

call insertAccord('MSPH-CM-272-19','2019-05-20','2019-06-04','2019-05-21','G','Remitir el recurso',false,false,2);

(1 accNumber, 
2 incordDate, 3 deadline
, 4 sessionDate
, 5 type(char)
, 6 observations
, 7 public bool,   
8 notified bool, 
9 state int)
