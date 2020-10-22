package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Table(name = "adresse")
@Data
@ToString
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

    @Override
    public String toString() {
        return "Adress_ID: " + adressId + ", Straße: " + straße + ", Hausnummer: " + hausnummer + ", Postleitzahl: " + postleitzahl;
    }
}
