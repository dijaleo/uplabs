package Logic;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.collections4.multimap.*;
import org.apache.commons.collections4.MultiValuedMap;

/**
 * Uplabs
 * @author dijaleo
 */

 public class Boutique{
    private HashMap<Integer, Produit> listeProduits; // product list, kind of like a catalog
    private MultiValuedMap<String, Integer> Categories; // product categories, each category is a key, and has an array list of products that belong to that same category
    private HashMap<Integer, Client> Clients;

    public Boutique(){
        this.listeProduits=new HashMap<Integer,Produit>(); // initialize the product catalog
        this.Categories = new ArrayListValuedHashMap<String, Integer>(); // initialize the category list
        this.Clients = new HashMap<Integer, Client>(); // initialize the customer list
    }

    public boolean nouveauProduit(Produit p){
        if(!this.listeProduits.containsKey(p.getRef())){ // check if product doesn't exist in catalog
            this.listeProduits.put(p.getRef(), p); // add the new product to the catalog
            this.nouveauProduitCategorie(p); // everytime a new product is added to the catalog, it is also added to the categories
            return true; // exit function with success signal
        }
        else return false; // if product already exists in catalog, exit function with failure signal
    }

    public void nouveauProduitCategorie(Produit p){
        // Automatically checks if category exists, add the product as a value
        // else, make a new category entry and add product's reference as its first value
        // no need to verify if the product already exists since this method is only called when adding a new product to the catalog
        this.Categories.put(p.getCatégorie(), p.getRef()); 
    }

    public boolean nouveauClient(Client c){
        // checks if customer alredy exists
        if(!this.Clients.containsKey(c.getID())){
            // if it doesn't, add it to the list of customers
            this.Clients.put(c.getID(), c);
            // exit method with success signal
            return true;
        }
        // else if customer already exists, exit method with failure signal
        else return false;
    }
    
    public boolean ajouterTransactionClient(int Matricule, Stock.Transaction t){
        // check if customer exists
        if(this.Clients.containsKey(Matricule)){
            // if it does, store it in a temp variable
            Client c=this.Clients.get(Matricule);
            // add the transaction to its list
            c.ajouterTransaction(t);
            // replace customer in current list with the temp one, with the new transaction added
            this.Clients.replace(Matricule, c);
            // exit method with sucess signal
            return true;
        }
        // if customer does not exist, exit method with failure signal
        else return false;
    }

    public boolean clientExiste(int ref){
        return this.Clients.containsKey(ref);
    }

    public Client retournerClientPourAffichage(int ref){
        return this.Clients.get(ref);
    }

    public boolean produitExiste(int ref){
        return this.listeProduits.containsKey(ref);
    }

    public Produit retournerProduitPourAffichage(int ref){
        return this.listeProduits.get(ref);
    }

    public String listeProduits(){
        String s="";
        for(Map.Entry<Integer, Produit> set : listeProduits.entrySet()){
            s+="\n"+set.getValue().toString()+"\n";
        }
        return s;
    }
 }