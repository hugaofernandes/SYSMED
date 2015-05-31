SELECT 
	de.nome as nome_especialidade,
    dho.ano as ano,
    dho.mes as mes,
	count(*) as qtd_consulta
FROM
    data_agendamento as da,
    data_horario as dho,
	data_especialidade as de

WHERE
    da.id_horario = dho.id 
	and  (
			(dho.ano = YEAR(DATE_SUB(now(),interval 1 year)) and dho.mes >= MONTH(NOW())) 
			or
			(dho.ano = YEAR(NOW()) and dho.mes < MONTH(NOW()))
		)
   and de.nome = da.id_especialidade
group by mes,nome_especialidade
order by nome_especialidade,ano , mes;
  
  