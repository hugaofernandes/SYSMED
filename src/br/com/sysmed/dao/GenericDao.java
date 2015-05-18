package br.com.sysmed.dao;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
 

import br.com.sysmed.util.HibernateUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
 
public class GenericDao<T extends Serializable> {
 
    private final Session session;
    private final Class<T> persistentClass;
   
 
    public Class<T> getPersistentClass() {
		return persistentClass;
	}

	public GenericDao() {
        this.session = HibernateUtil.getSession();
        this.persistentClass = (Class<T>) ((ParameterizedType) 
            getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
 
    public Session getSession() {
        return session;
    }
 
  
    protected void save(T entity) {
        try {
            getSession().getTransaction().begin();
            getSession().save(entity);
            getSession().getTransaction().commit();
        } catch (Throwable t) {
            getSession().getTransaction().rollback();
            t.printStackTrace();
        } finally {
            close();
        }
    }
 
    protected void update(T entity) {
        try {
            getSession().getTransaction().begin();
            getSession().update(entity);
            getSession().getTransaction().commit();
        } catch (Throwable t) {
            getSession().getTransaction().rollback();
            t.printStackTrace();
        } finally {
            close();
        }
    }
 
    protected void delete(T entity) {
        try {
            getSession().getTransaction().begin();
            getSession().delete(entity);
            getSession().getTransaction().commit();           
        } catch (Throwable t) {
            getSession().getTransaction().rollback();
            t.printStackTrace();
        } finally {
            close();
        }
    }
    
 
    public List<T> findAll() throws Exception {
        return getSession().createCriteria(persistentClass).list();
    }
 
    public T findByName(String nome) {
        return (T) getSession().createCriteria(persistentClass)
                .add(Restrictions.eq("nome", nome).ignoreCase()).uniqueResult();
    }
 
    public T findById(String id) {
        return (T) getSession().createCriteria(persistentClass)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }
    
    public T findById(int id) {
        return (T) getSession().createCriteria(persistentClass)
                .add(Restrictions.eq("id", id)).uniqueResult();
    }
    
    public T findByCpf(String cpf) {
        return (T) getSession().createCriteria(persistentClass)
                .add(Restrictions.eq("cpf", cpf).ignoreCase()).uniqueResult();
    }
    
       
    private void close() {
        if (getSession() != null && getSession().isOpen()) {
            getSession().close();
        }
    }
}