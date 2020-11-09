package de.gruppe4.datenbankenportfolio;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class Hauptprogramm {
    Scanner scanner;
    App app;
    static final int ADRESSE = 1;
    static final int ARBEITGEBER = 2;
    static final int KEYACCOUNTMANAGER = 3;
    static final int ORT = 4;
    static final int VERSICHERTER = 5;
    static final int VERTRAG = 6;

    public static void main(String[] args) {
        Hauptprogramm hauptprogramm = new Hauptprogramm();
        hauptprogramm.init();
    }

    public void init() {
        app = new App();
        app.init();
        scanner = new Scanner(System.in);

        this.readUserInput();
    }

    public void readUserInput() {
        int record = 0; // table or class the user wants to manipulate
        boolean userRecordSelcetionsIsValid = false;
        while (!userRecordSelcetionsIsValid) {
            System.out.println(
                    "\nBitte geben Sie an, welchen Datensatz Sie benutzen möchten:\n" + ADRESSE + ": Adresse\n" + ARBEITGEBER + ": Arbeitgeber\n" + KEYACCOUNTMANAGER + ": KeyAccountManager\n" + ORT + ": Ort\n" + VERSICHERTER + ": Versicherter\n" + VERTRAG + ": Vertrag");
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
                    "\nBitte geben Sie den Buchstaben der gewünschten Aktion ein\nc: Daten einfügen\nr: Daten abrufen\nu: Daten ändern\nd: Daten entfernen");
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
        System.out.println("\nBitte geben Sie die angefragten Parameter ein");
        boolean success = true;
        switch (record) {
            case ADRESSE:
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
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert noch kein Ort mit der angegebenen Postleitzahl.");
                    success = false;
                }
                break;

            case ARBEITGEBER:
                System.out.println("Abrechnungsverband");
                String abrechnungsverband = scanner.next();
                System.out.println("Name der Firma");
                String firmenname = scanner.next();
                System.out.println("Adress-ID");
                int adressId = scanner.nextInt();
                System.out.println("Mitarbeiter-Nummer");
                int mitarbeiternummer = scanner.nextInt();

                try {
                    app.createArbeitgeber(abrechnungsverband, firmenname, adressId, mitarbeiternummer);
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert keine Adresse mit der angegebenen Adress-ID.");
                    success = false;
                }
                break;

            case KEYACCOUNTMANAGER:
                System.out.println("Vorname");
                String vorname = scanner.next();
                System.out.println("Nachname");
                String nachname = scanner.next();
                System.out.println("Eintrittsdatum im Format jjjj-mm-dd");
                String datum = scanner.next();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date eintrittsdatum = new Date();
                try {
                    eintrittsdatum = dateFormat.parse(datum);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    app.createKeyAccountManager(vorname, nachname, eintrittsdatum);
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert keine Adresse mit der angegebenen Adress-ID.");
                    success = false;
                }
                break;

            case ORT:
                System.out.println("Postleitzahl");
                int plz = scanner.nextInt();
                System.out.println("Ortsname");
                String ortsname = scanner.next();
                try {
                    app.createOrt(plz, ortsname);
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert schon ein Ort mit der Postleitzahl.");
                    success = false;
                }
                break;

            case VERSICHERTER:
                System.out.println("Vorname");
                String vornameVers = scanner.next();
                System.out.println("Nachname");
                String nachnameVers = scanner.next();
                System.out.println("Adress ID");
                int adressIdVers = scanner.nextInt();
                // System.out.println("Arbeitgeber ID");
                // int arbeitgeberId = scanner.nextInt();
                System.out.println("Geburtsdatum im Format jjjj-mm-dd");
                String datumVers = scanner.next();
                DateFormat dateFormatVers = new SimpleDateFormat("yyyy-MM-dd");
                Date geburtsdatum = new Date();
                try {
                    geburtsdatum = dateFormatVers.parse(datumVers);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Rentenart");
                String rentenart = scanner.next();
                System.out.println("Versicherungsstatus");
                String versicherungsstatus = scanner.next();
                System.out.println("Versorgungspunkte");
                int versorgungspunkte = scanner.nextInt();
                try {
                    app.createVersicherter(vornameVers, nachnameVers, adressIdVers, geburtsdatum,
                            rentenart, versicherungsstatus, versorgungspunkte);
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert keine Adresse mit der angegebenen Adress-ID oder die angegebene Arbeitgeber-ID existiert noch nicht");
                    success = false;
                }
                break;

            case VERTRAG:
                System.out.println("Versicherungsnummer");
                int versicherungsNr = scanner.nextInt();
                System.out.println("Abschlussdatum im Format jjjj-mm-dd");
                String datumVertrag = scanner.next();
                DateFormat dateFormatVertrag = new SimpleDateFormat("yyyy-MM-dd");
                Date abschlussdatum = new Date();
                try {
                    abschlussdatum = dateFormatVertrag.parse(datumVertrag);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Vertragsstatus");
                String vertragsstatus = scanner.next();
                System.out.println("Vertragstyp");
                String vertragstyp = scanner.next();
                try {
                    app.createVertrag(versicherungsNr, abschlussdatum, vertragsstatus, vertragstyp);
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert keine Adresse mit der angegebenen Adress-ID oder die angegebene Arbeitgeber-ID existiert noch nicht");
                    success = false;
                }
                break;

            default:
                break;
        }
        if (success) {
            System.out.println("Eintrag erfolgreich angelegt");
        }
    }

    public void read(int record) {
        System.out.println();
        switch (record) {
            case ADRESSE:
                System.out.println("Bitte geben Sie die Adress-ID der Adresse ein, die Sie ausgeben lassen wollen:");
                int adressId = scanner.nextInt();
                try {
                    System.out.println(app.readAdresse(adressId));
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert keine Adresse mit der angegebenen Adress-ID.");
                }
                break;

            case ARBEITGEBER:
                System.out.println(
                        "Bitte geben Sie die Arbeitgeber-ID des Arbeitgebers ein, den Sie ausgeben lassen wollen:");
                int arbeitgeberId = scanner.nextInt();
                try {
                    System.out.println(app.readArbeitgeber(arbeitgeberId));
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert keine Arbeitgeber mit der angegebenen Arbeitgeber-ID.");
                }
                break;

            case KEYACCOUNTMANAGER:
                System.out.println(
                        "Bitte geben Sie die Mitarbeiter-ID des Key-Account-Managers ein, den Sie ausgeben lassen wollen:");
                int mitarbeiternummer = scanner.nextInt();
                try {
                    System.out.println(app.readKeyAccountManager(mitarbeiternummer));
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert kein KeyAccountManager mit der angegebenen Mitarbeiter-ID.");
                }
                break;

            case ORT:
                System.out.println("Bitte geben Sie die Postleitzahl des Ortes ein, den Sie ausgeben lassen wollen:");
                int plz = scanner.nextInt();
                try {
                    System.out.println(app.readOrt(plz));
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert kein Ort mit der angegebenen Postleitzahl.");
                }
                break;

            case VERSICHERTER:
                System.out.println(
                        "Bitte geben Sie die Versicherungs-Nummer des Versicherten ein, den Sie ausgeben lassen wollen:");
                int versicherungsnummer = scanner.nextInt();
                try {
                    System.out.println(app.readVersicherter(versicherungsnummer));
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert kein Versicherter mit der angegebenen Versicherungs-Nummer.");
                }
                break;

            case VERTRAG:
                System.out
                        .println("Bitte geben Sie die Vertrags-ID des Vertrages ein, den Sie ausgeben lassen wollen:");
                int vertragsId = scanner.nextInt();
                System.out.println(app.readVertrag(vertragsId));
                break;

            default:
                break;
        }
    }

    public void update(int record) {
        boolean success = true;
        System.out.println("\nBitte geben Sie die angefragten Parameter ein");
        switch (record) {
            case ADRESSE:
                System.out.println("Adress ID");
                int adressId = scanner.nextInt();
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
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert keine Adresse mit der angegebenen Adress-ID oder kein Ort mit der angegebenen Postleitzahl.");
                    success = false;
                }
                break;

            case ARBEITGEBER:
                System.out.println("Arbeitgeber-ID");
                int arbietgeberId = scanner.nextInt();
                System.out.println("Abrechnungsverband");
                String abrechnungsverband = scanner.next();
                System.out.println("Name der Firma");
                String firmenname = scanner.next();
                System.out.println("Adress-ID");
                int adressIdArbeitg = scanner.nextInt();
                System.out.println("Mitarbeiternummer");
                int mitarbeiternummer = scanner.nextInt();

                try {
                    app.updateArbeitgeber(arbietgeberId, abrechnungsverband, firmenname, adressIdArbeitg,
                            mitarbeiternummer);
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert keine Adresse mit der angegebenen Adress-ID.");
                    success = false;
                }

                break;

            case KEYACCOUNTMANAGER:
                System.out.println("Mitarbeiter-Nr.");
                int mitarbeiternummerKam = scanner.nextInt();
                System.out.println("Vorname");
                String vorname = scanner.next();
                System.out.println("Nachname");
                String nachname = scanner.next();
                System.out.println("Eintrittsdatum im Format jjjj-mm-dd");
                String datum = scanner.next();
                DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                Date eintrittsdatum = new Date();
                try {
                    eintrittsdatum = dateFormat.parse(datum);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                try {
                    app.updateKeyAccountManager(mitarbeiternummerKam, vorname, nachname, eintrittsdatum);
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert keine Adresse mit der angegebenen Adress-ID.");
                    success = false;
                }
                break;

            case ORT:
                System.out.println("Postleitzahl");
                int plz = scanner.nextInt();
                System.out.println("Ortsname");
                String ortsname = scanner.next();
                try {
                    app.updateOrt(plz, ortsname);
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert schon ein Ort mit der Postleitzahl.");
                    success = false;
                }
                break;

            case VERSICHERTER:
                System.out.println("Versicherungs-Nr.");
                int versicherungsNr = scanner.nextInt();
                System.out.println("Vorname");
                String vornameVers = scanner.next();
                System.out.println("Nachname");
                String nachnameVers = scanner.next();
                System.out.println("Adress-ID");
                int adressIdVers = scanner.nextInt();
                System.out.println("Arbeitgeber-ID");
                int arbeitgeberId = scanner.nextInt();
                System.out.println("Geburtsdatum im Format jjjj-mm-dd");
                String datumVers = scanner.next();
                DateFormat dateFormatGeburtsdatum = new SimpleDateFormat("yyyy-MM-dd");
                Date geburtsdatum = new Date();
                try {
                    geburtsdatum = dateFormatGeburtsdatum.parse(datumVers);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Rentenart");
                String rentenart = scanner.next();
                System.out.println("Versicherungsstatus");
                String versicherungsstatus = scanner.next();
                System.out.println("Versorgungspunkte");
                int versorgungspunkte = scanner.nextInt();

                try {
                    app.updateVersicherter(versicherungsNr, vornameVers, nachnameVers, adressIdVers, arbeitgeberId,
                            geburtsdatum, rentenart, versicherungsstatus, versorgungspunkte);
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert keine Adresse mit der angegebenen Adress-ID oder die angegebene Arbeitgeber-ID existiert nicht");
                    success = false;
                }
                break;

            case VERTRAG:
                System.out.println("Vertrags-ID");
                int vertragsId = scanner.nextInt();
                System.out.println("Versicherungs-Nummer");
                int versicherungsNrVertrag = scanner.nextInt();
                System.out.println("Abschlussdatum im Format jjjj-mm-dd");
                String datumVertrag = scanner.next();
                DateFormat dateFormatVertrag = new SimpleDateFormat("yyyy-MM-dd");
                Date abschlussdatum = new Date();
                try {
                    abschlussdatum = dateFormatVertrag.parse(datumVertrag);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("Vertragsstatus");
                String vertragsstatus = scanner.next();
                System.out.println("Vertragstyp");
                String vertragstyp = scanner.next();
                try {
                    app.updateVertrag(vertragsId, versicherungsNrVertrag, abschlussdatum, vertragsstatus, vertragstyp);
                } catch (Exception e) {
                    System.out.println(
                            "\nEtwas ist schiefgelaufen. Vielleicht existiert keine Adresse mit der angegebenen Adress-ID oder die angegebene Arbeitgeber-ID existiert noch nicht");
                    success = false;
                }
                break;

            default:
                break;
        }
        if (success) {
            System.out.println("Eintrag erfolgreich bearbeitet");
        }
    }

    public void delete(int record) {
        boolean success = true;
        System.out.println();
        switch (record) {
            case ADRESSE:
                System.out.println("Bitte geben Sie die Adress-ID der Adresse ein, die Sie entfernen wollen:");
                int adressId = scanner.nextInt();
                app.deleteAdresse(adressId);
                break;

            case ARBEITGEBER:
                System.out
                        .println("Bitte geben Sie die Arbeitgeber-ID des Arbeitgebers ein, den Sie entfernen wollen:");
                int arbeitgeberId = scanner.nextInt();
                app.deleteArbeitgeber(arbeitgeberId);
                break;

            case KEYACCOUNTMANAGER:
                System.out.println(
                        "Bitte geben Sie die Mitarbeiter-ID des Key-Account-Managers ein, den sie entfernen wollen:");
                int mitarbeiternummer = scanner.nextInt();
                app.deleteKeyAccountManager(mitarbeiternummer);
                break;

            case ORT:
                System.out.println("Bitte geben Sie die Postleitzahl des Ortes ein, den Sie entfernen wollen:");
                int plz = scanner.nextInt();
                app.deleteOrt(plz);
                break;

            case VERSICHERTER:
                System.out.println(
                        "Bitte geben Sie die Versicherungs-Nummer des Versicherten ein, den Sie entfernen wollen:");
                int versicherungsnummer = scanner.nextInt();
                app.deleteVersicherter(versicherungsnummer);
                break;

            case VERTRAG:
                System.out.println("Bitte geben sie die Vertrags-ID des Vertrages ein, den sie entfernen wollen:");
                int vertragsId = scanner.nextInt();
                app.deleteVertrag(vertragsId);
                break;

            default:
                break;
        }
        if (success) {
            System.out.println("Eintrag erfolgreich entfernt");
        }
    }
}
