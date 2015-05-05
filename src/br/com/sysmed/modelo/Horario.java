package br.com.sysmed.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.sql.Time;


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
		this.horaFinal = horaFinal;
		this.horaInicial = horaInicial;
		this.turno = turno;
	}
	
	public Horario(int diaDaSemana, Time horaInicial, Time horaFinal) {
		super();
		this.diaDaSemana = diaDaSemana;
		this.horaFinal = horaFinal;
		this.horaInicial = horaInicial;

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

	public void setHoraFinal(Time horaFinal) {
		this.horaFinal = horaFinal;
	}

	public Time getHoraInicial() {
		return this.horaInicial;
	}

	public void setHoraInicial(Time horaInicial) {
		this.horaInicial = horaInicial;
	}

	public Turno getTurno() {
		return this.turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

}