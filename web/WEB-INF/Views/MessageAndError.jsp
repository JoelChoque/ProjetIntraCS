<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="Header2.jsp"/> 
<div class="container mt-4">
    <div class="alert alert-danger" role="alert">
        ${mensaje}
    </div>
    <div class="mr-2">
        <c:url value="${url}" var="entityList"/>
        <a class="btn btn-outline-primary" href="${entityList}" >Return Entity</a>
    </div>
</div>
<jsp:include page="Footer2.jsp"/>
