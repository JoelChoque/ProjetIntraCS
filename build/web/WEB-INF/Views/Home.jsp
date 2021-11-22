<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "f" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!-- Définition des url pour les servlet-->
<c:url var="accueilUrl" value="/Home/home"></c:url>
<c:url var="adminUrl" value="/Admin/livres"></c:url>
<c:url var="achatUrl" value="/Achat/listeLivres"></c:url>

    <!-- pas sure style-->    
<c:url var="styleCss"  value="/ressource/css/style.css"></c:url>
<c:url var="urlImages" value="/ressource/images"/>
<c:url  value="/Login/logout" var="cheminlogout"/>

<jsp:include page="Header.jsp"/>  
<main>
        
         <!-- <div class="container d-flex align-items-center flex-column"   style="background-image: url('${urlImages}/fondo.jpg') >-->   
                
        <div class="container" style="background-image: url('${urlImages}/fondo.jpg')">   <h1>NOUS SOMMES ...</h1> <br/><br/>
       
                   <p><br>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Cursus risus at ultrices mi tempus imperdiet. Pellentesque eu tincidunt tortor aliquam nulla facilisi cras fermentum. Facilisi nullam vehicula ipsum a. 
                Eget arcu dictum varius duis at. Gravida cum sociis natoque penatibus et magnis dis. Eros donec ac odio tempor orci dapibus. Sapien nec sagittis aliquam malesuada. Eros donec ac odio tempor. Interdum consectetur libero id faucibus. 
                Semper auctor neque vitae tempus. Feugiat nisl pretium fusce id velit ut tortor.

Nulla pellentesque dignissim enim sit amet venenatis urna. Sociis natoque penatibus et magnis dis parturient. Arcu cursus vitae congue mauris. Purus non enim praesent elementum. Non sodales neque sodales ut etiam sit amet nisl. 
Non odio euismod lacinia at quis risus. Augue interdum velit euismod in pellentesque massa. Lacus suspendisse faucibus interdum posuere. Viverra nibh cras pulvinar mattis nunc sed blandit libero.<br><br> Gravida dictum fusce ut placerat.
In iaculis nunc sed augue lacus viverra vitae congue. Velit aliquet sagittis id consectetur purus ut faucibus pulvinar elementum. Enim lobortis scelerisque fermentum dui faucibus in ornare quam. Lorem sed risus ultricies tristique nulla.

Quam pellentesque nec nam aliquam sem et tortor consequat id. Facilisi morbi tempus iaculis urna id volutpat. Nulla facilisi nullam vehicula ipsum a arcu cursus vitae congue. Sit amet consectetur adipiscing elit. In tellus integer feugiat scelerisque varius.
At imperdiet dui accumsan sit amet. Integer quis auctor elit sed. Sollicitudin ac orci phasellus egestas tellus rutrum tellus. Sed adipiscing diam donec adipiscing tristique risus. Et pharetra pharetra massa massa ultricies mi quis hendrerit. 
Mi in nulla posuere sollicitudin. Faucibus turpis in eu mi bibendum neque. Maecenas pharetra convallis posuere morbi. Lacinia quis vel eros donec ac odio. Diam maecenas ultricies mi eget.<br><br> Nam libero justo laoreet sit amet cursus sit. 
Id eu nisl nunc mi ipsum faucibus. Feugiat vivamus at augue eget arcu dictum. Lacus vel facilisis volutpat est. In nisl nisi scelerisque eu ultrices vitae auctor eu.

Id donec ultrices tincidunt arcu. Et tortor consequat id porta nibh venenatis. Nunc sed velit dignissim sodales. Quam id leo in vitae turpis massa sed elementum. At tellus at urna condimentum mattis. Nec nam aliquam sem et tortor.
Nullam eget felis eget nunc lobortis. Tempor id eu nisl nunc. Pellentesque habitant morbi tristique senectus et netus et. Ut morbi tincidunt augue interdum velit euismod. Massa vitae tortor condimentum lacinia quis vel eros.

Vitae turpis massa sed elementum tempus egestas. Maecenas accumsan lacus vel facilisis volutpat. 

                    </p>
            
       </main>
<jsp:include page="Footer.jsp"/>

