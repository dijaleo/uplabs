package Logic;

/**
 * Uplabs
 * @author dijaleo
 */

public interface stockInterface {
    public boolean ajouterProduit(Produit p);
    public boolean retirerProduit(Produit p);
    public boolean achatProduit(Produit p, int q);
    public boolean venteProduit(Produit p, int q);
    public boolean deteriorationProduit(Produit p, int q);
}
