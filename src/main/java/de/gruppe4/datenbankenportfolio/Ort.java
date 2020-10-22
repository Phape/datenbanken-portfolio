package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "ort")
@Data
public class Ort {
    @Id
    @Column(name = "Postleitzahl")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postleitzahl;

    @Column(name = "Ortsname")
    private String ortsname;

}
