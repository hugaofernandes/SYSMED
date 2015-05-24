package br.com.sysmed.controladores;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;





import br.com.sysmed.dao.TurnoDAO;
import br.com.sysmed.excecoes.TurnoValidacao;
import br.com.sysmed.modelo.Horario;
import br.com.sysmed.modelo.Turno;

@ManagedBean
@ViewScoped
public class TurnoView {
	private String[] diasEscolhidos;   
    private List<String> diasDaSemana;
    private ScheduleModel cadastoTurnos;
    private TurnoDAO turnoDao;
    private Date horaInicio;
    private Date horaFinal;
    private Map<String, Integer> dias;
    private DefaultScheduleEvent event = new DefaultScheduleEvent();
    private int dia;
    public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	private Turno turno;
    
	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFinal() {
		return horaFinal;
	}

	public void setHoraFinal(Date horaFinal) {
		this.horaFinal = horaFinal;
	}

	@PostConstruct
    public void init() {   
		
		this.turno = new Turno();
		turnoDao = new TurnoDAO();
	
    	diasDaSemana = new ArrayList<String>();
   
    	diasDaSemana.add("Domingo");
    	diasDaSemana.add("Segunda");
        diasDaSemana.add("Terça");
        diasDaSemana.add("Quarta");
        diasDaSemana.add("Quinta");
        diasDaSemana.add("Sexta");
        diasDaSemana.add("Sabado");
        
        dias = new HashMap<String,Integer >();
        dias.put("Domingo",Calendar.SUNDAY);
        dias.put("Segunda",Calendar.MONDAY);
        dias.put("Terça",Calendar.TUESDAY);
        dias.put("Quarta",Calendar.WEDNESDAY);
        dias.put("Quinta",Calendar.THURSDAY);
        dias.put("Sexta",Calendar.FRIDAY);
        dias.put("Sabado",Calendar.SATURDAY);
        
        
        cadastoTurnos = new DefaultScheduleModel();
        horaInicio =  new Date();
        horaFinal = new Date();
        this.resetarDatas();
    }
 
 
	public String[] getDiasEscolhidos() {
        return diasEscolhidos;
    }
    
    public void adicionarHorario(){
    	Calendar cHoraInicio = Calendar.getInstance();
    	cHoraInicio.setTime(this.horaInicio);
    	Calendar cHoraFinal = Calendar.getInstance();
    	cHoraFinal .setTime(this.horaFinal);
    	java.sql.Time timei = new java.sql.Time(cHoraInicio.getTimeInMillis());
    	java.sql.Time timef = new java.sql.Time(cHoraFinal.getTimeInMillis());
        	
    	for(String dia :diasEscolhidos){
    		Horario horario = new Horario(dias.get(dia),timei,timef);
    		
    			TurnoValidacao val = this.turno.addHorario(horario);
    			if (val == TurnoValidacao.OPERACAO_BEM_SUCEDIDA){
    			DefaultScheduleEvent novoEvento = new DefaultScheduleEvent("", this.getInicioAtualizado(horario),this.getFinalAtualizado(horario));
    			novoEvento.setData(horario);
    			cadastoTurnos.addEvent(novoEvento);
    			}
    			else{
    				System.out.println(val);
    			}
    	}
    }
    public void resetarDatas(){ 
    	Calendar  horaInicio = Calendar.getInstance();
    	horaInicio.setTime(this.getHoraInicio());
    	horaInicio.set(Calendar.HOUR, 0);
    	horaInicio.set(Calendar.MINUTE, 0);
    	this.horaInicio = horaInicio.getTime();
    	
    	Calendar  horaFinal = Calendar.getInstance();
    	horaFinal.setTime(this.getHoraInicio());
    	horaFinal.set(Calendar.HOUR, 0);
    	horaFinal.set(Calendar.MINUTE, 0);
    	this.horaFinal = horaFinal.getTime();  	
    }
    
    public void salvar(){
    	System.out.println(this.turno.getNome());
    	turnoDao.salvar(this.turno);
    	this.diasDaSemana.clear();
    	this.cadastoTurnos.getEvents().clear();
    	this.turno = new Turno();
    }
 
