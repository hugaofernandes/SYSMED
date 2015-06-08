
insert into pessoa (nome, cpf, cidade, sexo, estado, data_nasc, numero_casa, nome_rua, bairro, telefone, email, estado_civil) values 
					("Joao", 12345678901, "Caico", 'M', "RN", now(), 1, "rua", "jony", 12340000, "email.com", "Solteiro"),
					("Maria", 15433465436, "Rio", 'F', "RJ", now(), 1, "rua", "jony", 12340000, "email.com", "Solteiro"),
                    ("Dra. Martha", 15433465435, "Rio", 'F', "RJ", now(), 1, "rua", "jony", 12340000, "email.com", "Solteiro"),
                    ("Dr. Santos", 12345678902, "Caico", 'M', "RN", now(), 1, "rua", "jony", 12340000, "email.com", "Solteiro"),
                    ("Senhor J", 12345288902, "Caico", 'M', "RN", now(), 1, "rua", "jony", 12340000, "email.com", "Solteiro");

insert into funcionario (cpf, salario, tipo_funcionario) values (15433465435, 1000, "medico"), (12345678902, 1000, "medico"), (12345288902, 500, "recepcionista");

insert into recepcionista (cpf) values (12345288902);

insert into paciente (cpf) values (12345678901), (15433465436);

insert into medico (cpf) values (15433465435), (12345678902);

insert into turno (nome) values ("TurnoManha");

insert into trabalha (cpf, turno) values
					(12345678902, "TurnoManha");

insert into especialidade (nome) values ("Dermatologista");
                  
insert into atua_como (nome_especialidade, custo_consulta, trabalha, duracao_esperada) values
					("Dermatologista", 100, (select id from trabalha where cpf = 12345678902 and turno = "TurnoManha"), 20);


insert into solicitao_consulta (horario, cpf_paciente, cpf_medico, cpf_avaliador, nome_especialidade, status_solicitacao, motivo_recusacao, duracao_esperada) values
								(now(), 12345678901, 12345678902, 12345288902, "Dermatologista", 'P', "veaco", 20),
                                (now(), 15433465436, 15433465435, 12345288902, "Dermatologista", 'A', "muito veaco", 20);



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
(str_to_date("2015-05-07 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,5,7,00,00),
(str_to_date("2015-06-02 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,6,2,00,00),
(str_to_date("2015-06-01 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,6,1,00,00),
(str_to_date("2015-06-04 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,6,4,00,00),
(str_to_date("2015-06-07 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,6,7,00,00),
(str_to_date("2015-06-08 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,6,8,00,00),
(str_to_date("2015-06-04 00:10:00","%Y-%m-%d %H:%i:%S"),2015,1,2,6,4,00,10),
(str_to_date("2015-06-02 00:10:00","%Y-%m-%d %H:%i:%S"),2015,1,2,6,2,00,10),
(str_to_date("2015-06-03 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,6,3,00,00),
(str_to_date("2015-06-05 00:00:00","%Y-%m-%d %H:%i:%S"),2015,1,2,6,5,00,00);


insert into data_medico(nome,cpf,sexo,data_nasc) values
("medico 1",'1','M',str_to_date("1990-05-07","%Y-%m-%d")),
("medico 2",'2','M',str_to_date("1990-05-07","%Y-%m-%d")),
("medico 3",'3','M',str_to_date("1990-05-07","%Y-%m-%d")),
("medico 4",'4','M',str_to_date("1990-05-07","%Y-%m-%d")),
("medico 5",'5','M',str_to_date("1990-05-07","%Y-%m-%d"));

insert into data_cliente(id, data_nasc,estado_civil,sexo,estado,cidade,bairro) values
(1, str_to_date("1990-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','M','RN','cidade 1','bairro 11'),
(2, str_to_date("1990-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','M','RN','cidade 1','bairro 11'),
(3, str_to_date("1992-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','M','RN','cidade 1','bairro 11'),
(4, str_to_date("1994-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','M','RN','cidade 1','bairro 12'),
(5, str_to_date("1994-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','M','RN','cidade 2','bairro 21'),
(6, str_to_date("1994-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','M','RN','cidade 2','bairro 21'),
(7, str_to_date("1989-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 2','bairro 22'),
(8, str_to_date("1989-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 2','bairro 22'),
(9, str_to_date("1989-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 2','bairro 22'),
(10, str_to_date("1989-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 3','bairro 31'),
(11, str_to_date("1988-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 3','bairro 33'),
(12, str_to_date("1988-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 3','bairro 33'),
(13, str_to_date("1988-01-01 00:00:00","%Y-%m-%d %H:%i:%S"),'Solteiro','F','RN','cidade 3','bairro 34');

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
(5,"especialidade 2",5,str_to_date("2015-05-07 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(1,"especialidade 1",1,str_to_date("2015-06-02 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(2,"especialidade 2",1,str_to_date("2015-06-01 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(3,"especialidade 3",2,str_to_date("2015-06-04 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(4,"especialidade 4",2,str_to_date("2015-06-07 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(5,"especialidade 1",2,str_to_date("2015-06-08 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(1,"especialidade 2",3,str_to_date("2015-06-04 00:10:00","%Y-%m-%d %H:%i:%S"),50),
(2,"especialidade 3",3,str_to_date("2015-06-02 00:10:00","%Y-%m-%d %H:%i:%S"),50),
(3,"especialidade 4",4,str_to_date("2015-06-03 00:00:00","%Y-%m-%d %H:%i:%S"),50),
(4,"especialidade 1",5,str_to_date("2015-06-05 00:00:00","%Y-%m-%d %H:%i:%S"),50);

