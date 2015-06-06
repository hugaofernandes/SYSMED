package br.com.sysmed.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.List;


/**
 * The persistent class for the trabalha database table.
 * 
 */
@Entity
@NamedQuery(name="Trabalha.findAll", query="SELECT t FROM Trabalha t")
public class Trabalha implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="TRABALHA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.AUTO, generator="TRABALHA_ID_GENERATOR")
	private int id;

	//bi-directional many-to-one association to Funcionario
	@ManyToOne
	@JoinColumn(name="cpf")
	private Funcionario funcionario;
	
	@OneToMany(mappedBy="trabalhaBean", cascade = CascadeType.ALL)
	private List<AtuaComo> atuaComos;
	
	//bi-directional many-to-one association to Turno
	@ManyToOne
	@JoinColumn(name="turno")
	private Turno turnoBean;

	public Trabalha() {
		this.atuaComos = new ArrayList<AtuaComo>();
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return this.funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Turno getTurnoBean() {
		return this.turnoBean;
	}

	public void setTurnoBean(Turno turnoBean) {
		this.turnoBean = turnoBean;
	}
	
	public List<AtuaComo> getAtuaComos() {
		return this.atuaComos;
	}

	public void setAtuaComos(List<AtuaComo> atuaComos) {
		this.atuaComos = atuaComos;
	}

	public AtuaComo addAtuaComo(AtuaComo atuaComo) {
		
		getAtuaComos().add(atuaComo);
		atuaComo.setTrabalhaBean(this);
		return atuaComo;
	}

	public AtuaComo removeAtuaComo(AtuaComo atuaComo) {
		getAtuaComos().remove(atuaComo);
		atuaComo.setTrabalhaBean(null);

		return atuaComo;
	}

}