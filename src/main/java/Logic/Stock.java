package Logic;

/**
 *
 * @author dijaleo
 */

import java.util.HashMap; 

public class Stock implements stockInterface{
    HashMap<Integer, Integer> Produits; //key is product reference, and value is the available quantity in stock

    public Stock(){
        this.Produits=new HashMap<Integer, Integer>(); //initialize the hashmap
    }

    @Override
    public boolean ajouterProduit(Produit p) {
        if(!Produits.containsKey(p.getRef())){ //check if element is not already present
            Produits.put(p.getRef(), 0); //add the new element
            return true; //exit method with true signal
        }
        else return false; //if element already exists, exit with false signal
    }

    @Override
    public boolean retirerProduit(Produit p) {
        if(Produits.containsKey(p.getRef())){ //check if element is indeed present
            Produits.remove(p.getRef()); //remove the element using its reference
            return true; //exit method with true signal
        }
        else return false; //if element does not exist or the key was associated with null, exit method with false signal
    }

    @Override
    public boolean achatProduit(Produit p, int q) {
        if(Produits.containsKey(p.getRef()) && q>0){ //check if the element already exists and the quantity to be bought is strictly superior to 0
            Produits.replace(p.getRef(), Produits.get(p.getRef())+q); //replace old quantity with the new one by adding the old quantity to the quantity bought
            return true; //exit method with true signal
        }
        else return false; //if element does not exist, or quantity<=0, exit method with false signal
    }

    @Override
    public boolean venteProduit(Produit p, int q) {
        if(Produits.containsKey(p.getRef()) && q>0){ //check if element already exists and the quantity to be sold is strictly superior to 0
            Produits.replace(p.getRef(), Produits.get(p.getRef())-q); //replace old quantity with the new one by adding the old quantity to the quantity sold
            return true; //exit method with true signam
        }
        else return false; //if element does not exist, or quantity<=0, exit method with false signal
    }

    @Override
    public boolean deteriorationProduit(Produit p, int q) {
        return venteProduit(p, q);
    }

}
