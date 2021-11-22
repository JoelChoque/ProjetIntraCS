<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- pas sure style-->    

<jsp:include page="Header2.jsp"/> 
<c:url  value="/Cesta/Activity/delete" var="activityDelete"/>
<c:url  value="/Activity/list" var="activityList"/>
<div class="container" style="margin-top: 15px">
    <h2>Student Activity</h2>
    <div class="form-group">
        <form action="/ProjetIntraCS/Cesta/listActivityStudent"  method="POST">
            <div class="form-inline">
                <label>Buscar Por ID Student:</label>
                <input type="text" name="txtIdStudent" class="form-control ml-2"  placeholder="001" required="">
                <button type="submit" class="btn btn-primary ml-4">Buscar</button>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
            </div>            
        </form>
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
            </tr>
        </c:forEach>    
    </table>  
</div>
<jsp:include page="Footer2.jsp"/>