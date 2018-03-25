<!-- author  Mathilde Pechdimaldjian -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Netflox</title>

    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="resources/css/standard.css" rel="stylesheet">
    <link href="resources/css/subscribe.css" rel="stylesheet">
  </head>

<!-- NAVBAR
================================================== -->
  <body class="bg">


  <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse" role="navigation">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <a class="navbar-brand" href="/Netflox/Home">Netflox</a>
          </div>
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
             <li class="active"><a href="/Netflox/Contact">Contactez nous </a></li></ul> 
               <ul class="nav navbar-nav navbar-right "> 
				    <c:if test="${!empty sessionScope.client}">
					   <li> <a href="/Netflox/CompteClient">Bienvenue ${sessionScope.client.pseudo} !</a> </li>
					   
					   <c:if test = "${sessionScope.status.categorie == 'inscrit'}">
					    <a href="/Netflox/Subscribe" type="button" class="btn btn-primary">Premium</a>
				   	   </c:if>
				   	    <c:if test = "${sessionScope.status.categorie == 'administrateur'}">
					   	 <a href="/Netflox/Administration" class="btn btn-primary">administration</a>
				   	   </c:if>	
					   <a type="button" class="btn btn-danger" href="/Netflox/Deconnection">Deconnection</a>	
					</c:if>
					<c:if test="${empty sessionScope.client}">
						<button id="signbtn" type="button" class="btn btn-primary btn-lg round" data-toggle="modal" data-target="#signModal">Sign in / Sign up</button>
				    </c:if>
				</ul> 
                
          </div><!-- /.navbar-collapse -->
        </nav>

      </div>
    </div>
   
        <img id="logo" src="resources/image/logo_N.png" >
			<a id="btn_sub" class="btn btn-danger btn-lg" href="/Netflox/Payement?type=Premium&id=0">S'abonner</a>
       <div id="div">
            <img id="pay" src="resources/image/pay.png" >
            <p id ="texte">10€ par mois</p>
            <img id="play" src="resources/image/play.png">
             <p id ="texte">Vidéo en illimité</p>
        </div>
        <div id="div">
            <img id="computer" src="resources/image/computer.png" >
            <p id ="texte"> Tout types d'écrans</p>

            <img id="Cat" src="resources/image/cat2.png" >
            <p id ="texte">Large choix de vidéo</p>
        </div>

        
    </div><!-- /.container -->


    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="../resources/bootstrap/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="resources/js/index.js"></script>
  </body>
</html>
