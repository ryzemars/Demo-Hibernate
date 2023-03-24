package utils;

import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {

    private static HibernateUtil instance;
    private Configuration config;
    private SessionFactory sessionFactory;

    public static HibernateUtil getInstance() {
        if (null == instance) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    private HibernateUtil() {
        configure();
    }

    private void configure() {
        config = new Configuration();
        config.configure("config/hibernate.cfg.xml");

        config.addAnnotatedClass(Student.class);
    }

    private void buildSessionFactory() {
        if (null == sessionFactory || sessionFactory.isClosed()) {
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                    .applySettings(config.getProperties()).build(); //nap file config da load duoc ↖ vao sessionfactory

            sessionFactory = config.buildSessionFactory(serviceRegistry);
        }
    }

    public Session openSession() {
        buildSessionFactory();
        return sessionFactory.openSession();
    }

    public void closeFactory() {
        if (null != sessionFactory && sessionFactory.isOpen()) {
            sessionFactory.close();
        }
    }
}
