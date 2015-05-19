package br.com.sysmed.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import br.com.sysmed.dao.PacienteDao;
import br.com.sysmed.modelo.Paciente;


@ManagedBean(name = "pacienteView")
//@ViewScoped
@SessionScoped  
public class PacienteView {
private PacienteDao dao;
private Paciente paciente;
private String data_nasc;
private List<Paciente> pacientes;
private List<Paciente> pacientesFilter;


	
	@PostConstruct
	public void init() {
		dao = new PacienteDao();
		paciente = new Paciente();
		try {
			pacientes = dao.findAll();
			//pacientesFilter = dao.findAll();
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
	
	public String paginaEditar() {
		System.out.println(this.paciente.getNome());
		return "paginaEditar";
	}
	
	public void editar() {
		System.out.println(this.paciente.getNome());
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy"); 
		try{
			this.paciente.setDataNasc((Date)formatter.parse(this.data_nasc));
		}catch(Exception e){
			e.printStackTrace();
		}
		paciente.setCpf(paciente.getCpf().replaceAll("[.-]", ""));
		paciente.setTelefone(paciente.getTelefone().replaceAll("[.-]", ""));
		dao.alterar(this.paciente);
		paciente = new Paciente();
		this.data_nasc = "";
	}
	
	public String novoPaciente(){
		System.out.println(this.paciente.getNome());
		this.paciente = new Paciente();
		this.data_nasc = "";
		return "paginaCadastro";
		
	}
	
	public PacienteDao getDao() {
		return dao;
	}
	
	public void setDao(PacienteDao dao) {
		this.dao = dao;
	}
	
	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}
	
	public void excluir(){
		System.out.println(this.paciente.getNome());
		dao.excluir(this.paciente);
		pacientes.remove(this.paciente);
		paciente = new Paciente();
		this.data_nasc = "";
		//init();
	}
	
	public String getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public List<Paciente> getPacientesFilter() {
		return pacientesFilter;
	}

	public void setPacientesFilter(List<Paciente> pacientesFilter) {
		this.pacientesFilter = pacientesFilter;
	}

	

}
