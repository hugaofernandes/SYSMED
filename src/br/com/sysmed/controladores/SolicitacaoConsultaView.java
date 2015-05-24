package br.com.sysmed.controladores;


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
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.sysmed.dao.PacienteDao;
import br.com.sysmed.dao.SolicitacaoConsultaDao;
import br.com.sysmed.modelo.EventoConsulta;
import br.com.sysmed.modelo.Paciente;

@ManagedBean(name = "solicitacaoConsultaView")
@ViewScoped
public class SolicitacaoConsultaView {
	private ScheduleModel eventModel;

	private SolicitacaoConsultaDao dao;
	private PacienteDao daoPaciente;
	private EventoConsulta event = new EventoConsulta();
	
	private List<String> cpfs;
	private String cpfEscolhido;
	
	
	@PostConstruct
	public void init() {
		dao = new SolicitacaoConsultaDao();
		daoPaciente = new PacienteDao();
		cpfs = daoPaciente.getCpfs();
		eventModel = dao.getAsDefaultScheduleModel();
	}
	
	
	
	public List<String> getCpfs() {
		return cpfs;
	}

	public void setCpfs(List<String> cpfs) {
		this.cpfs = cpfs;
	}

	
	public String getCpfEscolhido() {
		return cpfEscolhido;
	}
	
	public void onCpfSelect(SelectEvent event){
		System.out.println("cpfEscolhido");
		Paciente paciente = daoPaciente.findById(this.cpfEscolhido);
		this.event.setNomePaciente(paciente.getNome());
		this.event.setCpfPaciente(paciente.getCpf());
		this.event.setTelefone(paciente.getTelefone());
	}
	
	public void setCpfEscolhido(String cpfEscolhido) {
		this.cpfEscolhido = cpfEscolhido;
		
	}
	public List<String> completeText(String query) {   
        return cpfs;
    }
	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(EventoConsulta event) {
		this.event = event;
	}

	public void addEvent(ActionEvent actionEvent) {
        if(event.getId() == null)
            eventModel.addEvent(event);
        else
            eventModel.updateEvent(event);
        System.out.println("Data");
        System.out.println(event.getTitle());
        System.out.println(event.getStartDate());
        System.out.println(event.getEndDate());
        System.out.println(event.getDuracaoEsperada());
        event = new EventoConsulta();
    }
     
    public void onEventSelect(SelectEvent selectEvent) {
        event = (EventoConsulta) selectEvent.getObject();
    }
     
    public void onDateSelect(SelectEvent selectEvent) {
    	Date startDate = (Date) selectEvent.getObject();
    	event = new EventoConsulta(startDate);
    	
   
    }
     
    public void onEventMove(ScheduleEntryMoveEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());
        System.out.println("EventoMove");
        EventoConsulta event2 = (EventoConsulta) event.getScheduleEvent();
        System.out.println(event2.getStartDate());
        System.out.println(event.getPhaseId());
        addMessage(message);
    }
     
    public void onEventResize(ScheduleEntryResizeEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized", "Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta()); 
        System.out.println("EventResize");
        EventoConsulta event2 = (EventoConsulta) event.getScheduleEvent();
        System.out.println(event2.getTitle());
        System.out.println(event.getPhaseId());
        addMessage(message);
    }
     
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
