package services;

import models.Produit;
import play.libs.Codec;

import java.util.ArrayList;
import java.util.List;

public class ProduitService {

 private static ProduitService instance;

    private ProduitService() {
        produits = new ArrayList<Produit>();
    }

    public static ProduitService get() {
        if (instance == null) {
            instance = new ProduitService();
        }
        return instance;
    }

    private List<Produit> produits;

    public void addProduit(Produit produit) {
        produit.uuid = Codec.UUID();
        produits.add(produit);
    }

    public List<Produit> findAllProduit() {
        return produits;
    }

    public Produit getByUUID(String uuid) {
        for (Produit produit : produits) {
            if(produit.uuid.equals(uuid)) {
                return produit;
            }
        }
        return null;
    }

}