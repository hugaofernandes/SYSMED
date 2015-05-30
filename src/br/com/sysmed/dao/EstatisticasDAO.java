package br.com.sysmed.dao;




import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;








import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.sysmed.DTO.AnoMesConsulta;
import br.com.sysmed.DTO.MesDiaConsulta;



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
	
}
