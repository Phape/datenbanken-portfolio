package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;

public class Adresse {
    @Id
    @Column(name = "Adress_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adressId;

    @Column(name = "Straße")
    private String straße;
    
    @Column(name = "Hausnummer")
    private String hausnummer;
    
    @Column(name = "Postleitzahl")
    private String postleitzahl;
}
