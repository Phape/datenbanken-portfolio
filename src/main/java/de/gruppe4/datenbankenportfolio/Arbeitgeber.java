package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "arbeitgeber")
@NoArgsConstructor
public class Arbeitgeber {
    @Id
    @Column(name = "ArbeitgeberId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int arbeitgeberId;

    @Column(name = "Firmenname")
    private String firmenname;

    // @Column(name = "AdressId")
    private int adressId;

    // @Column(name = "MitarbeiterNr")
    private int mitarbeiterNr;

    @Column(name = "Abrechnungsverband")
    private String abrechnungsverband;

    @ManyToOne
    @JoinColumn(name = "MitarbeiterNr")
    private KeyAccountManager keyAccountManager;

    @ManyToOne
    @JoinColumn(name = "AdressId")
    private Adresse adresse;



    public int getArbeitgeberId() {
        return this.arbeitgeberId;
    }

    public void setArbeitgeberId(int arbeitgeberId) {
        this.arbeitgeberId = arbeitgeberId;
    }


    public String getFirmenname() {
        return this.firmenname;
    }

    public void setFirmenname(String firmenname) {
        this.firmenname = firmenname;
    }


    public int getAdressId() {
        return this.adressId;
    }

    public void setAdressId(int adressId) {
        this.adressId = adressId;
    }


    public int getMitarbeiterNr() {
        return this.mitarbeiterNr;
    }

    public void setMitarbeiterNr(int mitarbeiterNr) {
        this.mitarbeiterNr = mitarbeiterNr;
    }


    public String getAbrechnungsverband() {
        return this.abrechnungsverband;
    }

    public void setAbrechnungsverband(String abrechnungsverband) {
        this.abrechnungsverband = abrechnungsverband;
    }


    public KeyAccountManager getKeyAccountManager(int mitarbeiterNr) {
        return this.keyAccountManager;
    }

    public void setKeyAccountManager(KeyAccountManager keyAccountManager) {
        this.keyAccountManager = keyAccountManager;
    }


    public Adresse getAdresse(int adressId) {
        return this.adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }


    @Override
    public String toString() {
        return "{" +
            " arbeitgeberId='" + getArbeitgeberId() + "'" +
            ", firmenname='" + getFirmenname() + "'" +
            ", adressId='" + getAdressId() + "'" +
            ", abrechnungsverband='" + getAbrechnungsverband() + "'" +
            ", mitarbeiterNr='" + getKeyAccountManager(mitarbeiterNr) + "'" +
            ", adresse=" + getAdresse(adressId) + "'" +
            "}";
    }
}
