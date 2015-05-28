package br.com.sysmed.testes;

import java.sql.Time;
import java.util.Calendar;
import java.util.Date;
import java.util.List;





import br.com.sysmed.dao.*;
import br.com.sysmed.modelo.*;


public class testerPESSOA {

	public static void main(String[] args) {
		//printMedicos();
		//printSolicitacoes();
		//printConsultas();
		//printPacientes();
		//printRecepcionistas();
		//addRecepcionista();
		addTurno();
		//addMedico();
	}
	public static void addTurno(){
		//TurnoDAO turnoDAO = new TurnoDAO();
		//HorarioDao horarioDao = new HorarioDao();
		Turno turno = new Turno();
		Calendar cal = Calendar.getInstance(); 
		Time tcomeco = new Time(cal.getTimeInMillis());
		cal = Calendar.getInstance(); 
		Time tfinal = new Time(cal.getTimeInMillis());
		Horario horario = new Horario(1,tcomeco,tfinal);
		turno.addHorario(horario);
		turno.setNome("turno teste");
		//turnoDAO.salvar(turno);
		//horarioDao.salvar(horario);
		System.out.print("Adicionado");
	}
	public static void printPacientes(){
		PacienteDao dao = new PacienteDao();
		List<Paciente> pacientes = null;
		try{
			pacientes = dao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		for (Paciente paciente: pacientes){
			System.out.println(paciente.getCpf());
		}
	}
	public static void printSolicitacoes(){
		SolicitacaoConsultaDao dao = new SolicitacaoConsultaDao();
		List<SolicitaoConsulta> pacientes = null;
		try{
			pacientes = dao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		for (SolicitaoConsulta paciente: pacientes){
			System.out.println(paciente.getHorario());
		}
	}
	public static void addMedico(){
		Medico medico = new Medico();
		medico.setBairro("null");
		medico.setCidade("null");
		medico.setCpf("nullM");
		medico.setDataNasc(new Date());
		medico.setEmail("null");
		medico.setEstado("nl");
		medico.setNome("null");

		medico.setNomeRua("null");
	
		medico.setNumeroCasa("null");
		medico.setSalario(00.00);

		medico.setSexo('M');
		medico.setTelefone("null");

		medico.setEstado("null");
		MedicoDao dao = new MedicoDao();
		
		System.out.println(medico.getTipoFuncionario());
		dao.salvar(medico);
	}
	
	public static void addRecepcionista(){
		Recepcionista medico = new Recepcionista();
		medico.setBairro("null");
		medico.setCidade("null");
		medico.setCpf("nullR");
		medico.setDataNasc(new Date());
		medico.setEmail("null");
		medico.setEstado("nl");
		medico.setNome("null");
		medico.setNomeRua("null");
		medico.setNumeroCasa("null");
		medico.setSalario(00.00);
		medico.setSexo('F');
		medico.setTelefone("null");
		medico.setEstadoCivil("null");
		
		RecepcionistaDao dao = new RecepcionistaDao();
		
		System.out.println(medico.getTipoFuncionario());
		dao.salvar(medico);
	}
	
	
	
	public static void printMedicos(){
		MedicoDao dao = new MedicoDao();
		List<Medico> pacientes = null;
		try{
			pacientes = dao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		for (Medico paciente: pacientes){
			System.out.println(paciente.getCpf());
		}
	}
	public static void printRecepcionistas(){
		RecepcionistaDao dao = new RecepcionistaDao();
		List<Recepcionista> pacientes = null;
		try{
			pacientes = dao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		for (Recepcionista paciente: pacientes){
			System.out.println(paciente.getCpf());
		}
	}
	public static void printConsultas(){
		ConsultaDao dao = new ConsultaDao();
		List<Consulta> consultas = null;
		try{
			consultas = dao.findAll();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(consultas.size());
		for (Consulta consulta: consultas){
			System.out.println(consulta.getSolicitaoConsulta().getPaciente().getCpf());
		}
	}
}


	