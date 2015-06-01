package br.com.sysmed.DTO;

import java.math.BigInteger;

public class MesDiaConsulta {
	
	private int mes;
	private int dia;
	private int qtdConsultas;
	
	public MesDiaConsulta(int mes, int dia, int qtdConsultas) {
		this.mes = mes;
		this.dia = dia;
		this.qtdConsultas = qtdConsultas;
	}
	public MesDiaConsulta(Object[] dados) {
		this.mes = (Integer) dados[0];
		this.dia = (Integer) dados[1];
		BigInteger bdados2 = (BigInteger) dados[2];
		this.qtdConsultas = bdados2.intValue();
	}
	
	public int getMes() {
		return mes;
	}
	public void setMes(int mes) {
		this.mes = mes;
	}
	public int getDia() {
		return dia;
	}
	public void setDia(int dia) {
		this.dia = dia;
	}
	public int getQtdConsultas() {
		return qtdConsultas;
	}
	public void setQtdConsultas(int qtdConsultas) {
		this.qtdConsultas = qtdConsultas;
	}
	public String getMesDia(){	
		return this.mes +"-"+this.dia;
	}
	@Override
	public String toString() {
		return "MesDIaConsulta [mes=" + mes + ", dia=" + dia
				+ ", qtdConsultas=" + qtdConsultas + "]";
	}
	
}
