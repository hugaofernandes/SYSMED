package br.com.sysmed.controladores;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import br.com.sysmed.dao.EspecialidadeDAO;
import br.com.sysmed.dao.MedicoDao;
import br.com.sysmed.dao.TurnoDAO;
import br.com.sysmed.modelo.AtuaComo;
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
	private double custo_consulta;
	private int duracaoEsperada;
	
	private EspecialidadeDAO especialidadeDAO;
	private List<Medico> medicos;
	private List<Medico> medicosFilter;
	private Especialidade novaEspecialidade;
	private ScheduleModel horariosTrabalho;
	private List<AtuaComo> horarios;
	private AtuaComo atuaSelecionado;

	@PostConstruct
	public void init() {
		this.medico = new Medico();
		this.medico.setCpf("1");
		this.medico.setBairro("null");
		this.medico.setCidade("null");
		this.medico.setDataNasc(new Date());
		this.medico.setEmail("null");
		this.medico.setEstado("nl");
		this.medico.setNome("new medico");
		this.medico.setNomeRua("null");
		this.medico.setNumeroCasa("null");
		this.medico.setSalario(00.00);
		this.medico.setSexo('M');
		this.medico.setTelefone("null");
		this.medico.setEstado("RN");
		this.medico.setEstadoCivil("casado");

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
		horariosTrabalho = new DefaultScheduleModel();
		horarios = new ArrayList<AtuaComo>();

	}

	public void salvar(ActionEvent actionEvent) {
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		try {
			this.medico.setDataNasc((Date) formatter.parse(this.data_nasc));
		} catch (Exception e) {
			e.printStackTrace();
		}
		medico.setCpf(medico.getCpf().replaceAll("[.-]", ""));
		medico.setTelefone(medico.getTelefone().replaceAll("[.-]", ""));
		System.out.println(medico.getDataNasc());
		dao.salvar(medico);
		medicos.add(this.medico);
		medico = new Medico();
		this.data_nasc = "";
		System.out.println("salvo1");
	}

	public void salvar2() {
		try {
			dao.salvar(this.medico);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("salvo2");
	}

	public String paginaEditar() {
		System.out.println(this.medico.getNome());
		return "paginaEditarMedico";
	}

	public void editar() {
		System.out.println(this.medico.getNome());
		DateFormat formatter = new SimpleDateFormat("dd/MM/yy");
		try {
			this.medico.setDataNasc((Date) formatter.parse(this.data_nasc));
		} catch (Exception e) {
			e.printStackTrace();
		}
		medico.setCpf(medico.getCpf().replaceAll("[.-]", ""));
		medico.setTelefone(medico.getTelefone().replaceAll("[.-]", ""));
		dao.alterar(this.medico);
		medico = new Medico();
		this.data_nasc = "";
	}

	public void salvarEspecialidade() {
		especialidadeDAO.salvar(this.novaEspecialidade);
		this.novaEspecialidade = new Especialidade();
		this.atualizarEspecialidade();

	}

	public String novoMedico() {
		System.out.println(this.medico.getNome());
		this.medico = new Medico();
		this.data_nasc = "";
		return "paginaCadastroMedico";
	}

	public void addAtuaComo() {
		boolean adicionaAtuaComo = true;
		String messagemString = "";
		Trabalha trabalha;
		Turno turnoEscolhido = null;
		for (Turno turno : this.turnos) {
			if (turno.getNome().equals(this.turno)) {
				turnoEscolhido = turno;
			}
		}
		AtuaComo atua = new AtuaComo();
		atua.setCustoConsulta(this.custo_consulta);
		atua.setDuracaoEsperada(this.getDuracaoEsperada());
		for (Especialidade especialidade2 : this.especialidades) {
			if (especialidade2.getNome().equals(this.especialidade)) {
				atua.setEspecialidade(especialidade2);
			}
		}
		if (this.medico.temTurno(turnoEscolhido.getNome())) {
			trabalha = medico.getTrabalhaPorTurno(this.turno);
			System.out.println("ja existia");
			for(AtuaComo atuacomo:trabalha.getAtuaComos()){
				if (atuacomo.getEspecialidade().getNome().equals(atua.getEspecialidade().getNome()))
				{	
					adicionaAtuaComo = false;
					messagemString = "Essa especialidade ja foi adicionada a esse turno";
				}
			}
		} else {
			trabalha = new Trabalha();
			trabalha.setFuncionario(this.medico);
			trabalha.setTurnoBean(turnoEscolhido);
			turnoEscolhido.addTrabalha(trabalha);
			adicionaAtuaComo  = this.medico.addTrabalha(trabalha);
			if(!adicionaAtuaComo){
				messagemString = "Nao foi possivel adicionar o turno devido a um conflito entre horarios";
			}
			System.out.println("Não existia");
		}
		if(adicionaAtuaComo){
			horarios.add(atua);
			trabalha.addAtuaComo(atua);
			atua.setTrabalhaBean(trabalha);
			for(Horario horario:turnoEscolhido.getHorarios()){
				String titulo = turnoEscolhido.getNome()+ "\n" +this.especialidade;
				DefaultScheduleEvent novoEvento = new DefaultScheduleEvent(titulo, horario.getInicioAtualizado(),horario.getFinalAtualizado());
				novoEvento.setData(atua);
				this.horariosTrabalho.addEvent(novoEvento);
			}
			System.out.println(this.medico.getCpf());
			System.out.println(turnoEscolhido);
			System.out.println(this.especialidade);
			System.out.println("adicionado");
		}
		else{
			 FacesMessage messagem = new FacesMessage(FacesMessage.SEVERITY_ERROR,"Erro ao adicionar",messagemString);
			 addMessagem(messagem);
		}

	}
	
	private void addMessagem(FacesMessage message) {
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
	public List<AtuaComo> getHorarios() {
		return horarios;
	}

	public void setHorarios(List<AtuaComo> horarios) {
		this.horarios = horarios;
	}

	public void excluir() {
		System.out.println(this.medico.getNome());
		dao.excluir(this.medico);
		medicos.remove(this.medico);
		medico = new Medico();
		this.data_nasc = "";
	}
	public void excluirAtuaSelecionado(){
		Trabalha trabalhaExcluir = this.atuaSelecionado.getTrabalhaBean();
		List<ScheduleEvent> eventosExcluir = new ArrayList<ScheduleEvent>();
		AtuaComo atuaEvento;
		for(ScheduleEvent event:this.getHorariosTrabalho().getEvents()){
			atuaEvento = (AtuaComo) event.getData();
			if ((atuaEvento.getEspecialidade().getNome().equals(this.atuaSelecionado.getEspecialidade().getNome()))
				&&(atuaEvento.getTrabalhaBean().getTurnoBean().getNome().equals(this.getAtuaSelecionado().getTrabalhaBean().getTurnoBean().getNome()))
				){
				
				eventosExcluir.add(event);
			}
		}
		
		trabalhaExcluir.removeAtuaComo(this.atuaSelecionado);

		if (trabalhaExcluir.getAtuaComos().isEmpty()){
			this.medico.removeTrabalha(trabalhaExcluir);
		}

		for(ScheduleEvent event:eventosExcluir){
			this.getHorariosTrabalho().deleteEvent(event);
		}
		this.horarios.remove(this.atuaSelecionado);
	
	}
	public void atualizarEspecialidade() {
		try {
			this.especialidades = especialidadeDAO.findAll();
			System.out.println("atualizado");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nao atulizado");
		}
		for (Especialidade especialidade : this.getEspecialidades()) {
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

	public double getCusto_consulta() {
		return custo_consulta;
	}

	public void setCusto_consulta(double custo_consulta) {
		this.custo_consulta = custo_consulta;
	}

	public ScheduleModel getHorariosTrabalho() {
		return horariosTrabalho;
	}

	public void setHorariosTrabalho(ScheduleModel horariosTrabalho) {
		this.horariosTrabalho = horariosTrabalho;
	}
	public AtuaComo getAtuaSelecionado() {
		return atuaSelecionado;
	}

	public void setAtuaSelecionado(AtuaComo atuaSelecionado) {
		this.atuaSelecionado = atuaSelecionado;
	}
	public int getDuracaoEsperada() {
		return duracaoEsperada;
	}

	public void setDuracaoEsperada(int duracaoEsperada) {
		this.duracaoEsperada = duracaoEsperada;
	}


}
