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
							<li><a href="#tab5default" data-toggle="tab">PDF</a></li>

						</ul>
					</div><!-- tabbed head panel end -->
					
<!-- tabbed body panel start -->
					<div class="panel-body">
						<div class="tab-content">
		  <!-- Panel ajouter video -->
							<div class="tab-pane fade in active" id="tab1default">
								<div id="AddVideo">	
									  <form method="post" action="/Projet-TER/AdministrationTraitement?action=Add_Video" >
										<input type="text" name="a_nom" class="form-control input-sm chat-input" placeholder="nom" />
										</br> 
										<input type="text" name="a_categorie" class="form-control input-sm chat-input"placeholder="catégorie 1=documentaire 2=film 3=série" /> 
										</br> 
										<input type="text" name="a_motclef" class="form-control input-sm chat-input"placeholder="mots clefs" /> 
										</br> 
										<input type="text" name="a_resume" class="form-control input-sm chat-input" placeholder="résumé" />
										</br>
										<input type="text" name="a_saison" class="form-control input-sm chat-input" placeholder=" saison" />
										</br>
										<input type="text" name="a_ep" class="form-control input-sm chat-input" placeholder=" n° episode" />
										</br>
										<input type="text" name="a_louer" class="form-control input-sm chat-input" placeholder=" prix location" />
										</br>
										<input type="text" name="a_achat" class="form-control input-sm chat-input" placeholder=" prix achat" />
										</br>
				                      <button  type="submit" class="btn btn-danger btn-md">Ajouter</button>
	                     			 </form>
								</div>

							</div>
			<!-- Panel Suppression video -->
							<div class="tab-pane fade" id="tab2default">
								<div id="DeleteVideo">

									<input type="text" name="d_titre_V" class="form-control input-sm chat-input" placeholder="titre" />
									</br>
									<input type="text" name="d_episode_V"class="form-control input-sm chat-input" placeholder="numéro d'épisode" />
									</br>
									<input type="text" name="d_saison"class="form-control input-sm chat-input" placeholder="saison" />
									</br>
									<div class="wrapper">
										<span class="group-btn"> 
											<a href="/Projet-TER/AdministrationTraitement?action=Del_Video" class="btn btn-danger btn-md">supprimer <i class="fa fa-sign-in"></i></a>
										</span>
									</div>
								</div>
							</div>
							
			<!-- Panel ajout client  -->				
							<div class="tab-pane fade" id="tab3default">
								<div id="AddClient">
									<input type="text" name="a_pseudo" class="form-control input-sm chat-input" placeholder="pseudo" />
									</br> <input type="text" name="a_pw" class="form-control input-sm chat-input" placeholder="password" /> </br>
									<div class="wrapper">
										<span class="group-btn"> <a href="/Projet-TER/Administration?action=Add_Client" class="btn btn-danger btn-md">ajouter<i class="fa fa-sign-in"></i></a>
										</span>
									</div>
								</div>


							</div>
			<!-- Panel Supprime client  -->
							<div class="tab-pane fade" id="tab4default">
								<div id="DeleteClient">
									<input type="text" name="d_id" class="form-control input-sm chat-input" placeholder="id" />
									</br> <input type="text" name="d_pseudo" class="form-control input-sm chat-input" placeholder="pseudo" />
									</br>
									<div class="wrapper">
										<span class="group-btn"> <a href="/Projet-TER/AdministrationTraitement?action=Del_Client"class="btn btn-danger btn-md">Supprimer</a>
										</span>
									</div>
								</div>
							</div>
							
			<!-- Panel PDF -->
								<div class="tab-pane fade" id="tab5default">
									<div id="pdf">
									  <h3> Télécharger la liste des films du site </h3>
										  <a id="audit" href="/Projet-TER/AdministrationTraitement?action=Audit" class="btn btn-danger btn-md">Audit</a>
											<form methode="POST">
												<input type="text" name="day" class="form-control" placeholder="Day" />
												<input type="text" name="month" class="form-control" placeholder="Month" />
												<input type="text" name="year" class="form-control" placeholder="Year" />
                         						<a id="Ca" href="/Projet-TER/AdministrationTraitement?action=CA" class="btn btn-danger btn-md">Chiffre d'affaire </a>
											</form>
										
									</div>
								</div>
						</div> <!-- fin tab-content-->
					</div><!-- fin body panel -->
				</div>
			</div>
					<span class="group-btn">
                       
                     </span>
                     
                     	
      	</div>
      </div>
      





      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <script>window.jQuery || document.write('<script src="../resources/bootstrap/assets/js/vendor/jquery.min.js"><\/script>')</script>
      <script src="resources/bootstrap/js/bootstrap.min.js"></script>
      <script src="resources/js/administration.js"></script>
    </body>
    </html>
