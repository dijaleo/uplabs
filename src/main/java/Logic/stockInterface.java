package Logic;

/**
 * Uplabs
 * @author dijaleo
 */

public interface stockInterface {
    public boolean ajouterProduit(Produit p);
    public boolean retirerProduit(int reference);
    public boolean achatProduit(int reference, int q);
    public boolean venteProduit(int reference, int q);
    public boolean deteriorationProduit(int reference, int q);
}
