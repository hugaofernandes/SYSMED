package br.com.sysmed.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the especialidade database table.
 * 
 */
@Entity
@NamedQuery(name="Especialidade.findAll", query="SELECT e FROM Especialidade e")
public class Especialidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String nome;

	private String descricao;

	//bi-directional many-to-one association to AtuaComo
	@OneToMany(mappedBy="especialidade")
	private List<AtuaComo> atuaComos;

	//bi-directional many-to-one association to SolicitaoConsulta
	@OneToMany(mappedBy="especialidade")
	private List<SolicitaoConsulta> solicitadaEm;

	public Especialidade() {
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<AtuaComo> getAtuaComos() {
		return this.atuaComos;
	}

	public void setAtuaComos(List<AtuaComo> atuaComos) {
		this.atuaComos = atuaComos;
	}

	public AtuaComo addAtuaComo(AtuaComo atuaComo) {
		getAtuaComos().add(atuaComo);
		atuaComo.setEspecialidade(this);

		return atuaComo;
	}

	public AtuaComo removeAtuaComo(AtuaComo atuaComo) {
		getAtuaComos().remove(atuaComo);
		atuaComo.setEspecialidade(null);

		return atuaComo;
	}

	public List<SolicitaoConsulta> getSolicitadaEm() {
		return this.solicitadaEm;
	}

	public void setSolicitadaEm(List<SolicitaoConsulta> solicitadaEm) {
		this.solicitadaEm = solicitadaEm;
	}

	public SolicitaoConsulta addSolicitadaEm(SolicitaoConsulta solicitadaEm) {
		getSolicitadaEm().add(solicitadaEm);
		solicitadaEm.setEspecialidade(this);

		return solicitadaEm;
	}

	public SolicitaoConsulta removeSolicitadaEm(SolicitaoConsulta solicitadaEm) {
		getSolicitadaEm().remove(solicitadaEm);
		solicitadaEm.setEspecialidade(null);

		return solicitadaEm;
	}
	@Override
	public String toString() {
		return this.getNome();
	}
}