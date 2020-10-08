CREATE DATABASE dbportfolio;
USE dbportfolio;
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
CREATE TABLE adresse (
    Adress_ID INTEGER,
    Straße VARCHAR(70),
    Hausnummer VARCHAR(10),
    Postleitzahl INTEGER,
    PRIMARY KEY (Adress_ID)
);
CREATE TABLE arbeitgeber (
    Arbeitgeber_ID INTEGER,
    Adress_ID INTEGER,
    Firmenname VARCHAR(120),
    Mitarbeiter_Nr INTEGER,
    Abrechnungsverband VARCHAR(10),
    PRIMARY KEY (Arbeitgeber_ID),
    FOREIGN KEY (Adress_ID) REFERENCES adresse(Adress_ID)
);
CREATE TABLE key_account_manager (
    Mitarbeiter_Nr INTEGER,
    Vorname VARCHAR(70),
    Nachname  VARCHAR(70),
    Eintrittsdatum DATE,
    PRIMARY KEY (Mitarbeiter_Nr)
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

INSERT INTO vertrag (
    Vertrags_ID,
    Vertragsstatus,
    Typ,
    Abschlussdatum,
    Versicherungs_Nr
  )
VALUES (
    5646,
    'Betriebsrente',
    'klassik',
    '1966-12-07',
    123456789
  );
  INSERT INTO rentner (
      Versicherungs_Nr,
      Nachname,
      Vorname,
      Rentenart,
      Rentenhoehe,
      Arbeitgeber_ID
    )
  VALUES (
      123456789,
      'Hallo',
      'Welt',
      'klassik',
      '251',
      83325
    );