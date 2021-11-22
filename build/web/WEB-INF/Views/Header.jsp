<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!-- Définition des url pour les servlet OJO ACHAT-->
<c:url var="accueilUrl" value="/Home/home"></c:url>
<c:url var="adminUrl" value="/Admin/livres"></c:url>
<c:url var="achatUrl" value="/Achat/listeLivres"></c:url>
<c:url var="cheminlogout" value="/Home/accueil" />

<!-- pas sure style-->    
<c:url var="styleCss"  value="/ressource/css/style.css"></c:url>
<c:url var="urlImages" value="/ressource/images"/>

<!DOCTYPE html>
<html>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <title>Projet Intra Login</title>
    <!-- Font Awesome icons (free version)-->
    <script src="https://use.fontawesome.com/releases/v5.13.0/js/all.js" crossorigin="anonymous"></script>
    <!-- Google fonts-->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css" />
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css" />
    <!-- Core theme CSS (includes Bootstrap)-->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">
    <header>
        <head>
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
                <div class="container">

                    <div class="navbar-collapse collapse">
                        <ul class="nav navbar-nav">
                            <li><a href="${accueilUrl}">Home</a></li>
                            <li><a href="${achatUrl}">Achat</a></li>

                            <c:if test="${not empty role or role.equals('admin')}">     
                                <li><a href="${adminUrl}">Administration</a></li>

                            </c:if>
                                        <!-- <li><a href="${adminUrl}">Administration</a></li> -->
                            <li><a href="${cheminlogout}">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </nav>  
        </div>
    </header>
    <body onload='document.loginForm.username.focus();'>     
