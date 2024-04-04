package ua.m1info.cc2018.Model;

public class Producteur {
    private int id;
    private String nom; // "nom" means name in French
    private String pays; // "pays" means country in French

    // Default constructor
    public Producteur() {
    }

    // Constructor with all fields
    public Producteur(int id, String nom, String pays) {
        this.id = id;
        this.nom = nom;
        this.pays = pays;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

}
