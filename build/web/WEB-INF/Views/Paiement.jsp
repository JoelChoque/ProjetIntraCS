
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="Header.jsp"/>



<div class="container" >
<h1>Formulaire ajouter information du client!</h1>

 <div class="col-md-6 col-sm-12 col-lg-"/>
    <div class="container" >
           
       <form id="myform" name="myform" method="post" action="/ProjetIntraCS/Achat/paiement"> 
          <table>
                                    
              <div class="form-group">
                  <label for="numFacture">Num Facture</label>
                  <input id="numFacture" name="numFacture" class="form-control" type="text">
                </div>
              <div class="form-group">
                  <label for="telephone">Telephone</label>
                  <input id="telephone" name="telephone" class="form-control" type="text">
                </div>
                 <div class="form-group">
                  <label for="nomClient">Nom Complete du Client</label>
                  <input id="nomClient" name="nomClient" class="form-control" type="text">
                </div>
                 <div class="form-group">
                  <label for="adresse">Adresse:</label>
                  <input id="adresse" name="adresse" class="form-control" type="text">
                </div> 
                 <div class="form-group">
                  <label for="email">Email</label>
                  <input id="email" name="email" class="form-control" type="text">
                </div>   
               <div class="form-group">
                  <label for="montantht">Montant ht</label>
                  <input id="montantht" name="montantht" class="form-control" type="text">
                </div> 
              <div class="form-group">
                  <label for="mttaxe">Montant taxe</label>
                  <input id="mttaxe" name="mttaxe" class="form-control" type="text">
                </div> 
          </table>
    <button  type="submit" name="submit"  class="btn btn-primary center" >Ajouter</button><br> <br>
    <button  type="reset" name="annuler" class="btn btn-danger center" onclick="return confirm('Voulez-vous effacer tous les champs?');">Annuler</button>
    
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
  </form>
          
      </div>
     </div>
   </div>
<jsp:include page="Footer.jsp"/>