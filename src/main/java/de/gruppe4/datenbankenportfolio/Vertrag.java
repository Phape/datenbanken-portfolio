package de.gruppe4.datenbankenportfolio;

import java.sql.Date;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "vertrag")
@Data
public class Vertrag {
    @Id
    @Column(name = "Vertrags_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vertragsID;

    @Column(name = "Versicherungs_Nr")
    private int versicherungsNr;

    @Column(name = "Abschlussdatum")
    private Date abschlussdatum;

    @Column(name = "Vertragsstatus")
    private String vertragsstatus;

    @Column(name = "Vertragstyp")
    private String vertragstyp;

}
