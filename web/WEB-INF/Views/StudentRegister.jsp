<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- pas sure style-->    
<c:url var="styleCss"  value="/ressource/css/style.css"></c:url>
<c:url var="urlImages" value="/ressource/images"/>

<c:url  value="/Login/login" var="cheminlogin"/>
<c:url  value="/Login/register" var="cheminregister"/>
<c:url  value="/Login/logout" var="cheminlogout"/>
<c:url  value="/Student/list" var="StudentList"/>

<jsp:include page="Header2.jsp"/> 
<div class="container mt-4">
    <form name="student" action="/ProjetIntraCS/Student/save" method="POST">
        <div class="card border-primary">
            <div class="card-header">
                <h5>${title}</h5>
            </div>
            <div class="card-body text-primary">
                <div class="form-row">
                    <input type="hidden" name="id_student" value="${student.id_student}"  class="form-control">
                    <div class="col-md-6 mb-3">
                        <label>First name</label>
                        <input type="text" name="name" value="${student.name}"  class="form-control" required="">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Email</label>
                        <input type="email" name="email" value="${student.email}" class="form-control" required="">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Telphone</label>
                        <input type="text" name="telephone" value="${student.telephone}" class="form-control" required="" >
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Sexo</label>
                        <select class="form-control" name="sexo">
                            <option value="M">Male</option>
                            <option value="F">Feminine</option>
                        </select>
                    </div> 
                    <c:if test="${student.id_student==0}">
                        <div class="col-md-6 mb-3">
                            <label>Username</label>
                            <input type="text" name="username" value="${student.usager.username}" class="form-control" required="" >
                        </div>
                        <div class="col-md-6 mb-3">
                            <label>Password</label>
                            <input type="password" name="password" value="${student.usager.password}" class="form-control" required="" >
                        </div>
                    </c:if>

                </div>    
            </div>
            <div class="card-footer">
                <a class="btn btn-danger" href="${StudentList}">Cancel</a>
                <input type="submit" name="submit" value="save" class="btn btn-primary">
            </div>
        </div>    
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>

<jsp:include page="Footer2.jsp"/>