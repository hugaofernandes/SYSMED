package br.com.sysmed.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.sysmed.dao.RecepcionistaDao;
import br.com.sysmed.modelo.Recepcionista;



@ManagedBean(name = "recepcionistaView")
@ViewScoped
public class RecepcionistaView {
private RecepcionistaDao dao;
private Recepcionista recepcionista;
private String data_nasc;
private List<Recepcionista> recepcionistas;
	
	@PostConstruct
	public void init() {
		dao = new RecepcionistaDao();
		recepcionista = new Recepcionista();
		try {
			recepcionistas = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public List<Recepcionista> getRecepcionistas() {
		return recepcionistas;
	}
	public Recepcionista getRecepcionista() {
		return recepcionista;
	}
	
	public void setPaciente(Recepcionista recepcionista) {
		this.recepcionista = recepcionista;
	}
			
	public void salvar(ActionEvent actionEvent) {
		System.out.println("############################################################################");
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy"); 
		try{
			this.recepcionista.setDataNasc((Date)formatter.parse(this.data_nasc));
		}catch(Exception e){
			e.printStackTrace();
		}
		recepcionista.setCpf(recepcionista.getCpf().replaceAll("[.-]", ""));
		recepcionista.setTelefone(recepcionista.getTelefone().replaceAll("[.-]", ""));
		System.out.println(recepcionista.getDataNasc());
        dao.salvar(recepcionista);
        recepcionistas.add(this.recepcionista);
    	recepcionista = new Recepcionista();
    	this.data_nasc = "";
    }
	public String getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}
	
	
	
	

}
