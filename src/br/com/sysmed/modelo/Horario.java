package br.com.sysmed.modelo;

import java.io.Serializable;

import javax.persistence.*;

import br.com.sysmed.excecoes.HorarioValidacao;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;


/**
 * The persistent class for the horario database table.
 * 
 */
@Entity
@NamedQuery(name="Horario.findAll", query="SELECT h FROM Horario h")
public class Horario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="HORARIO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.AUTO, generator="HORARIO_ID_GENERATOR")
	private int id;

	@Column(name="dia_da_semana", columnDefinition="tinyint")
	private int diaDaSemana;

	@Column(name="hora_final")
	private Time horaFinal;

	@Column(name="hora_inicial")
	private Time horaInicial;

	//bi-directional many-to-one association to Turno
	@ManyToOne(cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	@JoinColumn(name="nome_turno")
	private Turno turno;

	public Horario() {
	}
	
	public Horario(int diaDaSemana, Time horaInicial, Time horaFinal,
			Turno turno) {
		super();
		this.diaDaSemana = diaDaSemana;
		this.setHoraInicial(horaInicial);
		this.setHoraFinal(horaFinal);
		this.turno = turno;
	}
	
	public Horario(int diaDaSemana, Time horaInicial, Time horaFinal) throws RuntimeException{
		super();
		this.diaDaSemana = diaDaSemana;
		HorarioValidacao validacao = this.setHoraInicial(horaInicial);
		if(validacao!=HorarioValidacao.OPERACAO_BEM_SUCEDIDA){
			throw new RuntimeException(validacao.getDescicao());
		}
		validacao = this.setHoraFinal(horaFinal);
		if(validacao!=HorarioValidacao.OPERACAO_BEM_SUCEDIDA){
			throw new RuntimeException(validacao.getDescicao());
		}
		

	}
	
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDiaDaSemana() {
		return this.diaDaSemana;
	}

	public void setDiaDaSemana(int diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public Time getHoraFinal() {
		return this.horaFinal;
	}

	public HorarioValidacao setHoraFinal(Time horaFinal){
		if (this.horaInicial!=null){
			Calendar tFinal = Calendar.getInstance();
			tFinal.setTimeInMillis(horaFinal.getTime());
			Calendar tInicio = Calendar.getInstance();
			tInicio.setTimeInMillis(this.getHoraInicial().getTime());	
			if ((tFinal.get(Calendar.MINUTE) == tInicio.get(Calendar.MINUTE))&&(tFinal.get(Calendar.HOUR_OF_DAY) == tInicio.get(Calendar.HOUR_OF_DAY))){
				return HorarioValidacao.ERRO;
			}
			if ((tFinal.get(Calendar.HOUR_OF_DAY) < tInicio.get(Calendar.HOUR_OF_DAY))){
					return HorarioValidacao.ERRO;
			}
			if ((tFinal.get(Calendar.HOUR_OF_DAY) == tInicio.get(Calendar.HOUR_OF_DAY))&&(tFinal.get(Calendar.MINUTE) < tInicio.get(Calendar.MINUTE))){
				return HorarioValidacao.ERRO;
			}
		}
		this.horaFinal = horaFinal;
		return HorarioValidacao.OPERACAO_BEM_SUCEDIDA;
	}

	public Time getHoraInicial() {
		return this.horaInicial;
	}

	public HorarioValidacao setHoraInicial(Time horaInicial){
		if (this.horaFinal!=null){
			Calendar tInicio = Calendar.getInstance();
			tInicio.setTimeInMillis(horaInicial.getTime());
			Calendar tFinal = Calendar.getInstance();
			tFinal.setTimeInMillis(this.getHoraFinal().getTime());	
			if ((tFinal.get(Calendar.MINUTE) == tInicio.get(Calendar.MINUTE))&&(tFinal.get(Calendar.HOUR_OF_DAY) == tInicio.get(Calendar.HOUR_OF_DAY))){
				return HorarioValidacao.ERRO;
			}
	
			if ((tFinal.get(Calendar.HOUR_OF_DAY) < tInicio.get(Calendar.HOUR_OF_DAY))){
					return HorarioValidacao.ERRO;
			}
			if ((tFinal.get(Calendar.HOUR_OF_DAY) == tInicio.get(Calendar.HOUR_OF_DAY))&&(tFinal.get(Calendar.MINUTE) < tInicio.get(Calendar.MINUTE))){
				return HorarioValidacao.ERRO;
		     }
		}
		this.horaInicial = horaInicial;
		return HorarioValidacao.OPERACAO_BEM_SUCEDIDA;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	
	public Date getInicioAtualizado(){
    	Calendar horarioInicio = Calendar.getInstance();
    	horarioInicio.setTimeInMillis(this.getHoraInicial().getTime());
    	Calendar inicio_evento = Calendar.getInstance();
    	inicio_evento.set(Calendar.HOUR_OF_DAY,  horarioInicio.get(Calendar.HOUR_OF_DAY));
    	inicio_evento.set(Calendar.MINUTE,  horarioInicio.get(Calendar.MINUTE));
    	inicio_evento.set(Calendar.DAY_OF_WEEK,this.getDiaDaSemana());
    	return inicio_evento.getTime();
    }
    
    public Date getFinalAtualizado(){
      	Calendar horarioFinal = Calendar.getInstance();
    	horarioFinal.setTimeInMillis(this.getHoraFinal().getTime());
    	Calendar final_evento = Calendar.getInstance();
    	final_evento.set(Calendar.HOUR_OF_DAY,  horarioFinal.get(Calendar.HOUR_OF_DAY));
    	final_evento.set(Calendar.MINUTE,  horarioFinal.get(Calendar.MINUTE));
    	final_evento.set(Calendar.DAY_OF_WEEK,this.getDiaDaSemana());
    	return final_evento.getTime();
    }

}