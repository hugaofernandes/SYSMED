SELECT 
    dho.ano as ano,
    dho.mes as mes,
    count(*) as total_consultas
FROM
    data_agendamento as da,
    data_horario as dho
WHERE
    da.id_horario = dho.id 
	and  (
			(dho.ano = YEAR(DATE_SUB(now(),interval 1 year)) and dho.mes >= MONTH(NOW())) 
			or
			(dho.ano = YEAR(NOW()) and dho.mes < MONTH(NOW()))
		)
group by mes
order by ano , mes;
  
  