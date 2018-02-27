
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
          <link href="resources/css/administrateur.css" rel="stylesheet">
        </head>
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
              <h3>150</h3>

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
              <h3>53<sup style="font-size: 20px"></sup></h3>

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
              <h3>44</h3>

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
									<input type="text" id="d_nom" class="form-control input-sm chat-input" placeholder="nom" />
										</br> 
										<input type="text" id="d_catégorie" class="form-control input-sm chat-input"placeholder="catégorie" /> 
										</br> 
										<input type="text" id="d_motclef" class="form-control input-sm chat-input"placeholder="mots clefs" /> 
										</br> 
										<input type="text" id="d_resumé" class="form-control input-sm chat-input" placeholder="résumé" />
										</br>
									<div class="wrapper">
										<span class="group-btn"> <a href="#"
											class="btn btn-danger btn-md">ajouter<i
												class="fa fa-sign-in"></i></a>
										</span>
									</div>
								</div>

							</div>
			<!-- Panel Suppression video -->
							<div class="tab-pane fade" id="tab2default">
								<div id="DeleteVideo">

									<input type="text" id="d_titre_V" class="form-control input-sm chat-input" placeholder="titre" />
									</br>
									<input type="text" id="d_episode_V"class="form-control input-sm chat-input" placeholder="numéro d'épisode" />
									</br>
									<input type="text" id="d_cat_V"class="form-control input-sm chat-input" placeholder="catégorie" />
									</br>
									<div class="wrapper">
										<span class="group-btn"> 
											<a href="#" class="btn btn-danger btn-md">supprimer <i class="fa fa-sign-in"></i></a>
										</span>
									</div>
								</div>
							</div>
							
			<!-- Panel ajout client  -->				
							<div class="tab-pane fade" id="tab3default">
								<div id="AddClient">
									<input type="text" id="a_pseudo" class="form-control input-sm chat-input" placeholder="pseudo" />
									</br> <input type="text" id="a_pw" class="form-control input-sm chat-input" placeholder="password" /> </br>
									<div class="wrapper">
										<span class="group-btn"> <a href="#"
											class="btn btn-danger btn-md">ajouter<i class="fa fa-sign-in"></i></a>
										</span>
									</div>
								</div>


							</div>
			<!-- Panel Supprime client  -->
							<div class="tab-pane fade" id="tab4default">
								<div id="DeleteClient">
									<input type="text" id="d_id"
										class="form-control input-sm chat-input" placeholder="id" />
									</br> <input type="text" id="d_pseudo"
										class="form-control input-sm chat-input" placeholder="pseudo" />
									</br>
									<div class="wrapper">
										<span class="group-btn"> <a href="#"
											class="btn btn-danger btn-md">Supprimer</a>
										</span>
									</div>
								</div>
							</div>
							
			<!-- Panel PDF -->
								<div class="tab-pane fade" id="tab5default">
									<div id="pdf">
									  <h3> Télécharger la liste des films du site </h3>
										  <a id="audit" class="btn btn-danger btn-md">Audit</a>
											<form action="">
												<input type="text" id="date"
														class="form-control" placeholder="Day" />
												<input type="text" id="date"
														class="form-control" placeholder="Month" />
												<input type="text" id="date"
														class="form-control" placeholder="Year" />
											
                         						<a id="Ca" class="btn btn-danger btn-md">Chiffre d'affaire </a>
                   						  		
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
