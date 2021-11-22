/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.Facture;
import Models.LibrairieDataContext;
import Models.LivreAchete;
import Models.Panier;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maria Claudia
 */
@Controller
public class AchatController {  //OJO  INITIALISE ???
    LibrairieDataContext librairieDataContext = new LibrairieDataContext();
   // Panier panier = new Panier();
     // Panier panier ;
        
     // retourne le panier stocké dans la variable session s'il existe, sinon elle retourne un panier vide. 
  private Panier getPanier(HttpSession session){
        Panier panier;
        //Vérifier s'il y a déja un panier dans la session
        if (session.getAttribute("panier") != null){
            // récupérer le panier de la session
            panier=(Panier)session.getAttribute("panier");
       
        }else{
		panier= new Panier();		// création d'un nouveau panier
            }
          return panier;
}//getpanier
   
     //retourne une vue qui affiche la liste des livres de la table "Livres".lien "Achat" du menu principal
    @RequestMapping(value="/Achat/listeLivres", method = RequestMethod.GET) 
    public ModelAndView listeLivres(){
        // regresar nombreVista, Cle de la vue, y la lista a usar
     return new ModelAndView("ListeLivres","listeLivres",librairieDataContext.selectLivre());
    }
    
     @RequestMapping(value="/Achat/listeLivresU", method = RequestMethod.GET) 
    public ModelAndView listeLivresU(){
        // regresar nombreVista, Cle de la vue, y la lista a usar
     return new ModelAndView("ListeLivresU","listeLivres",librairieDataContext.selectLivre());
    }

  //acheterLivre,ajoute ce livre au panier stocké dans la session
    @RequestMapping(value="/Achat/acheterLivre/{isbn}", method = RequestMethod.GET)
     public  String acheterLivre(@PathVariable int isbn, HttpSession session){ 
        //Livre lv = new Livre(isbn);
         LivreAchete liv1 = new LivreAchete(isbn);
         // récupérer le panier de la session       
        Panier panier=this.getPanier(session);
     
        // ajouter livre choisi dans le panier OJO IMPLEMENTER METHODE DANS DATACONTEXT
          panier.ajouter(liv1);
        //remettre le panier dans la session pour la prochaine requête
        session.setAttribute("panier", panier);
        // se rediriger vers la méthode liste
        return "redirect:/Achat/listeLivres"; 
    }
 
     //paiement,retourne une vue avec un formulaire pour saisir les informations du client et du paiement 
    @RequestMapping(value="/Achat/paiement", method = RequestMethod.GET)
    public ModelAndView paiement(){
        return new ModelAndView("Paiement");
    }
    
    @RequestMapping(value="/Achat/paiement", method = RequestMethod.POST)
    public ModelAndView paiement(@ModelAttribute("myform") Facture facture){ //Aoute quoi avant/apres facture ?
         Facture f =new Facture(facture.getNumFacture(),facture.getTelephone(),facture.getNomClient(),facture.getAdresse(),
                                facture.getEmail(),facture.getMontantht(),facture.getMttaxe());
        //codigo
        librairieDataContext.insertFacture(f);
    
//pour Details ???? ***********************************************????????????????
                return new ModelAndView("Confirmation");
    }
   
  
   //afficherPanier, retourne la vue "AfficherPanier" en lui envoyant le contenu du panier du session
    @RequestMapping(value="/Achat/afficherPanier", method = RequestMethod.GET)
    public ModelAndView afficherPanier(HttpSession session){
       ModelAndView pagePanier = new ModelAndView("AfficherPanier");
       // récupérer le panier de la session
       Panier panier=this.getPanier(session);
       pagePanier.addObject("listeLivres",panier.getListe());
        return pagePanier;
    }
    
     //Supprimer,comme paramètre l'isbn du livre à supprimer du panier(session). redirige vers la méthode d'action "afficherPanier
    @RequestMapping(value="/Achat/supprimer", method = RequestMethod.GET)
    public String supprimer(@RequestParam int isbn, HttpSession session){
         // récupérer le panier de la session
        Panier panier=this.getPanier(session);
        // supprimer le livre du panier
        panier.supprimer(isbn);
        //remettre le panier dans la session
        session.setAttribute("panier", panier);
        return "redirect:/Achat/afficherPanier";
    }

    
    //valider,insert les informations de la facture dans la table "Factures" et les livres choisis dans la table "DetailsFacture
    //retourne vue confirmation paiment OJO FINI-LE ***************************
   
        //VIDER panier
    @RequestMapping(value="/Achat/viderPanier", method = RequestMethod.GET)
    public String viderPanier(HttpSession session){
       //supprimer le panier de la session ou vider le panier	       
       Panier panier=this.getPanier(session);
      // panier.viderPanier();
       session.removeAttribute("panier");        
       return "redirect:/Achat/listeLivres";
    }
}
