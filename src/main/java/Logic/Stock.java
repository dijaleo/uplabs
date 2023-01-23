package Logic;

/**
 * Uplabs
 * @author dijaleo
 */

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

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
    public boolean retirerProduit(int reference) {
        if(Produits.containsKey(reference)){ //check if element is indeed present
            Produits.remove(reference); //remove the element using its reference
            return true; //exit method with true signal
        }
        else return false; //if element does not exist or the key was associated with null, exit method with false signal
    }

    @Override
    public boolean achatProduit(int reference, int q) {
        if(Produits.containsKey(reference) && q>0){
            Produits.replace(reference, Produits.get(reference)+q);
            return true;
        }
        else return false;
    }

    @Override @Deprecated
    public boolean venteProduit(int reference, int q) {
        if(Produits.containsKey(reference) && q>0 && Produits.get(reference)>=q){
            Produits.replace(reference, Produits.get(reference)-q);
            return true;
        }
        else return false;
    }

    @Override
    public boolean deteriorationProduit(int reference, int q) {
        return venteProduit(reference, q);
    }

    public boolean produitExiste(int ref){
        return this.Produits.containsKey(ref);
    }

    public int retournerQteStock(int ref){
        return this.Produits.get(ref);
    }

    public class Transaction{
        // key is product reference, value is quantity bought by customer
        protected HashMap<Integer, Integer> ticket; 
        protected int reference;
        protected Date date;
        private static int i=0;

        public Transaction(){
            this.ticket= new HashMap<Integer, Integer>();
            this.reference=i++;
            this.date=new Date();
        }

        public boolean vente(int ref, int qte){
             // check if element already exists and the quantity to be sold is strictly superior to 0 
             // and the quantity available in stock is superior eo equal to the quantity to be sold
            if(Produits.containsKey(ref) && qte>0 && Produits.get(ref)>=qte){
                 // replace old quantity with the new one by adding the old quantity to the quantity sold
                Produits.replace(ref, Produits.get(ref)-qte);
                // add the product's reference and the quantity bought to the ticket
                this.ticket.put(ref, qte); 
                //exit method with true signal
                return true; 
            }
            else return false; //if element does not exist, or quantity<=0, exit method with false signal
        }

        @Override
        public String toString(){
            String s = "Transaction N°"+this.reference+". Date: "+DateFormat.getDateInstance().format(this.date);
            for (Map.Entry<Integer, Integer> set : ticket.entrySet()){
                s+="\nRef: "+set.getKey()+"     Quantité: "+set.getValue();
            }
            return s;
        }
    }
}