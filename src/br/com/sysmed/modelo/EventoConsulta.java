package br.com.sysmed.modelo;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.primefaces.model.DefaultScheduleEvent;



public class EventoConsulta extends DefaultScheduleEvent{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Paciente paciente;
	private Medico medico;
	
	public EventoConsulta(Date dataInicio,Paciente paciente,int duracaoEsperada) {
		System.out.println("Novo evento com tudo");
		this.paciente = paciente;
		this.setStartDate(dataInicio);
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(this.getStartDate()); 
		cal.add(Calendar.MINUTE, duracaoEsperada); 
		Date endate =  cal.getTime(); 
		this.setEndDate(endate);
	}
	public EventoConsulta() {
		System.out.println("Novo evento sem nada");
		Calendar cal = Calendar.getInstance(); 
		this.setStartDate(cal.getTime());
		cal.add(Calendar.MINUTE, 30); 
		this.setEndDate(cal.getTime()); 
		this.paciente = new Paciente();
		
	}
	
	
	public EventoConsulta(Date dataInicial) {
		this.setStartDate(dataInicial);
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(this.getStartDate()); 
		cal.add(Calendar.MINUTE, 30); 
		Date endate =  cal.getTime(); 
		this.setEndDate(endate);
		this.paciente = new Paciente();
	}
	
	public void setDuracaoEsperada(int duracao){
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(this.getStartDate()); 
		cal.add(Calendar.MINUTE, duracao); 
		Date newEndante =  cal.getTime(); 
		this.setEndDate(newEndante);
		this.paciente = new Paciente();
	}
	

	public long getDuracaoEsperada(){
		System.out.println("Get invocado");
		System.out.println(this.getTitle());
		
		Calendar cals = Calendar.getInstance();
		cals.setTime(this.getStartDate());
		System.out.println("Inicial: "+this.getStartDate());
		System.out.println("Inicial calendar: "+cals.getTime());
		
		Calendar calf = Calendar.getInstance();
		calf.setTime(this.getEndDate());
		System.out.println("Final: "+this.getEndDate());
		System.out.println("Final calendar: "+calf.getTime());
		
		long diff = calf.getTimeInMillis() - cals.getTimeInMillis();
		long diffMinutos = TimeUnit.MILLISECONDS.toMinutes(diff);
	    System.out.println("diferenca: "+diff);
	    System.out.println("Tempo: "+diffMinutos);
	    System.out.println("Sai get");
		return  diffMinutos;
		
	}

	
	@Override
	public String getTitle() {
		return this.paciente.getNome();
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	
	

	

}
