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

    <!-- Bootstrap core CSS -->
    <link href="ressources/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="ressources/css/standard.css" rel="stylesheet">
    <link href="ressources/css/infoVideo.css" rel="stylesheet">
  </head>
<!-- NAVBAR
================================================== -->
  <body class="bg">
    <div class="navbar-wrapper">
      <div class="container">

        <nav class="navbar navbar-inverse" role="navigation">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">Netflox</a>
          </div>

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
          </div>

      </div>



    <div class="container marketing">


        <div>
          <img id="prezImg" src="../Affiche/1.jpg">
          <h2 id="nom">Star Wars - Les Derniers Jedi </h2>
          <article id="text"> Synopsis : Les hÃ©ros du RÃ©veil de la force rejoignent les figures lÃ©gendaires de la galaxie dans
            une aventure Ã©pique qui rÃ©vÃ¨le des secrets ancestraux sur la Force et entraÃ®ne de surpren...</article>


            <ul class="rate-area">
            <input type="radio" id="5-star" name="rating" value="5" /><label for="5-star" title="Amazing">5 stars</label>
            <input type="radio" id="4-star" name="rating" value="4" /><label for="4-star" title="Good">4 stars</label>
            <input type="radio" id="3-star" name="rating" value="3" /><label for="3-star" title="Average">3 stars</label>
            <input type="radio" id="2-star" name="rating" value="2" /><label for="2-star" title="Not Good">2 stars</label>
            <input type="radio" id="1-star" name="rating" value="1" /><label for="1-star" title="Bad">1 star</label>

            </ul>
        </div>

        <div id="btnscol">
          <a class="btn pulse-button"  id="rent" href="payement/payement.html"></a>
          <a class="btn pulse-button"  id="dwl" href="payement/payement.html"></a>
          <a class="btn pulse-button"  id="Premium" href="payement/payement.html"></a>
        </div>

      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

    </div><!--container -->


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="bootstrap/assets/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="ressources/bootstrap/js/bootstrap.min.js"></script>
    <script src="ressources/js/infoVideo.js"></script>
  </body>
</html>
