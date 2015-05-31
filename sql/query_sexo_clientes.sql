SELECT 
	dc.sexo as sexo,
	count(*)
FROM
    data_agendamento as da,
	data_cliente as dc
WHERE
    da.id_cliente = dc.id
group by sexo
