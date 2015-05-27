package br.com.sysmed.dao;
import java.util.Date;
import java.util.List;






import org.primefaces.model.DefaultScheduleModel;

import br.com.sysmed.modelo.EventoConsulta;
import br.com.sysmed.modelo.Paciente;
import br.com.sysmed.modelo.SolicitaoConsulta;


public class SolicitacaoConsultaDao extends GenericDao<SolicitaoConsulta> {
	public void salvar(SolicitaoConsulta solicitacaoConsulta) {
        save(solicitacaoConsulta);
    }
 
    public void alterar(SolicitaoConsulta solicitacaoConsulta) {
        update(solicitacaoConsulta);
    }
 
    public void excluir(String id) {
    	SolicitaoConsulta c = findById(id);
        delete(c);
    }
    
    public DefaultScheduleModel getAsDefaultScheduleModel(){
    	DefaultScheduleModel eventModel = new DefaultScheduleModel();
    	PacienteDao daoPaciente = new PacienteDao();
		List<SolicitaoConsulta> solicitacoes = null;
		try{
			solicitacoes = this.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		for (SolicitaoConsulta solicitacao: solicitacoes){
			String cpfPaciente = solicitacao.getPaciente().getCpf();
			Paciente paciente = daoPaciente.findById(cpfPaciente);
			int duracao = solicitacao.getDuracaoEsperada();
			Date dataInicio = solicitacao.getHorario();
			eventModel.addEvent(new EventoConsulta(dataInicio,paciente,duracao));
		}
		return eventModel;
    }
}
