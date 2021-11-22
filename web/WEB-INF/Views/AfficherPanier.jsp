<%-- 
    Document   : AfficherPanier
    Created on : Oct 15, 2021, 7:25:44 PM
    Author     : Maria Claudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="Header.jsp"/>

             <c:url var="factureUrl" value="/Achat/paiement"></c:url>
             <c:url var="achatUrl" value="/Achat/listeLivres"></c:url>
             <c:url var="supprimerUrl" value="/Achat/supprimer"/>
             <c:url var="viderUrl" value="/Achat/viderPanier"/>
             <c:url var="accueilUrl" value="/Home/home"></c:url>
             <c:url var="adminUrl" value="/Admin/ajouterLivres"></c:url>
             <c:url var="achatUrl" value="/Achat/listeLivres"></c:url>
               <c:url  value="/Login/logout" var="cheminlogout"/>
	<div class="container">
		<h1>Liste Achats</h1>
             
              
                
                <a href="${factureUrl}"class="btn btn-primary">Paiement</a>
                <a href="${viderUrl}" class="btn btn-primary" >Vider panier</a>
                <a href="${achatUrl}" class="btn btn-primary">Retour liste Livres</a>
		<table class="table table-striped">
			<thead>
				<tr>
					<th>ISBN</th>
					<th>Titre</th>
                                        <th>Prix</th>
                                        <th>Action</th>
				</tr>
			</thead>

			<c:forEach var="livre" items="${panier.getListe()}">
			    <tr>
				<td>${livre.isbn}</td>
				<td>${livre.titre}</td>
                                <td>${livre.prix}</td>
				<td><a class="btn btn-danger"  href="${supprimerUrl}?isbn=${livre.isbn}">Supprimer</a>  </td>
                           
                            </tr>
			</c:forEach>
		</table>

	</div>
<jsp:include page="Footer.jsp"/>

