SELECT 
    dho.mes as mes,
	dho.dia as dia,
	count(*) as qtd_consultas
FROM
    data_agendamento as da,
    data_horario as dho
WHERE
    da.id_horario = dho.id and
    dho.ano = YEAR(now()) and dho.mes = MONTH(NOW())
group by dia;