CREATE DATABASE dbPortfolio;

CREATE TABLE rentner (
    Versicherungs_Nr INTEGER NOT NULL, --auto_increment Konflikt mit versicherter
    Nachname VARCHAR(70), 
    Vorname VARCHAR(70), 
    Rentenart VARCHAR(20),
    Rentenhoehe FLOAT,
    Arbeitgeber_ID INTEGER,
    PRIMARY KEY (Versicherungs_Nr),
    FOREIGN KEY (Adress_ID) REFERENCES adresse(Adress_ID),
    FOREIGN KEY (Arbeitgeber_ID) REFERENCES arbeitgeber(Arbeitgeber_ID)
    );
CREATE TABLE vertrag (
    Vertrags_ID INTEGER NOT NULL AUTO_INCREMENT,
    Vertragsstatus VARCHAR(20),
    Typ VARCHAR(10),
    Abschlussdatum DATE,
    Versicherungs_Nr INTEGER,
    PRIMARY KEY (Vertrags_ID),
    FOREIGN KEY (Versicherungs_Nr) REFERENCES rentner(Versicherungs_Nr),
    FOREIGN KEY (Versicherungs_Nr) REFERENCES versicherter(Versicherungs_Nr)
);
CREATE TABLE arbeitgeber (
    Arbeitgeber_ID INTEGER NOT NULL AUTO_INCREMENT,
    Adress_ID INTEGER,
    Firmenname VARCHAR(120),
    Mitarbeiter_Nr INTEGER,
    Abrechnungsverband VARCHAR(10),
    PRIMARY KEY (Arbeitgeber_ID),
    FOREIGN KEY (Adress_ID) REFERENCES adresse(Adress_ID),
    FOREIGN KEY (Mitarbeiter_Nr) REFERENCES key_account_manager(Mitarbeiter_Nr)
);
CREATE TABLE key_account_manager (
    Mitarbeiter_Nr INTEGER NOT NULL AUTO_INCREMENT,
    Vorname VARCHAR(70),
    Nachname  VARCHAR(70),
    Eintrittsdatum DATE,
    PRIMARY KEY (Mitarbeiter_Nr)
);
CREATE TABLE adresse (
    Adress_ID INTEGER NOT NULL AUTO_INCREMENT,
    Straße VARCHAR(70),
    Hausnummer VARCHAR(10),
    Postleitzahl INTEGER,
    PRIMARY KEY (Adress_ID),
    FOREIGN KEY (Postleitzahl) REFERENCES ort(Postleitzahl)
);
CREATE TABLE ort (
    Postleitzahl INTEGER NOT NULL,
    Ortsname VARCHAR(70),
    PRIMARY KEY (Postleitzahl)
);
CREATE TABLE versicherter (
    Versicherungs_Nr INTEGER NOT NULL, --auto_increment Konflikt mit rentner
    Nachname VARCHAR(70),
    Vorname VARCHAR(70),
    Geburtsdatum DATE,
    Adress_ID INTEGER,
    Arbeitgeber_ID INTEGER,
    Gehalt FLOAT,
    PRIMARY KEY (Versicherungs_Nr)
    FOREIGN KEY (Adress_ID) REFERENCES adresse(Adress_ID),
    FOREIGN KEY (Arbeitgeber_ID) REFERENCES arbeitgeber(Arbeitgeber_ID)
);

SAVEPOINT vor_insert;

-- Inserts

INSERT INTO ort (Postleitzahl, Ortsname)
VALUES (76887, Bad Bergzabern),
(76131, Karlsruhe),
(55116, Mainz),
(76137, Karlsruhe),
(10115, Berlin),
(20095, Hamburg),
(76133, Karlsruhe),
(76199, Ettlingen),
(75177, Pforzheim),
(76829, Landau)

INSERT INTO adresse (Straße, Hausnummer, Postleitzahl)
VALUES (Hauptstraße, 54, 76887),
(Am Bach, 99, 10115),
(Zollstraße, 3, 55116),
(Bahnhofstraße, 65	76137),
(Gartenstraße, 45, 20095),
(Ettlingerstraße, 12, 76131),
(Am Seeweg, 4, 76131),
(Bachstraße, 9, 76133),
(Bahnhofstraße, 65, 76137),
(Hansstraße, 2, 76199),
(Am Tor, 33, 76199),
(Donaustraße, 2, 76829),
(Zaunpfad, 78a, 76829),
(Untere Hauptstraße, 231, 55116),
(Adenauerring, 99, 75177);

INSERT INTO key_account_manager (Vorname, Nachname, Eintrittsdatum)
VALUES (Frauke, Bauer, 01.04.2000),
(Martin, Lutz, 15.06.2010),
(Ingrid, Nist, 15.08.2020),
(Tim, Seibert, 01.12.1990),
(Walter, Mayer, 01.01.1980);

INSERT INTO arbeitgeber (Firmenname, Adress_ID, Abrechnungsverband, Mitarbeiter_Nr)
VALUES (ENBW, 6, West, 2312), --adress-ids müssen noch angepasst werden, nachdem die ids automatisch generiert wurden
(DRV, 7, West, 4321),
(Stadt Karlsruhe, 8, West, 2645),
(Stadt Berlin, 9, Ost, 1265),
(SAP, 15, West, 2312);

INSERT INTO vertrag (Vertragsstatus, Typ, Abschlussdatum, Versicherungs_Nr)
Values (aktiv, klassik, 12.12.2000), --Versicherungsnummern ergänzen, nachdem sie generiert wurden
(aktiv, klassik, 01.12.1990),
(aktiv, dynamik, 15.09.1990),
(aktiv, riester, 20.03.1978),
(inaktiv, klassik, 23.11.2002);

INSERT INTO versicherter (Versicherungs_Nr, Vorname, Nachname, Geburtsdatum, Gehalt, Adress_ID, Arbeitgeber_ID)
VALUES (Horst, Ehren, 11.08.1978, 3434), --versicherungs Nr fehlt noch, sollte automatisch generiert werden
(Axel, Zaun, 23.07.1990, 1587), --adress-id und arbeitgeber-id nach automatischer generierung ergänzen
(Ulli, Weber, 06.10.2000, 5676),
(Lilli, Schick, 15.08.1988, 3399),
(Karl, Grün, 17.09.1983, 2456);

INSERT INTO rentner (Versicherungs_Nr, Nachname, Vorname, Rentenart, Rentenhoehe, Arbeitgeber_ID)
VALUES (Müller, Max, Altersrente, 360, 1), --versicherungs Nr fehlt noch, sollte automatisch generiert werden
(Frey, Roman, Altersrente, 332, 1), --arbeitgeber_id nach Generierung anpassen
Ulm, Markus, Altersrente, 234, 2),
(Braun, Thomas, Witwenrente, 109, 4),
(Nau, Olaf, Altersrente, 97, 3);


-- Beispiele für Foreign Key

CREATE TABLE aatest(
    ID INTEGER NOT NULL AUTO_INCREMENT,
    Name VARCHAR(70),
    PRIMARY KEY (ID)
);

CREATE TABLE aatest1(
    ID INTEGER NOT NULL AUTO_INCREMENT,
    Nachname VARCHAR(70),
    Parent_ID INTEGER,
    PRIMARY KEY (ID),
    FOREIGN KEY (Parent_ID) REFERENCES aatest(ID)
);

INSERT INTO aatest1 (Nachname)
VALUE ('Mayer');

INSERT INTO aatest(Name)
VALUE ('Philipp');