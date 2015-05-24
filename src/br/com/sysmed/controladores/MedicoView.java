package br.com.sysmed.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.com.sysmed.dao.MedicoDao;
import br.com.sysmed.dao.TurnoDAO;
import br.com.sysmed.modelo.Medico;


@ManagedBean(name = "medicoView")
@SessionScoped  
public class MedicoView {
private MedicoDao dao;
private TurnoDAO daoTurno;
private Medico medico;
private String data_nasc;
private List<Medico> medicos;
private List<Medico> medicosFilter;


	
	@PostConstruct
	public void init() {
		daoTurno = new TurnoDAO();
		dao = new MedicoDao();
		medico = new Medico();
		try {
			medicos = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
		
	public void salvar(ActionEvent actionEvent) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy"); 
		try{
			this.medico.setDataNasc((Date)formatter.parse(this.data_nasc));
		}catch(Exception e){
			e.printStackTrace();
		}
		medico.setCpf(medico.getCpf().replaceAll("[.-]", ""));
		medico.setTelefone(medico.getTelefone().replaceAll("[.-]", ""));
		System.out.println(medico.getDataNasc());
        dao.salvar(medico);
        medicos.add(this.medico);
        medico = new Medico();
    	this.data_nasc = "";
    }
	
	public String paginaEditar() {
		System.out.println(this.medico.getNome());
		return "paginaEditarMedico";
	}
	
	public void editar() {
		System.out.println(this.medico.getNome());
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy"); 
		try{
			this.medico.setDataNasc((Date)formatter.parse(this.data_nasc));
		}catch(Exception e){
			e.printStackTrace();
		}
		medico.setCpf(medico.getCpf().replaceAll("[.-]", ""));
		medico.setTelefone(medico.getTelefone().replaceAll("[.-]", ""));
		dao.alterar(this.medico);
		medico = new Medico();
		this.data_nasc = "";
	}
	
	public String novoMedico(){
		System.out.println(this.medico.getNome());
		this.medico = new Medico();
		this.data_nasc = "";
		return "paginaCadastroMedico";
		
	}
	public void addTurno(){
		
	}
	public void excluir(){
		System.out.println(this.medico.getNome());
		dao.excluir(this.medico);
		medicos.remove(this.medico);
		medico = new Medico();
		this.data_nasc = "";
	}
	
	public String getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}
	
	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void setMedicos(List<Medico> medicos) {
		this.medicos = medicos;
	}

	public List<Medico> getMedicosFilter() {
		return medicosFilter;
	}

	public void setMedicosFilter(List<Medico> medicosFilter) {
		this.medicosFilter = medicosFilter;
	}
}
