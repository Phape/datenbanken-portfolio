CREATE DATABASE dbportfolio;
USE dbportfolio;
CREATE TABLE ort (
    Postleitzahl INT,
    Ortsname VARCHAR(70),
    PRIMARY KEY (Postleitzahl)
);
CREATE TABLE adresse (
    Adress_ID INT,
    Straße VARCHAR(70),
    Hausnummer VARCHAR(10),
    Postleitzahl INT,
    PRIMARY KEY (Adress_ID),
    FOREIGN KEY (Postleitzahl) REFERENCES ort(Postleitzahl)
);
CREATE TABLE key_account_manager (
    Mitarbeiter_Nr INT,
    Vorname VARCHAR(70),
    Nachname  VARCHAR(70),
    Eintrittsdatum DATE,
    PRIMARY KEY (Mitarbeiter_Nr)
);
CREATE TABLE arbeitgeber (
    Arbeitgeber_ID INT,
    Adress_ID INT,
    Firmenname VARCHAR(120),
    Mitarbeiter_Nr INT,
    Abrechnungsverband VARCHAR(10),
    PRIMARY KEY (Arbeitgeber_ID),
    FOREIGN KEY (Adress_ID) REFERENCES adresse(Adress_ID),
    FOREIGN KEY (Mitarbeiter_Nr) REFERENCES key_account_manager(Mitarbeiter_Nr)
);
CREATE TABLE rentner (
    Versicherungs_Nr INT,
    Nachname VARCHAR(70), 
    Vorname VARCHAR(70), 
    Rentenart VARCHAR(20),
    Rentenhoehe FLOAT,
    Arbeitgeber_ID INT,
    Adress_ID INT,
    PRIMARY KEY (Versicherungs_Nr),
    FOREIGN KEY (Adress_ID) REFERENCES adresse(Adress_ID),
    FOREIGN KEY (Arbeitgeber_ID) REFERENCES arbeitgeber(Arbeitgeber_ID)
);
CREATE TABLE versicherter (
    Versicherungs_Nr INT,
    Nachname VARCHAR(70),
    Vorname VARCHAR(70),
    Geburtsdatum DATE,
    Adress_ID INT,
    Arbeitgeber_ID INT,
    Gehalt FLOAT,
    PRIMARY KEY (Versicherungs_Nr),
    FOREIGN KEY (Adress_ID) REFERENCES adresse(Adress_ID),
    FOREIGN KEY (Arbeitgeber_ID) REFERENCES arbeitgeber(Arbeitgeber_ID)
);
CREATE TABLE vertrag (
    Vertrags_ID INT,
    Vertragsstatus VARCHAR(20),
    Typ VARCHAR(10),
    Abschlussdatum DATE,
    Versicherungs_Nr INT,
    PRIMARY KEY (Vertrags_ID),
    FOREIGN KEY (Versicherungs_Nr) REFERENCES rentner(Versicherungs_Nr),
    FOREIGN KEY (Versicherungs_Nr) REFERENCES versicherter(Versicherungs_Nr)
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