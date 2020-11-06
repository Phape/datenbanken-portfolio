package de.gruppe4.datenbankenportfolio;

import java.sql.Date;
import java.util.List;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class App {
    static SessionFactory factory;
    static Session session;
    static Configuration config;

    public static void main(String[] args) {
        //config = new Configuration().configure();
        //factory = config.buildSessionFactory();
        //session = factory.openSession();

        App app = new App();
        app.init();
        System.out.println("\nAdresse: " + app.readAdresse(1));
        System.out.println("Arbeitgeber: " + app.readArbeitgeber(1));
        System.out.println("KeyAccountManager: " + app.readKeyAccountManager(1));
        System.out.println("Ort: " + app.readOrt(76137));
        System.out.println("Versicherter: " + app.readVersicherter(1));
        System.out.println("Vertrag: " + app.readVertrag(1));
        // System.out.println("Adressen: " + app.readAdressen());

        session.close();
    }

    public void init() {
        config = new Configuration().configure();
        factory = config.buildSessionFactory();
        session = factory.openSession();
        System.out.println("______________________________");
    }

    protected void createAdresse(String straße, String hausnummer, int plz) {
        Transaction t = session.beginTransaction();
        Adresse adresse = new Adresse(straße, hausnummer, plz);
        session.save(adresse);
        t.commit();
    }

    protected Adresse readAdresse(int adressId) {
        Transaction t = session.beginTransaction();
        Adresse adresse = session.get(Adresse.class, adressId);
        t.commit();
        return adresse;
    }

    protected void updateAdresse(int adressId, String straße, String hausnummer, int plz) {
        Adresse adresse = new Adresse();
        adresse.setAdressId(adressId); // is needed to id the adress to be updated
        adresse.setStraße(straße);
        adresse.setHausnummer(hausnummer);
      //  adresse.setPostleitzahl(plz);

        Transaction t = session.beginTransaction();
        session.update(adresse); // try-catch needed? see slide 171 / Hibernate-18
        t.commit();
    }

    protected void deleteAdresse(int adressId) {
        Adresse adresse = new Adresse();
        adresse.setAdressId(adressId);

        Transaction t = session.beginTransaction();
        session.delete(adresse); // try-catch needed? see slide 171 / Hibernate-18
        t.commit();
    }

    protected List<Adresse> readAdresseList() {
        Transaction t = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Adresse> adressen = session.createQuery("from Adresse").list();
        t.commit();
        return adressen;
    }


    protected void createArbeitgeber(String abrechnungsverband, String firmenname, int adressId, int mitarbeiterNr) {
        Transaction t = session.beginTransaction();
        Arbeitgeber arbeitgeber = new Arbeitgeber();
        arbeitgeber.setAbrechnungsverband(abrechnungsverband);
        arbeitgeber.setFirmenname(firmenname);
        arbeitgeber.setAdressId(adressId);
        arbeitgeber.setMitarbeiterNr(mitarbeiterNr);
        arbeitgeber.setKeyAccountManager(session.get(KeyAccountManager.class, mitarbeiterNr));
        session.save(arbeitgeber);
        t.commit();
    }

    protected Arbeitgeber readArbeitgeber(int arbeitgeberId) {
        Transaction t = session.beginTransaction();
        Arbeitgeber arbeitgeber = session.get(Arbeitgeber.class, arbeitgeberId);
        t.commit();
        return arbeitgeber;
    }

    protected void updateArbeitgeber(int arbeitgeberId, String abrechnungsverband, String firmenname, int adressId,
            int mitarbeiterNr) {
        Arbeitgeber arbeitgeber = new Arbeitgeber();
        arbeitgeber.setArbeitgeberId(arbeitgeberId);
        arbeitgeber.setAbrechnungsverband(abrechnungsverband);
        arbeitgeber.setFirmenname(firmenname);
        arbeitgeber.setAdressId(adressId);
        arbeitgeber.setMitarbeiterNr(mitarbeiterNr);

        Transaction t = session.beginTransaction();
        session.update(arbeitgeber);
        t.commit();
    }

    protected void deleteArbeitgeber(int arbeitgeberId) {
        Arbeitgeber arbeitgeber = new Arbeitgeber();
        arbeitgeber.setArbeitgeberId(arbeitgeberId);

        Transaction t = session.beginTransaction();
        session.delete(arbeitgeber);
        t.commit();
    }

    protected List<Arbeitgeber> readArbeitgeberList() {
        Transaction t = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Arbeitgeber> arbeitgeberList = session.createQuery("from Arbeitgeber").list();
        t.commit();
        return arbeitgeberList;
    }


    protected void createKeyAccountManager(String vorname, String nachname, Date eintritsdatum) {
        KeyAccountManager keyAccountManager = new KeyAccountManager();
        keyAccountManager.setVorname(vorname);
        keyAccountManager.setNachname(nachname);
        keyAccountManager.setEintrittsdatum(eintritsdatum);

        Transaction t = session.beginTransaction();
        session.save(keyAccountManager);
        t.commit();
    }

    protected KeyAccountManager readKeyAccountManager(int mitarbeiterNr) {
        Transaction t = session.beginTransaction();
        KeyAccountManager keyAccountManager = session.get(KeyAccountManager.class, mitarbeiterNr);
        t.commit();
        return keyAccountManager;
    }

    protected void updateKeyAccountManager(int mitarbeiterNr, String vorname, String nachname, Date eintritsdatum) {
        KeyAccountManager keyAccountManager = new KeyAccountManager();
        keyAccountManager.setMitarbeiterNr(mitarbeiterNr);
        keyAccountManager.setVorname(vorname);
        keyAccountManager.setNachname(nachname);
        keyAccountManager.setEintrittsdatum(eintritsdatum);

        Transaction t = session.beginTransaction();
        session.update(keyAccountManager);
        t.commit();
    }

    protected void deleteKeyAccountManager(int mitarbeiterNr) {
        KeyAccountManager keyAccountManager = new KeyAccountManager();
        keyAccountManager.setMitarbeiterNr(mitarbeiterNr);

        Transaction t = session.beginTransaction();
        session.delete(keyAccountManager);
        t.commit();
    }

    protected List<KeyAccountManager> readKeyAccountManagerList() {
        Transaction t = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<KeyAccountManager> keyAccountManagerList = session.createQuery("from KeyAccountManager").list();
        t.commit();
        return keyAccountManagerList;
    }

    protected void createOrt(int plz, String ortsname) {
        Ort ort = new Ort();
        ort.setPostleitzahl(plz);
        ort.setOrtsname(ortsname);

        Transaction t = session.beginTransaction();
        session.save(ort);
        t.commit();
    }

    protected Ort readOrt(int postleitzahl) {
        Transaction t = session.beginTransaction();
        Ort ort = session.get(Ort.class, postleitzahl);
        t.commit();
        return ort;
    }

    protected void updateOrt(int plz, String ortsname) {
        Ort ort = new Ort();
        ort.setPostleitzahl(plz);
        ort.setOrtsname(ortsname);

        Transaction t = session.beginTransaction();
        session.update(ort);
        t.commit();
    }

    protected void deleteOrt(int postleitzahl) {
        Ort ort = new Ort();
        ort.setPostleitzahl(postleitzahl);

        Transaction t = session.beginTransaction();
        session.delete(ort);
        t.commit();
    }

    protected List<Ort> readOrtList() {
        Transaction t = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Ort> ortList = session.createQuery("from Ort").list();
        t.commit();
        return ortList;
    }

    protected void createVersicherter(String vorname, String nachname, int adressId, int arbeitgeberId,
            Date geburtsdatum, String rentenart, String versicherungsstatus, int versorgungspunkte) {
        Versicherter versicherter = new Versicherter();
        versicherter.setVorname(vorname);
        versicherter.setNachname(nachname);
        versicherter.setAdressId(adressId);
        // versicherter.setArbeitgeberId(arbeitgeberId);
        versicherter.setGeburtsdatum(geburtsdatum);
        versicherter.setRentenart(rentenart);
        versicherter.setVersicherungsstatus(versicherungsstatus);
        versicherter.setVersorgungspunkte(versorgungspunkte);

        Transaction t = session.beginTransaction();
        session.save(versicherter);
        t.commit();
    }

    protected Versicherter readVersicherter(int versicherungsNr) {
        Transaction t = session.beginTransaction();
        Versicherter versicherter = session.get(Versicherter.class, versicherungsNr);
        t.commit();
        return versicherter;
    }

    protected void updateVersicherter(int versicherungsNr, String vorname, String nachname, int setAdressId,
            int arbeitgeberId, Date geburtsdatum, String rentenart, String versicherungsstatus, int versorgungspunkte) {
        Versicherter versicherter = new Versicherter();
        versicherter.setVersicherungsNr(versicherungsNr);
        versicherter.setVorname(vorname);
        versicherter.setNachname(nachname);
        versicherter.setAdressId(setAdressId);
        // versicherter.setArbeitgeberId(arbeitgeberId);
        versicherter.setGeburtsdatum(geburtsdatum);
        versicherter.setRentenart(rentenart);
        versicherter.setVersicherungsstatus(versicherungsstatus);
        versicherter.setVersorgungspunkte(versorgungspunkte);

        Transaction t = session.beginTransaction();
        session.update(versicherter);
        t.commit();
    }

    protected void deleteVersicherter(int versicherungsNr) {
        Versicherter versicherter = new Versicherter();
        versicherter.setVersicherungsNr(versicherungsNr);

        Transaction t = session.beginTransaction();
        session.delete(versicherter);
        t.commit();
    }

    protected List<Versicherter> readVersicherterList() {
        Transaction t = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Versicherter> versicherterList = session.createQuery("from Versicherter").list();
        t.commit();
        return versicherterList;
    }

    protected void createVertrag(int versicherungsNr, Date abschlussdatum, String vertragsstatus, String vertragstyp) {
        Vertrag vertrag = new Vertrag();
        vertrag.setVersicherungsNr(versicherungsNr);
        vertrag.setAbschlussdatum(abschlussdatum);
        vertrag.setVertragsstatus(vertragsstatus);
        vertrag.setVertragstyp(vertragstyp);

        Transaction t = session.beginTransaction();
        session.save(vertrag);
        t.commit();
    }

    protected Vertrag readVertrag(int vertragsId) {
        Transaction t = session.beginTransaction();
        Vertrag vertrag = session.get(Vertrag.class, vertragsId);
        t.commit();
        return vertrag;
    }

    protected void updateVertrag(int vertragsId, int versicherungsNr, Date abschlussdatum, String vertragsstatus,
            String vertragstyp) {
        Vertrag vertrag = new Vertrag();
        vertrag.setVertragsId(vertragsId);
        vertrag.setVersicherungsNr(versicherungsNr);
        vertrag.setAbschlussdatum(abschlussdatum);
        vertrag.setVertragsstatus(vertragsstatus);
        vertrag.setVertragstyp(vertragstyp);

        Transaction t = session.beginTransaction();
        session.update(vertrag);
        t.commit();
    }

    protected void deleteVertrag(int vertragsId) {
        Vertrag vertrag = new Vertrag();
        vertrag.setVertragsId(vertragsId);

        Transaction t = session.beginTransaction();
        session.delete(vertrag);
        t.commit();
    }

    protected List<Vertrag> readVertragList() {
        Transaction t = session.beginTransaction();
        @SuppressWarnings("unchecked")
        List<Vertrag> vertragList = session.createQuery("from Vertrag").list();
        t.commit();
        return vertragList;
    }
}