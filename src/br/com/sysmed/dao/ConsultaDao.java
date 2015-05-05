package br.com.sysmed.dao;

import br.com.sysmed.modelo.*;


public class ConsultaDao extends GenericDao<Consulta>{
	public void salvar(Consulta consulta) {
        save(consulta);
    }
 
    public void alterar(Consulta consulta) {
        update(consulta);
    }
 
    public void excluir(String id) {
    	Consulta c = findById(id);
        delete(c);
    }
}
