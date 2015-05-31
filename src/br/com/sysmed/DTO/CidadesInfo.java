package br.com.sysmed.DTO;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class CidadesInfo {
	private Map<String, Cidade> cidades;
	public CidadesInfo() {
		cidades = new HashMap<String, Cidade>();
	}
	public Map<String, Cidade> getCidades() {
		return cidades;
	}
	public void setCidades(Map<String, Cidade> cidades) {
		this.cidades = cidades;
	}
	public void add(Object[] dados){
		String nome_cidade = (String) dados[0];
		String nome_bairro = (String) dados[1];
		BigInteger bdados = (BigInteger) dados[2];
		int qtd = bdados.intValue();
		this.add(nome_cidade,nome_bairro,qtd);
	}
	private void add(String nome_cidade, String nome_bairro, int qtd) {
		if (!this.cidades.containsKey(nome_cidade))
		{
			this.cidades.put(nome_cidade,new Cidade(nome_cidade));
		}
		this.cidades.get(nome_cidade).add(nome_bairro, qtd);	
	}
}
