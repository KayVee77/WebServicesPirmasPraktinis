package lt.eif.viko.kvisciuna.movieapp.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
/**
 * Utility class for managing Hibernate SessionFactory instance.
 * This class provides a method to obtain a SessionFactory object, which is used for creating sessions
 * and interacting with the database using Hibernate ORM.
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory = buildSessionFactory();
    /**
     * Builds and returns a Hibernate SessionFactory object.
     * This method creates a new SessionFactory by configuring Hibernate based on the hibernate.cfg.xml file.
     * If an exception occurs during the configuration process, it prints an error message and throws an exception.
     * @return A SessionFactory object.
     */
    private static SessionFactory buildSessionFactory() {
        try {
            return new Configuration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {

            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Returns the Hibernate SessionFactory instance.
     * This method provides access to the SessionFactory object created during application startup.
     * @return The SessionFactory object.
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;}
}