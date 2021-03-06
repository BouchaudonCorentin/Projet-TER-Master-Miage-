<!-- author  Mathilde Pechdimaldjian -->
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Netflox</title>

    <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/recherche.css" rel="stylesheet">    
    <link href="resources/css/standard.css" rel="stylesheet">
    <link href="resources/css/index.css" rel="stylesheet">



  </head>
  <body class="bg">
	 <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse" role="navigation">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <a class="navbar-brand" href="/Netflox/Home">Netflox</a>
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
           <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
             <li class="active"><a href="/Netflox/Contact">Contactez nous </a></li></ul>
               <ul class="nav navbar-nav navbar-right ">
				    <c:if test="${!empty sessionScope.client}">
					   <li> <a href="/Netflox/CompteClient">Bienvenue ${sessionScope.client.pseudo} !</a> </li>
                 <c:if test="${!empty sessionScope.parrain}">
                   <li> <a href="/Netflox/CompteClient">Vous avez ${sessionScope.parrain.nbpoints} point(s) de parrainage !</a> </li>
                </c:if>
					   <c:if test = "${sessionScope.status.categorie == 'inscrit'}">
					    <a href="/Netflox/Subscribe" type="button" class="btn btn-primary">Premium</a>
				   	   </c:if>
				   	    <c:if test = "${sessionScope.status.categorie == 'administrateur'}">
					   	 <a href="/Netflox/Administration" class="btn btn-primary">administration</a>
				   	   </c:if>
					   <a type="button" class="btn btn-danger" href="/Netflox/Deconnection">Deconnection</a>
					</c:if>

				</ul>

          </div><!-- /.navbar-collapse -->
        </nav>

      </div>
    </div>
    <div class="container marketing">

      <div class="col-sm-12">
      	<c:forEach var="v" items="${videos}">
      	  <div class="card card-1">
      	 	 <a href="/Netflox/DetailVideo?idVideo=${v.id}" id="p-film"><b>${v.nomVideo}</b></a>	
      	 	 			<c:if test = "${v.numepisode != 0}"><p style="padding-left:5%; color=#FFFF;">épisode n°${v.numepisode} </p></c:if>
          	<img id="image-card" src="Affiche/${v.id}.jpg">
          </div>
		</c:forEach>
      </div>
     </div>

  
  </body>
</html>
  
