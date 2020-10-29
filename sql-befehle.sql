CREATE DATABASE dbPortfolio;
USE dbPortfolio;
CREATE TABLE ort (
    Postleitzahl INTEGER NOT NULL,
    Ortsname VARCHAR(70) NOT NULL,
    PRIMARY KEY (Postleitzahl)
);
CREATE TABLE adresse (
    AdressId INTEGER NOT NULL AUTO_INCREMENT,
    Straße VARCHAR(70) NOT NULL,
    Hausnummer VARCHAR(10) NOT NULL,
    Postleitzahl INTEGER NOT NULL,
    PRIMARY KEY (AdressId),
    FOREIGN KEY (Postleitzahl) REFERENCES ort(Postleitzahl)
);
CREATE TABLE keyAccountManager (
    MitarbeiterNr INTEGER NOT NULL AUTO_INCREMENT,
    Vorname VARCHAR(70) NOT NULL,
    Nachname  VARCHAR(70) NOT NULL,
    Eintrittsdatum DATE NOT NULL,
    PRIMARY KEY (MitarbeiterNr)
);
CREATE TABLE arbeitgeber (
    ArbeitgeberId INTEGER NOT NULL AUTO_INCREMENT,
    Firmenname VARCHAR(120) NOT NULL,
    AdressId INTEGER NOT NULL,
    Abrechnungsverband VARCHAR(10) NOT NULL,
    MitarbeiterNr INTEGER NOT NULL,
    PRIMARY KEY (ArbeitgeberId),
    FOREIGN KEY (AdressId) REFERENCES adresse(AdressId),
    FOREIGN KEY (MitarbeiterNr) REFERENCES keyAccountManager(MitarbeiterNr)
);
CREATE TABLE versicherter (
    VersicherungsNr INTEGER NOT NULL AUTO_INCREMENT, 
    Vorname VARCHAR(70) NOT NULL,
    Nachname VARCHAR(70) NOT NULL,
    Geburtsdatum DATE NOT NULL,
    Versorgungspunkte FLOAT,
    AdressId INTEGER NOT NULL,
    Rentenart VARCHAR(20),
    Versicherungsstatus VARCHAR(20),
    ArbeitgeberId INTEGER,
    PRIMARY KEY (VersicherungsNr),
    FOREIGN KEY (AdressId) REFERENCES adresse(AdressId),
    FOREIGN KEY (ArbeitgeberId) REFERENCES arbeitgeber(ArbeitgeberId)
);
CREATE TABLE vertrag (
    VertragsId INTEGER NOT NULL AUTO_INCREMENT,
    VersicherungsNr INTEGER NOT NULL,
    Abschlussdatum DATE NOT NULL,
    Vertragsstatus VARCHAR(20),
    Vertragstyp VARCHAR(10),
    PRIMARY KEY (VertragsId),
    FOREIGN KEY (VersicherungsNr) REFERENCES versicherter(VersicherungsNr)
);


INSERT INTO ort (Postleitzahl, Ortsname)
VALUES (76887, 'Bad Bergzabern'),
(76131, 'Karlsruhe'),
(55116, 'Mainz'),
(76137, 'Karlsruhe'),
(10115, 'Berlin'),
(20095, 'Hamburg'),
(76133, 'Karlsruhe'),
(76199, 'Ettlingen'),
(75177, 'Pforzheim'),
(76829, 'Landau');

INSERT INTO adresse (Straße, Hausnummer, Postleitzahl)
VALUES ('Hauptstraße', '54', 76887),
('Am Bach', '99', 10115),
('Zollstraße', '3', 55116),
('Bahnhofstraße', '65', 76137),
('Gartenstraße', '45', 20095),
('Ettlingerstraße', '12', 76131),
('Am Seeweg', '4', 76131),
('Bachstraße', '9', 76133),
('Bahnhofstraße', '65', 76137),
('Hansstraße', '2', 76199),
('Am Tor', '33', 76199),
('Donaustraße', '2', 76829),
('Zaunpfad', '78a', 76829),
('Untere Hauptstraße', '231', 55116),
('Adenauerring', '99', 75177),
('Baldachinstraße', '23', 76133),
('Schneeweg', '4', 10115),
('Milchstraße', '44', 76133);

INSERT INTO keyAccountManager (Vorname, Nachname, Eintrittsdatum)
VALUES ('Frauke', 'Bauer', DATE '2000-04-01'),
('Martin', 'Lutz', DATE '2010-06-15'),
('Ingrid', 'Nist', DATE '2020-08-15'),
('Tim', 'Seibert', DATE '1990-12-01'),
('Walter', 'Mayer', DATE '1980-01-01');

