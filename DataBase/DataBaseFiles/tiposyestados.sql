alter table T_TYPE change DESCRIPTION DESCRIPTION VARCHAR(25);
insert into T_TYPE (ID, DESCRIPTION) values ('A', 'Administración Municipal');
insert into T_TYPE (ID, DESCRIPTION) values ('B', 'Auditoria Interna');
insert into T_TYPE (ID, DESCRIPTION) values ('C', 'Lic');
insert into T_TYPE (ID, DESCRIPTION) values ('D', 'Obras');
insert into T_TYPE (ID, DESCRIPTION) values ('E', 'Plan Regulador');
insert into T_TYPE (ID, DESCRIPTION) values ('F', 'Hacienda');
insert into T_TYPE (ID, DESCRIPTION) values ('G', 'Juridicos');
insert into T_TYPE (ID, DESCRIPTION) values ('H', 'Sociales');
insert into T_TYPE (ID, DESCRIPTION) values ('I', 'Ambiente');
insert into T_TYPE (ID, DESCRIPTION) values ('J', 'Varios');


insert into T_STATE (ID, DESCRIPTION)values (0, 'Cumplido');
insert into T_STATE (ID, DESCRIPTION)values (1, 'Incumplido');
insert into T_STATE (ID, DESCRIPTION)values (2, 'Pendiente');
insert into T_STATE (ID, DESCRIPTION)values (3, 'Recibido');
insert into T_STATE (ID, DESCRIPTION)values (4, 'Desestimado');


