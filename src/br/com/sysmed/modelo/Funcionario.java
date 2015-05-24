package br.com.sysmed.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the funcionario database table.
 * 
 */
@Entity
@NamedQuery(name="Funcionario.findAll", query="SELECT f FROM Funcionario f")
public abstract class Funcionario extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	private double salario;

	@Column(name="tipo_funcionario")
	protected String tipoFuncionario;
	
	//bi-directional many-to-one association to Trabalha
	@OneToMany(mappedBy="funcionario", cascade={CascadeType.ALL})
	private List<Trabalha> trabalha;

	public double getSalario() {
		return this.salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getTipoFuncionario() {
		return this.tipoFuncionario;
	}

	public List<Trabalha> getTrabalha() {
		return this.trabalha;
	}

	public void setTrabalha(List<Trabalha> trabalha) {
		this.trabalha = trabalha;
	}

	public Trabalha addTrabalha(Trabalha trabalha) {
		getTrabalha().add(trabalha);
		trabalha.setFuncionario(this);
		return trabalha;
	}

	public Trabalha removeTrabalha(Trabalha trabalha) {
		getTrabalha().remove(trabalha);
		trabalha.setFuncionario(null);
		return trabalha;
	}

}