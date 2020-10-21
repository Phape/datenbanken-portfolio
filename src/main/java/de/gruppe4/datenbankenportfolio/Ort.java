package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;

public class Ort {
    @Id
    @Column(name = "Postleitzahl")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postleitzahl;

    @Column(name = "Ortsname")
    private String ortsname;

}
