package br.com.sysmed.dao;



import br.com.sysmed.modelo.Horario;



public class HorarioDao  extends GenericDao<Horario> {
	public void salvar(Horario horario) {
        save(horario);
    }
 
    public void alterar(Horario horario) {
        update(horario);
    }
 
    public void excluir(String id) {
    	Horario  c = findById(id);
        delete(c);
    }
    
}
