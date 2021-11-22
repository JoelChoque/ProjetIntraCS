/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Models.AuthenticationErrorModel;
import Models.MyAuthenticationProvider;
import Models.Usager;
import Models.UserManager;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Maria Claudia
 */
@Controller
public class LoginController {
    AuthenticationProvider myprovider;
    UserManager usermanager;
    public LoginController(){
        this.myprovider=new MyAuthenticationProvider();
        this.usermanager=new UserManager();
    }

    @RequestMapping(value="Login/login", method = RequestMethod.GET)
    public ModelAndView login( @RequestParam(value="loginError",required=false, defaultValue="false") String loginError) {
        ModelAndView view =new ModelAndView("Login");
        if (loginError.equals("true")){
            // informer la vue login qu'il y a une erreur pour afficher le message
            view.addObject("loginError","true" );
        }
        return view;
    }
@RequestMapping(value="Login/login", method = RequestMethod.POST)
    public String login(HttpServletRequest req, HttpServletResponse response) {
    
    try{
        // créer un usager à base d'un username et un password
        String username=req.getParameter("username");
        String password =req.getParameter("password");
        Usager user= new Usager(username, password,new ArrayList());
        Authentication authentication =  new UsernamePasswordAuthenticationToken(user,password, new ArrayList());
        //La crétion du jeton d'authentification si possible
        myprovider.authenticate(authentication );
        req.setAttribute("username",username);
        //Lire l'url d'origine pour une redirection après une authentification réussie
        SavedRequest savedRequest = new HttpSessionRequestCache().getRequest(req, response);
        return "redirect:"+(savedRequest!=null?savedRequest.getRedirectUrl():"/Home/accueil");
        //return "accueil";
    }catch( AuthenticationException ex){
        HttpSession session=req.getSession(true);
        session.setAttribute("LoginErrorMessage", ex.getMessage());
        
       // return "redirect:Home/login?loginError=true";******************  OJO
       return "redirect:Login/login?loginError=true"; //CHANGÉ
       } 
    }

    @RequestMapping(value="Login/logout", method = RequestMethod.POST)
    public String logout (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){ 
            //supprimer le jeton d'authentification
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/Home/accueil";
    }

@RequestMapping(value="Login/register", method = RequestMethod.GET)
    public ModelAndView register( @RequestParam(value="registerError",required=false, defaultValue="false") String registerError) {
        ModelAndView view= new ModelAndView("Register");
        if (registerError.equals("true"))
            view.addObject("registerError","true" );
        return view; 
    }

    @RequestMapping(value="Login/register", method = RequestMethod.POST)
    public String register(HttpServletRequest req, HttpSession session) {
        
    try{
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String courriel=req.getParameter("courriel");
        // attribuer le role ROLE_USER par défaut au nouveau usager
        List<GrantedAuthority> authorities= new ArrayList();
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        Usager myuser=new Usager(username, password,true,courriel,authorities);
        this.usermanager.createUser(myuser);
        return "Accueil"; //CHANGÉ
    }catch(IncorrectResultSizeDataAccessException ex){
      //  HttpSession session=req.getSession(true);
       // session.setAttribute("AuthError", new AuthenticationErrorModel(ex.getMessage()));
          session.setAttribute("AuthError", new AuthenticationErrorModel(ex.getMessage()));
              return "redirect:Login/register?registerError=true";
       }
    }   
    @RequestMapping(value="Login/error403", method = RequestMethod.GET)
    //public ModelAndView Erreur() { ****//CHANGÉ
      public ModelAndView error403() {     
        ModelAndView view = new ModelAndView("error403");
        Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
        Usager user=(Usager)authentication.getPrincipal();
        view.addObject("username",  user.getUsername());    
        return view;
     
    }

}
