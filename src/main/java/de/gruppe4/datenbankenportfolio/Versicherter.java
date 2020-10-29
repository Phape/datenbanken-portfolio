package de.gruppe4.datenbankenportfolio;

import java.sql.Date;
import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "versicherter")
@NoArgsConstructor
public class Versicherter {
    @Id
    @Column(name = "VersicherungsNr")
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

    @Column(name = "AdressId")
    private int adressId;

    @Column(name = "Rentenart")
    private String rentenart;

    @Column(name = "Versicherungsstatus")
    private String versicherungsstatus;

    @Column(name = "ArbeitgeberId")
    private int arbeitgeberId;


    public int getVersicherungsNr() {
        return this.versicherungsNr;
    }

    public void setVersicherungsNr(int versicherungsNr) {
        this.versicherungsNr = versicherungsNr;
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

    public Date getGeburtsdatum() {
        return this.Geburtsdatum;
    }

    public void setGeburtsdatum(Date Geburtsdatum) {
        this.Geburtsdatum = Geburtsdatum;
    }

    public float getVersorgungspunkte() {
        return this.versorgungspunkte;
    }

    public void setVersorgungspunkte(float versorgungspunkte) {
        this.versorgungspunkte = versorgungspunkte;
    }

    public int getAdressId() {
        return this.adressId;
    }

    public void setAdressId(int adressId) {
        this.adressId = adressId;
    }

    public String getRentenart() {
        return this.rentenart;
    }

    public void setRentenart(String rentenart) {
        this.rentenart = rentenart;
    }

    public String getVersicherungsstatus() {
        return this.versicherungsstatus;
    }

    public void setVersicherungsstatus(String versicherungsstatus) {
        this.versicherungsstatus = versicherungsstatus;
    }

    public int getArbeitgeberId() {
        return this.arbeitgeberId;
    }

    public void setArbeitgeberId(int arbeitgeberId) {
        this.arbeitgeberId = arbeitgeberId;
    }

    @Override
    public String toString() {
        return "{" +
            " versicherungsNr='" + getVersicherungsNr() + "'" +
            ", vorname='" + getVorname() + "'" +
            ", nachname='" + getNachname() + "'" +
            ", Geburtsdatum='" + getGeburtsdatum() + "'" +
            ", versorgungspunkte='" + getVersorgungspunkte() + "'" +
            ", adressId='" + getAdressId() + "'" +
            ", rentenart='" + getRentenart() + "'" +
            ", versicherungsstatus='" + getVersicherungsstatus() + "'" +
            ", arbeitgeberId='" + getArbeitgeberId() + "'" +
            "}";
    }

}
