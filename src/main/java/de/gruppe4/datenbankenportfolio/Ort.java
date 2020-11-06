package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;

import lombok.NoArgsConstructor;

import java.util.List;
import java.io.Serializable;
import java.util.ArrayList;

@Entity
@Table(name = "ort")
@NoArgsConstructor
@SuppressWarnings("serial")
public class Ort implements Serializable{

    @Id
    @Column(name = "Postleitzahl", unique = true)
    private int postleitzahl;

    @Column(name = "Ortsname", nullable=false)
    private String ortsname;

    @OneToMany(mappedBy = "ort", cascade=CascadeType.ALL)
    private List<Adresse> adressen = new ArrayList<Adresse>();



    public Ort() {
    }

    public Ort(int postleitzahl, String ortsname, List<Adresse> adressen) {
        this.postleitzahl = postleitzahl;
        this.ortsname = ortsname;
        this.adressen = adressen;
    }
    

    
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
