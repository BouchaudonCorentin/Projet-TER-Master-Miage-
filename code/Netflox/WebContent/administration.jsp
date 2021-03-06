   <!-- 
   # Permet d'envoyer au AdministrationTraitement les informations nécessaires pour effectuer des actions 
   #et d'avoir en retour si cela à reussi ou non pour l'indiquer à l'utilisateur 
   #  author  Mathilde Pechdimaldjian -->
   
   
   
    <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


    <!DOCTYPE html>
    <html lang="fr">
      <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
       
        <meta name="administration" content="">

          <title>Netflox</title>
         	<link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet">
          <link href="resources/css/standard.css" rel="stylesheet">
          <link href="resources/css/administrateur.css" rel="stylesheet">
        </head>
<!-- Les pop up gestion -->
  <!-- AjoutVideo -->
            
       <c:if test = "${ajout_video ==  true}">
			 <div class="alert alert-success alert-dismissible">
  		 	 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  	 	 	<strong>Success!</strong> Video ajoutée.
	 	 	</div>

  		</c:if>
  		
  		 <c:if test = "${ajout_video ==  false}">
			 <div class="alert alert-danger alert-dismissible">
   			 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  	 	 	<strong>Echec!</strong> Video n'a pas pu être ajoutée.
	 	 	</div>

  		</c:if>
<!-- SuppressionVideo -->
		   <c:if test = "${echec_suppressionVideo ==  false}">
			 <div class="alert alert-success alert-dismissible">
  		 	 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  	 	 	<strong>Success!</strong> Video supprimée.
	 	 	</div>

  		</c:if>
  		
  		 <c:if test = "${echec_suppressionVideo == true}">
			 <div class="alert alert-danger alert-dismissible">
   			 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  	 	 	<strong>Echec!</strong> Video n'a pas pu être supprimée.
	 	 	</div>

  		</c:if>

<!-- AjoutClient -->
	   <c:if test = "${echec_inscription ==  false}">
			 <div class="alert alert-success alert-dismissible">
  		 	 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  	 	 	<strong>Success!</strong> Client ajouté.
	 	 	</div>

  		</c:if>
  		
  		 <c:if test = "${echec_inscription == true}">
			 <div class="alert alert-danger alert-dismissible">
   			 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  	 	 	<strong>Echec!</strong> Client n'a pas pu être ajouté.
	 	 	</div>

  		</c:if>
<!-- SuppressionClient -->
		  
  		 <c:if test = "${echec_suppressionclient == true}">
			 <div class="alert alert-danger alert-dismissible">
   			 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  	 	 	<strong>Echec!</strong> Client n'a pas pu être supprimée.
	 	 	</div>

  		</c:if>
  		
  		 <c:if test = "${echec_suppressionclient ==  false}">
			 <div class="alert alert-success alert-dismissible">
  		 	 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
  	 	 	<strong>Success!</strong> Client supprimée.
	 	 	</div>
  		</c:if>
 

  		
 <!-- MODIFICATION VIDEO-->
	 		<c:if test = "${echec_modifierVideo ==  false}">
				 <div class="alert alert-success alert-dismissible">
	  		 	 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  	 	 	<strong>Success!</strong> Video modifiée".
		 	 	</div>
	
	  		</c:if>
	  		
	  		 <c:if test = "${echec_modifierVideo == true}">
				 <div class="alert alert-danger alert-dismissible">
	   			 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  	 	 	<strong>Echec!</strong> Video n'a pas pu être modfiée.
		 	 	</div>
	
	  		</c:if>
	 <!-- MODIFICATION CLIENT-->
	  			<c:if test = "${echec_modifierClient ==  false}">
				 <div class="alert alert-success alert-dismissible">
	  		 	 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  	 	 	<strong>Success!</strong> Client modifié.
		 	 	</div>
	
	  		</c:if>
	  		
	  		 <c:if test = "${echec_modifierClient == true}">
				 <div class="alert alert-danger alert-dismissible">
	   			 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  	 	 	<strong>Echec!</strong> Client n'a pas pu être modfié.
		 	 	</div>
	
	  		</c:if>
	  		
	 <!-- MODIFICATION PARRAIN-->
	  			<c:if test = "${echec_Parrain_r ==  true}">
				 <div class="alert alert-success alert-dismissible">
	  		 	 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  	 	 	<strong>PARRAIN</strong> Nombre de vidéo réinitialisé.
		 	 	</div>
	
	  		</c:if>
	  		
	  		 <c:if test = "${echec_Parrain_r == false}">
				 <div class="alert alert-danger alert-dismissible">
	   			 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  	 	 	<strong>Echec!</strong>Nombre de vidéo non réinitialisé.
		 	 	</div>
	
	  		</c:if>
	  		
	  		
	  		<c:if test = "${echec_Parrain_s ==  true}">
				 <div class="alert alert-success alert-dismissible">
	  		 	 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  	 	 	<strong>PARRAIN</strong> Lien entre le neveu supprimé .
		 	 	</div>
	
	  		</c:if>
	  		
	  		 <c:if test = "${echec_Parrain_s == false}">
				 <div class="alert alert-danger alert-dismissible">
	   			 <a href="#" class="close" data-dismiss="alert" aria-label="close">&times;</a>
	  	 	 	<strong>Echec!</strong>Lien entre le neveu non supprimé.
		 	 	</div>
	
	  		</c:if>
	  		 		
	  		
	  		
	  		
  
  		
