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
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse">
           
              <img id="logo_nav" src="resources/image/logo_N.png" >
              
            </button>
                      </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse">
            <ul class="nav navbar-nav ">
              <li class="active"><a href="#">Contact</a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a id="Documentaires">Documentaires</a></li>
                  <li><a id="Films">Films</a></li>
                  <li><a id="Series">Séries</a></li>
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
