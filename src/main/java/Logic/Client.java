package Logic;

import java.util.Date;

/**
 * Uplabs
 * @author DELLY213
 */

public class Client extends Personne {
    Date dateAjout;
    public Client(String nom, String prenom, Date dateDeNaissance) {
        super(nom, prenom, dateDeNaissance);
        this.dateAjout=new Date();
    }
    public Date getDateAjout() {
        return dateAjout;
    }
}
