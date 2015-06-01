package br.com.sysmed.DTO;

import java.math.BigInteger;

public class AnoMesConsulta {
	private int ano;
	private int mes;
	private int qtdConsultas;
	
	public AnoMesConsulta(int ano, int mes, int qtdConsultas) {
		this.ano = ano;
		this.mes = mes;
		this.qtdConsultas = qtdConsultas;
	}
	
	public AnoMesConsulta(Object[] dados) {
		this.ano = (Integer) dados[0];
		this.mes = (Integer) dados[1];
		BigInteger bdados2 = (BigInteger) dados[2];
		this.qtdConsultas = bdados2.intValue();
	}
	public AnoMesConsulta() {
		this.ano = 0;
		this.mes = 0;
		this.qtdConsultas = 0;
	}
	
	public int getAno() {
		return ano;
	}
	
	public void setAno(int ano) {
		this.ano = ano;
	}
	
	public int getMes() {
		return mes;
	}
	
	public void setMes(int mes) {
		this.mes = mes;
	}
	
	public int getQtdConsultas() {
		return qtdConsultas;
	}
	
	public void setQtdConsultas(int qtdConsultas) {
		this.qtdConsultas = qtdConsultas;
	}
	public String getAnoMes(){	
		return this.ano +"-"+this.mes;
	}
	@Override
	public String toString() {
		return "AnoMesConsulta [ano=" + ano + ", mes=" + mes
				+ ", qtdConsultas=" + qtdConsultas + "]";
	}
}
