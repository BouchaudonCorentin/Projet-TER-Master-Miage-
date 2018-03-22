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
      <link href="resources/css/administrateur.css" rel="stylesheet">
  	</head>
  
  
    <body class="bg">

	 <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse" role="navigation">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <a class="navbar-brand" href="/Projet/Home">Netflox</a>
          </div>

          
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
           <ul class="nav navbar-nav navbar-right "> 
				    <c:if test="${!empty sessionScope.client}">
					   <li> <a href="/Projet/CompteClient">Bienvenue ${sessionScope.client.pseudo} !</a> </li>
					   		 <c:if test="${!empty sessionScope.parrain}">
						  	 	<li> <a href="/Projet/CompteClient">Vous avez ${sessionScope.parrain.nbpoints} point(s) de parrainage !</a> </li>
						  	 </c:if>
					   <c:if test = "${sessionScope.status.categorie == 'inscrit'}">
					    <a href="/Projet/Subscribe" type="button" class="btn btn-primary">Premium</a>
				   	   </c:if>
				   	    <c:if test = "${sessionScope.status.categorie == 'administrateur'}">
					   	 <a href="/Projet/Administration" class="btn btn-primary">administration</a>
				   	   </c:if>	
					   <a type="button" class="btn btn-danger" href="/Projet/Deconnection">Deconnection</a>	
					</c:if>
					<c:if test="${empty sessionScope.client}">
						<button id="signbtn" type="button" class="btn btn-primary btn-lg round" data-toggle="modal" data-target="#signModal">Sign in / Sign up</button>
				    </c:if>
				</ul> 
                
          </div><!-- /.navbar-collapse -->
        </nav>

      </div>
    </div>
   
	
	      <div class="container">
	
	          <div class="row">
	          	<div class="col-md-12">
					<div class="panel with-nav-tabs" id="fct">
	<!-- tabbed head panel start -->
						<div class="panel-heading">
							<ul class="nav nav-tabs">
								<li class="active"><a href="#tab1default" data-toggle="tab">Achats</a></li>
								<li><a href="#tab2default" data-toggle="tab">Locations actives </a></li>
								<li><a href="#tab3default" data-toggle="tab">Locations terminées</a></li>
								<li><a href="#tab4default" data-toggle="tab">Parrainage</a></li>
								
							
								
	
							</ul>
						</div><!-- tabbed head panel end -->
						
	<!-- tabbed body panel start -->
						<div class="panel-body">
							<div class="tab-content">
								<div class="tab-pane fade in active" id="tab1default">
								<ul>
								<c:forEach var="v" items="${a}">
      	 						 <li><a href="/Projet/DetailVideo?idVideo=${v.id}" id="p-film">${v.nomVideo} </a></li>
								</c:forEach>
								</ul>
								</div>
								<div class="tab-pane fade" id="tab2default">
								<ul>
								<c:forEach var="v" items="${lc}">
      	 						 <li><a href="/Projet/DetailVideo?idVideo=${v.id}" id="p-film">${v.nomVideo} </a></li>
								</c:forEach>
								</ul>
								</div>
								<div class="tab-pane fade" id="tab3default">
								<ul>
								<c:forEach var="v" items="${lf}">
      	 						 <li><a href="/Projet/DetailVideo?idVideo=${v.id}" id="p-film">${v.nomVideo} </a></li>
								</c:forEach>
								</ul>
								</div>
								<div class="tab-pane fade" id="tab4default">
								<ul>
									<c:if test="${!empty sessionScope.parrain}">
						  	 			<li>Vous etes le parrain de <B>${neveuNom}</B> ! </li>
						  	 			<li>Vous avez <B>${sessionScope.parrain.nbpoints}</B> point(s) de parrainage ! </li>
						  	 			<li>Vous pouvez louer <B>${sessionScope.parrain.nbvideo}</B> vidéo(s) gratuitement ! </li>
						  	 		</c:if>
						  	 		<c:if test="${empty sessionScope.parrain}">
						  	 			Devenez parrain et obtenez de nombres avantages
						  	 		</c:if>
								</ul>
								</div>
								
							</div>
						</div>
					</div>
				</div>
			</div>
	
		</div>
		
		 <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <script>window.jQuery || document.write('<script src="../resources/bootstrap/assets/js/vendor/jquery.min.js"><\/script>')</script>
      <script src="resources/bootstrap/js/bootstrap.min.js"></script>
      <script src="resources/js/administration.js"></script>
	</body>
</html>
	
      