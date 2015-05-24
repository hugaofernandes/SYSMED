package br.com.sysmed.dao;


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
}
