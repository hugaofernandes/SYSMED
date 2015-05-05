package br.com.sysmed.modelo;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the pessoa database table.
 * 
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@NamedQuery(name="Pessoa.findAll", query="SELECT p FROM Pessoa p")
public abstract class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition="CHAR(11)") 
	private String cpf;

	private String bairro;

	private String cidade;

	@Temporal(TemporalType.DATE)
	@Column(name="data_nasc")
	private Date dataNasc;

	private String email;
	
	@Column(columnDefinition="CHAR(2)") 
	private String estado;

	@Column(name="estado_civil")
	private String estadoCivil;

	private String nome;

	@Column(name="nome_rua")
	private String nomeRua;

	@Column(name="numero_casa")
	private String numeroCasa;

	private char sexo;
	
	@Column(columnDefinition="CHAR(8)") 
	private String telefone;


	public Pessoa() {
	}
    
	

	public Pessoa(String cpf, String bairro, String cidade, Date dataNasc,
			String email, String estado, String estadoCivil, String nome,
			String nomeRua, String numeroCasa, char sexo, String telefone) {
		super();
		this.cpf = cpf;
		this.bairro = bairro;
		this.cidade = cidade;
		this.dataNasc = dataNasc;
		this.email = email;
		this.estado = estado;
		this.estadoCivil = estadoCivil;
		this.nome = nome;
		this.nomeRua = nomeRua;
		this.numeroCasa = numeroCasa;
		this.sexo = sexo;
		this.telefone = telefone;
	}



	public String getCpf() {
		return this.cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBairro() {
		return this.bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return this.cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Date getDataNasc() {
		return this.dataNasc;
	}

	public void setDataNasc(Date dataNasc) {
		this.dataNasc = dataNasc;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEstado() {
		return this.estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getEstadoCivil() {
		return this.estadoCivil;
	}

	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}

	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomeRua() {
		return this.nomeRua;
	}

	public void setNomeRua(String nomeRua) {
		this.nomeRua = nomeRua;
	}

	public String getNumeroCasa() {
		return this.numeroCasa;
	}

	public void setNumeroCasa(String numeroCasa) {
		this.numeroCasa = numeroCasa;
	}

	public char getSexo() {
		return this.sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getTelefone() {
		return this.telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


}