package br.com.sysmed.dao;




import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;








import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sysmed.DTO.*;




public class EstatisticasDAO {
	 EntityManagerFactory entityManagerFactory;
	 EntityManager em;
	 
	 public EstatisticasDAO() {
		 entityManagerFactory = Persistence.createEntityManagerFactory("SYSMED");
		 em = entityManagerFactory.createEntityManager();
	    }


	
	public List<AnoMesConsulta> getConsultaPorAno() {
		Query query = em.createNativeQuery("SELECT dho.ano as ano, dho.mes as mes, count(*) as total_consultas FROM data_agendamento as da, data_horario as dho WHERE da.id_horario = dho.id and ( (dho.ano = YEAR(DATE_SUB(now(),interval 1 year)) and dho.mes >= MONTH(NOW())) or (dho.ano = YEAR(NOW()) and dho.mes < MONTH(NOW())) ) group by mes order by ano , mes");
		List<Object[]> results = query.getResultList();
		List<AnoMesConsulta> resultDTO = new ArrayList<AnoMesConsulta>();
	    for(Object[] a:results){
	    	resultDTO.add(new AnoMesConsulta(a));
		}
		return resultDTO;
	}
	
	public List<MesDiaConsulta > getConsultaPorMes() {
		Query query = em.createNativeQuery("SELECT dho.mes as mes, dho.dia as dia, count(*) as qtd_consultas FROM data_agendamento as da, data_horario as dho WHERE da.id_horario = dho.id and dho.ano = YEAR(now()) and dho.mes = MONTH(NOW()) group by dia");
		List<Object[]> results = query.getResultList();
		List<MesDiaConsulta > resultDTO = new ArrayList<MesDiaConsulta >();
	    for(Object[] a:results){
	    	resultDTO.add(new MesDiaConsulta (a));
		}
		return resultDTO;
	}
	
	public AnoMesInfoQtd getEspecPorAno() {
		Query query = em.createNativeQuery("SELECT de.nome as nome_especialidade, dho.ano as ano, dho.mes as mes, count(*) as qtd_consulta FROM data_agendamento as da, data_horario as dho, data_especialidade as de WHERE da.id_horario = dho.id and ( (dho.ano = YEAR(DATE_SUB(now(),interval 1 year)) and dho.mes >= MONTH(NOW())) or (dho.ano = YEAR(NOW()) and dho.mes < MONTH(NOW())) ) and de.nome = da.id_especialidade group by mes,nome_especialidade order by nome_especialidade,ano , mes;");
		List<Object[]> results = query.getResultList();
		AnoMesInfoQtd dto = new AnoMesInfoQtd();
	    for(Object[] a:results){
	    	dto.add(a);
		}
		return dto;
	}
	public AnoMesInfoQtd getMedPorAno() {
		Query query = em.createNativeQuery("SELECT dm.nome as nome_medico, dho.ano as ano, dho.mes as mes, count(*) as qtd_consulta FROM data_agendamento as da, data_horario as dho, data_medico as dm WHERE da.id_horario = dho.id and ( (dho.ano = YEAR(DATE_SUB(now(),interval 1 year)) and dho.mes >= MONTH(NOW())) or (dho.ano = YEAR(NOW()) and dho.mes < MONTH(NOW())) ) and dm.cpf = da.id_medico group by mes,nome_medico");
		List<Object[]> results = query.getResultList();
		AnoMesInfoQtd dto = new AnoMesInfoQtd();
	    for(Object[] a:results){
	    	dto.add(a);
		}
		return dto;
	}
	
	public InfoQtd getMedPorMes() {
		Query query = em.createNativeQuery("SELECT dm.nome as nome_medico, count(*) as qtd_consultas FROM data_agendamento as da, data_horario as dho, data_medico as dm WHERE dm.cpf = da.id_medico and da.id_horario = dho.id and dho.ano = YEAR(now()) and dho.mes = MONTH(NOW()) group by nome_medico");
		List<Object[]> results = query.getResultList();
		InfoQtd dto = new InfoQtd();
	    for(Object[] a:results){
	    	dto.add(a);
		}
		return dto;
	}
	public CharInfoQtd getQtdSexo() {
		Query query = em.createNativeQuery("SELECT dc.sexo as sexo, count(*) FROM data_agendamento as da, data_cliente as dc WHERE da.id_cliente = dc.id group by sexo");
		List<Object[]> results = query.getResultList();
		CharInfoQtd  dto = new CharInfoQtd();
	    for(Object[] a:results){
	    	dto.add(a);
		}
		return dto;
	}
	public IntInfoQtd getIdadeClientes() {
		Query query = em.createNativeQuery("SELECT TIMESTAMPDIFF(YEAR,data_nasc,CURDATE()) AS idade, count(*) as qtd FROM data_agendamento as da, data_cliente as dc WHERE da.id_cliente = dc.id group by idade");
		List<Object[]> results = query.getResultList();
		IntInfoQtd dto = new IntInfoQtd();
	    for(Object[] a:results){
	    	dto.add(a);
		}
		return dto;
	}
	public CidadesInfo getCidadesCliente() {
		Query query = em.createNativeQuery("select dc.cidade as cidade, dc.bairro as bairro, count(bairro) as qtd_bairro from data_agendamento as da, data_cliente as dc where da.id_cliente = dc.id group by cidade, bairro");
		List<Object[]> results = query.getResultList();
		CidadesInfo dto = new CidadesInfo();
	    for(Object[] a:results){
	    	dto.add(a);
		}
		return dto;
	}
}
