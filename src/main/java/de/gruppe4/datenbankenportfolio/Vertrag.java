package de.gruppe4.datenbankenportfolio;

import java.sql.Date;

import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vertrag")
@Data
@NoArgsConstructor
public class Vertrag {
    @Id
    @Column(name = "VertragsId")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vertragsId;

    // @Column(name = "VersicherungsNr")
    private int versicherungsNr;

    @Column(name = "Abschlussdatum")
    private Date abschlussdatum;

    @Column(name = "Vertragsstatus")
    private String vertragsstatus;

    @Column(name = "Vertragstyp")
    private String vertragstyp;

    @ManyToOne
    @JoinColumn(name = "VersicherungsNr", insertable = false, updatable = false)
    private Versicherter versicherter;
    


    public int getVertragsId() {
        return this.vertragsId;
    }

    public void setVertragsId(int vertragsId) {
        this.vertragsId = vertragsId;
    }


    public int getVersicherungsNr() {
        return this.versicherungsNr;
    }

    public void setVersicherungsNr(int versicherungsNr) {
        this.versicherungsNr = versicherungsNr;
    }


    public Date getAbschlussdatum() {
        return this.abschlussdatum;
    }

    public void setAbschlussdatum(Date abschlussdatum) {
        this.abschlussdatum = abschlussdatum;
    }


    public String getVertragsstatus() {
        return this.vertragsstatus;
    }

    public void setVertragsstatus(String vertragsstatus) {
        this.vertragsstatus = vertragsstatus;
    }


    public String getVertragstyp() {
        return this.vertragstyp;
    }

    public void setVertragstyp(String vertragstyp) {
        this.vertragstyp = vertragstyp;
    }


    public Versicherter getVersicherter() {
        return this.versicherter;
    }

    public void setVersicherter(Versicherter versicherter) {
        this.versicherter = versicherter;
    }


    @Override
    public String toString() {
        return "{" +
            " vertragsId='" + getVertragsId() + "'" +
            ", versicherungsNr='" + getVersicherungsNr() + "'" +
            ", abschlussdatum='" + getAbschlussdatum() + "'" +
            ", vertragsstatus='" + getVertragsstatus() + "'" +
            ", vertragstyp='" + getVertragstyp() + "'" +
            ", versicherter='" + getVersicherter().getVorname() + " " + getVersicherter().getNachname() + "'" +
            "}";
    }

}
