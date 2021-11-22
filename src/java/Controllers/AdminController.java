/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.LibrairieDataContext;
import Models.Livre;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maria Claudia
 */
@Controller
public class AdminController {
    LibrairieDataContext librairieDataContext = new LibrairieDataContext();

 @RequestMapping(value ="/Admin/liste",method =RequestMethod.GET)
  public ModelAndView liste(){  
 return new ModelAndView("ListeLivres","listeLivres",librairieDataContext.selectLivre());
    }
  
  @RequestMapping(value ="/Admin/livres",method =RequestMethod.GET)
  public ModelAndView livres(){  
 return new ModelAndView("Administration","listeLivres",librairieDataContext.selectLivre());
    }
  //nous redirige vers la vue "AjouterLivre"
@RequestMapping(value = "/Admin/ajouterLivres",method =RequestMethod.GET )
    public ModelAndView ajouterLivres(){
        return new ModelAndView("AjouterLivre");
    }
    
    //ajouterLivre,Elle reçoit comme paramètre un objet de type "Livre" et l'ajoute à la table "Livres"
    @RequestMapping(value = "/Admin/ajouterLivre",method =RequestMethod.POST )
    public String ajouterLivre(@ModelAttribute("myform") Livre livre){
   
        Livre l =new Livre(livre.getIsbn(),
                livre.getAuteur(),livre.getTitre(),livre.getPrix(),
                livre.getQuantite(),livre.getPhoto(),livre.getResum());
                //livre.LivreMapper(request);*/
             
        librairieDataContext.insertLivre(l);
        return  "redirect:/Admin/liste";
    }
    
    //supprimer livre
        @RequestMapping("Admin/delete/{isbn}")
    public String delete(@PathVariable int isbn){
       librairieDataContext.delete(isbn);
        return "redirect:/Admin/liste";
    }

    //Modifier
   // @RequestMapping(value="Admin/update/{isbn}", method=RequestMethod.GET)
      @RequestMapping(value="Admin/update/{isbn}", method=RequestMethod.GET)
    public ModelAndView update(@PathVariable int isbn){
        //rechercher le produit qui correspond au numéro recu en paramètre
        Livre livre= librairieDataContext.selectByID(isbn);
        // afficher le produit dans un formulaire pour la modification
        return new ModelAndView("Modifier","livre",livre);
    }
@RequestMapping(value = "Admin/update",method =RequestMethod.POST )
    public String update(@ModelAttribute("myform") Livre livre){
        // appel de la méthode update du datacontext
        librairieDataContext.updateLivre(livre);
        return  "redirect:/Admin/liste";
    }

}
  