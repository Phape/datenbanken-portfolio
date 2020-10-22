package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "adresse")
@Data
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
