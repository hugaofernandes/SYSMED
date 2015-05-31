SELECT 
	TIMESTAMPDIFF(YEAR,data_nasc,CURDATE()) AS idade,
	count(*) as qtd
FROM
    data_agendamento as da,
	data_cliente as dc
WHERE
    da.id_cliente = dc.id
group by idade
