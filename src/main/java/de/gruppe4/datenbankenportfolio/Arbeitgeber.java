package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;

@Entity
@Table(name = "arbeitgeber")
public class Arbeitgeber {
    @Id
    @Column(name = "Arbeitgeber_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int arbeitgeberId;

    @Column(name = "Firmenname")
    private String firmenname;

    @Column(name = "Adress_ID")
    private int adressId;

    @Column(name = "Abrechnungsverband")
    private String abrechnungsverband;

    @Column(name = "Mitarbeiter_Nr")
    private int mitarbeiterNr;

}
