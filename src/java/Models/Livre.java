/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author Maria Claudia
 */
public class Livre {
    private int isbn;
    private String auteur;
    private String titre;
    private double prix;
    private int quantite;
    private String photo;
    private String resum;
    
    public Livre(int isbn, String auteur, String titre, double prix, int quantite, String photo, String resum) {
        this.isbn = isbn;
        this.auteur = auteur;
        this.titre = titre;
        this.prix = prix;
        this.quantite = quantite;
        this.photo = photo;
        this.resum = resum;
    }

    public Livre() {
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getResum() {
        return resum;
    }

    public void setResume(String resum) {
        this.resum = resum;
    }
    
 public Livre LivreMapper(HttpServletRequest request){
    
       int isbn =Integer.parseInt(request.getParameter("isbn"));
       String auteur =request.getParameter("auteur");
       String titre =request.getParameter("titre");
       double prix =Double.parseDouble("prix");
       int quantite =Integer.parseInt(request.getParameter("quantite"));
       String photo=request.getParameter("photo");
       String resum =request.getParameter("resum");
       
       return new Livre (isbn,auteur,titre,prix,quantite,photo, resum);
    }
}
