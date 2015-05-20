package br.com.sysmed.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import br.com.sysmed.dao.PacienteDao;
import br.com.sysmed.dao.RecepcionistaDao;
import br.com.sysmed.modelo.Paciente;
import br.com.sysmed.modelo.Recepcionista;


@ManagedBean(name = "recepcionistaView")
@SessionScoped  
public class RecepcionistaView {
private RecepcionistaDao dao;
private Recepcionista recepcionista;
private String data_nasc;
private List<Recepcionista> recepcionistas;
private List<Recepcionista> recepcionistasFilter;
	
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
	
	public void salvar(ActionEvent actionEvent) {
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
	
	public String paginaEditar() {
		System.out.println(this.recepcionista.getNome());
		return "paginaEditarRecepcionista";
	}
	
	public void editar() {
		//System.out.println(this.recepcionista.getNome());
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy"); 
		try{
			this.recepcionista.setDataNasc((Date)formatter.parse(this.data_nasc));
		}catch(Exception e){
			e.printStackTrace();
		}
		recepcionista.setCpf(recepcionista.getCpf().replaceAll("[.-]", ""));
		recepcionista.setTelefone(recepcionista.getTelefone().replaceAll("[.-]", ""));
		dao.alterar(this.recepcionista);
		recepcionista = new Recepcionista();
		this.data_nasc = "";
	}
	
	public String novo(){
		System.out.println(this.recepcionista.getNome());
		this.recepcionista = new Recepcionista();
		this.data_nasc = "";
		return "paginaCadastroRecepcionista";
		
	}
	
	public void excluir(){
		System.out.println(this.recepcionista.getNome());
		dao.excluir(this.recepcionista);
		recepcionistas.remove(this.recepcionista);
		recepcionista = new Recepcionista();
		this.data_nasc = "";
	}
	
	public String getData_nasc() {
		return data_nasc;
	}
	public void setData_nasc(String data_nasc) {
		this.data_nasc = data_nasc;
	}

	public Recepcionista getRecepcionista() {
		return recepcionista;
	}

	public void setRecepcionista(Recepcionista recepcionista) {
		this.recepcionista = recepcionista;
	}

	public List<Recepcionista> getRecepcionistas() {
		return recepcionistas;
	}

	public void setRecepcionistas(List<Recepcionista> recepcionistas) {
		this.recepcionistas = recepcionistas;
	}

	public List<Recepcionista> getRecepcionistasFilter() {
		return recepcionistasFilter;
	}

	public void setRecepcionistasFilter(List<Recepcionista> recepcionistasFilter) {
		this.recepcionistasFilter = recepcionistasFilter;
	}

	

}
