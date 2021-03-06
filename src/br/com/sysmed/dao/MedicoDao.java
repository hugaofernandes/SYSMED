package br.com.sysmed.dao;

import br.com.sysmed.modelo.Medico;

import java.util.List;

import org.hibernate.Query;


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
    
    public void excluir(Medico medico) {
    	Medico c = findByCpf(medico.getCpf());
        delete(c);
    }
    
    
    @SuppressWarnings("unchecked")
	public List<String> getCpfs(){
    	String hql = "SELECT E.cpf FROM Medico E";
    	Query query = this.getSession().createQuery(hql);
    	List<String> results = query.list();
    	return results;
    }
}
