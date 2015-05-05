package br.com.sysmed.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
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
	@OneToMany(mappedBy="turno", cascade={CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Horario> horarios;

	//bi-directional many-to-one association to Trabalha
	@OneToMany(mappedBy="turnoBean", cascade={CascadeType.ALL})
	private List<Trabalha> trabalha;

	public Turno() {
		this.horarios = new ArrayList<Horario>();
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

	public Horario addHorario(Horario horario) {
		getHorarios().add(horario);
		horario.setTurno(this);
		return horario;
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

}