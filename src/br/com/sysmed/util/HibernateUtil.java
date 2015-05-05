package br.com.sysmed.util;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class HibernateUtil {
	private static SessionFactory SESSION_FACTORY;
	private static ServiceRegistry serviceRegistry;
    static  {
        try {
        	Configuration configuration = new Configuration();
        	configuration.configure();
        	serviceRegistry = new StandardServiceRegistryBuilder().applySettings(
                    configuration.getProperties()).build();
            SESSION_FACTORY = configuration.buildSessionFactory(serviceRegistry);
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
 
    public static Session getSession() {
        return SESSION_FACTORY.openSession();
    }
}
