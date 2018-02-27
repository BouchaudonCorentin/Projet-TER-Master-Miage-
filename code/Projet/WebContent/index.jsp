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
    <link href="resources/css/index.css" rel="stylesheet">
  </head>
  
  <c:if test = "${echec_connection == true}">
    <script>
    	alert("Erreur : Utilisateur ou mot de passe inconnue !");
    </script>
  </c:if>

<!-- NAVBAR
================================================== -->
  <body class="bg">

    <div class="navbar-wrapper">
      <div class="contain
      er">

        <nav class="navbar navbar-inverse" role="navigation">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <a class="navbar-brand" href="#">Netflox</a>
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
			
               <ul class="nav navbar-nav"> 
				    <c:if test="${!empty sessionScope.client}">
					   <li> <a href="/monCompte">Bienvenue ${sessionScope.client.pseudo} !</a> </li>
					   
					   <c:if test = "${sessionScope.status.categorie == 'inscrit'}">
					   		<button type="button" class="btn btn-primary">Premium</button>
				   	   </c:if>	
					   <button type="button" class="btn btn-danger">Deconnection</button>     	
					</c:if>
					<c:if test="${empty sessionScope.client}">
						<button id="signbtn" type="button" class="btn btn-primary btn-lg round" data-toggle="modal" data-target="#signModal">Sign in / Sign up</button>
				    </c:if>
				</ul> 
                
          </div><!-- /.navbar-collapse -->
        </nav>

      </div>
    </div>


    <!-- Carousel
    ================================================== -->
    <div id="myCarousel" class="carousel slide" data-ride="carousel">
      <!-- Indicators -->
      <ol class="carousel-indicators">
        <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
        <li data-target="#myCarousel" data-slide-to="1"></li>
        <li data-target="#myCarousel" data-slide-to="2"></li>
      </ol>
      <div class="carousel-inner" role="listbox">

        <div class="item active">
          <img class="first-slide" src="Affiche/1.jpg" alt="First slide">
          <div class="container">

            <div class="carousel-caption">
                <h2 id="#C_nom">Star Wars - Les Derniers Jedi </h2>
                <article id="#C_article"> Synopsis : Les héros du Réveil de la force rejoignent les figures légendaires de la galaxie dans
                  une aventure épique qui révèle des secrets ancestraux sur la Force et entraîne de surpren...</article>
              <p><a class="btn btn-primary btn-lg round" href="infoVideo.html" role="button">Lire plus</a></p>
            </div>
          </div>
        </div>
        <div class="item">
          <img class="second-slide" src="/Affiche/2.jpg" alt="Second slide">
          <div class="container">
            <div class="carousel-caption">
              <p><a class="btn btn-primary btn-lg round" href="infoVideo.html" role="button">Lire plus</a></p>
            </div>
          </div>
        </div>

      </div>
      <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
        <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
        <span class="sr-only">Previous</span>
      </a>
      <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
        <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
        <span class="sr-only">Next</span>
      </a>
    </div><!-- /.carousel -->



  <!--  ================================================== -->
    <!--Video contener -->

    <div class="container marketing">

      <div class="col-sm-12">
      	<c:forEach var="v" items="${videos}">
      	  <div class="card card-1">
          	<img class="card card-1" src="Affiche/${v.id}.jpg">
          </div>
		</c:forEach>
      </div>



<!----------------------------inscription connection--------------------------------------------------------->
      <div class="modal fade" id="signModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">

            <div class="modal-body">
              <div class="cotn_principal">
                <div class="cont_centrar">
                  <div class="cont_login">

                    <div class="cont_info_log_sign_up">
                      <div class="col_md_login">
                        <div class="cont_ba_opcitiy">
                          <h2>LOGIN</h2>
                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                          <button class="btn_login" onclick="change_login()">LOGIN</button>
                        </div>
                      </div>

                      <div class="col_md_sign_up">
                        <div class="cont_ba_opcitiy">
                          <h2>SIGN UP</h2>
                          <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
                          <button class="btn_sign_up" onclick="change_sign_up()">SIGN UP</button>
                        </div>
                      </div>
                    </div>

                  <div class="cont_back_info">
                     <div class="cont_img_back_grey">
                       <img src="resources/image/image_Film.jpg" alt="" />
                     </div>
                  </div>

                  <div class="cont_forms" >
                    <div class="cont_img_back_">
                      <img src="resources/image/image_Film.jpg" alt="" />
                    </div>

                    <div class="cont_form_login">
                      <a href="#" onclick="hide_login_sign_up()" ><i class="material-icons">X</i></a>
                      <h2>LOGIN</h2>
                      <form method="post" action="Connection">
	                      <input  class="form-control input-sm chat-input" name="pseudo" type="text" placeholder="Pseudo" />
	                      </br>
	                      <input class="form-control input-sm chat-input" name="mdp" type="password" placeholder="Password" />
	                        </br>
	                      <button type="submit" class="btn_login">LOGIN</button>
                      </form>
                    </div>
<!-- verification si le client est co ( pas de bouton ou deco) -->
                    <div class="cont_form_sign_up">
                      <a  onclick="hide_login_sign_up()"><i class="material-icons">X</i></a>
                      <h2>SIGN UP</h2>
                      <form method="post" action="Inscription" >
	                      <input class="form-control input-sm chat-input" name="nom" type="text" placeholder="First Name" />
	                      </br>
	                      <input class="form-control input-sm chat-input" name="prenom" type="text" placeholder="Last Name" />
	                      </br>
	                      <input class="form-control input-sm chat-input"  name="pseudo" type="text" placeholder="Nickname" />
	                      </br>
	                      <input class="form-control input-sm chat-input"  name="email" type="text" placeholder="Email" />
	                      </br> 
	                      <input class="form-control input-sm chat-input" name="mdp"type="password" placeholder="Password" />
	                      </br>  
	                      <input class="form-control input-sm chat-input" name="verimdp" type="password" placeholder="Confirm Password" />
	                      </br>  
	                      <button  type="submit" class="btn_sign_up">SIGN UP</button>
                      </form>
                    </div>

                  </div>
                </div>
               </div>
             </div>
            </div>

          </div>
        </div>
      </div>


      <!-- FOOTER -->
      <footer>
        <p class="pull-right"><a href="#">Back to top</a></p>
        <p>&copy; 2016 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>

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
