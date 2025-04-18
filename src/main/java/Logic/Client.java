package Logic;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Logic.Stock.Transaction;

/**
 * Uplabs
 * @author DELLY213
 */

public class Client extends Personne {

    private Date dateAjout;
    private Map<Integer, Transaction> Transactions; // key is transaction reference, value is transaction itself

    public Client(String nom, String prenom, String dateDeNaissance) {
        super(nom, prenom, dateDeNaissance);
        this.dateAjout=new Date();
        this.Transactions= new HashMap<Integer, Transaction>();
    }

    public Date getDateAjout() {
        return dateAjout;
    }

    public void ajouterTransaction(Transaction t){
        this.Transactions.put(t.reference, t);
    }

    @Override
    public String toString(){
        String s = "Client N°"+this.ID+"    "+this.nom+" "+this.prenom;
        for (Map.Entry<Integer, Transaction> set : Transactions.entrySet()){
            s+="<br>"+set.getValue().toString();
        }
        return s;
    }
}
