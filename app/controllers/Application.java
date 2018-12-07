package controllers;

import models.Commande;
import models.Produit;
import play.mvc.Controller;
import services.CommandeService;
import services.ProduitService;

import java.util.List;

public class Application extends Controller {

    public static void index() {
        render();
    }

    //Gestion des produits
    public static void addProduit(){
        render();
    }

    public static void saveProduit(Produit produit) {
        ProduitService.get().addProduit(produit);
        listProduits();
    }

    public static void listProduits(){
        List<Produit> produits = ProduitService.get().findAllProduit();
        render(produits);
    }

    //Gestion du détail de chaque produit
    public static void detailProduit(String nom, String uuid) {
        Produit produit = ProduitService.get().getByUUID(uuid);
        render(produit);
    }

    //Gestion des commandes
    public static void saveProduittoCommande(Produit produit) {
        CommandeService.get().addProduitToCommande(produit);
        listProduits();
    }

    public static void listCommande(){
        List<Produit> produits = CommandeService.get().findAllProduit();
        render(produits);
    }
}