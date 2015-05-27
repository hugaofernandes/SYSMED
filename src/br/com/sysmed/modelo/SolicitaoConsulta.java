package br.com.sysmed.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the solicitao_consulta database table.
 * 
 */
@Entity
@Table(name="solicitao_consulta")
@NamedQuery(name="SolicitaoConsulta.findAll", query="SELECT s FROM SolicitaoConsulta s")
public class SolicitaoConsulta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SOLICITAO_CONSULTA_ID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.AUTO, generator="SOLICITAO_CONSULTA_ID_GENERATOR")
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date horario;

	@Column(name="motivo_recusacao")
	private String motivoRecusacao;

	@Column(name="status_solicitacao")
	private char statusSolicitacao;
	
	@Column(name="duracao_esperada", columnDefinition="smallint")	
	private int duracaoEsperada;
	
	public int getDuracaoEsperada() {
		return duracaoEsperada;
	}

	public void setDuracaoEsperada(int duracaoEsperada) {
		this.duracaoEsperada = duracaoEsperada;
	}

	//bi-directional many-to-one association to Consulta
	@OneToMany(mappedBy="solicitaoConsulta")
	private List<Consulta> consultas;

	//bi-directional many-to-one association to Especialidade
	@ManyToOne
	@JoinColumn(name="nome_especialidade")
	private Especialidade especialidade;

	//bi-directional many-to-one association to Medico
	@ManyToOne
	@JoinColumn(name="cpf_medico")
	private Medico medico;

	//bi-directional many-to-one association to Paciente
	@ManyToOne
	@JoinColumn(name="cpf_paciente")
	private Paciente paciente;

	//bi-directional many-to-one association to Recepcionista
	@ManyToOne
	@JoinColumn(name="cpf_avaliador")
	private Recepcionista recepcionista;

	public SolicitaoConsulta() {
		this.paciente = new Paciente();
		this.medico = new Medico();
	}
	
	public SolicitaoConsulta(Date horario) {
		this.horario = horario;
		this.paciente = new Paciente();
		this.medico = new Medico();
	}
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getHorario() {
		return this.horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}

	public String getMotivoRecusacao() {
		return this.motivoRecusacao;
	}

	public void setMotivoRecusacao(String motivoRecusacao) {
		this.motivoRecusacao = motivoRecusacao;
	}

	public char getStatusSolicitacao() {
		return this.statusSolicitacao;
	}

	public void setStatusSolicitacao(char statusSolicitacao) {
		this.statusSolicitacao = statusSolicitacao;
	}

	public List<Consulta> getConsultas() {
		return this.consultas;
	}

	public void setConsultas(List<Consulta> consultas) {
		this.consultas = consultas;
	}

	public Consulta addConsulta(Consulta consulta) {
		getConsultas().add(consulta);
		consulta.setSolicitaoConsulta(this);

		return consulta;
	}

	public Consulta removeConsulta(Consulta consulta) {
		getConsultas().remove(consulta);
		consulta.setSolicitaoConsulta(null);

		return consulta;
	}

	public Especialidade getEspecialidade() {
		return this.especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Medico getMedico() {
		return this.medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Paciente getPaciente() {
		return this.paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Recepcionista getRecepcionista() {
		return this.recepcionista;
	}

	public void setRecepcionista(Recepcionista recepcionista) {
		this.recepcionista = recepcionista;
	}

}