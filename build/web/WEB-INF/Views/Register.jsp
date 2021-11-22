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
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"/>

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
                            <div id="register-box">

                                <c:if test="${not empty registerError}" >
                                    <div class="error">${authErrorMessage}</div>
                                </c:if> 
                                <h2>Spring Security Register Form</h2>
                                <form name='registerForm' action="<c:url value='/Login/register' />" method='POST'>
                                    <table>
                                        <tr>
                                            <td>Le nom de l'usager:</td>
                                            <td><input type='text' name='username' value=''></td>
                                        </tr>
                                        <tr>
                                            <td>Le mot de passe:</td>
                                            <td><input type='password' name='password' /></td>
                                        </tr>
                                        <tr>
                                            <td>L'adresse courriel:</td>
                                            <td><input type='email' name='courriel' /></td>
                                        </tr>
                                        <tr>
                                            <td colspan='2'><input name="submit" type="submit" class="btn btn-primary"
                                                                   value="submit" /></td>
                                        </tr>
                                    </table>

                                    <input type="hidden" name="${_csrf.parameterName}"
                                           value="${_csrf.token}" />

                                </form>
                            </div>
                        </div>
                        <jsp:include page="Footer.jsp"/>