package database;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import models.Customer;

public class SessionFactoryBuilder 
{
	private static SessionFactory sessionFactory = null;

    public static SessionFactory getSessionFactory() 
    {
        if (sessionFactory == null || sessionFactory.isClosed()) {
            try {
            	sessionFactory = new Configuration()
    					.configure("hibernate.cfg.xml")
    					.addAnnotatedClass(Customer.class) ///?????
    					.buildSessionFactory();
    			System.out.println("Connection Established");
    			
            } catch (Exception e) {
                System.err.println("Failed to create SessionFactory: " + e.getMessage());
                e.printStackTrace();
                throw new ExceptionInInitializerError(e);
            }
        }
        return sessionFactory;
    }

    public static void closeSessionFactory() 
    {
        if (sessionFactory != null) {
            try {
                sessionFactory.close();
            } catch (Exception e) {
                System.err.println("Failed to close SessionFactory: " + e.getMessage());
                e.printStackTrace();
            }
        }
    }
}