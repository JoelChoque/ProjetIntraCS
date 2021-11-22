<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- pas sure style-->    

<jsp:include page="Header2.jsp"/> 
<c:url  value="/Cesta/list" var="cestaList"/>
<c:url  value="/Activity/addCesta" var="addCesta"/>
<c:url  value="/Home/accueil" var="homeAccueil"/>
<div class="container" style="margin-top: 15px">
    <h2>Activitys</h2>
    <div class="form-group">
        <a class="btn btn-success mr-2" href="${cestaList}"><i class="fas fa-cart-arrow-down"></i> Cart  <span class="badge badge-light">${countCart}</span></a>
        <a href="${homeAccueil}">Volver</a>
    </div>    
    <table class="table">
        <thead class="thead-dark">
            <tr class="text-center">
                <th>#</th>
                <th>Entidad</th>
                <th>Name</th>
                <th>Date Ini</th>
                <th>Date Fin</th>
                <th>Action</th>
            </tr>
        </thead>
        <c:forEach var="activity" items="${activitys}">
            <tr>
                <th>${activity.id_activity}</th>
                <td>${activity.entity.name}</td>
                <td>${activity.name}</td>
                <td>${activity.date_ini}</td>
                <td>${activity.date_fin}</td>
                <td class="text-center">
                    <a class="btn btn-outline-danger btn-sm" href="${addCesta}/${activity.id_activity}"><i class="fas fa-cart-plus"></i> add to cart</a>                    
                </td>
            </tr>
        </c:forEach>    
    </table>  
</div>
<jsp:include page="Footer2.jsp"/>