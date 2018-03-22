<!-- author  Mathilde Pechdimaldjian -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="fr">
  <head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Netflox</title>

    <!-- Bootstrap core CSS -->
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="resources/css/standard.css" rel="stylesheet">
    <link href="resources/css/infoVideo.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body class="bg">

    <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse" role="navigation">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <a class="navbar-brand" href="/Projet/Home"">Netflox</a>
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
             <li class="active"><a href="/Projet/Contact">Contactez nous </a></li></ul> 
               <ul class="nav navbar-nav navbar-right "> 
				    <c:if test="${!empty sessionScope.client}">
					   <li> <a href="/Projet/CompteClient">Bienvenue ${sessionScope.client.pseudo} !</a> </li>
					      <li> <a>Vous avez ${sessionScope.client.pseudo} point(s) !</a> </li>
					   <c:if test = "${sessionScope.status.categorie == 'inscrit'}">
					    <a href="/Projet/Subscribe" type="button" class="btn btn-primary">Premium</a>
				   	   </c:if>
				   	    <c:if test = "${sessionScope.status.categorie == 'administrateur'}">
					   	 <a href="/Projet/Administration" class="btn btn-primary">administration</a>
				   	   </c:if>	
					   <a type="button" class="btn btn-danger" href="/Projet/Deconnection">Deconnection</a>	
					</c:if>
					
				</ul> 
                
          </div><!-- /.navbar-collapse -->
        </nav>

      </div>
    </div>
   
  <div class="container marketing">


        <div>
          <img id="prezImg" src="Affiche/${id}.jpg">
          <h2 id="nom"> <B>${nom}</B></h2>
           <p id="text"><B>Prix location : ${p_louer}</B></p>
           <p id="text"><B>Prix achat : ${p_achat}</B></p>
          <p id="text"><B>Synopsis : ${resume}</B></p>
           </br>
          <p id="text"> <B>EPISODE : ${ep}</B></p>
          <p id="text"><B>SAISON : ${saison}</B></p>
            <p id="text"> <B>VUES : ${vue}</B></p>
          <p id="text"><B>TELECHARGEMENT : ${dl}</B></p>


            <ul class="rate-area">
            <input type="radio" id="5-star" name="rating" value="5" /><label for="5-star" title="Amazing">5 stars</label>
            <input type="radio" id="4-star" name="rating" value="4" /><label for="4-star" title="Good">4 stars</label>
            <input type="radio" id="3-star" name="rating" value="3" /><label for="3-star" title="Average">3 stars</label>
            <input type="radio" id="2-star" name="rating" value="2" /><label for="2-star" title="Not Good">2 stars</label>
            <input type="radio" id="1-star" name="rating" value="1" /><label for="1-star" title="Bad">1 star</label>

            </ul>
        </div>

        <div id="btnscol">
        
         <c:if test = "${sessionScope.status.getCategorie() == 'inscrit'}" >
         			
			      <c:choose>
			    	<c:when test = "${achat == true}">
			       		<button class="btn btn-default btn-danger" type="submit">TELECHARGER</button>
			    	</c:when>
			    	<c:when test = "${louer == true}">
			       		<a href="/Projet/AfficheVideo?idvideo=${id}" class="btn btn-default btn-danger" type="submit">REGARDER</a>
			    	</c:when>
			    	<c:otherwise>
			       			<a class="btn pulse-button"  id="rent" href="/Projet/Payement?type=Location&id=${id}"></a>
			          		<a class="btn pulse-button"  id="dwl" href="/Projet/Payement?type=Achat&id=${id}"></a>
			          		<a class="btn pulse-button"  id="parrain" href="/Projet/Payement?type=Parrain&id=${id}"></a>
			   		 </c:otherwise>
				</c:choose>
         </c:if>			
		         
         <c:if test ="${sessionScope.status.getCategorie() == 'premium'}">
        	<a class="btn pulse-button"  id="Premium" href="/Projet/AfficheVideo?idvideo=${id}"></a>
         </c:if>
         <c:if test ="${sessionScope.status.getCategorie() == 'administrateur'}">
        	<a class="btn pulse-button"  id="Premium" href="/Projet/AfficheVideo?idvideo=${id}"></a>
         </c:if>
  
       

     

    </div><!--container -->


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="bootstrap/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="ressources/js/infoVideo.js"></script>
  </body>
</html>