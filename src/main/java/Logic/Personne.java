/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logic;


/**
 * Uplabs
 * @author dijaleo
 */

//imports et bibliothèques
import java.util.Date; //pour la manipulation des dates de naissance
import java.text.ParseException;
import java.text.SimpleDateFormat;

public abstract class Personne {
    
    //attributs
    protected String nom, prenom;
    protected Date dateDeNaissance; //le type peut changer
    protected int ID;
    protected static int i=0;
    
    //méthodes
    public Personne(String nom, String prenom, String dateDeNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        try {
            this.dateDeNaissance= new SimpleDateFormat("dd/MM/yyyy").parse(dateDeNaissance);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.ID=i++;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Date getDateDeNaissance() {
        return dateDeNaissance;
    }

    public void setDateDeNaissance(Date dateDeNaissance) {
        this.dateDeNaissance = dateDeNaissance;
    }
    
    public int getID(){
        return this.ID;
    }
}
