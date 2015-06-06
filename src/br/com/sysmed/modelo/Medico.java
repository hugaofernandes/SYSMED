package br.com.sysmed.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.ArrayList;
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

	//bi-directional many-to-one association to SolicitaoConsulta
	@OneToMany(mappedBy="medico")
	private List<SolicitaoConsulta> solicitadoEm;

	public Medico() {
		super();
		this.trabalha = new ArrayList<Trabalha>();
		this.tipoFuncionario = "medico";
	}

	public String getSobre() {
		return this.sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
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