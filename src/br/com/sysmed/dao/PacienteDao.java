package br.com.sysmed.dao;

import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Remove;
import org.hibernate.Query;

import br.com.sysmed.modelo.*;

public class PacienteDao extends GenericDao<Paciente> {
	
	public void salvar(Paciente paciente) {
        save(paciente);
    }
	
	public void alterar(Paciente paciente) {
        update(paciente);
    }
	
	public void excluir(Paciente paciente) {
    	Paciente c = findByCpf(paciente.getCpf());
        delete(c);
    }
    
    public List<String> getCpfs(){
    	String hql = "SELECT E.cpf FROM Paciente E";
    	Query query = this.getSession().createQuery(hql);
    	List<String> results = query.list();
    	return results;
    }
}
