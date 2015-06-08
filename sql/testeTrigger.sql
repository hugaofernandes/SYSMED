
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

