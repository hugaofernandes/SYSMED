package br.com.sysmed.dao;
import br.com.sysmed.modelo.SolicitaoConsulta;


public class SolicitacaoConsultaDao extends GenericDao<SolicitaoConsulta> {
	public void salvar(SolicitaoConsulta solicitacaoConsulta) {
        save(solicitacaoConsulta);
    }
 
    public void alterar(SolicitaoConsulta solicitacaoConsulta) {
        update(solicitacaoConsulta);
    }
 
    public void excluir(int id) {
    	SolicitaoConsulta c = findById(id);
        delete(c);
    }
    
    
}
