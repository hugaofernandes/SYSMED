package br.com.sysmed.DTO;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class CharInfoQtd {
	private Map<Character, Integer> data;

	public Map<Character, Integer> getData() {
		return data;
	}
	public void setData(Map<Character, Integer> data) {
		this.data = data;
	}
	public CharInfoQtd() {
		this.data = new HashMap<Character,Integer>();
	}
	public void add(Object[] dados){
		Character info = (Character) dados[0];
		BigInteger bdados2 = (BigInteger) dados[1];
		int qtdConsultas = bdados2.intValue();
		this.add(info,qtdConsultas);
	}
	private void add(Character info, int qtdConsultas) {
			this.data.put(info,qtdConsultas);	
	}
}
