package br.com.sysmed.dao;

import java.util.List;

import org.hibernate.Query;

import br.com.sysmed.modelo.Medico;


public class MedicoDao extends GenericDao< Medico> {

	public void salvar(Medico medico) {
        save(medico);
    }
 
    public void alterar(Medico medico) {
        update(medico);
    }
 
    public void excluir(String id) {
    	Medico c = findById(id);
        delete(c);
    }
    /*
    public List<String> getCpfs(){
    	String hql = "SELECT E.cpf FROM Medico E";
    	Query query = this.getSession().createQuery(hql);
    	List<String> results = query.list();
    	return results;
    }*/
}
