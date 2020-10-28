package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "arbeitgeber")
@NoArgsConstructor
public class Arbeitgeber {
    @Id
    @Column(name = "Arbeitgeber_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int arbeitgeberId;

    @Column(name = "Firmenname")
    private String firmenname;

    @Column(name = "Adress_ID")
    private int adressId;

    @Column(name = "Abrechnungsverband")
    private String abrechnungsverband;

    @Column(name = "Mitarbeiter_Nr")
    private int mitarbeiterNr;

    // @ManyToOne
    // @JoinColumn(name = "Adress_ID")
    // private Adresse adresse;


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

    public String getAbrechnungsverband() {
        return this.abrechnungsverband;
    }

    public void setAbrechnungsverband(String abrechnungsverband) {
        this.abrechnungsverband = abrechnungsverband;
    }

    public int getMitarbeiterNr() {
        return this.mitarbeiterNr;
    }

    public void setMitarbeiterNr(int mitarbeiterNr) {
        this.mitarbeiterNr = mitarbeiterNr;
    }

    @Override
    public String toString() {
        return "{" +
            " arbeitgeberId='" + getArbeitgeberId() + "'" +
            ", firmenname='" + getFirmenname() + "'" +
            ", adressId='" + getAdressId() + "'" +
            ", abrechnungsverband='" + getAbrechnungsverband() + "'" +
            ", mitarbeiterNr='" + getMitarbeiterNr() + "'" +
            "}";
    }
}
