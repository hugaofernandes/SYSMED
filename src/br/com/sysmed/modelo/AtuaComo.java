package br.com.sysmed.modelo;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the atua_como database table.
 * 
 */
@Entity
@Table(name="atua_como")
@NamedQuery(name="AtuaComo.findAll", query="SELECT a FROM AtuaComo a")
public class AtuaComo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATUA_COMO_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.AUTO, generator="ATUA_COMO_ID_GENERATOR")
	private int id;

	@Column(name="custo_consulta")
	private double custoConsulta;

	//bi-directional many-to-one association to Especialidade
	@ManyToOne
	@JoinColumn(name="nome_especialidade")
	private Especialidade especialidade;


	//bi-directional many-to-one association to Trabalha
	@ManyToOne
	@JoinColumn(name="trabalha" )
	private Trabalha trabalhaBean;

	public AtuaComo() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getCustoConsulta() {
		return this.custoConsulta;
	}

	public void setCustoConsulta(double custoConsulta) {
		this.custoConsulta = custoConsulta;
	}

	public Especialidade getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Trabalha getTrabalhaBean() {
		return this.trabalhaBean;
	}

	public void setTrabalhaBean(Trabalha trabalhaBean) {
		this.trabalhaBean = trabalhaBean;
	}

}