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
public class Facture {
    private int numFacture;
    private String telephone;
    private String nomClient;
    private String adresse;
    private String email;
    private double montantht;
    private double mttaxe;

    public Facture(int numFacture, String telephone, String nomClient, String adresse, String email, double montantht, double mttaxe) {
        this.numFacture = numFacture;
        this.telephone = telephone;
        this.nomClient = nomClient;
        this.adresse = adresse;
        this.email = email;
        this.montantht = montantht;
        this.mttaxe = mttaxe;
    }

    public Facture() {
    }

    public int getNumFacture() {
        return numFacture;
    }

    public void setNumFacture(int numFacture) {
        this.numFacture = numFacture;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

     public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getMontantht() {
        return montantht;
    }

    public void setMontantht(double montantht) {
        this.montantht = montantht;
    }

    public double getMttaxe() {
        return mttaxe;
    }

    public void setMttaxe(double mttaxe) {
        this.mttaxe = mttaxe;
    }
    
     public Facture FactureMapper(HttpServletRequest request){
    
       int numFacture =Integer.parseInt(request.getParameter("numFacture"));
       String telephone =request.getParameter("telephone");
       String nomClient =request.getParameter("nomClient");
       String adresse=request.getParameter("adresse");
       String email=request.getParameter("photo");
      double montantht =Double.parseDouble("montantht"); 
      double mttaxe =Double.parseDouble("mttaxe");
        
       return new Facture(numFacture,telephone,nomClient,adresse,email,montantht,mttaxe);
    }
    
}
