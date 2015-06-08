
DROP TRIGGER IF EXISTS triggerDataWareHouse;
DELIMITER $$

CREATE TRIGGER triggerDataWareHouse AFTER INSERT
ON solicitao_consulta
FOR EACH ROW
BEGIN

    insert ignore into data_medico values (
		(select nome from pessoa where cpf = new.cpf_medico),
        new.cpf_medico,
        (select sexo from pessoa where cpf = new.cpf_medico),
		(select data_nasc from pessoa where cpf = new.cpf_medico));
        
	insert ignore into data_cliente values (
		new.cpf_paciente,
        (select data_nasc from pessoa where cpf = new.cpf_paciente),
		(select estado_civil from pessoa where cpf = new.cpf_paciente),
        (select sexo from pessoa where cpf = new.cpf_paciente),
        (select estado from pessoa where cpf = new.cpf_paciente),
        (select bairro from pessoa where cpf = new.cpf_paciente),
        (select cidade from pessoa where cpf = new.cpf_paciente));
    
    insert ignore into data_especialidade values (
		new.nome_especialidade);
         
	insert ignore into data_horario values (
		new.horario,
        year(new.horario),
        case when month(new.horario) between 1 and 6 then 1 else 3 end,
        case when month(new.horario) between 1 and 4 then 1 when month(new.horario) between 5 and 8 then 2 else 3 end,
        month(new.horario),
        day(new.horario),
        hour(new.horario),
        minute(new.horario));
    
    insert ignore into data_agendamento values (
		new.cpf_paciente,
        new.nome_especialidade,
        new.cpf_medico,
        new.horario,
		(select a.custo_consulta from atua_como as a, trabalha as t where t.cpf = new.cpf_medico and a.nome_especialidade = new.nome_especialidade and a.trabalha = t.id));
    
END$$

DELIMITER ;

