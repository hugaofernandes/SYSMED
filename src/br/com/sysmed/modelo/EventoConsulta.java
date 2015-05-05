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
	private String nomePaciente;
	private String cpfPaciente;
	private String telefone;
	
	
	public EventoConsulta(Date dataInicio,String nomePaciente,String cpfPaciente,String telefone,int duracaoEsperada) {
		System.out.println("Novo evento com tudo");
		this.telefone = telefone;
		this.nomePaciente = nomePaciente;
		this.cpfPaciente = cpfPaciente;
		this.setStartDate(dataInicio);
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(this.getStartDate()); 
		cal.add(Calendar.MINUTE, duracaoEsperada); 
		Date endate =  cal.getTime(); 
		this.setEndDate(endate);
	}
	public EventoConsulta() {
		System.out.println("Novo evento sem nada");
		this.nomePaciente = "";
		this.cpfPaciente = "";
		Calendar cal = Calendar.getInstance(); 
		this.setStartDate(cal.getTime());
		cal.add(Calendar.MINUTE, 30); 
		this.setEndDate(cal.getTime()); 
		
	}
	
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	public EventoConsulta(Date dataInicial) {
		this.nomePaciente = "";
		this.cpfPaciente = "";
		this.setStartDate(dataInicial);
		Calendar cal = Calendar.getInstance(); 
		cal.setTime(this.getStartDate()); 
		cal.add(Calendar.MINUTE, 30); 
		Date endate =  cal.getTime(); 
		this.setEndDate(endate);
	}
	
	public void setDuracaoEsperada(int duracao){

		Calendar cal = Calendar.getInstance(); 
		cal.setTime(this.getStartDate()); 
		cal.add(Calendar.MINUTE, duracao); 
		Date newEndante =  cal.getTime(); 
		this.setEndDate(newEndante);
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
		return this.nomePaciente;
	}
	public String getNomePaciente() {
		return nomePaciente;
	}
	public void setNomePaciente(String nomePaciente) {
		this.nomePaciente = nomePaciente;
	}
	public String getCpfPaciente() {
		return cpfPaciente;
	}
	public void setCpfPaciente(String cpfPaciente) {
		this.cpfPaciente = cpfPaciente;
	}
	
	

	

}
