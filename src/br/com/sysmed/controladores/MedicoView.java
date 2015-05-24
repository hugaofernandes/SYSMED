package br.com.sysmed.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

import br.com.sysmed.dao.EspecialidadeDAO;
import br.com.sysmed.dao.MedicoDao;
import br.com.sysmed.dao.TurnoDAO;
import br.com.sysmed.modelo.Especialidade;
import br.com.sysmed.modelo.Horario;
import br.com.sysmed.modelo.Medico;
import br.com.sysmed.modelo.Trabalha;
import br.com.sysmed.modelo.Turno;


@ManagedBean(name = "medicoView")
@SessionScoped  
public class MedicoView {
private MedicoDao dao;

private String turno;
private List<Turno> turnos;

private String especialidade;
private List<Especialidade> especialidades;

private Medico medico;
private String data_nasc;
private EspecialidadeDAO especialidadeDAO;
private List<Medico> medicos;
private List<Medico> medicosFilter;

private Especialidade novaEspecialidade;


	@PostConstruct
	public void init() {
		TurnoDAO daoTurno = new TurnoDAO();
		try {
	
			this.turnos = daoTurno.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		especialidadeDAO = new EspecialidadeDAO();
		try {
			
			this.especialidades = especialidadeDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		dao = new MedicoDao();
		try {
			medicos = dao.findAll();
		} catch (Exception e) {
			e.printStackTrace();

		}
		this.novaEspecialidade = new Especialidade();
		medico = new Medico();
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
	
	public void salvarEspecialidade(){
		especialidadeDAO.salvar(this.novaEspecialidade);
		this.novaEspecialidade = new Especialidade();
		this.atualizarEspecialidade();
	
	}
	public String novoMedico(){
		System.out.println(this.medico.getNome());
		this.medico = new Medico();
		this.data_nasc = "";
		return "paginaCadastroMedico";
		
	}
	public void addTurno(){
		System.out.println("teste");
		System.out.println(this.turno);
	}
	public void excluir(){
		System.out.println(this.medico.getNome());
		dao.excluir(this.medico);
		medicos.remove(this.medico);
		medico = new Medico();
		this.data_nasc = "";
	}
	public void atualizarEspecialidade(){
		try {
			this.especialidades = especialidadeDAO.findAll();
			System.out.println("atualizado");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nao atulizado");
		}
		for (Especialidade especialidade:this.getEspecialidades()){
			System.out.println(especialidade);
		}
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
	
	public List<Turno> getTurnos() {
		return turnos;
	}

	public void setTurnos(List<Turno> turnos) {
		this.turnos = turnos;
	}
	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}
	public List<Especialidade> getEspecialidades() {
		return especialidades;
	}

	public void setEspecialidades(List<Especialidade> especialidades) {
		this.especialidades = especialidades;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public Especialidade getNovaEspecialidade() {
		return novaEspecialidade;
	}

	public void setNovaEspecialidade(Especialidade novaEspecialidade) {
		this.novaEspecialidade = novaEspecialidade;
	}
	
	
	
	

}
