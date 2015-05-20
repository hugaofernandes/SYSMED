package br.com.sysmed.dao;


import java.util.List;

import org.hibernate.Query;

import br.com.sysmed.modelo.Paciente;
import br.com.sysmed.modelo.Recepcionista;

public class RecepcionistaDao extends GenericDao<Recepcionista> {
	
	public void salvar(Recepcionista recepcionista) {
        save(recepcionista);
    }
 
    public void alterar(Recepcionista recepcionista) {
        update(recepcionista);
    }
 
    public void excluir(String id) {
    	Recepcionista c = findById(id);
        delete(c);
    }
    
    public void excluir(Recepcionista r) {
    	Recepcionista c = findByCpf(r.getCpf());
        delete(c);
    }
    
    public List<String> getCpfs(){
    	String hql = "SELECT E.cpf FROM Recepcionista E";
    	Query query = this.getSession().createQuery(hql);
    	List<String> results = query.list();
    	return results;
    }
}
