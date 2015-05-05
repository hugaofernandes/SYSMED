package br.com.sysmed.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the consulta database table.
 * 
 */
@Entity
@NamedQuery(name="Consulta.findAll", query="SELECT c FROM Consulta c")
public class Consulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CONSULTA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.AUTO, generator="CONSULTA_ID_GENERATOR")
	private int id;

	private String diagnostico;

	@Column(name="historico_familiar")
	private String historicoFamiliar;

	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;

	@Column(name="observacao_medica")
	private String observacaoMedica;

	@Column(name="queixa_principal")
	private String queixaPrincipal;

	@Column(name="recomendacao_medica")
	private String recomendacaoMedica;

	private String sintomas;

	private String tratamento;

	//bi-directional many-to-one association to SolicitaoConsulta
	@ManyToOne
	@JoinColumn(name="id_solicitacao")
	private SolicitaoConsulta solicitaoConsulta;

	public Consulta() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiagnostico() {
		return this.diagnostico;
	}

	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public String getHistoricoFamiliar() {
		return this.historicoFamiliar;
	}

	public void setHistoricoFamiliar(String historicoFamiliar) {
		this.historicoFamiliar = historicoFamiliar;
	}

	public Date getHorario() {
		return this.horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public String getObservacaoMedica() {
		return this.observacaoMedica;
	}

	public void setObservacaoMedica(String observacaoMedica) {
		this.observacaoMedica = observacaoMedica;
	}

	public String getQueixaPrincipal() {
		return this.queixaPrincipal;
	}

	public void setQueixaPrincipal(String queixaPrincipal) {
		this.queixaPrincipal = queixaPrincipal;
	}

	public String getRecomendacaoMedica() {
		return this.recomendacaoMedica;
	}

	public void setRecomendacaoMedica(String recomendacaoMedica) {
		this.recomendacaoMedica = recomendacaoMedica;
	}

	public String getSintomas() {
		return this.sintomas;
	}

	public void setSintomas(String sintomas) {
		this.sintomas = sintomas;
	}

	public String getTratamento() {
		return this.tratamento;
	}

	public void setTratamento(String tratamento) {
		this.tratamento = tratamento;
	}

	public SolicitaoConsulta getSolicitaoConsulta() {
		return this.solicitaoConsulta;
	}

	public void setSolicitaoConsulta(SolicitaoConsulta solicitaoConsulta) {
		this.solicitaoConsulta = solicitaoConsulta;
	}

}