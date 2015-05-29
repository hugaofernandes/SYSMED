insert into data_especialidade values("especialidade 1");
insert into data_especialidade values("especialidade 2");
insert into data_especialidade values("especialidade 3");
insert into data_especialidade values("especialidade 4");
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2015-05-01 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,5,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2015-04-01 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,4,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2015-04-30 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,4,30,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2015-03-01 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,1,3,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2015-02-01 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,1,2,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2015-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,1,1,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2014-12-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,2,4,12,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2014-11-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,2,4,11,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2014-10-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,2,4,10,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2014-09-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,2,3,9,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2014-08-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,2,3,8,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2014-07-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,3,7,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2014-06-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,2,6,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2014-05-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,2,5,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2014-04-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,2,4,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2014-03-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,1,3,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2014-02-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,1,2,1,00,00);
insert into data_horario(id,ano,semestre,trimestre,mes,dia,hora,min) value(str_to_date("2014-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),2014,1,1,1,1,000,00);

insert into data_agendamento(id_cliente,id_especialidade,id_medico,id_horario,valor_consulta) values
(null,"especialidade 1",null,str_to_date("2015-05-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 4",null,str_to_date("2015-04-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 4",null,str_to_date("2015-04-30 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 3",null,str_to_date("2015-03-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 2",null,str_to_date("2015-02-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 1",null,str_to_date("2015-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 2",null,str_to_date("2014-12-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 3",null,str_to_date("2014-11-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 4",null,str_to_date("2014-10-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 1",null,str_to_date("2014-09-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 2",null,str_to_date("2014-08-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 3",null,str_to_date("2014-07-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 4",null,str_to_date("2014-06-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 1",null,str_to_date("2014-05-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 2",null,str_to_date("2014-04-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 3",null,str_to_date("2014-03-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 4",null,str_to_date("2014-02-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(null,"especialidade 1",null,str_to_date("2014-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),50);