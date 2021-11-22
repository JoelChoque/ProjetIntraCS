<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="Header.jsp"/>



<div class="container" >
<h1>Formulaire Modifier Livre!</h1>

 <div class="col-md-6 col-sm-12 col-lg-"/>
    <div class="container" >
   
       
       <form id="myform" name="myform" method="post" action="/ProjetIntraCS/Admin/update" > 
          <table>
                 <div class="form-group">
                  <label for="isbn">ISBN</label>
                  <input  id="isbn" name="isbn" class="form-control" readonly value="${livre.isbn}">
                </div>                   
              <div class="form-group">
                  <label for="auteur">Auteur</label>
                  <input  id="auteur" name="auteur" class="form-control" type="text" value="${livre.auteur}">
                </div>
              <div class="form-group">
                  <label for="titre">Titre</label>
                  <input id="titre" name="titre" class="form-control" type="text" value="${livre.titre}">
                </div>
                 <div class="form-group">
                  <label for="prix">Prix</label>
                  <input id="prix" name="prix" class="form-control" type="text" value="${livre.prix}">
                </div>
                 <div class="form-group">
                  <label for="quantite">Quantité:</label>
                  <input id="quantite" name="quantite" class="form-control" type="text" value="${livre.quantite}">
                </div> 
                 <div class="form-group">
                  <label for="photo">Photo</label>
                  <input id="photo" name="photo" class="form-control" type="text" value="${livre.photo}">
                </div>   
               <div class="form-group">
                  <label for="resum">Resume</label>
                  <input id="resum" name="resum" class="form-control" type="text" value="${livre.resum}">
                </div> 
          </table>
    <button  type="submit" name="submit"  class="btn btn-primary center" >Update</button><br> <br>
    <button  type="reset" name="annuler" class="btn btn-danger center" onclick="return confirm('Voulez-vous effacer tous les champs?');">Annuler</button>
  </form>
          
      </div>
     </div>
   </div>
<jsp:include page="Footer.jsp"/>

