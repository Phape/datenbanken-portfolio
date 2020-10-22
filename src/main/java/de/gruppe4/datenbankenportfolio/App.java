package de.gruppe4.datenbankenportfolio;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    static SessionFactory factory;
    static Session session;
    static Configuration config;

    public static void main(String[] args) {
        System.out.println("Hello World!");

        config = new Configuration().configure();
        factory = config.buildSessionFactory();
        session = factory.openSession();

        App app = new App();
        System.out.println("Adresse: " + app.readAdresse(1).toString());

        session.close();
    }

    protected Adresse readAdresse(int adressId) {
        Transaction t = session.beginTransaction();
        Adresse adresse = session.get(Adresse.class, adressId);
        t.commit();
        return adresse;
    }

}