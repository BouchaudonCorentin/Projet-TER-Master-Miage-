<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

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
		         
		               <div class="navbar-header">
		                 <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
		                   <span class="sr-only">Toggle navigation</span>
		                   <span class="icon-bar"></span>
		                   <span class="icon-bar"></span>
		                   <span class="icon-bar"></span>
		                 </button>
		                 <a class="navbar-brand" href="/index">Netflox</a>
		               </div>
		
		               <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
		                 <ul class="nav navbar-nav">
		                   <li class="active"><a href="#">Link</a></li>
		                   <li><a href="#">Link</a></li>
		                   <li class="dropdown">
		                     <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
		                     <ul class="dropdown-menu">
		                       <li><a href="/recherche?Documentaire">Documentaires</a></li>
		                       <li><a href="recherche?Film">Films</a></li>
		                       <li><a href="recherche?serie">Séries</a></li>
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
		               </div><!-- /.navbar-collapse -->
		             </nav>
		
		           </div>
		
		         </div>

        <img id="logo" src="resources/image/logo_N.png" >

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

        <button id="btn_sub" class="btn btn-danger btn-lg " onclick="">S'abonner</button>
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
