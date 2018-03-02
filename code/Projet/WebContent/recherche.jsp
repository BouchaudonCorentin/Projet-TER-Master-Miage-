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
    <link href="ressources/css/recherche.css" rel="stylesheet">
    <link href="resources/js/recherche.js" rel="stylesheet">



  </head>
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
  
  </body>
</html>
  
