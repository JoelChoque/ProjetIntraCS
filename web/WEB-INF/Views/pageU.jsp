<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!-- Définition des url pour les servlet OJO ACHAT-->


<c:url var="achatUrl" value="/Achat/listeLivres"></c:url>
<c:url var="cheminlogout" value="/Login/logout" />

<!-- pas sure style-->    
<c:url var="styleCss"  value="/ressource/css/style.css"></c:url>
<c:url var="urlImages" value="/ressource/images"/>


<jsp:include page="Header2.jsp"/>

<div class="container" style="background-image: url('${urlImages}/fondo.jpg')">    <br/>

    <div class="container" >
        <h1>Bienvenue dans la page usager ${username}</h1>

        <div class="row">
            <div class="ml-4">
                <c:url value="/Activity/list" var="activityList"/>
                <a class="btn btn-outline-primary" href="${activityList}" >See Activitys</a>
            </div>
        </div> 

        <c:url value="/Home/accueil" var="cheminaccueil"/>
        <p> Revenir à la page d'accueil <a href="${cheminaccueil}" >Cliquez ici!</a></p>


        <form action="<c:url value='/Login/logout' />" method='POST'>
            <input name="submit" type="submit" value="Logout" />
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
        </form>

    </div>
    <jsp:include page="Footer2.jsp"/>