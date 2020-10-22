package de.gruppe4.datenbankenportfolio;

import java.util.List;

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
        System.out.println("Adresse: " + app.readAdresse(1));
        System.out.println("Adressen: " + app.readAdressen());

        session.close();
    }

    protected void createAdresse() {
        Adresse adresse = new Adresse();
        // adresse.setAdressId(); //auto generated
        adresse.setStraße("straße");
        adresse.setHausnummer("hausnummer");
        adresse.setPostleitzahl("postleitzahl");

        Transaction t = session.beginTransaction();
        session.save(adresse); // try-catch needed? see slide 171 / Hibernate-18
        t.commit();
    }

    protected Adresse readAdresse(int adressId) {
        Transaction t = session.beginTransaction();
        Adresse adresse = session.get(Adresse.class, adressId);
        t.commit();
        return adresse;
    }

    protected void updateAdresse() {
        Adresse adresse = new Adresse();
        adresse.setAdressId(5); // is needed to id the adress to be updated
        adresse.setStraße("straße");
        adresse.setHausnummer("hausnummer");
        adresse.setPostleitzahl("postleitzahl");

        Transaction t = session.beginTransaction();
        session.update(adresse); // try-catch needed? see slide 171 / Hibernate-18
        t.commit();
    }

    protected void deleteAdresse(int adressId) {
        Adresse adresse = new Adresse();
        adresse.setAdressId(5);

        Transaction t = session.beginTransaction();
        session.delete(adresse); // try-catch needed? see slide 171 / Hibernate-18
        t.commit();
    }

    protected List<Adresse> readAdressen() {
        Transaction t = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Adresse> adressen = session.createQuery("from Adresse").list();
        t.commit();
        return adressen;
    }

}