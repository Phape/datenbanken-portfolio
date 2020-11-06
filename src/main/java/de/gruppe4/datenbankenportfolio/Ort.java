package de.gruppe4.datenbankenportfolio;

import javax.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "ort")

@SuppressWarnings("serial")
public class Ort implements Serializable {

    @Id
    @Column(name = "Postleitzahl", unique = true)
    private int postleitzahl;

    @Column(name = "Ortsname", nullable = false)
    private String ortsname;

    public Ort() {
    }

    public Ort(int postleitzahl, String ortsname) {
        this.postleitzahl = postleitzahl;
        this.ortsname = ortsname;
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
        return "{" + " postleitzahl='" + getPostleitzahl() + "'" + ", ortsname='" + getOrtsname() + "'" + "}";
    }
}