<!--HTML BODY-->   		
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
             <li class="active"><a href="/Netflox/Contact">Contactez nous </a></li>
             </ul> 
               <<ul class="nav navbar-nav navbar-right ">
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
   
           

    <!-- administeur view-->

    <!-- Main content -->



      <!-- Small boxes (Stat box) -->
      <div class="row" id="smalpanel">
        <div class="col-xs-3 col-xs-3">
          <!-- small box -->
          <div class="small-box bg-aqua">
            <div class="inner">
              <h3>${nbvideo}</h3>

              <p>Videos</p>
            </div>
            <div class="icon">
              <i class="ion ion-bag"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-xs-3 col-xs-3">
          <!-- small box -->
          <div class="small-box bg-green">
            <div class="inner">
              <h3>${nbMembre}<sup style="font-size: 20px"></sup></h3>

              <p>Members</p>
            </div>
            <div class="icon">
              <i class="ion ion-stats-bars"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
        <div class="col-xs-3 col-xs-3">
          <!-- small box -->
          <div class="small-box bg-yellow">
            <div class="inner">
              <h3>${nbPremium}</h3>

              <p>Premiums</p>
            </div>
            <div class="icon">
              <i class="ion ion-person-add"></i>
            </div>
            <a href="#" class="small-box-footer">More info <i class="fa fa-arrow-circle-right"></i></a>
          </div>
        </div>
        <!-- ./col -->
      </div>
      <!-- /.row -->
      <!-- Main row-->

      <div class="container">
<!-- Panel des fonctions  -->
          <div class="row">
          	<div class="col-md-12">
				<div class="panel with-nav-tabs" id="fct">
<!-- tabbed head panel start -->
					<div class="panel-heading">
						<ul class="nav nav-tabs">
							<li class="active"><a href="#tab1default" data-toggle="tab">Ajouter video</a></li>
							<li><a href="#tab2default" data-toggle="tab">Supprimer video </a></li>
							<li><a href="#tab3default" data-toggle="tab">Ajouter User</a></li>
							<li><a href="#tab4default" data-toggle="tab">Supprimer User</a></li>
							<li><a href="#tab6default" data-toggle="tab">Modifier Client</a></li>
							<li><a href="#tab7default" data-toggle="tab">Modifier Film</a></li>
							<li><a href="#tab5default" data-toggle="tab">Parrain</a></li>
							<li><a href="#tab8default" data-toggle="tab">PDF</a></li>
							

						</ul>
					</div><!-- tabbed head panel end -->
					
