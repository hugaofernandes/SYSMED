DROP DATABASE IF EXISTS sysmed;
CREATE DATABASE sysmed;
USE sysmed;

CREATE TABLE pessoa (
  cpf char(11) NOT NULL,
  nome varchar(75) NOT NULL,
  data_nasc date NOT NULL,
  numero_casa varchar(5) NOT NULL,
  nome_rua varchar(75) NOT NULL,
  bairro varchar(50) NOT NULL,
  cidade varchar(30) NOT NULL,
  estado char(2) NOT NULL,
  telefone char(8) NOT NULL,
  email varchar(75) DEFAULT NULL,
  sexo enum('M','F') NOT NULL,
  estado_civil varchar(10) NOT NULL,
  PRIMARY KEY (cpf)
) ;

CREATE TABLE paciente (
  cpf char(11) NOT NULL,
  descricao_local_trabalho varchar(2500) DEFAULT NULL,
  medicao_atual varchar(2500) DEFAULT NULL,
  profissao_atual varchar(200) DEFAULT NULL,
  alergias_conhecidas varchar(1000) DEFAULT NULL,
  PRIMARY KEY (cpf),
FOREIGN KEY (cpf) REFERENCES pessoa (cpf)
);

CREATE TABLE funcionario (
  cpf char(11) NOT NULL,
  salario double NOT NULL,
  tipo_funcionario varchar(25) NOT NULL,
  PRIMARY KEY (cpf),
  FOREIGN KEY (cpf) REFERENCES pessoa (cpf)
);

CREATE TABLE medico (
  cpf char(11) NOT NULL,
  sobre varchar(4000) DEFAULT NULL,
  PRIMARY KEY (cpf),
  FOREIGN KEY (cpf) REFERENCES funcionario (cpf)
);

CREATE TABLE recepcionista (
  cpf char(11) NOT NULL,
  PRIMARY KEY (cpf),
  FOREIGN KEY (cpf) REFERENCES funcionario (cpf)
);

CREATE TABLE turno (
  nome varchar(50) NOT NULL,
  PRIMARY KEY (nome)
);

CREATE TABLE horario (
  id int(11) NOT NULL AUTO_INCREMENT,
  nome_turno varchar(50) NOT NULL,
  dia_da_semana tinyint(4) NOT NULL,
  hora_inicial time NOT NULL,
  hora_final time NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (nome_turno) REFERENCES turno (nome)
);

CREATE TABLE trabalha (
  id int(11) NOT NULL AUTO_INCREMENT,
  cpf char(11) NOT NULL,
  turno varchar(50) NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (cpf) REFERENCES funcionario (cpf),
  FOREIGN KEY (turno) REFERENCES turno (nome)
);

CREATE TABLE especialidade (
  nome varchar(50) NOT NULL,
  descricao varchar(1000) DEFAULT NULL,
  PRIMARY KEY (nome)
);

CREATE TABLE atua_como(
	id int(11) NOT NULL AUTO_INCREMENT,
	nome_especialidade varchar(50) NOT NULL,
	custo_consulta double NOT NULL,
	trabalha int(11) NOT NULL,
	duracao_esperada smallint(6) NOT NULL,
	PRIMARY KEY (id),
	FOREIGN KEY (nome_especialidade) REFERENCES especialidade(nome),
	FOREIGN KEY (trabalha) REFERENCES trabalha(id)
);

CREATE TABLE solicitao_consulta (
  id int(11) NOT NULL AUTO_INCREMENT,
  horario datetime NOT NULL,
  cpf_paciente char(11) NOT NULL,
  cpf_medico char(11) NOT NULL,
  cpf_avaliador char(11) DEFAULT NULL,
  nome_especialidade varchar(50) NOT NULL,
  status_solicitacao enum('P','A','R') DEFAULT NULL,
  motivo_recusacao varchar(500) DEFAULT NULL,
  duracao_esperada smallint(6) NOT NULL,
  PRIMARY KEY (id),
  UNIQUE (horario,cpf_paciente),
  UNIQUE (horario,cpf_medico),
  FOREIGN KEY (cpf_avaliador) REFERENCES recepcionista(cpf),
  FOREIGN KEY (cpf_paciente) REFERENCES paciente (cpf),
  FOREIGN KEY (cpf_medico) REFERENCES medico (cpf),
  FOREIGN KEY (nome_especialidade) REFERENCES especialidade (nome)
);

CREATE TABLE consulta (
  id int(11) NOT NULL AUTO_INCREMENT,
  id_solicitacao int(11) NOT NULL,
  horario datetime NOT NULL,
  queixa_principal varchar(2500) DEFAULT NULL,
  sintomas varchar(2500) DEFAULT NULL,
  observacao_medica varchar(2500) DEFAULT NULL,
  historico_familiar varchar(2500) DEFAULT NULL,
  diagnostico varchar(2500) DEFAULT NULL,
  tratamento varchar(2500) DEFAULT NULL,
  recomendacao_medica varchar(2500) DEFAULT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (id_solicitacao) REFERENCES solicitao_consulta(id)
);



-- DATA WAREHOUSE

CREATE TABLE data_cliente (
  id char(11) NOT NULL,
  data_nasc date DEFAULT NULL,
  estado_civil varchar(10) DEFAULT NULL,
  sexo enum('M','F') DEFAULT NULL,
  estado char(2) DEFAULT NULL,
  bairro varchar(50) DEFAULT NULL,
  cidade varchar(30) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE data_especialidade (
  nome varchar(50) NOT NULL,
  PRIMARY KEY (nome)
);

CREATE TABLE data_horario (
  id datetime not null,
  ano int(11) DEFAULT NULL,
  semestre int(11) DEFAULT NULL,
  trimestre int(11) DEFAULT NULL,
  mes int(11) DEFAULT NULL,
  dia int(11) DEFAULT NULL,
  hora int(11) DEFAULT NULL,
  min int(11) DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE data_medico (
  nome varchar(75) DEFAULT NULL,
  cpf char(11) NOT NULL,
  sexo enum('M','F') DEFAULT NULL,
  data_nasc date DEFAULT NULL,
  PRIMARY KEY (cpf)
);

CREATE TABLE data_agendamento (
  id_cliente char(11) DEFAULT NULL,
  id_especialidade varchar(50) DEFAULT NULL,
  id_medico char(11) DEFAULT NULL,
  id_horario datetime DEFAULT NULL,
  valor_consulta double DEFAULT NULL,
  FOREIGN KEY (id_cliente) REFERENCES data_cliente (id),
  FOREIGN KEY (id_especialidade) REFERENCES data_especialidade (nome),
  FOREIGN KEY (id_medico) REFERENCES data_medico (cpf),
  FOREIGN KEY (id_horario) REFERENCES data_horario (id)
);