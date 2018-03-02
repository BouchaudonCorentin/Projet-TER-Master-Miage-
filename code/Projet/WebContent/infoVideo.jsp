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
            <a class="navbar-brand" href="/Projet-TER/Home">Netflox</a>
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <li class="active"><a href="#">Link</a></li>
              <li><a href="#">Link</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="#">Documentaires</a></li>
                  <li><a href="#">Films</a></li>
                  <li><a href="#">Séries</a></li>
                </ul>
              </li>
            </ul>
            <div class="col-sm-3 col-md-3">
                <form class="navbar-form" role="search">
                <div class="input-group">
                    <input type="text" class="form-control" placeholder="Search" name="q">
                    <div class="input-group-btn">
                        <button class="btn btn-default" type="submit"><i class="glyphicon glyphicon-search"></i></button>
                    </div>
                </div>
                </form>
            </div>
           
       <!-- bouton de la navbar -->
			
               <ul class="nav navbar-nav navbar-right "> 
				    <c:if test="${!empty sessionScope.client}">
					   <li> <a href="/Projet-TER/monCompte">Bienvenue ${sessionScope.client.pseudo} !</a> </li>	
					   <a type="button" class="btn btn-danger" href="/Projet-TER/Deconnection">Deconnection</a>	
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
           <p id="text"><B>Prix location : ${louer}</B></p>
           <p id="text"><B>Prix achat : ${achat}</B></p>
          <p id="text"><B>Synopsis : ${resume}</B></p>
           </br>
          <p id="text"> <B>EPISODE : ${ep}</B></p>
          <p id="text"><B>SAISON : ${saison}</B></p>


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
           	<a class="btn pulse-button"  id="rent" href="/Projet-TER/Payement?type=Location&id=${id}"></a>
          	<a class="btn pulse-button"  id="dwl" href="/Projet-TER/Payement?type=Achat&id=${id}"></a>
         </c:if>
         <c:if test ="${sessionScope.status.getCategorie() == 'premium'}">
        	<a class="btn pulse-button"  id="Premium" href="/Projet-TER/AfficheVideo?idvideo=${id}"></a>
         </c:if>
         <c:if test ="${sessionScope.status.getCategorie() == 'administrateur'}">
        	<a class="btn pulse-button"  id="Premium" href="/Projet-TER/AfficheVideo?idvideo=${id}"></a>
         </c:if>
        </div>

      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a>Terms</a></p>
      </footer>

    </div><!--container -->


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="bootstrap/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="resources/bootstrap/js/bootstrap.min.js"></script>
    <script src="ressources/js/infoVideo.js"></script>
  </body>
</html>