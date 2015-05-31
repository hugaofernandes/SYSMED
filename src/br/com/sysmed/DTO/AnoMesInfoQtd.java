package br.com.sysmed.DTO;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class AnoMesInfoQtd {

	private Map<String, List<AnoMesConsulta>> data;

	public AnoMesInfoQtd() {
		data = new HashMap<String, List<AnoMesConsulta>>();
	}
	
	public void add(Object[] dados){
		String info = (String) dados[0];
		int ano = (Integer) dados[1];
		int mes = (Integer) dados[2];
		BigInteger bdados2 = (BigInteger) dados[3];
		int qtdConsultas = bdados2.intValue();
		this.add(info,ano,mes,qtdConsultas);
	}
	
	public void inicializarInfo(String info){
		this.data.put(info, new ArrayList<AnoMesConsulta>());
	
		Calendar comeco = Calendar.getInstance();
		comeco.add(Calendar.YEAR, -1);
		
		Calendar cfinal = Calendar.getInstance();
		cfinal.add(Calendar.MONTH, -1);
		
		while(comeco.before(cfinal)){
			this.data.get(info).add(new AnoMesConsulta(comeco.get(Calendar.YEAR),(comeco.get(Calendar.MONTH)+1),0));
			comeco.add(Calendar.MONTH, +1);
		}
	}
	
	public void add(String info,int ano, int mes,int qtd){
		if (!this.data.containsKey(info))
		{
			inicializarInfo(info);
		}
		this.addDados(info,ano,mes,qtd);
	
	}
		
	private void addDados(String info, int ano, int mes, int qtd) {
		for(AnoMesConsulta a:this.data.get(info)){
			if ((a.getAno() == ano)&&(a.getMes() == mes)){
				a.setQtdConsultas(a.getQtdConsultas()+qtd);
			}
		}
	}

	@Override
	public String toString() {
		String retorno = "";
		for (Map.Entry<String,List<AnoMesConsulta>> entry : this.data.entrySet())
		{
		    for(AnoMesConsulta dados:entry.getValue()){
		    	retorno += entry.getKey() +" "+ dados.toString() + "\n";
		    }
		}
		return retorno;
	}
	public Map<String, List<AnoMesConsulta>> getData() {
		return data;
	}
	public void setData(Map<String, List<AnoMesConsulta>> data) {
		this.data = data;
	}
}
