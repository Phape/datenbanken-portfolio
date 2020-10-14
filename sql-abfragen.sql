CREATE DATABASE dbPortfolio;

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
    Rentenart VARCHAR(20),
    Rentenhoehe FLOAT,
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
VALUES (Frauke, Bauer, 2000-04-01),
(Martin, Lutz, 2010-06-15),
(Ingrid, Nist, 2020-08-15),
(Tim, Seibert, 1990-12-01),
(Walter, Mayer, 1980-01-01);

INSERT INTO arbeitgeber (Firmenname, Adress_ID, Abrechnungsverband, Mitarbeiter_Nr)
VALUES (ENBW, 6, West, 2312), --adress-ids müssen noch angepasst werden, nachdem die ids automatisch generiert wurden
(DRV, 7, West, 4321),
(Stadt Karlsruhe, 8, West, 2645),
(Stadt Berlin, 9, Ost, 1265),
(SAP, 15, West, 2312);

INSERT INTO vertrag (Vertragsstatus, Typ, Abschlussdatum, Versicherungs_Nr)
Values (aktiv, klassik, 2000-12-12), --Versicherungsnummern ergänzen, nachdem sie generiert wurden
(aktiv, klassik, 1990-12-01),
(aktiv, dynamik, 1990-09-15),
(aktiv, riester, 1978-03-20),
(inaktiv, klassik, 2002-11-23);

INSERT INTO versicherter (Versicherungs_Nr, Vorname, Nachname, Geburtsdatum, Gehalt, Adress_ID, Rentenart, Rentenhoehe, Arbeitgeber_ID)
VALUES (Horst, Ehren, 1978-11-08, 3434), --versicherungs Nr fehlt noch, sollte automatisch generiert werden
(Axel, Zaun, 1990-07-23, 1587), --adress-id und arbeitgeber-id nach automatischer generierung ergänzen
(Ulli, Weber, 2000-10-06, 5676),
(Lilli, Schick, 1988-08-15, 3399),
(Karl, Grün, 1983-09-17, 2456),

(Max, Müller, 1950-02-02, Altersrente, 360, 1), --versicherungs Nr fehlt noch, sollte automatisch generiert werden
(Roman, Frey, 1950-12-08, Altersrente, 332, 1), --arbeitgeber_id nach Generierung anpassen
(Markus, Ulm, 1931-09-13, Altersrente, 234, 2),
(Thomas, Braun, 1920-12-09, Witwenrente, 109, 4),
(Olaf, Nau, 1936-05-30, Altersrente, 97, 3);



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