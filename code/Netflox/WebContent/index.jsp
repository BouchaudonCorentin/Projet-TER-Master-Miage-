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
    <link href="resources/css/index.css" rel="stylesheet">
  </head>


  		 <c:if test = "${echec_connection == true}">
			 <div class="alert alert-danger alert-dismissible">
   			 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  	 	 	<strong>Connection Impossible!</strong> Mot de passe ou pseudo incorrect.
	 	 	</div>

  		</c:if>
  		 <c:if test = "${echec_inscription == true}">
			 <div class="alert alert-danger alert-dismissible">
   			 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  	 	 	<strong>Inscription impossible!</strong> Pseudo déja utilisé.
	 	 	</div>

  		</c:if>

  		<c:if test = "${echec_password == true}">
			 <div class="alert alert-danger alert-dismissible">
   			 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  	 	 	<strong>Attention!</strong> La saisie de la verification du mot de passe est incorrect.
	 	 	</div>

  		</c:if>

  		 <c:if test = "${echec_parrain == true}">
			 <div class="alert alert-danger alert-dismissible">
   			 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  	 	 	<strong>Parrainage impossible</strong> Verifiez que le nom est correct.
	 	 	</div>

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
            <a class="navbar-brand" href="/Netflox/Home">Netflox</a>
          </div>

          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
             <li class="active"><a href="/Netflox/Contact">Contactez nous </a></li>
              <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Catégorie <b class="caret"></b></a>
                <ul class="dropdown-menu">
                  <li><a href="/Netflox/Recherche?cat=3">Documentaires</a></li>
                  <li><a href="/Netflox/Recherche?cat=1">Films</a></li>
                  <li><a href="/Netflox/Recherche?cat=2">Séries</a></li>
                </ul>
              </li>
               <li class="dropdown">
                <a href="#" class="dropdown-toggle" data-toggle="dropdown">MotClefs<b class="caret"></b></a>
                <ul class="dropdown-menu" >
                <form action="/Netflox/Recherche?cat=motsclefs" method="post">
                  <li id="checkbox" class="form-check"><input type="checkbox" name="check" value="2"> Action</li>
                  <li id="checkbox" class="form-check"><input type="checkbox" name="check" value="5"> Animation</li>
                  <li id="checkbox" class="form-check"><input type="checkbox" name="check" value="1"> Aventure</li>
                  <li id="checkbox" class="form-check"><input type="checkbox" name="check" value="8"> Comédie</li>
                  <li id="checkbox" class="form-check"><input type="checkbox" name="check" value="9"> Drame</li>
                  <li id="checkbox" class="form-check"><input type="checkbox" name="check" value="6"> Fantastique</li>
                  <li id="checkbox" class="form-check"><input type="checkbox" name="check" value="4"> Enfant</li>
                  <li id="checkbox" class="form-check"><input type="checkbox" name="check" value="10"> Historique</li>
                  <li id="checkbox" class="form-check"><input type="checkbox" name="check" value="12"> Information</li>
                  <li id="checkbox" class="form-check"><input type="checkbox" name="check" value="7"> Policier</li>
                  <li id="checkbox" class="form-check"><input type="checkbox" name="check" value="3"> Science-fiction</li>
                  <li id="checkbox" class="form-check"><input type="checkbox" name="check" value="11"> Thiller</li>
                  <li> <button id="checkbox" type="submit" class="btn btn-default btn-danger">CHERCHER</button></li>
       				</form>
                </ul>
              </li>

            </ul>
       <!-- bouton de la navbar -->

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


      	<c:forEach var="c" items="${carroussel}" varStatus="s">
        <div class="item <c:if test = "${carsl_supp[s.index] == 'first'}"> <c:out value='active' /></c:if>">
          <img class="${carsl_supp[s.index]}-slide" src="Affiche/${c.id}.jpg" alt="slide">
          <div class="container">

            <div class="carousel-caption">
                <h2>${c.nomVideo}</h2>
                <p style="font-size:12px;"> Synopsis : ${c.resume}</p>
              <p><a class="btn btn-primary btn-lg round" href="/Netflox/DetailVideo?idVideo=${c.id}" role="button">Lire plus</a></p>
            </div>
          </div>
        </div>
		</c:forEach>

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
    <!--Video container -->

    <div class="container marketing">

      <div class="col-sm-12">
      	<c:forEach var="v" items="${videos}">
      	  <div class="card card-1">
      	 	 <a href="/Netflox/DetailVideo?idVideo=${v.id}" id="p-film">${v.nomVideo} </a>
          	<img id="image-card" src="Affiche/${v.id}.jpg">
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

                          <button class="btn_login" onclick="change_login()">LOGIN</button>
                        </div>
                      </div>

                      <div class="col_md_sign_up">
                        <div class="cont_ba_opcitiy">
                          <h2>SIGN UP</h2>

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
	                      <input  class="form-control input-sm chat-input" name="pseudo" type="text" placeholder="Pseudo" required />
	                      </br>
	                      <input class="form-control input-sm chat-input" name="mdp" type="password" placeholder="Password" required />
	                        </br>
	                      <button type="submit" class="btn_login">LOGIN</button>
                      </form>
                    </div>
<!-- verification si le client est co ( pas de bouton ou deco) -->
                    <div class="cont_form_sign_up">
                      <a  onclick="hide_login_sign_up()"><i class="material-icons">X</i></a>
                      <h2>SIGN UP</h2>
                      <form method="post" action="Inscription" >
	                      <input class="form-control input-sm chat-input" name="nom" type="text" placeholder="First Name" required />
	                      </br>
	                      <input class="form-control input-sm chat-input" name="prenom" type="text" placeholder="Last Name" required/>
	                      </br>
	                      <input class="form-control input-sm chat-input"  name="pseudo" type="text" placeholder="Nickname" required />
	                      </br>
	                      <input class="form-control input-sm chat-input"  name="email" type="text" placeholder="Email" required/>
	                      </br>
	                      <input class="form-control input-sm chat-input" name="mdp" type="password" placeholder="Password" required/>
	                      </br>
	                      <input class="form-control input-sm chat-input" name="verimdp" type="password" placeholder="Confirm Password" required />
	                      </br>
	                       <input class="form-control input-sm chat-input" name="parrain" type="text" placeholder="Pseudo parrain"/>

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
