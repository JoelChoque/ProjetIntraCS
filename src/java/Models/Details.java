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
public class Details {
    private int numFacture;
     private int isbn;
     private double prix;

    public Details(int numFacture, int isbn, double prix) {
        this.numFacture = numFacture;
        this.isbn = isbn;
        this.prix = prix;
    }

    public Details() {
    }

    public int getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(int numFacture) {
        this.numFacture = numFacture;
    }

    public  int getIsbn() {
        return isbn;
    }

    public void setIsbn( int isbn) {
        this.isbn = isbn;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
     
    public Details LivreMapper(HttpServletRequest request){
    
       int numFacture =Integer.parseInt(request.getParameter("numFacture"));
        int isbn =Integer.parseInt(request.getParameter("isbn"));
       double prix =Double.parseDouble("prix");
           
       return new Details (numFacture,isbn,prix);
    }
}
