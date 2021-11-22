<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- pas sure style-->    

<jsp:include page="Header2.jsp"/> 
<c:url  value="/Entity/register" var="entityregister"/>
<c:url  value="/Entity/edit" var="entityedit"/>
<c:url  value="/Entity/delete" var="entitydelete"/>
<c:url  value="/Home/admin" var="cheminadmin"/>
<div class="container" style="margin-top: 15px">
    
    <h2>Entitys</h2>
    <div class="form-group">
        <a class="btn btn-success mr-2" href="${entityregister}">Agregar Nuevo</a>
        <a href="${cheminadmin}">Volver</a>
    </div>    
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th>#</th>
                <th>Name</th>
                <th>Email</th>
                <th>Adress</th>
                <th>Telephone</th>
                <th>Action</th>
            </tr>
        </thead>
        <c:forEach var="entity" items="${entitys}">
            <tr>
                <th>${entity.id_entity}</th>
                <td>${entity.name}</td>
                <td>${entity.email}</td>
                <td>${entity.adress}</td>
                <td>${entity.telephone}</td>
                <td class="text-center">
                    <a href="${entityedit}/${entity.id_entity}"><i class="fas fa-edit"></i></a>
                    <a href="${entitydelete}?id=${entity.id_entity}"><i class="fas fa-trash-alt"></i></a>
                </td>
            </tr>
        </c:forEach>    
    </table>  
</div>
<jsp:include page="Footer2.jsp"/>