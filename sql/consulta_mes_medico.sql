SELECT 
	dm.nome as nome_medico,
	count(*) as qtd_consultas
FROM
    data_agendamento as da,
    data_horario as dho,
	data_medico as dm
WHERE
	dm.cpf = da.id_medico and
    da.id_horario = dho.id and
    dho.ano = YEAR(now()) and dho.mes = MONTH(NOW())
group by nome_medico;