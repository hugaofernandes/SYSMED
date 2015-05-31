package br.com.sysmed.DTO;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class IntInfoQtd {
	private Map<Integer, Integer> data;

	public Map<Integer, Integer> getData() {
		return data;
	}
	public void setData(Map<Integer, Integer> data) {
		this.data = data;
	}
	public IntInfoQtd() {
		this.data = new HashMap<Integer,Integer>();
	}
	public void add(Object[] dados){
		BigInteger bdados1 = (BigInteger) dados[0];
		int info  =  bdados1.intValue();
		BigInteger bdados2 = (BigInteger) dados[1];
		int qtdConsultas = bdados2.intValue();
		this.add(info,qtdConsultas);
	}
	private void add(Integer info, int qtdConsultas) {
			this.data.put(info,qtdConsultas);	
	}
}
