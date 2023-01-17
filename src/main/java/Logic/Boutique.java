package Logic;

import java.util.HashMap;
import org.apache.commons.collections4.multimap.*;
import org.apache.commons.collections4.MultiValuedMap;

/**
 *
 * @author dijaleo
 */

 public class Boutique{
    private HashMap<Integer, Produit> listeProduits; // product list, kind of like a catalog
    private MultiValuedMap<String, Integer> Categories; // product categories, each category is a key, and has an array list of products that belong to that same category

    public Boutique(){
        this.listeProduits=new HashMap<Integer,Produit>(); // initialize the product catalog
        this.Categories = new ArrayListValuedHashMap<String, Integer>(); // initialize the category list
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
        // make category in lowercase and trims any spaces at the end, automatically checks if it exists, add the product as a value
        // else, make a new category enrtry and add product's reference as its first value
        // no need to verify if the product already exists since this method is only called when adding a new product to the catalog
        this.Categories.put((p.getCatégorie().trim()).toLowerCase(), p.getRef()); 
    }
 }