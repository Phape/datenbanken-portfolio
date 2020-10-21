package de.gruppe4.datenbankenportfolio;

import java.sql.Date;

import javax.persistence.*;

public class KeyAccountManager {
    @Id
    @Column(name = "Mitarbeiter_Nr")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mitarbeiterNr;

    @Column(name = "Vorname")
    private String vorname;

    @Column(name = "Nachname")
    private String nachname;

    @Column(name = "Eintrittsdatum")
    private Date eintrittsdatum;

}
