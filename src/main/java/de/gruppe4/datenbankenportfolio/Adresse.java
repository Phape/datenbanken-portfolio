package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;

@Entity
@Table(name = "adresse")
public class Adresse {
    @Id
    @Column(name = "AdressId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adressId;

    @Column(name = "Straße")
    private String straße;

    @Column(name = "Hausnummer")
    private String hausnummer;

    // @Column(name = "Postleitzahl")
    private int postleitzahl;

    @ManyToOne
    @JoinColumn(name = "Postleitzahl", referencedColumnName = "Postleitzahl")
    private Ort ort;

    public Adresse() {
    }

    public Adresse(String straße, String hausnummer, int postleitzahl) {
        this.straße = straße;
        this.hausnummer = hausnummer;
        this.postleitzahl = postleitzahl;
        // this.postleitzahl=ort.getPostleitzahl();
    }

    public int getAdressId() {
        return this.adressId;
    }

    public void setAdressId(int adressId) {
        this.adressId = adressId;
    }

    public String getStraße() {
        return this.straße;
    }

    public void setStraße(String straße) {
        this.straße = straße;
    }

    public String getHausnummer() {
        return this.hausnummer;
    }

    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    public int getPostleitzahl() {
        return this.postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public Ort getOrt() {
        return this.ort;
    }

    public void setOrt(Ort ort) {
        this.ort = ort;
    }

    @Override
    public String toString() {
        return "{" + " adressId='" + getAdressId() + "'" + ", straße='" + getStraße() + "'" + ", hausnummer='"
                + getHausnummer() + "'" + ", postleitzahl='" + getOrt().getPostleitzahl() + "'" + ", ort='"
                + getOrt().getOrtsname() + "'" + "}";
    }
}
