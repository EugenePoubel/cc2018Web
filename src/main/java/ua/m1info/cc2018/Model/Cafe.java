package ua.m1info.cc2018.Model;

public class Cafe {
    private int id;
    private String nom;
    private Producteur producteur;
    private int intensite; // Intensity of the coffee, scale of 1 to 10
    private int amertume;

    private int acidite;

    private int corps;

    private int torrefaction;

    private String description;

    private int note;



    // Constructeur par défaut
    public Cafe() {
    }

    // Constructor


    public Cafe(int id, String nom, Producteur producteur, int intensite, int amertume, int acidite, int corps, int torrefaction, String description, int note) {
        this.id = id;
        this.nom = nom;
        this.producteur = producteur;
        this.setIntensite(intensite);
        this.setAmertume(amertume);
        this.setAcidite(acidite);
        this.setCorps(corps);
        this.setTorrefaction(torrefaction);
        this.description = description;
        this.note = note;
    }

    // Getter and setter for intensite
    public int getIntensite() {
        return intensite;
    }

    public void setIntensite(int intensite) {
        if (intensite >= 1 && intensite <= 10) {
            this.intensite = intensite;
        } else {
            throw new IllegalArgumentException("Intensité doit être entre 1 et 10.");
        }
    }

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

    public Producteur getProducteur() {
        return producteur;
    }

    public void setProducteur(Producteur producteur) {
        this.producteur = producteur;
    }

    public int getAmertume() {
        return amertume;
    }

    public void setAmertume(int amertume) {
        if (amertume >= 1 && amertume <= 5) {
            this.amertume = amertume;
        } else {
            throw new IllegalArgumentException("Amertume doit être entre 1 et 5.");
        }
    }

    public int getAcidite() {
        return acidite;
    }

    public void setAcidite(int acidite) {
        if (acidite >= 1 && acidite <= 5) {
            this.acidite = acidite;
        } else {
            throw new IllegalArgumentException("Acidité doit être entre 1 et 5.");
        }
    }

    public int getCorps() {
        return corps;
    }

    public void setCorps(int corps) {
        if (corps >= 1 && corps <= 5) {
            this.corps = corps;
        } else {
            throw new IllegalArgumentException("Corps doit être entre 1 et 5.");
        }
    }

    public int getTorrefaction() {
        return torrefaction;
    }

    public void setTorrefaction(int torrefaction) {
        if (torrefaction >= 1 && torrefaction <= 5) {
            this.torrefaction = torrefaction;
        } else {
            throw new IllegalArgumentException("Torrefaction doit être entre 1 et 5.");
        }
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNote() {
        return note;
    }

    public void setNote(int note) {
        if (note >= 1 && note <= 5) {
            this.nom = nom;
        } else {
            throw new IllegalArgumentException("La note doit être entre 1 et 5.");
        }
    }
}
