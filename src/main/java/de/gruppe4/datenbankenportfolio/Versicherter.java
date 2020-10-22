package de.gruppe4.datenbankenportfolio;

import java.sql.Date;
import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "versicherter")
@Data
@NoArgsConstructor
public class Versicherter {
    @Id
    @Column(name = "Versicherungs_Nr")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int versicherungsNr;

    @Column(name = "Vorname")
    private String vorname;

    @Column(name = "Nachname")
    private String nachname;

    @Column(name = "Geburtsdatum")
    private Date Geburtsdatum;

    @Column(name = "Versorgungspunkte")
    private float versorgungspunkte;

    @Column(name = "Adress_ID")
    private int adressId;

    @Column(name = "Rentenart")
    private String rentenart;

    @Column(name = "Versicherungsstatus")
    private String versicherungsstatus;

    @Column(name = "Arbeitgeber_ID")
    private int arbeitgeber_ID;

}
