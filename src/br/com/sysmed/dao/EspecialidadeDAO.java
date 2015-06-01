package br.com.sysmed.dao;


import java.util.List;

import org.hibernate.Query;

import br.com.sysmed.modelo.Especialidade;



public class EspecialidadeDAO extends GenericDao<Especialidade>{
	public void salvar(Especialidade especialidade) {
        save(especialidade);
    }
 
    public void alterar(Especialidade especialidade) {
        update(especialidade);
    }
 
    public void excluir(String id) {
    	Especialidade c = findById(id);
        delete(c);
    }
    
    @SuppressWarnings("unchecked")
   	public List<String> getNomes(){
       	String hql = "SELECT E.nome FROM Especialidade E";
       	Query query = this.getSession().createQuery(hql);
       	List<String> results = query.list();
       	return results;
       }
}
