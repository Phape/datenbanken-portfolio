CREATE DATABASE dbPortfolio;
CREATE TABLE rentner (
    Versicherungs_Nr INTEGER,
    Nachname VARCHAR(70), 
    Vorname VARCHAR(70), 
    Rentenart VARCHAR(20),
    Rentenhoehe FLOAT,
    Arbeitgeber_ID INTEGER,
    PRIMARY KEY (Versicherungs_Nr)
    );
CREATE TABLE vertrag (
    Vertrags_ID INTEGER,
    Vertragsstatus VARCHAR(20),
    Typ VARCHAR(10),
    Abschlussdatum DATE,
    Versicherungs_Nr INTEGER,
    PRIMARY KEY (Vertrags_ID)
);
CREATE TABLE arbeitgeber (
    Arbeitgeber_ID INTEGER,
    Adress_ID INTEGER,
    Firmenname VARCHAR(120),
    Mitarbeiter_Nr INTEGER,
    Abrechnungsverband VARCHAR(10),
    PRIMARY KEY (Arbeitgeber_ID)
);
CREATE TABLE key_account_manager (
    Mitarbeiter_Nr INTEGER,
    Vorname VARCHAR(70),
    Nachname  VARCHAR(70),
    Eintrittsdatum DATE,
    PRIMARY KEY (Mitarbeiter_Nr)
);
CREATE TABLE adresse (
    Adress_ID INTEGER,
    Straße VARCHAR(70),
    Hausnummer VARCHAR(10),
    Postleitzahl INTEGER,
    PRIMARY KEY (Adress_ID)
);
CREATE TABLE ort (
    Postleitzahl INTEGER,
    Ortsname VARCHAR(70),
    PRIMARY KEY (Postleitzahl)
);
CREATE TABLE versicherter (
    Versicherungs_Nr INTEGER,
    Nachname VARCHAR(70),
    Vorname VARCHAR(70),
    Geburtsdatum DATE,
    Adress_ID INTEGER,
    Arbeitgeber_ID INTEGER,
    Gehalt FLOAT,
    PRIMARY KEY (Versicherungs_Nr)
);

SAVEPOINT vor_insert;

-- Inserts

INSERT INTO ort (Postleitzahl, Ortsname)
VALUES (),
(), --bitte Beispieldaten einfügen
();

INSERT INTO adresse (Adress_ID, Straße, Hausnummer, Postleitzahl)
VALUES (),
(), --bitte Beispieldaten einfügen
();

INSERT INTO key_account_manager (Mitarbeiter_Nr, Vorname, Nachname, Eintrittsdatum)
VALUES (),
(), --bitte Beispieldaten einfügen
();

INSERT INTO arbeitgeber (Arbeitgeber_ID, Adress_ID, Firmenname, Mitarbeiter_Nr, Abrechnungsverband)
VALUES (),
(),
();

INSERT INTO versicherter (Versicherungs_Nr, Nachname, Vorname, Geburtsdatum, Adress_ID, Arbeitgeber_ID, Gehalt)
VALUES (),
(),
();

INSERT INTO vertrag (Vertrags_ID, Vertragsstatus, Typ, Abschlussdatum, Versicherungs_Nr)
Values ('101', ),
--woher wüsste man hier die Versicherungs-Nr, diese muss ja erst automatisch generiert werden
--um generiert zu werden, muss doch erst der rentner-Insert abgeschlossen sein, oder?
(aktiv, klassik, 12.12.2000), --vertragsId automatisch?, Versicherungsnummer an der stelle noch nicht generiert
(aktiv, klassik, 01.12.1990),
(aktiv, dynamik, 15.09.1990),
(aktiv, riester, 20.03.1978),
(inaktiv, klassik, 23.11.2002);

INSERT INTO rentner (Versicherungs_Nr, Nachname, Vorname, Rentenart, Rentenhoehe, Arbeitgeber_ID)
VALUES (Müller, Max, Altersrente, 360, 1), --versicherungs Nr fehlt noch, sollte automatisch generiert werden
(Frey, Roman, Altersrente, 332, 1),
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