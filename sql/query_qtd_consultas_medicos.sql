SELECT 
	dm.nome as nome_medico,
    dho.ano as ano,
    dho.mes as mes,
	count(*) as qtd_consulta
FROM
    data_agendamento as da,
    data_horario as dho,
	data_medico as dm

WHERE
	da.id_horario = dho.id 
	and  (
			(dho.ano = YEAR(DATE_SUB(now(),interval 1 year)) and dho.mes >= MONTH(NOW())) 
			or
			(dho.ano = YEAR(NOW()) and dho.mes < MONTH(NOW()))
		)
   and dm.cpf = da.id_medico
group by mes,nome_medico
order by nome_medico,ano , mes;
  
  