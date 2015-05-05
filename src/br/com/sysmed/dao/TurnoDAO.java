package br.com.sysmed.dao;

import br.com.sysmed.modelo.Turno;

public class TurnoDAO extends GenericDao<Turno> {
	public void salvar(Turno turno) {
        save(turno);
    }
 
    public void alterar(Turno turno) {
        update(turno);
    }
 
    public void excluir(int id) {
    	Turno c = findById(id);
        delete(c);
    }
  
}
