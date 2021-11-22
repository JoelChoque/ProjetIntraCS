<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!-- pas sure style-->    
<c:url var="styleCss"  value="/ressource/css/style.css"></c:url>
<c:url var="urlImages" value="/ressource/images"/>

<c:url  value="/Login/login" var="cheminlogin"/>
<c:url  value="/Login/register" var="cheminregister"/>
<c:url  value="/Login/logout" var="cheminlogout"/>

<c:url  value="/Activity/list" var="ActivityList"/>

<jsp:include page="Header2.jsp"/> 
<div class="container mt-4">
    <form name="activity" action="/ProjetIntraCS/Activity/save" method="POST">
        <div class="card border-primary">
            <div class="card-header">
                <h5>${title}</h5>
            </div>
            <div class="card-body text-primary">
                <div class="form-row">
                    <input type="hidden" name="id_activity" value="${activity.id_activity}"  class="form-control">
                    <div class="col-md-6 mb-3">
                        <label>Entidad</label>
                        <select class="form-control" name="id_entity">
                            <option value="0">Seleccionar</option>
                            <c:forEach var="entity" items="${entitys}">   
                                <c:if test="${activity.id_entity==entity.id_entity}">
                                    <option selected="${activity.id_entity}" value="${entity.id_entity}">${entity.name}</option>
                                </c:if>
                                <c:if test="${entity.id_entity!=activity.id_entity}">
                                    <option value="${entity.id_entity}">${entity.name}</option>
                                </c:if>
                            </c:forEach>
                        </select>
                    </div> 
                    <div class="col-md-6 mb-3">
                        <label>First name</label>
                        <input type="text" name="name" value="${activity.name}"  class="form-control" required="">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Fecha Inicio</label>
                        <input type="date" name="date_ini" value="${activity.date_ini}" class="form-control" required="">
                    </div>
                    <div class="col-md-6 mb-3">
                        <label>Fecha Fin</label>
                        <input type="date" name="date_fin" value="${activity.date_fin}" class="form-control" required="" >
                    </div>                    
                </div>    
            </div>
            <div class="card-footer">
                <a class="btn btn-danger" href="${ActivityList}">Cancel</a>
                <input type="submit" name="submit" value="save" class="btn btn-primary">
            </div>
        </div>    
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form>
</div>

<jsp:include page="Footer2.jsp"/>