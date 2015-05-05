package br.com.sysmed.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;
import java.util.List;


/**
 * The persistent class for the paciente database table.
 * 
 */
@Entity
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;



	@Column(name="alergias_conhecidas")
	private String alergiasConhecidas;

	@Column(name="descricao_local_trabalho")
	private String descricaoLocalTrabalho;

	@Column(name="medicao_atual")
	private String medicaoAtual;

	@Column(name="profissao_atual")
	private String profissaoAtual;

	//bi-directional many-to-one association to SolicitaoConsulta
	@OneToMany(mappedBy="paciente")
	private List<SolicitaoConsulta> solicitacoesRealizadas;

	


	public Paciente(String cpf, String bairro, String cidade, Date dataNasc,
			String email, String estado, String estadoCivil, String nome,
			String nomeRua, String numeroCasa, char sexo, String telefone,String alergiasConhecidas, String descricaoLocalTrabalho,
			String medicaoAtual, String profissaoAtual) {
		super(cpf, bairro, cidade, dataNasc, email, estado, estadoCivil, nome, nomeRua,
				numeroCasa, sexo, telefone);
		this.alergiasConhecidas = alergiasConhecidas;
		this.descricaoLocalTrabalho = descricaoLocalTrabalho;
		this.medicaoAtual = medicaoAtual;
		this.profissaoAtual = profissaoAtual;
	}

	public Paciente() {
		super();
	}


	public String getAlergiasConhecidas() {
		return this.alergiasConhecidas;
	}

	public void setAlergiasConhecidas(String alergiasConhecidas) {
		this.alergiasConhecidas = alergiasConhecidas;
	}

	public String getDescricaoLocalTrabalho() {
		return this.descricaoLocalTrabalho;
	}

	public void setDescricaoLocalTrabalho(String descricaoLocalTrabalho) {
		this.descricaoLocalTrabalho = descricaoLocalTrabalho;
	}

	public String getMedicaoAtual() {
		return this.medicaoAtual;
	}

	public void setMedicaoAtual(String medicaoAtual) {
		this.medicaoAtual = medicaoAtual;
	}

	public String getProfissaoAtual() {
		return this.profissaoAtual;
	}

	public void setProfissaoAtual(String profissaoAtual) {
		this.profissaoAtual = profissaoAtual;
	}

	public List<SolicitaoConsulta> getSolicitacoesRealizadas() {
		return this.solicitacoesRealizadas;
	}

	public void setSolicitacoesRealizadas(List<SolicitaoConsulta> solicitacoesRealizadas) {
		this.solicitacoesRealizadas = solicitacoesRealizadas;
	}

	public SolicitaoConsulta addSolicitacoesRealizada(SolicitaoConsulta solicitacoesRealizada) {
		getSolicitacoesRealizadas().add(solicitacoesRealizada);
		solicitacoesRealizada.setPaciente(this);

		return solicitacoesRealizada;
	}

	public SolicitaoConsulta removeSolicitacoesRealizada(SolicitaoConsulta solicitacoesRealizada) {
		getSolicitacoesRealizadas().remove(solicitacoesRealizada);
		solicitacoesRealizada.setPaciente(null);

		return solicitacoesRealizada;
	}

}