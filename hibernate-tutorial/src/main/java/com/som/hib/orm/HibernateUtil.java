package com.som.hib.orm;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            // Create the SessionFactory from hibernate.cfg.xml
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            // Make sure you log the exception, as it might be swallowed
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }


//    private static SessionFactory sessionFactory;
//    private static ServiceRegistry serviceRegistry;
//
//    private static SessionFactory configureSessionFactory() throws HibernateException {
//        Configuration configuration = new Configuration();
//        configuration.configure();
//        serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        return sessionFactory;
//    }

}