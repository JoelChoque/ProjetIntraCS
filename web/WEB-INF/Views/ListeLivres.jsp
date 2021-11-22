<%-- 
    Document   : ListeLivre
    Created on : Oct 15, 2021, 7:22:40 PM
    Author     : Maria Claudia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%--  LIENS URL --%>

<jsp:include page="Header.jsp"/>

    <c:url var="listePanierUrl" value="/Achat/afficherPanier"/>
    <c:url var="ajouterPanierUrl" value="/Achat/acheterLivre"/>
   <div class="container">
		<h1>La liste des Livres</h1>
                <p>
                    <a href="${listePanierUrl}">Voir Panier</a>
                    <h3>Panier :${panier.getListe().size()}</h3>
                </p>

		<table class="table table-striped">
			<thead>
				<tr>
					<th>ISBN</th>
					<th>Auteur</th>
					<th>Titre</th>
                                        <th>Prix</th>
                                        <th>Quantite</th>
                                        <th>Photo</th>
                                        <th>Resume</th>
				</tr>
	 		</thead>

			<c:forEach var="livre" items="${listeLivres}">
			    <tr>
				<td>${livre.isbn}</td>
				<td>${livre.auteur}</td>
				<td>${livre.titre}</td>
                                <td>${livre.prix}</td>
                                <td>${livre.quantite}</td>
                                <td>${livre.photo}</td>
                                <td>${livre.resum}</td>
				<td><a class="btn btn-danger" href="${ajouterPanierUrl}/${livre.isbn}">Ajouter</a></td>
                             </tr>
			</c:forEach>
		</table>

	</div>
<jsp:include page="Footer.jsp"/>

