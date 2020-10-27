package de.gruppe4.datenbankenportfolio;

import java.sql.Date;
import java.util.Scanner;

public class Hauptprogramm {
    Scanner scanner;
    App app;

    public static void main(String[] args) {
        Hauptprogramm hauptprogramm = new Hauptprogramm();
        hauptprogramm.readUserInput(); // do while einfügen

        // App app = new App();
        // app.init();

        // System.out.println(app.readAdresse(6));
    }

    public void readUserInput() {
        app = new App();
        app.init();
        System.out.println(app.readAdresse(6));

        scanner = new Scanner(System.in);
        int record = 0; // table or class the user wants to manipulate
        boolean userRecordSelcetionsIsValid = false;
        while (!userRecordSelcetionsIsValid) {
            System.out.println(
                    "Bitte geben sie an, welchen Datensatz sie bearbeiten möchten.\n1: Adresse\n2: Arbeitgeber\n3: KeyAccountManager\n4: Ort\n5: Versicherter\n6: Vertrag");
            record = scanner.nextInt();
            if (0 < record && record < 7) {
                userRecordSelcetionsIsValid = true;
            } else {
                userRecordSelcetionsIsValid = false;
                System.out.println("Inkorrekte Eingabe!");
            }
        }

        boolean userCRUDSelecionIsValid = false;
        while (!userCRUDSelecionIsValid) {
            System.out.println(
                    "Bitte geben sie den Buchstabe der Aktion die sie ausführen wollen ein:\nc: Daten einfügen\nr: Daten abrufen\nu: Daten ändern\nd: Daten löschen");
            char operation = scanner.next().toLowerCase().charAt(0);
            switch (operation) {
                case 'c':
                    create(record);
                    userCRUDSelecionIsValid = true;
                    break;
                case 'r':
                    read(record);
                    userCRUDSelecionIsValid = true;
                    break;
                case 'u':
                    update(record);
                    userCRUDSelecionIsValid = true;
                    break;
                case 'd':
                    delete(record);
                    userCRUDSelecionIsValid = true;
                    break;
                default:
                    userCRUDSelecionIsValid = false;
                    System.out.println("Inkorrekte Eingabe!");
                    break;
            }
        }
    }

    public void create(int record) {
        System.out.println("Bitte geben sie die angefragen Parameter ein");
        switch (record) {
            case 1: // Adresse
                System.out.println("Straße");
                String straße = scanner.next();
                System.out.println("Hausnummer");
                String hausnummer = scanner.next();
                System.out.println("Postleitzahl");
                int postleitzahl = scanner.nextInt();
                app.createAdresse(straße, hausnummer, postleitzahl);
                break;

            case 2: // Arbeitgeber
                System.out.println("Abrechnungsverband");
                String abrechnungsverband = scanner.next();
                System.out.println("Name der Firma");
                String firmenname = scanner.next();
                System.out.println("AdressID");
                int adressId = scanner.nextInt();
                System.out.println("Mitarbeiternummer");
                int mitarbeiternummer = scanner.nextInt();
                app.createArbeitgeber(abrechnungsverband, firmenname, adressId, mitarbeiternummer);
                break;

            case 3: // KeyAccountManager
                System.out.println("Vorname");
                String vorname = scanner.next();
                System.out.println("Nachname");
                String nachname = scanner.next();
                System.out.println("Eintrittsdatum im Format jjjj-mm-dd"); // vielleicht auch Forat jjjjmmdd, da long
                long datum = scanner.nextLong();
                Date eintritsdatum = new Date(datum);
                app.createKeyAccountManager(vorname, nachname, eintritsdatum);
                break;

            case 4: // Ort
                System.out.println("Postleitzahl");
                int plz = scanner.nextInt();
                System.out.println("Ortsname");
                String ortsname = scanner.next();
                app.createOrt(plz, ortsname);
                break;

            case 5: // Versicherter
                System.out.println("Vorname");
                String vornameVers = scanner.next();
                System.out.println("Nachname");
                String nachnameVers = scanner.next();
                System.out.println("Adress ID");
                int adressIdVers = scanner.nextInt();
                System.out.println("Arbeitgeber ID");
                int arbeitgeberId = scanner.nextInt();
                System.out.println("Geburtsdatum im Format jjjj-mm-dd"); // Format korrekt?
                long gebDatum = scanner.nextLong();
                Date geburtsdatum = new Date(gebDatum);
                System.out.println("Rentenart");
                String rentenart = scanner.next();
                System.out.println("Versicherungsstatus");
                String versicherungsstatus = scanner.next();
                System.out.println("Versorgungspunkte");
                int versorgungspunkte = scanner.nextInt();
                app.createVersicherter(vornameVers, nachnameVers, adressIdVers, arbeitgeberId, geburtsdatum, rentenart,
                        versicherungsstatus, versorgungspunkte);
                break;

            case 6: // Vertrag
                System.out.println("Versicherungsnummer");
                int versicherungsNr = scanner.nextInt();
                System.out.println("Abschlussdatum im Format jjjj-mm-dd"); // Format korrekt?
                long abschlDatum = scanner.nextLong();
                Date abschlussdatum = new Date(abschlDatum);
                System.out.println("Vertragsstatus");
                String vertragsstatus = scanner.next();
                System.out.println("Vertragstyp");
                String vertragstyp = scanner.next();
                app.createVertrag(versicherungsNr, abschlussdatum, vertragsstatus, vertragstyp);
                break;

            default:
                break;
        }
    }

    public void read(int record) {

    }

    public void update(int record) {

    }

    public void delete(int record) {

    }
}