<!-- tabbed body panel start -->
					<div class="panel-body">
						<div class="tab-content">
		  <!-- Panel ajouter video -->
							<div class="tab-pane fade in active" id="tab1default">
								<div id="AddVideo">	
									  <form method="post" action="/Netflox/AdministrationTraitement?action=Add_Video" >
										<input type="text" name="a_nom" class="form-control input-sm chat-input" placeholder="nom" required/>
										</br> 
										<input type="number" name="a_categorie" class="form-control input-sm chat-input"placeholder="catégorie 1=documentaire 2=film 3=série" required/> 
										</br> 
										<input type="text" name="a_motclef" class="form-control input-sm chat-input"placeholder="mots clefs" required/> 
										</br> 
										<input type="text" name="a_resume" class="form-control input-sm chat-input" placeholder="résumé" required/>
										</br>
										<input type="text" name="a_saison" class="form-control input-sm chat-input" placeholder=" saison" required/>
										</br>
										<input type="number" name="a_ep" class="form-control input-sm chat-input" placeholder=" n° episode" required/>
										</br>
										<input type="number" name="a_louer" class="form-control input-sm chat-input" placeholder=" prix location" required/>
										</br>
										<input type="number" name="a_achat" class="form-control input-sm chat-input" placeholder=" prix achat" required/>
										</br>
				                      <button  type="submit" class="btn btn-danger btn-md">Ajouter</button>
	                     			 </form>
								</div>

							</div>
			<!-- Panel Suppression video -->
							<div class="tab-pane fade" id="tab2default">
								<div id="DeleteVideo">
								<form method="post" action="/Netflox/AdministrationTraitement?action=Del_Video">	
									<input type="text" name="d_titre_V" class="form-control input-sm chat-input" placeholder="titre" required/>
									</br>
									<input type="number" name="d_episode_V"class="form-control input-sm chat-input" placeholder="numéro d'épisode" required />
									</br>
									<input type="number" name="d_saison"class="form-control input-sm chat-input" placeholder="saison" required/>
									</br>
									<div class="wrapper">
									<button  type="submit"  class="btn btn-danger btn-md">supprimer </button>
									</form>
									</div>
								</div>
							</div>
							
			<!-- Panel ajout client  -->				
							<div class="tab-pane fade" id="tab3default">
								<div id="AddClient">
									<form method="post" action="/Netflox/AdministrationTraitement?action=Add_Client">
										<input type="text" name="a_nom" class="form-control input-sm chat-input" placeholder="nom" required />
										</br> 
										<input type="text" name="a_prenom" class="form-control input-sm chat-input" placeholder="prenom" required />
										</br> 
										<input type="text" name="a_email" class="form-control input-sm chat-input" placeholder="email" required />
										</br> 
										<input type="text" name="a_pseudo" class="form-control input-sm chat-input" placeholder="pseudo" required/>
										</br> 
										<input type="text" name="a_mdp" class="form-control input-sm chat-input" placeholder="password" required/> 
										</br>
										<button type="submit"  class="btn btn-danger btn-md">ajouter</button>
									</form>
									</div>
								</div>
			<!-- Panel Supprime client  -->
							<div class="tab-pane fade" id="tab4default">
								<div id="DeleteClient">
								<form method="post" action="/Netflox/AdministrationTraitement?action=Del_Client">
									<input type="text" name="d_pseudo" class="form-control input-sm chat-input" placeholder="pseudo" required/>
									</br>
									<button type="submit" id="Ca" class="btn btn-danger btn-md">supprimer </button>
									</form>
								</div>
							</div>
							
			<!-- Panel PDF -->
								<div class="tab-pane fade" id="tab8default">
									<div id="pdf">
											<form method="post" action="/Netflox/AdministrationTraitement?action=Audit" >
												<input type="number" name="day" class="form-control" placeholder="Day" required />
												<input type="number" name="month" class="form-control" placeholder="Month" required/>
												<input type="number" name="year" class="form-control" placeholder="Year" required/>
                         						<button type="submit" id="Ca"class="btn btn-danger btn-md">AUDIT</button>
											</form>
										<h3> Télécharger la liste des films du site </h3>
										  <a  type="submit" id="audit" href="/Netflox/AdministrationTraitement?action=CA" class="btn btn-danger btn-md">Liste pdf </a>
									</div>
								</div>
								
								
	<!-- Panel modifier client  -->				
							<div class="tab-pane fade" id="tab6default">
								<div id="ModifierClient">
									<form method="post" action="/Netflox/AdministrationTraitement?action=Mod_Client">
									 <h3>Eléments de recherche</h3>
									 	<input type="text" name="m_pseudo" class="form-control input-sm chat-input" placeholder="pseudo" required/>
										</br> 
										<h3>Eléments a modifier</h3>
										<input type="text" name="m_nom" class="form-control input-sm chat-input" placeholder="nom" required />
										</br> 
										<input type="text" name="m_prenom" class="form-control input-sm chat-input" placeholder="prenom" required/>
										</br> 
										<input type="text" name="m_email" class="form-control input-sm chat-input" placeholder="email" required/>
										</br> 
										<input type="text" name="m_mdp" class="form-control input-sm chat-input" placeholder="password" required/> 
										</br>
										<button type="submit"  class="btn btn-danger btn-md">Modifier</button>
									</form>
									</div>
								</div>
								
								
							<div class="tab-pane fade" id="tab7default">
							<div id="ModifieVideo">
								<form method="post" action="/Netflox/AdministrationTraitement?action=Mod_Video">	
								  <h3>Eléments de recherche</h3>
									<input type="text" name="m_titre" class="form-control input-sm chat-input" placeholder="nom " required/>
									</br>
									<input type="number" name="m_ep" class="form-control input-sm chat-input" placeholder="episode " required/>
									</br>
									<input type="number" name="m_saison" class="form-control input-sm chat-input" placeholder="saison " required/>
									</br>
									<h3>Eléments a modifier</h3>
									<input type="text" name="m_resume" class="form-control input-sm chat-input" placeholder="resumé " required/>
									</br>
									<input type="number" name="m_location"class="form-control input-sm chat-input" placeholder="prix location " required/>
									</br>
									<input type="number" name="m_achat"class="form-control input-sm chat-input" placeholder="prix achat " required/>
									</br>
									<button  type="submit"  class="btn btn-danger btn-md">supprimer </button>
									</form>
								</div>
								</div>
									
								<div class="tab-pane fade" id="tab5default">
								<div id="ModifieVideo">
								<form method="post" action="/Netflox/AdministrationTraitement?action=Parrain_Renit">	
								  <h3>Réinitiliser le nombre de vidéo gratuite </h3>
									<input type="text" name="p_pseudo" class="form-control input-sm chat-input" placeholder="pseudo " required/>
									</br>
									<input type="number" name="p_nbVideo" class="form-control input-sm chat-input" placeholder="nombre de video  " required/>
									</br>
									<button  type="submit"  class="btn btn-danger btn-md">Renitialiser </button>
									</form>
									
									<form method="post" action="/Netflox/AdministrationTraitement?action=Parrain_supp">	
								 	 <h3>Supprimer le lien avec le neveu</h3>
									<input type="text" name="p_pseudo" class="form-control input-sm chat-input" placeholder="pseudo " required/>
									</br>
									<button  type="submit"  class="btn btn-danger btn-md">supprimer </button>
									</form>
								</div>
								</div>
							</div>
						</div> <!-- fin tab-content-->
					</div><!-- fin body panel -->
				</div>
			</div>
                     
    


      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <script>window.jQuery || document.write('<script src="../resources/bootstrap/assets/js/vendor/jquery.min.js"><\/script>')</script>
      <script src="resources/bootstrap/js/bootstrap.min.js"></script>
      <script src="resources/js/administration.js"></script>
    </body>
    </html>
