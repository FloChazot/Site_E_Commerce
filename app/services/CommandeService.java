package services;

import models.Produit;
import play.libs.Codec;

import java.util.ArrayList;
import java.util.List;

public class CommandeService {

    private static CommandeService instance;

    private CommandeService() {
        produits = new ArrayList<Produit>();
    }

    public static CommandeService get() {
        if (instance == null) {
            instance = new CommandeService();
        }
        return instance;
    }

    private List<Produit> produits;

    public void addProduitToCommande(Produit produit) {
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