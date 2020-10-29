package de.gruppe4.datenbankenportfolio;

import java.sql.Date;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "keyAccountManager")
@NoArgsConstructor
public class KeyAccountManager {
    @Id
    @Column(name = "MitarbeiterNr")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int mitarbeiterNr;

    @Column(name = "Vorname")
    private String vorname;

    @Column(name = "Nachname")
    private String nachname;

    @Column(name = "Eintrittsdatum")
    private Date eintrittsdatum;


    public int getMitarbeiterNr() {
        return this.mitarbeiterNr;
    }

    public void setMitarbeiterNr(int mitarbeiterNr) {
        this.mitarbeiterNr = mitarbeiterNr;
    }

    public String getVorname() {
        return this.vorname;
    }

    public void setVorname(String vorname) {
        this.vorname = vorname;
    }

    public String getNachname() {
        return this.nachname;
    }

    public void setNachname(String nachname) {
        this.nachname = nachname;
    }

    public Date getEintrittsdatum() {
        return this.eintrittsdatum;
    }

    public void setEintrittsdatum(Date eintrittsdatum) {
        this.eintrittsdatum = eintrittsdatum;
    }

    @Override
    public String toString() {
        return "{" +
            " mitarbeiterNr='" + getMitarbeiterNr() + "'" +
            ", vorname='" + getVorname() + "'" +
            ", nachname='" + getNachname() + "'" +
            ", eintrittsdatum='" + getEintrittsdatum() + "'" +
            "}";
    }
}
