<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- pas sure style-->    
<c:url var="styleCss"  value="/ressource/css/style.css"></c:url>
<c:url var="urlImages" value="/ressource/images"/>

<c:url  value="/Login/login" var="cheminlogin"/>
<c:url  value="/Login/register" var="cheminregister"/>
<c:url  value="/Login/logout" var="cheminlogout"/>

<c:url  value="/Entity/list" var="EntityList"/>

<jsp:include page="Header2.jsp"/> 
<div class="container mt-4">
    <form name="entity" action="/ProjetIntraCS/Entity/save" method="POST">
        <div class="card border-primary">
            <div class="card-header">
                <h5>${title}</h5>
            </div>
            <div class="card-body text-primary">
                <div class="form-row">
                    <input type="hidden" name="id_entity" value="${entity.id_entity}"  class="form-control">
                    <div class="col-md-6 mb-3">
                        <label>First name</label>
                        <input type="text" name="name" value="${entity.name}"  class="form-control" required="">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Email</label>
                        <input type="email" name="email" value="${entity.email}" class="form-control" required="">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Adress</label>
                        <input type="text" name="adress" value="${entity.adress}" class="form-control" required="" >
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Telphone</label>
                        <input type="text" name="telephone" value="${entity.telephone}" class="form-control" required="" >
                    </div>                     
                </div>    
            </div>
            <div class="card-footer">
                <a class="btn btn-danger" href="${EntityList}">Cancel</a>
                <input type="submit" name="submit" value="save" class="btn btn-primary">
            </div>
        </div>    
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>

<jsp:include page="Footer2.jsp"/>