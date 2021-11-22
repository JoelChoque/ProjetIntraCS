<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- pas sure style-->    

<jsp:include page="Header2.jsp"/> 
<c:url  value="/Cesta/Activity/delete" var="activityDelete"/>
<c:url  value="/Activity/list" var="activityList"/>
<div class="container" style="margin-top: 15px">
    <h2>My Activitys</h2>
    <div class="form-group">
        <a href="${activityList}">Volver</a>
    </div>    
    <table class="table">
        <thead class="thead-dark">
            <tr class="text-center">
                <th>#</th>
                <th>Student</th>
                <th>Entidad</th>
                <th>Name</th>
                <th>Date Ini</th>
                <th>Date Fin</th>
                <th>Action</th>
            </tr>
        </thead>
        <c:forEach var="cesta" items="${activitys}" varStatus="r">
            <tr>
                <th>${r.index+1}</th>
                <th>${cesta.student.name}</th>
                <td>${cesta.activity.entity.name}</td>
                <td>${cesta.activity.name}</td>
                <td>${cesta.activity.date_ini}</td>
                <td>${cesta.activity.date_fin}</td>
                <td class="text-center">
                    <a href="${activityDelete}?idStudent=${cesta.student.id_student}&idActivity=${cesta.activity.id_activity}"><i class="fas fa-trash-alt"></i></a>
                </td>
            </tr>
        </c:forEach>    
    </table>  
</div>
<jsp:include page="Footer2.jsp"/>