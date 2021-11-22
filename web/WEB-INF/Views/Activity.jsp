<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- pas sure style-->    

<jsp:include page="Header2.jsp"/> 
<c:url  value="/Activity/register" var="activityregister"/>
<c:url  value="/Activity/edit" var="activityedit"/>
<c:url  value="/Activity/delete" var="activitydelete"/>
<c:url  value="/Home/admin" var="cheminadmin"/>
<div class="container" style="margin-top: 15px">
    <h2>Activitys</h2>
    <div class="form-group">
        <a class="btn btn-success mr-2" href="${activityregister}">Agregar Nuevo</a>
        <a href="${cheminadmin}">Volver</a>
    </div>    
    <table class="table">
        <thead class="thead-dark">
            <tr>
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
                    <a href="${activityedit}/${activity.id_activity}"><i class="fas fa-edit"></i></a>
                    <a href="${activitydelete}?id=${activity.id_activity}"><i class="fas fa-trash-alt"></i></a>
                </td>
            </tr>
        </c:forEach>    
    </table>  
</div>
<jsp:include page="Footer2.jsp"/>