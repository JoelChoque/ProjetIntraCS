/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author Maria Claudia
 */
public class Panier {

    // la liste des livres achetés
private List<LivreAchete>  liste  =new ArrayList(); 
//private List<LivreAchete> liste =new ArrayList();// initialise la liste
     public Panier() { } 
//constructeur   
public Panier(List<LivreAchete> liste) {
        this.liste = liste;
    }
//metod ajouter Livre achete
        public void ajouter(LivreAchete livre)
        { 
            this.liste.add(livre);
            
        }
    
        public void supprimer(int isbn)
        {
            this.liste.remove(this.liste.stream().filter(p->p.getIsbn()==isbn).findFirst().get());
        }
         //méthode d'accès pour la propriété "liste"
      public List<LivreAchete> getListe()
        {
            return this.liste;
        }
        //méthode valider tous les éléments de la liste
        public void viderPanier()
        {
            this.liste.clear();
           
        }
        
        //ojo ****************
    public boolean isPresent(int isbn){ 
    Stream<LivreAchete> isbn2 = this.liste.stream().filter(p->p.getIsbn()==isbn);
        if(isbn2!= null){return false;}
        else {
            return true;
    }
    }
    
 
}//panier
 