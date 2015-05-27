package br.com.sysmed.controladores;


import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.sysmed.dao.EspecialidadeDAO;
import br.com.sysmed.dao.MedicoDao;
import br.com.sysmed.dao.PacienteDao;
import br.com.sysmed.dao.SolicitacaoConsultaDao;
import br.com.sysmed.modelo.AtuaComo;
import br.com.sysmed.modelo.Especialidade;
import br.com.sysmed.modelo.Medico;
import br.com.sysmed.modelo.Paciente;
import br.com.sysmed.modelo.SolicitaoConsulta;

@ManagedBean(name = "solicitacaoConsultaView")
@ViewScoped
public class SolicitacaoConsultaView {
	private ScheduleModel eventModel;

	private SolicitacaoConsultaDao dao;
	private DefaultScheduleEvent event;
	
	private PacienteDao daoPaciente;
	private List<String> cpfsPacientes;
	private String cpfPaciente;
	
	private MedicoDao daoMedico;
	private List<String> cpfsMedicos;
	private String cpfMedico;
	
	private EspecialidadeDAO especialidadeDAO;
	private List<String> especialidades;
	private String especialidadeEscohida;

	public String getEspecialidadeEscohida() {
		return especialidadeEscohida;
	}

	public void setEspecialidadeEscohida(String especialidade) {
		this.especialidadeEscohida = especialidade;
	}

	@PostConstruct
	public void cpfsPacientes() {
		dao = new SolicitacaoConsultaDao();
		daoPaciente = new PacienteDao();
		cpfsPacientes = daoPaciente.getCpfs();
		daoMedico = new MedicoDao();
		cpfsMedicos = daoMedico.getCpfs();
		especialidadeDAO = new EspecialidadeDAO();
		especialidades = especialidadeDAO.getNomes();
		eventModel  = new DefaultScheduleModel();
		List<SolicitaoConsulta> consultas = null;
		try {
			consultas = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (SolicitaoConsulta solicitacao:consultas){
			Date dataInicio = solicitacao.getHorario();
			Calendar cal = Calendar.getInstance(); 
			cal.setTime(dataInicio); 
			cal.add(Calendar.MINUTE, solicitacao.getDuracaoEsperada()); 
			Date dataFinal = cal.getTime();
			eventModel.addEvent(new DefaultScheduleEvent(solicitacao.getPaciente().getNome(),dataInicio,dataFinal));
			event.setData(solicitacao);
		}
	}
	
	public List<String> getCpfsPacientes() {
		return cpfsPacientes;
	}

	public void setCpfsPacientes(List<String> cpfsPacientes) {
		this.cpfsPacientes = cpfsPacientes;
	}

	
	public String getCpfPaciente() {
		return cpfPaciente;
	}
	
	public void onPacienteSelect(SelectEvent event){
		System.out.println("Paciente selecionado");
		Paciente paciente = daoPaciente.findById(this.cpfPaciente);
		SolicitaoConsulta solicitacao = (SolicitaoConsulta) this.event.getData();
		paciente.addSolicitacoesRealizada(solicitacao);
		this.event.setTitle(paciente.getNome());
	}
	
	public void onMedicoSelect(SelectEvent event){
		System.out.println("Medico selecionado");
		Medico medico = daoMedico.findByCpf(this.cpfMedico);
		SolicitaoConsulta solicitacao = (SolicitaoConsulta) this.event.getData();
		medico.addSolicitadoEm(solicitacao);
	}
	
	public void onEspecialidadeSelect(SelectEvent event){
		System.out.println("Medico selecionado");
		Especialidade especialidade = especialidadeDAO.findById(this.especialidadeEscohida);
	
		SolicitaoConsulta solicitacao = (SolicitaoConsulta) this.event.getData();
		especialidade.addSolicitadaEm(solicitacao);
	}
	
	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
		
	}
	
	public List<String> completePaciente(String query) {   
        return cpfsPacientes;
    }
	
	public List<String> completeMedico(String query) {   
        return cpfsMedicos;
    }
	
	public List<String> completeEspecialidade(String query) {   
        return especialidades;
    }
	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(DefaultScheduleEvent event) {
		this.event = event;
	}

	public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null){
            eventModel.addEvent(event);
        	SolicitaoConsulta solicitacao = (SolicitaoConsulta) event.getData();
        	dao.salvar(solicitacao);
        }
        else{
            eventModel.updateEvent(event);
        }
        SolicitaoConsulta solicitacao = (SolicitaoConsulta) event.getData();
      
        event = new DefaultScheduleEvent();
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (DefaultScheduleEvent) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
    	Date startDate = (Date) selectEvent.getObject();
    	
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(startDate); 
		cal.add(Calendar.MINUTE, 30); 
		Date dataFinal = cal.getTime();
		SolicitaoConsulta solicitacao = new SolicitaoConsulta(startDate);
		solicitacao.setDuracaoEsperada(30);
		solicitacao.setStatusSolicitacao('A');
    	event = new DefaultScheduleEvent("",startDate,dataFinal);  
    	event.setData(solicitacao);
    }
    
    public String getCpfMedico() {
		return cpfMedico;
	}

	public void setCpfMedico(String cpfMedico) {
		this.cpfMedico = cpfMedico;
	}
}
