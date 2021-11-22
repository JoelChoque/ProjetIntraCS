<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- pas sure style-->    

<jsp:include page="Header2.jsp"/> 
<c:url  value="/Student/register" var="studentregister"/>
<c:url  value="/Student/edit" var="studentedit"/>
<c:url  value="/Student/delete" var="studentdelete"/>
<c:url  value="/Home/admin" var="cheminadmin"/>
<div class="container" style="margin-top: 15px">
    <h2>Students</h2>
    <div class="form-group">
        <a class="btn btn-success mr-2" href="${studentregister}">Agregar Nuevo</a>
        <a href="${cheminadmin}">Volver</a>
    </div>    
    <table class="table">
        <thead class="thead-dark">
            <tr>
                <th>#</th>
                <th>First Name</th>
                <th>Email</th>
                <th>TelPhone</th>
                <th>Sexo</th>
                <th>Action</th>
            </tr>
        </thead>
        <c:forEach var="student" items="${students}">
            <tr>
                <th>${student.id_student}</th>
                <td>${student.getName()}</td>
                <td>${student.getEmail()}</td>
                <td>${student.getTelephone()}</td>
                <td>${student.getSexo()}</td>
                <td class="text-center">
                    <a href="${studentedit}/${student.id_student}"><i class="fas fa-edit"></i></a>
                    <a href="${studentdelete}?id=${student.id_student}"><i class="fas fa-trash-alt"></i></a>
                </td>
            </tr>
        </c:forEach>    
    </table>  
</div>
<jsp:include page="Footer2.jsp"/>