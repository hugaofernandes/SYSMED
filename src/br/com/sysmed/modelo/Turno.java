package br.com.sysmed.modelo;

import java.io.Serializable;

import javax.persistence.*;

import br.com.sysmed.excecoes.*;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the turno database table.
 * 
 */
@Entity
@NamedQuery(name="Turno.findAll", query="SELECT t FROM Turno t")
public class Turno implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nome;

	//bi-directional many-to-one association to Horario
	@OneToMany(mappedBy="turno", cascade = CascadeType.ALL)
	private List<Horario> horarios;

	//bi-directional many-to-one association to Trabalha
	@OneToMany(mappedBy="turnoBean", cascade={CascadeType.ALL})
	private List<Trabalha> trabalha;

	public Turno() {
		this.horarios = new ArrayList<Horario>();
		this.trabalha = new ArrayList<Trabalha>();
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Horario> getHorarios() {
		return this.horarios;
	}

	public void setHorarios(List<Horario> horarios) {
		this.horarios = horarios;
	}
	
	public TurnoValidacao editar(Horario horario, int dia,Date horaInicial,Date horaFinal){

		Horario horarioAntigo = new Horario(horario.getDiaDaSemana(),horario.getHoraInicial(),horario.getHoraFinal());
		this.getHorarios().remove(horario);
		Calendar cHoraInicio = Calendar.getInstance();
	    cHoraInicio.setTime(horaInicial);

	    HorarioValidacao val = horario.setHoraInicial(new java.sql.Time(cHoraInicio.getTimeInMillis()));
	    
	    if (val != HorarioValidacao.OPERACAO_BEM_SUCEDIDA){
	  
	    	return TurnoValidacao.ERRO;
	    }
	   
	    Calendar cHoraFinal = Calendar.getInstance();
	    cHoraFinal.setTime(horaFinal);
	    val = horario.setHoraFinal(new java.sql.Time(cHoraFinal .getTimeInMillis()));
	    
	    if (val != HorarioValidacao.OPERACAO_BEM_SUCEDIDA){
	  
	    	horario.setHoraInicial(horarioAntigo.getHoraInicial());
	    	return TurnoValidacao.ERRO;
	    }
		
	    horario.setDiaDaSemana(dia);
	    
	    if (this.addHorario(horario)!=TurnoValidacao.OPERACAO_BEM_SUCEDIDA){
	
	    	horario.setHoraInicial(horarioAntigo.getHoraInicial());
	    	horario.setHoraFinal(horarioAntigo.getHoraFinal());
	    	horario.setDiaDaSemana(horarioAntigo.getDiaDaSemana());
	    	this.addHorario(horario);
	      	return TurnoValidacao.ERRO;
	    }  

	    return TurnoValidacao.OPERACAO_BEM_SUCEDIDA;
	   
	}
	public boolean daConflito(Turno outroTurno){
		for(Horario horario:outroTurno.getHorarios()){
			if((this.validar(horario)!=TurnoValidacao.OPERACAO_BEM_SUCEDIDA)){
				return true;
			}
		}
		return false;
	}
	public TurnoValidacao validar(Horario horario){
		for (Horario horario2 :this.getHorarios()){
			if (horario2.getDiaDaSemana() == horario.getDiaDaSemana()){
				if (horario2.getHoraInicial().equals(horario.getHoraInicial())){
					System.out.println("1");
					return TurnoValidacao.ERRO;
				}
				if (horario2.getHoraFinal().equals(horario.getHoraInicial())){
					System.out.println("2");
					return TurnoValidacao.ERRO;
				}
				if (horario2.getHoraInicial().equals(horario.getHoraFinal())){
					System.out.println("3");
					return TurnoValidacao.ERRO;
				}
				if (horario2.getHoraFinal().equals(horario.getHoraFinal())){
					System.out.println("4");
					return TurnoValidacao.ERRO;
				}
				if (horario2.getHoraInicial().before(horario.getHoraInicial()) 
				    && horario2.getHoraFinal().after(horario.getHoraInicial())){
					System.out.println("5");
					return TurnoValidacao.ERRO;
				}
				if (horario2.getHoraInicial().before(horario.getHoraFinal()) 
				    && horario2.getHoraFinal().after(horario.getHoraFinal())){
					System.out.println("6");
					return TurnoValidacao.ERRO;
				}	
				if (horario2.getHoraInicial().after(horario.getHoraInicial()) 
					&& horario2.getHoraFinal().before(horario.getHoraFinal())){
					System.out.println("7");
					return TurnoValidacao.ERRO;
				}
			}
		}
		return TurnoValidacao.OPERACAO_BEM_SUCEDIDA;
	}
	
	public TurnoValidacao addHorario(Horario horario){
		TurnoValidacao validacao = this.validar(horario);
		if(validacao==TurnoValidacao.OPERACAO_BEM_SUCEDIDA){
			getHorarios().add(horario);
			horario.setTurno(this);
		}	
		return validacao;
	}
   
	public Horario removeHorario(Horario horario) {
		getHorarios().remove(horario);
		horario.setTurno(null);
		return horario;
	}

	public List<Trabalha> getTrabalha() {
		return this.trabalha;
	}

	public void setTrabalha(List<Trabalha> trabalha) {
		this.trabalha = trabalha;
	}

	public Trabalha addTrabalha(Trabalha trabalha) {
		getTrabalha().add(trabalha);
		trabalha.setTurnoBean(this);
		return trabalha;
	}

	public Trabalha removeTrabalha(Trabalha trabalha) {
		getTrabalha().remove(trabalha);
		trabalha.setTurnoBean(null);
		return trabalha;
	}
    @Override
    public String toString() {
    	return this.getNome();
    }
}