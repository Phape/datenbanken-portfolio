package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "arbeitgeber")
@Data //Wird benutzt um Getter, Setter und toString im Hintergrund zu erzeugen
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

}
