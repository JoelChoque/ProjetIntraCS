<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="org.springframework.security.core.userdetails.User"%>
<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@page import="org.springframework.security.core.Authentication"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- pas sure style-->    

<!DOCTYPE html>
<html>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />

    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css" integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn" crossorigin="anonymous"><!-- comment -->

    <c:url var="styleCss"  value="/ressource/css/style.css"></c:url>
    <c:url var="urlImages" value="/ressource/images"/>

    <c:url  value="/Login/login" var="cheminlogin"/>
    <c:url  value="/Login/register" var="cheminregister"/>
    <c:url  value="/Login/logout" var="cheminlogout"/>

    <header>
        <title>Login Page</title>
        <style>
            .error {
                padding: 15px;
                margin-bottom: 20px;
                color: red;
            }

            .msg {
                padding: 15px;
                margin-bottom: 20px;
                color: #31708f;
                background-color:#d9edf7;
            }

            #login-box {
                width: 300px;
                padding: 20px;
                margin: 100px auto;
                background: #fff;
                -webkit-border-radius: 2px;
                -moz-border-radius: 2px;
                border: 1px solid #000;
            }
        </style>
        <!-- Navigation-->
        <div style=" height:20vh;">
            <nav  class="container navbar navbar-inverse navbar-fixed-top" style=" height:20vh; background-image: url('${urlImages}/banner2.jpg')" >

                </header> 
                <body onload='document.loginForm.username.focus();'>   
                    <div class="container" style="background-image: url('${urlImages}/fondo.jpg')">    <br/>

                        <div class="container" >
                            <h1>Welcome..!!! to admin page : ${username}</h1>
                            <div class="row">
                                <div class="mr-2">
                                    <c:url value="/Student/list" var="studentList"/>
                                    <a class="btn btn-outline-primary" href="${studentList}" >Students</a>
                                </div>
                                 <div class="mr-2">
                                    <c:url value="/Entity/list" var="entityList"/>
                                    <a class="btn btn-outline-primary" href="${entityList}" >Entitys</a>
                                </div>
                                 <div class="mr-2">
                                    <c:url value="/Activity/list" var="activityList"/>
                                    <a class="btn btn-outline-primary" href="${activityList}" >Activitys</a>
                                </div>
                                 <div class="mr-2">
                                    <c:url value="/Cesta/listActivityStudent" var="cestaList"/>
                                    <a class="btn btn-outline-primary" href="${cestaList}" >Student Activitys</a>
                                </div>
                            </div>                   
                            <p> 
                                <c:url value="/Home/accueil" var="cheminaccueil"/>
                            <p> Revenir à la page d'accueil <a href="${cheminaccueil}" >Cliquez ici!</a></p>

                            <form action="<c:url value='/Login/logout' />" method='POST'>
                                <input name="submit" type="submit" value="Logout!" />
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                            </form>
                            </p>
                        </div>
                        <jsp:include page="Footer.jsp"/>