INSERT INTO arbeitgeber (Firmenname, AdressId, Abrechnungsverband, MitarbeiterNr)
VALUES ('ENBW', 6, 'West', 1), 
('DRV', 7, 'West', 1),
('Stadt Karlsruhe', 8, 'West', 2),
('Stadt Berlin', 9, 'Ost', 2),
('SAP', 15, 'West', 3),
('Helios Klinik', 16, 'West', 4),
('Bundeswehr', 17, 'Ost', 5),
('Stadt Stuttgart', 18, 'West', 4);

INSERT INTO versicherter (Vorname, Nachname, Geburtsdatum, Versorgungspunkte, AdressId, Rentenart, Versicherungsstatus, ArbeitgeberId)
VALUES ('Horst', 'Ehren', DATE '1978-11-08', 34, 1, '', 'aktiv', 6),
('Axel', 'Zaun', DATE '1990-07-23', 55, 2, '', 'aktiv',  6), 
('Ulli', 'Weber', DATE '2000-10-06', 90, 3, '', 'pausiert', 7),
('Lilli', 'Schick', DATE '1988-08-15', 150, 4, '', 'pausiert', 7),
('Karl', 'Grün', DATE '1983-09-17', 180, 5, '', 'aktiv', 8),
('Max', 'Müller', DATE '1950-02-02', 190, 10, 'Altersrente', 'inaktiv', 1), 
('Roman', 'Frey', DATE '1950-12-08', 220, 11, 'Altersrente', 'inaktiv', 1),
('Markus', 'Ulm', DATE '1931-09-13', 259, 12, 'Altersrente', 'inaktiv', 2),
('Thomas', 'Braun', DATE '1920-12-09', 274, 13, 'Witwenrente', 'inaktikv', 4),
('Olaf', 'Nau', DATE '1936-05-30', 210, 14, 'Altersrente', 'inaktiv', 3);

INSERT INTO vertrag (Vertragsstatus, Vertragstyp, Abschlussdatum, VersicherungsNr)
Values ('aktiv', 'klassik', DATE '2000-12-12', 1), 
('', 'klassik', DATE '1990-12-01', 6),
('', 'dynamik', DATE '1979-09-15', 8),
('', 'riester', DATE '1978-03-20', 10),
('', 'klassik', DATE '1950-11-23', 9),
('inaktiv', 'dynamik', DATE '2005-10-24', 1),
('aktiv', 'klassik', DATE '2014-03-08', 2),
('aktiv', 'klassik', DATE '2016-05-29', 3),
('aktiv', 'klassik', DATE '2000-10-01', 4),
('aktiv', 'klassik', DATE '2000-08-15', 5),
('', 'klassik', DATE '1990-12-01', 6),
('', 'dynamik', DATE '1964-04-01', 7),
('', 'klassik', DATE '1961-03-15', 8),
('', 'riester', DATE '1960-12-15', 9),
('', 'klassik', DATE '1958-09-13', 10);

SELECT * 
FROM arbeitgeber 
WHERE MitarbeiterNr = 2;

SELECT VersicherungsNr, Vorname, Nachname, Ortsname
FROM versicherter, adresse, ort 
WHERE (versicherter.AdressId=adresse.AdressId) AND adresse.Postleitzahl=ort.Postleitzahl AND ort.Ortsname = 'Karlsruhe';

SELECT *
FROM versicherter, arbeitgeber
WHERE versicherter.ArbeitgeberId=arbeitgeber.ArbeitgeberId AND arbeitgeber.Firmenname='ENBW';

SELECT *
FROM vertrag
WHERE Abschlussdatum < DATE '2002-01-01';

SELECT ArbeitgeberId, Firmenname
From arbeitgeber;

SELECT Nachname, Vorname, Versorgungspunkte
FROM versicherter, arbeitgeber
WHERE versicherter.ArbeitgeberId = arbeitgeber.ArbeitgeberId AND arbeitgeber.Firmenname = 'Stadt Karlsruhe';

SELECT VersicherungsNr, Nachname, Vorname, Ortsname
FROM versicherter, arbeitgeber, adresse, ort
WHERE versicherter.ArbeitgeberId = arbeitgeber.ArbeitgeberId AND arbeitgeber.AdressId = adresse.AdressId AND adresse.Postleitzahl = ort.Postleitzahl AND ort.Ortsname = 'Berlin';