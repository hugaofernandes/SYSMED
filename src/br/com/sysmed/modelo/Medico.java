package br.com.sysmed.modelo;

import java.io.Serializable;

import javax.persistence.*;

import org.primefaces.expression.impl.ThisExpressionResolver;

import java.util.List;


/**
 * The persistent class for the medico database table.
 * 
 */
@Entity
@NamedQuery(name="Medico.findAll", query="SELECT m FROM Medico m")
public class Medico extends Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;



	private String sobre;

	//bi-directional many-to-one association to AtuaComo
	@OneToMany(mappedBy="medico")
	private List<AtuaComo> atuaComos;


	//bi-directional many-to-one association to SolicitaoConsulta
	@OneToMany(mappedBy="medico")
	private List<SolicitaoConsulta> solicitadoEm;

	public Medico() {
		super();
		this.tipoFuncionario = "medico";
	}

	public String getSobre() {
		return this.sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	public List<AtuaComo> getAtuaComos() {
		return this.atuaComos;
	}

	public void setAtuaComos(List<AtuaComo> atuaComos) {
		this.atuaComos = atuaComos;
	}

	public AtuaComo addAtuaComo(AtuaComo atuaComo) {
		getAtuaComos().add(atuaComo);
		atuaComo.setMedico(this);

		return atuaComo;
	}

	public AtuaComo removeAtuaComo(AtuaComo atuaComo) {
		getAtuaComos().remove(atuaComo);
		atuaComo.setMedico(null);

		return atuaComo;
	}

	public List<SolicitaoConsulta> getSolicitadoEm() {
		return this.solicitadoEm;
	}

	public void setSolicitadoEm(List<SolicitaoConsulta> solicitadoEm) {
		this.solicitadoEm = solicitadoEm;
	}

	public SolicitaoConsulta addSolicitadoEm(SolicitaoConsulta solicitadoEm) {
		getSolicitadoEm().add(solicitadoEm);
		solicitadoEm.setMedico(this);

		return solicitadoEm;
	}

	public SolicitaoConsulta removeSolicitadoEm(SolicitaoConsulta solicitadoEm) {
		getSolicitadoEm().remove(solicitadoEm);
		solicitadoEm.setMedico(null);

		return solicitadoEm;
	}

}