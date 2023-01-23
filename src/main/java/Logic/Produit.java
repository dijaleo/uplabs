package Logic;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * Uplabs
 * @author Aymen
 */
public class Produit {
    
    //attribut
    private String nom;
    private String description;
    private String catégorie;
    private int ref; //référence
    private double prix;

    //constructeur
    public Produit(String nom, String description, String catégorie, double prix, int reference) {
        this.nom = nom;
        this.description = description;
        // moved trimming and making category lower case to here, makes more sense
        this.catégorie = (catégorie.toLowerCase()).trim();
        this.prix = prix;
        this.ref=reference;
    }
    
    //getter and setter
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCatégorie() {
        return catégorie;
    }

    public void setCatégorie(String catégorie) {
        this.catégorie = catégorie;
    }

    public int getRef() {
        return ref;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    @Override
    public String toString(){
        return this.ref+"   "+this.nom+"    "+this.prix+"DA     "+this.catégorie+"\n"+this.description;
    }
}