    public Date getInicioAtualizado(Horario horario){
    	Calendar horarioInicio = Calendar.getInstance();
    	horarioInicio.setTimeInMillis(horario.getHoraInicial().getTime());
    	Calendar inicio_evento = Calendar.getInstance();
    	inicio_evento.set(Calendar.HOUR_OF_DAY,  horarioInicio.get(Calendar.HOUR_OF_DAY));
    	inicio_evento.set(Calendar.MINUTE,  horarioInicio.get(Calendar.MINUTE));
    	inicio_evento.set(Calendar.DAY_OF_WEEK,horario.getDiaDaSemana());
    	return inicio_evento.getTime();
    }
    
    public Date getFinalAtualizado(Horario horario){
      	Calendar horarioFinal = Calendar.getInstance();
    	horarioFinal.setTimeInMillis(horario.getHoraFinal().getTime());
    	Calendar final_evento = Calendar.getInstance();
    	final_evento.set(Calendar.HOUR_OF_DAY,  horarioFinal.get(Calendar.HOUR_OF_DAY));
    	final_evento.set(Calendar.MINUTE,  horarioFinal.get(Calendar.MINUTE));
    	final_evento.set(Calendar.DAY_OF_WEEK,horario.getDiaDaSemana());
    	return final_evento.getTime();
    }
    
	public void setDiasEscolhidos(String[] diasEscolhidos) {
        this.diasEscolhidos = diasEscolhidos;
    }
 
    public List<String> getDiasDaSemana() {
        return diasDaSemana;
    }
    public ScheduleModel getCadastoTurnos() {
        return cadastoTurnos;
    }
      
    public DefaultScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(DefaultScheduleEvent event) {
		this.event = event;
	}

	 public void onEventSelect(SelectEvent selectEvent) {
	     event = (DefaultScheduleEvent) selectEvent.getObject();
	     Calendar a = Calendar.getInstance();
	     a.setTime(event.getStartDate());
	     this.dia = a.get(Calendar.DAY_OF_WEEK);
	     this.horaInicio = event.getStartDate();
	     this.horaFinal = event.getEndDate();
	     
	 }
	 
	public Map<String, Integer> getDias() {
		return dias;
	}

	public void setDias(Map<String, Integer> dias) {
		this.dias = dias;
	}

	public void editarEvento(ActionEvent actionEvent){
	
		Calendar hinicio = Calendar.getInstance();
		hinicio.setTime(this.getHoraInicio());
		System.out.println("hinicio: "+hinicio.getTime());
		
		Calendar hfinal = Calendar.getInstance();
		hfinal.setTime(this.getHoraFinal());

		Calendar novoInicio = Calendar.getInstance();
		novoInicio.setTime(event.getStartDate());
		novoInicio.set(Calendar.HOUR_OF_DAY,hinicio.get(Calendar.HOUR_OF_DAY));
		novoInicio.set(Calendar.MINUTE,hinicio.get(Calendar.MINUTE));
		novoInicio.set(Calendar.SECOND,0);
		
		Calendar novoFinal = Calendar.getInstance();
		novoFinal.setTime(event.getEndDate());
		novoFinal.set(Calendar.HOUR_OF_DAY,hfinal.get(Calendar.HOUR_OF_DAY));
		novoFinal.set(Calendar.MINUTE,hfinal.get(Calendar.MINUTE));
		novoFinal.set(Calendar.SECOND,0);
	
		Horario horarioeditar = (Horario)event.getData();
		if((this.turno.editar(horarioeditar, this.dia, novoInicio.getTime(), novoFinal.getTime()))==TurnoValidacao.OPERACAO_BEM_SUCEDIDA){
				event.setStartDate(novoInicio.getTime());
				event.setEndDate(novoFinal.getTime());
				Calendar a = Calendar.getInstance();
			    a.setTime(event.getStartDate());
			    a.set(Calendar.DAY_OF_WEEK, this.dia);
			    event.setStartDate(a.getTime());
			    a.setTime(event.getEndDate());
			    a.set(Calendar.DAY_OF_WEEK, this.dia);
			    event.setEndDate(a.getTime());
				this.cadastoTurnos.updateEvent(this.getEvent());
				event = new DefaultScheduleEvent();
				this.resetarDatas();
		}
		else{
			 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Conflito de Horarios","erro");	        
		     addMessage(message);
		}	
			
	}
	
    private void addMessage(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}
