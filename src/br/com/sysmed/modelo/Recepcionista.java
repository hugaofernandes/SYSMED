package br.com.sysmed.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the recepcionista database table.
 * 
 */
@Entity
@NamedQuery(name="Recepcionista.findAll", query="SELECT r FROM Recepcionista r")
public class Recepcionista extends Funcionario implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional many-to-one association to SolicitaoConsulta
	@OneToMany(mappedBy="recepcionista")
	private List<SolicitaoConsulta> solicitacoesAvaliadas;

	public Recepcionista() {
		this.tipoFuncionario = "recepcionista";
	}

	public List<SolicitaoConsulta> getSolicitacoesAvaliadas() {
		return this.solicitacoesAvaliadas;
	}

	public void setSolicitacoesAvaliadas(List<SolicitaoConsulta> solicitacoesAvaliadas) {
		this.solicitacoesAvaliadas = solicitacoesAvaliadas;
	}

	public SolicitaoConsulta addSolicitacoesAvaliada(SolicitaoConsulta solicitacoesAvaliada) {
		getSolicitacoesAvaliadas().add(solicitacoesAvaliada);
		solicitacoesAvaliada.setRecepcionista(this);

		return solicitacoesAvaliada;
	}

	public SolicitaoConsulta removeSolicitacoesAvaliada(SolicitaoConsulta solicitacoesAvaliada) {
		getSolicitacoesAvaliadas().remove(solicitacoesAvaliada);
		solicitacoesAvaliada.setRecepcionista(null);

		return solicitacoesAvaliada;
	}

}