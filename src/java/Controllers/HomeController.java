package Controllers;

import Models.Usager;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maria Claudia
 */
@Controller
public class HomeController {
//      @RequestMapping(value="/Home/accueil", method=RequestMethod.GET)
//      public ModelAndView accueil(){
//            return new ModelAndView("Accueil");
//      }
//}

      @RequestMapping(value="/Home/home", method=RequestMethod.GET)
      public ModelAndView home(){
            
//            if(role == USER_ROLE){
//                return new ModelAndView("PageU");
//            }
            return new ModelAndView("Home");
      }
      
     
    @RequestMapping(value="/Home/accueil", method = RequestMethod.GET)
    public String accueil(ModelMap model) {
        // la lecture du jeton d'authentification s'il existe
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if (authentication!=null){
            // la lecture du username
            String username=authentication.getName();
            //Envoyer le username à la vue
            model.addAttribute("username",  username);
        }
        
        return "Accueil";
     
    }
    @RequestMapping(value="/Home/user", method = RequestMethod.GET)
    public String securedUser(ModelMap model) {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if (authentication!=null){
            Usager user=(Usager)authentication.getPrincipal();  
            model.addAttribute("username",  user.getUsername());
        }
        
        return "pageU";
     
    }

    @RequestMapping(value="/Home/admin", method = RequestMethod.GET)
    public String securedAdmin(ModelMap model) {
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        if (authentication!=null){
            //User user=(User)authentication.getPrincipal();   
            UserDetails user=(UserDetails)authentication.getPrincipal();   
            model.addAttribute("username",  user.getUsername());
        }
        return "pageA";
     
    }

    
}//HomeController
