package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "ort")
@NoArgsConstructor
public class Ort {
    @Id
    @Column(name = "Postleitzahl")
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postleitzahl;

    @Column(name = "Ortsname")
    private String ortsname;


    public int getPostleitzahl() {
        return this.postleitzahl;
    }

    public void setPostleitzahl(int postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    public String getOrtsname() {
        return this.ortsname;
    }

    public void setOrtsname(String ortsname) {
        this.ortsname = ortsname;
    }

    @Override
    public String toString() {
        return "{" +
            " postleitzahl='" + getPostleitzahl() + "'" +
            ", ortsname='" + getOrtsname() + "'" +
            "}";
    }

}
