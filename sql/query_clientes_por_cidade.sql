select 
	dc.cidade as cidade,
	dc.bairro as bairro,
	count(bairro) as qtd_bairro
from 
	data_agendamento as da,
	data_cliente as dc
where 
	da.id_cliente = dc.id
group by cidade, bairro
order by cidade, bairro