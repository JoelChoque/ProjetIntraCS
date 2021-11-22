<%-- 
    Document   : Administration
    Created on : Oct 17, 2021, 8:21:49 PM
    Author     : Maria Claudia
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%--  LIENS URL --%>

<jsp:include page="Header.jsp"/>

    <c:url var="listePanierUrl" value="/Achat/afficherPanier"/>
    <c:url var="ajouterLivreUrl" value="/Admin/ajouterLivres"/>
    <c:url var="supprimerLivreUrl" value="Admin/delete"/>
    <c:url var="updateLivreUrl" value="Admin/update"/>
      <c:url  value="/Login/logout" var="cheminlogout"/>
	<div class="container">
		<h1>La liste des Livres test</h1>
                <p>
                <a href="${ajouterLivreUrl}" class="btn btn-primary">Ajouter Livre</a>
              
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
		<!--		<td><a class="btn btn-danger" href="${supprimerLivreUrl}/${livre.isbn}" onclick="return confirm('Voulez-vous supprimer ce livre?');">Supprimer</a></td>
                                <td><a class="btn btn-primary" href="${updateLivreUrl}/${livre.isbn}">Update</a></td> -->
                             </tr>
			</c:forEach>
		</table>

	</div>
<jsp:include page="Footer.jsp"/>