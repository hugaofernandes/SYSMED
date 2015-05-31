package br.com.sysmed.DTO;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Cidade {
	private int qtd_clientes;
	private String nome;
	private Map<String, Integer> bairros;
	
	public Cidade(String nome) {
		this.nome = nome;
		this.qtd_clientes = 0;
		this.bairros = new HashMap<String,Integer>();
	}
	
	public int getQtd_clientes() {
		return qtd_clientes;
	}
	
	public void setQtd_clientes(int qtd_clientes) {
		this.qtd_clientes = qtd_clientes;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	public void add(String bairro, int quantidade){
		if (!this.bairros.containsKey(bairro))
		{
			this.bairros.put(bairro,0);
		}
		this.qtd_clientes += quantidade;
		this.bairros.put(bairro,this.bairros.get(bairro)+quantidade);
	}
	
	public Map<String, Integer> getbairros() {
		return bairros;
	}
	
	public void bairros(Map<String, Integer> qtd_bairros) {
		this.bairros = qtd_bairros;
	}
}
