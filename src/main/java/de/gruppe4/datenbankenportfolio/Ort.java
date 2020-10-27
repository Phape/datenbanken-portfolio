package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ort")
@Data //Wird benutzt um Getter, Setter und toString im Hintergrund zu erzeugen
@NoArgsConstructor
public class Ort {
    @Id
    @Column(name = "Postleitzahl")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postleitzahl;

    @Column(name = "Ortsname")
    private String ortsname;

}
