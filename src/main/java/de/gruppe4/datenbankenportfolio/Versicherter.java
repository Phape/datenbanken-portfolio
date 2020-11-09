package de.gruppe4.datenbankenportfolio;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "versicherter")

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
    private Date geburtsdatum;

    @Column(name = "Versorgungspunkte")
    private float versorgungspunkte;

    @Column(name = "AdressId")
    private int adressId;

    @ManyToOne
    @JoinColumn(name = "AdressId", insertable = false, updatable = false)
    private Adresse adresse;

    @Column(name = "Rentenart")
    private String rentenart;

    @Column(name = "Versicherungsstatus")
    private String versicherungsstatus;

    // @ManyToMany
    // @JoinColumn(name = "ArbeitgeberId")
    // private List<Arbeitgeber> arbeitgeber;

    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "Arbeitsverhaeltnisse", 
        joinColumns = { @JoinColumn(name = "VersicherungsNr") }, 
        inverseJoinColumns = { @JoinColumn(name = "ArbeitgeberId") }
    )
    private List<Arbeitgeber> arbeitgebers = new ArrayList<Arbeitgeber>();

    public Versicherter() {

    }

    public Versicherter(String vorname, String nachname, Date geburtsdatum, float versorgungspunkte, int adressId,
            String rentenart, String versicherungsstatus) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geburtsdatum = geburtsdatum;
        this.versorgungspunkte = versorgungspunkte;
        this.adressId = adressId;
        this.rentenart = rentenart;
        this.versicherungsstatus = versicherungsstatus;
    }

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
        return this.geburtsdatum;
    }

    public void setGeburtsdatum(Date Geburtsdatum) {
        this.geburtsdatum = Geburtsdatum;
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

    public Adresse getAdresse() {
        return this.adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
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

    public List<Arbeitgeber> getArbeitgebers() {
        return this.arbeitgebers;
    }

    public void setArbeitgebers(List<Arbeitgeber> arbeitgeber) {
        this.arbeitgebers = arbeitgeber;
    }

    @Override
    public String toString() {
        return "{" + " versicherungsNr='" + getVersicherungsNr() + "'" + ", vorname='" + getVorname() + "'"
                + ", nachname='" + getNachname() + "'" + ", Geburtsdatum='" + getGeburtsdatum() + "'"
                + ", versorgungspunkte='" + getVersorgungspunkte() + "'" + ", adressId='" + getAdressId() + "'"
                + ", rentenart='" + getRentenart() + "'" + ", versicherungsstatus='" + getVersicherungsstatus() + "'"
                + ", arbeitgebers'" + getArbeitgebers() + "'" + ", arbeitgeber='" + getArbeitgebers() + "'"
                + "}";
    }

}
