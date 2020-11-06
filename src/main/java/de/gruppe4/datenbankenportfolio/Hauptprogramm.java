package de.gruppe4.datenbankenportfolio;

import java.sql.Date;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Scanner;

public class Hauptprogramm {
    Scanner scanner;
    App app;

    public static void main(String[] args) {
        Hauptprogramm hauptprogramm = new Hauptprogramm();
        hauptprogramm.readUserInput();

        // App app = new App();
        // app.init();

        // System.out.println(app.readAdresse(6));
    }

    public void readUserInput() {
        app = new App();
        app.init();

        scanner = new Scanner(System.in);
        int record = 0; // table or class the user wants to manipulate
        boolean userRecordSelcetionsIsValid = false;
        while (!userRecordSelcetionsIsValid) {
            System.out.println(
                    "\nBitte geben sie an, welchen Datensatz sie benutzen möchten.\n1: Adresse\n2: Arbeitgeber\n3: KeyAccountManager\n4: Ort\n5: Versicherter\n6: Vertrag");
            record = scanner.nextInt();
            if (0 < record && record < 7) {
                userRecordSelcetionsIsValid = true;
            } else {
                userRecordSelcetionsIsValid = false;
                System.out.println("Inkorrekte Eingabe!\n");
            }
        }

        boolean userCRUDSelecionIsValid = false;
        while (!userCRUDSelecionIsValid) {
            System.out.println(
                    "\nBitte geben sie den Buchstabe der Aktion die sie ausführen wollen ein:\nc: Daten einfügen\nr: Daten abrufen\nu: Daten ändern\nd: Daten löschen");
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
        System.out.println("\nBitte geben sie die angefragten Parameter ein");
        switch (record) {
            case 1: // Adresse
                System.out.println("Straße");
                String straße = scanner.next();
                System.out.println("Hausnummer");
                String hausnummer = scanner.next();
                System.out.println("Postleitzahl");
                int postleitzahl = scanner.nextInt();
                try {
                    app.createAdresse(straße, hausnummer, postleitzahl);
                } catch (Exception e) {
                    System.out.println(
                            "Etwas ist schiefgelaufen. Vielleicht existiert noch kein Ort mit der angegebenen Postleitzahl.");
                }
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
                String datum = scanner.next();
                long dateLong = Long.parseLong(datum.replace("-", ""));
                Date eintritsdatum = new Date(dateLong); // Datum wird nicht richtig abgespeichert
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
        System.out.println();
        switch (record) {
            case 1: // Adresse
                System.out.println("Geben sie die Adress ID der Adresse ein die sie ausgeben lassen wollen:");
                int adressId = scanner.nextInt();
                System.out.println(app.readAdresse(adressId));
                break;

            case 2: // Arbeitgeber
                System.out.println("Geben sie die Arbeitgeber ID des Arbeitgebers ein den sie ausgeben lassen wollen:");
                int arbeitgeberId = scanner.nextInt();
                System.out.println(app.readArbeitgeber(arbeitgeberId));
                break;

            case 3: // KeyAccountManager
                System.out.println(
                        "Geben sie die Mitarbeiter ID des Key-Account-Managers ein den sie ausgeben lassen wollen:");
                int mitarbeiternummer = scanner.nextInt();
                System.out.println(app.readKeyAccountManager(mitarbeiternummer));
                break;

            case 4: // Ort
                System.out.println("Geben sie die Postleitzahl des Ortes ein den sie ausgeben lassen wollen:");
                int plz = scanner.nextInt();
                System.out.println(app.readOrt(plz));
                break;

            case 5: // Versicherter
                System.out.println(
                        "Geben sie die Versicherungs Nrummer des Versicherten ein den sie ausgeben lassen wollen:");
                int versicherungsnummer = scanner.nextInt();
                System.out.println(app.readVersicherter(versicherungsnummer));
                break;

            case 6: // Vertrag
                System.out.println("Geben sie die Vertrags ID des Vertrages ein den sie ausgeben lassen wollen:");
                int vertragsId = scanner.nextInt();
                System.out.println(app.readVertrag(vertragsId));
                break;

            default:
                break;
        }
    }

    public void update(int record) {
        int adressId;
        int mitarbeiternummer;
        int versicherungsNr;

        System.out.println("\nBitte geben sie die angefragten Parameter ein");
        switch (record) {
            case 1: // Adresse
                System.out.println("Adress ID");
                adressId = scanner.nextInt();
                System.out.println("Straße");
                String straße = scanner.next();
                System.out.println("Hausnummer");
                String hausnummer = scanner.next();
                System.out.println("Postleitzahl");
                int postleitzahl = scanner.nextInt();
                try {
                    app.updateAdresse(adressId, straße, hausnummer, postleitzahl);
                } catch (Exception e) {
                    System.out.println(
                            "Etwas ist schiefgelaufen. Vielleicht existiert noch kein Ort mit der angegebenen Postleitzahl.");
                }
                break;

            case 2: // Arbeitgeber
                System.out.println("Arbietgeber ID");
                int arbietgeberId = scanner.nextInt();
                System.out.println("Abrechnungsverband");
                String abrechnungsverband = scanner.next();
                System.out.println("Name der Firma");
                String firmenname = scanner.next();
                System.out.println("AdressID");
                adressId = scanner.nextInt();
                System.out.println("Mitarbeiternummer");
                mitarbeiternummer = scanner.nextInt();
                app.updateArbeitgeber(arbietgeberId, abrechnungsverband, firmenname, adressId, mitarbeiternummer);
                break;

            case 3: // KeyAccountManager
                System.out.println("Mitarbeiter Nr.");
                mitarbeiternummer = scanner.nextInt();
                System.out.println("Vorname");
                String vorname = scanner.next();
                System.out.println("Nachname");
                String nachname = scanner.next();
                System.out.println("Eintrittsdatum im Format jjjj-mm-dd"); // vielleicht auch Forat jjjjmmdd, da long
                long datum = scanner.nextLong();
                Date eintritsdatum = new Date(datum);
                app.updateKeyAccountManager(mitarbeiternummer, vorname, nachname, eintritsdatum);
                break;

            case 4: // Ort
                System.out.println("Postleitzahl");
                int plz = scanner.nextInt();
                System.out.println("Ortsname");
                String ortsname = scanner.next();
                app.updateOrt(plz, ortsname);
                break;

            case 5: // Versicherter
                System.out.println("Versicherungs Nr.");
                versicherungsNr = scanner.nextInt();
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
                app.updateVersicherter(versicherungsNr, vornameVers, nachnameVers, adressIdVers, arbeitgeberId,
                        geburtsdatum, rentenart, versicherungsstatus, versorgungspunkte);
                break;

            case 6: // Vertrag
                System.out.println("Vertrags ID");
                int vertragsId = scanner.nextInt();
                System.out.println("Versicherungsnummer");
                versicherungsNr = scanner.nextInt();
                System.out.println("Abschlussdatum im Format jjjj-mm-dd"); // Format korrekt?
                long abschlDatum = scanner.nextLong();
                Date abschlussdatum = new Date(abschlDatum);
                System.out.println("Vertragsstatus");
                String vertragsstatus = scanner.next();
                System.out.println("Vertragstyp");
                String vertragstyp = scanner.next();
                app.updateVertrag(vertragsId, versicherungsNr, abschlussdatum, vertragsstatus, vertragstyp);
                break;

            default:
                break;
        }
    }

    public void delete(int record) {
        System.out.println();
        switch (record) {
            case 1: // Adresse
                System.out.println("Geben sie die Adress ID der Adresse ein die sie löschen wollen:");
                int adressId = scanner.nextInt();
                app.deleteAdresse(adressId);
                break;

            case 2: // Arbeitgeber
                System.out.println("Geben sie die Arbeitgeber ID des Arbeitgebers ein den sie löschen wollen:");
                int arbeitgeberId = scanner.nextInt();
                app.deleteAdresse(arbeitgeberId);
                break;

            case 3: // KeyAccountManager
                System.out.println("Geben sie die Mitarbeiter ID des Key-Account-Managers ein den sie löschen wollen:");
                int mitarbeiternummer = scanner.nextInt();
                app.deleteAdresse(mitarbeiternummer);
                break;

            case 4: // Ort
                System.out.println("Geben sie die Postleitzahl des Ortes ein den sie löschen wollen:");
                int plz = scanner.nextInt();
                app.deleteAdresse(plz);
                break;

            case 5: // Versicherter
                System.out.println("Geben sie die Versicherungs Nrummer des Versicherten ein den sie löschen wollen:");
                int versicherungsnummer = scanner.nextInt();
                app.deleteAdresse(versicherungsnummer);
                break;

            case 6: // Vertrag
                System.out.println("Geben sie die Vertrags ID des Vertrages ein den sie löschen wollen:");
                int vertragsId = scanner.nextInt();
                app.deleteAdresse(vertragsId);
                break;

            default:
                break;
        }
    }
}
