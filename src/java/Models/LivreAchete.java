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
public class LivreAchete {
    LibrairieDataContext dc = new LibrairieDataContext();

    private int isbn;
      private String titre;
      private double prix;

      //constructeur !
    public LivreAchete( int  isbn, String titre, double prix) {
        this.titre =titre;
        this.isbn = isbn;
        this.prix = prix;
    }
    
    //constructeur pour voir la liste du panier livreachete
    public LivreAchete(int isbn) {
       this.isbn = isbn;
      this.titre = dc.getLivre(isbn).getTitre();
    this.prix = dc.getLivre(isbn).getPrix();
        
    }
    

    public LivreAchete() {}

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

     
    public  int  getIsbn() {
        return isbn;
    }

    public void setIsbn( int  isbn) {
        this.isbn = isbn;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
      
    public LivreAchete LivreMapper(HttpServletRequest request){
     int isbn =Integer.parseInt(request.getParameter("isbn"));
       String titre =request.getParameter("titre");
       double prix =Double.parseDouble("prix");
      
       return new LivreAchete (isbn,titre,prix);
    }
    
    
}
