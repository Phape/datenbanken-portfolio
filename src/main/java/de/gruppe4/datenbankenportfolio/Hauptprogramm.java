package de.gruppe4.datenbankenportfolio;

public class Hauptprogramm {
    public static void main(String[] args) {
        App app = new App();
        app.init();
        
        System.out.println(app.readAdresse(6));
    }
}
