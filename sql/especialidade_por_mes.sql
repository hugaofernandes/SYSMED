select 
	select_table.nome_especialidade_m as nome_especialidade,
	select_table.ano_m as ano,
	select_table.mes_m as mes,
	select_table.qtd_consulta
from
	(SELECT 
		A.nome_especialidade_m,
		A.ano_m,
		A.mes_m,
		coalesce(qtd_consulta, 0) as qtd_consulta
		
	from
		(select distinct d.nome as nome_especialidade_m ,ano as ano_m,mes as mes_m
		from
		(SELECT 
				dho.ano as ano,
				dho.mes as mes
			
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
		) as D,
		data_especialidade as d) as A

		LEFT JOIN

		(SELECT 
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
	  ) as B
	ON A.nome_especialidade_m = B.nome_especialidade and A.ano_m = B.ano and A.mes_m = B.mes) as select_table
order by nome_especialidade,ano,mes
