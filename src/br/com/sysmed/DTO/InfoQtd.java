package br.com.sysmed.DTO;


import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class InfoQtd {
	private Map<String, Integer> data;

	public Map<String, Integer> getData() {
		return data;
	}
	public void setData(Map<String, Integer> data) {
		this.data = data;
	}
	public InfoQtd() {
		this.data = new HashMap<String,Integer>();
	}
	public void add(Object[] dados){
		String info = (String) dados[0];
		BigInteger bdados2 = (BigInteger) dados[1];
		int qtdConsultas = bdados2.intValue();
		this.add(info,qtdConsultas);
	}
	private void add(String info, int qtdConsultas) {
			this.data.put(info,qtdConsultas);	
	}
}
