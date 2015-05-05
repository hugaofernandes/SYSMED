package br.com.sysmed.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;

import br.com.sysmed.dao.PacienteDao;
import br.com.sysmed.modelo.Paciente;


@ManagedBean(name = "pacienteView")
@ViewScoped
public class PacienteView {
private PacienteDao dao;
private Paciente paciente;
private String data_nasc;
private List<Paciente> pacientes;
	
	@PostConstruct
	public void init() {
		dao = new PacienteDao();
		paciente = new Paciente();
		try {
			pacientes = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
	public List<Paciente> getPacientes() {
		return pacientes;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public void salvar(ActionEvent actionEvent) {
		System.out.println("############################################################################");
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy"); 
		try{
			this.paciente.setDataNasc((Date)formatter.parse(this.data_nasc));
		}catch(Exception e){
			e.printStackTrace();
		}
		paciente.setCpf(paciente.getCpf().replaceAll("[.-]", ""));
		paciente.setTelefone(paciente.getTelefone().replaceAll("[.-]", ""));
		System.out.println(paciente.getDataNasc());
        dao.salvar(paciente);
        pacientes.add(this.paciente);
    	paciente = new Paciente();
    	this.data_nasc = "";
    }
	public String getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}
	
	
	
	

}
