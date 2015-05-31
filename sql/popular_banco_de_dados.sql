insert into data_especialidade values("especialidade 1");
insert into data_especialidade values("especialidade 2");
insert into data_especialidade values("especialidade 3");
insert into data_especialidade values("especialidade 4");

insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) values
(str_to_date("2015-04-01 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,4,1,00,00),
(str_to_date("2015-04-30 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,4,30,00,00),
(str_to_date("2015-03-01 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,1,3,1,00,00),
(str_to_date("2015-02-01 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,1,2,1,00,00),
(str_to_date("2015-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,1,1,1,00,00),
(str_to_date("2014-12-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,2,4,12,1,00,00),
(str_to_date("2014-11-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,2,4,11,1,00,00),
(str_to_date("2014-10-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,2,4,10,1,00,00),
(str_to_date("2014-09-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,2,3,9,1,00,00),
(str_to_date("2014-08-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,2,3,8,1,00,00),
(str_to_date("2014-07-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,3,7,1,00,00),
(str_to_date("2014-06-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,2,6,1,00,00),
(str_to_date("2014-05-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,2,5,1,00,00),
(str_to_date("2014-04-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,2,4,1,00,00),
(str_to_date("2014-03-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,1,3,1,00,00),
(str_to_date("2014-02-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,1,2,1,00,00),
(str_to_date("2014-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,1,1,1,000,00),
(str_to_date("2015-05-01 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,5,1,00,00),
(str_to_date("2015-05-02 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,5,2,00,00),
(str_to_date("2015-05-03 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,5,3,00,00),
(str_to_date("2015-05-04 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,5,4,00,00),
(str_to_date("2015-05-05 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,5,5,00,00),
(str_to_date("2015-05-06 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,5,6,00,00),
(str_to_date("2015-05-07 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,5,7,00,00);

insert into data_medico(nome,cpf,sexo,data_nasc) values
("medico 1",'1','M',str_to_date("1990-05-07","%Y-%m-%d")),
("medico 2",'2','M',str_to_date("1990-05-07","%Y-%m-%d")),
("medico 3",'3','M',str_to_date("1990-05-07","%Y-%m-%d")),
("medico 4",'4','M',str_to_date("1990-05-07","%Y-%m-%d")),
("medico 5",'5','M',str_to_date("1990-05-07","%Y-%m-%d"));

insert into data_cliente(data_nasc,estado_civil,sexo,estado,cidade,bairro) values
(str_to_date("1990-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','M','RN','cidade 1','bairro 11'),
(str_to_date("1990-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','M','RN','cidade 1','bairro 11'),
(str_to_date("1992-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','M','RN','cidade 1','bairro 11'),
(str_to_date("1994-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','M','RN','cidade 1','bairro 12'),
(str_to_date("1994-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','M','RN','cidade 2','bairro 21'),
(str_to_date("1994-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','M','RN','cidade 2','bairro 21'),
(str_to_date("1989-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 2','bairro 22'),
(str_to_date("1989-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 2','bairro 22'),
(str_to_date("1989-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 2','bairro 22'),
(str_to_date("1989-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 3','bairro 31'),
(str_to_date("1988-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 3','bairro 33'),
(str_to_date("1988-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 3','bairro 33'),
(str_to_date("1988-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 3','bairro 34');

insert into data_agendamento(id_cliente,id_especialidade,id_medico,id_horario,valor_consulta) values
(1,"especialidade 1",1,str_to_date("2015-05-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(2,"especialidade 4",2,str_to_date("2015-04-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(3,"especialidade 4",3,str_to_date("2015-04-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(4,"especialidade 2",4,str_to_date("2015-04-30 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(5,"especialidade 3",5,str_to_date("2015-03-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(6,"especialidade 2",1,str_to_date("2015-02-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(7,"especialidade 1",2,str_to_date("2015-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(8,"especialidade 2",3,str_to_date("2014-12-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(9,"especialidade 3",4,str_to_date("2014-11-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(10,"especialidade 4",5,str_to_date("2014-10-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(11,"especialidade 1",1,str_to_date("2014-09-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(12,"especialidade 2",2,str_to_date("2014-08-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(13,"especialidade 3",3,str_to_date("2014-07-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(1,"especialidade 4",4,str_to_date("2014-06-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(2,"especialidade 1",5,str_to_date("2014-05-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(3,"especialidade 2",1,str_to_date("2014-04-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(4,"especialidade 3",2,str_to_date("2014-03-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(5,"especialidade 4",3,str_to_date("2014-02-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(6,"especialidade 1",4,str_to_date("2014-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(7,"especialidade 1",5,str_to_date("2015-05-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(8,"especialidade 1",1,str_to_date("2015-05-02 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(9,"especialidade 2",2,str_to_date("2015-05-03 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(10,"especialidade 2",3,str_to_date("2015-05-04 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(11,"especialidade 3",4,str_to_date("2015-05-04 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(12,"especialidade 3",5,str_to_date("2015-05-05 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(13,"especialidade 4",1,str_to_date("2015-05-05 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(1,"especialidade 4",2,str_to_date("2015-05-05 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(2,"especialidade 1",3,str_to_date("2015-05-06 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(3,"especialidade 1",4,str_to_date("2015-05-06 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(4,"especialidade 2",5,str_to_date("2015-05-07 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(5,"especialidade 2",5,str_to_date("2015-05-07 00:00:00","%Y-%m-%d %H:%i:%S"),50);

