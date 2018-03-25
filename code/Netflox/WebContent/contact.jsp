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
    <link href="resources/css/contact.css" rel="stylesheet">
   	<link href="https://fonts.googleapis.com/css?family=Oswald:700|Patua+One|Roboto+Condensed:700" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
  	</head>
  
  
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
             <li class="active"><a href="/Netflox/Contact">Contactez nous </a></li></ul> 
               <ul class="nav navbar-nav navbar-right "> 
				    <c:if test="${!empty sessionScope.client}">
					   <li> <a href="/Netflox/CompteClient">Bienvenue ${sessionScope.client.pseudo} !</a> </li>
						<li> <a>Vous avez ${sessionScope.client.pseudo} point(s) !</a> </li>
					   <c:if test = "${sessionScope.status.categorie == 'inscrit'}">
					    <a href="/Netflox/Subscribe" type="button" class="btn btn-primary">Premium</a>
				   	   </c:if>
				   	    <c:if test = "${sessionScope.status.categorie == 'administrateur'}">
					   	 <a href="/Netflox/Administration" class="btn btn-primary">administration</a>
				   	   </c:if>	
					   <a type="button" class="btn btn-danger" href="/Netflox/Deconnection">Deconnection</a>	
					</c:if>
				</ul> 
                
          </div><!-- /.navbar-collapse -->
        </nav>

      </div>
    </div>
   
			<section id="contact" class="content-section text-center">
			        <div class="contact-section">
			            <div class="container">
			              <h2>Nous contacter</h2>
			              <p>N'hésitez pas à nous envoyer un message</p>
			              <div class="row">
			                <div class="col-md-8 col-md-offset-2">
			                  <form class="form-horizontal">
			                    <div class="form-group">
			                      <label >Votre nom</label requierd>
			                      <input type="text" class="form-control" id="exampleInputName2" placeholder="Jane Doe">
			                    </div>
			                    <div class="form-group">
			                      <label >Email</label>
			                      <input type="email" class="form-control" id="exampleInputEmail2" placeholder="jane.doe@example.com">
			                    </div>
			                    <div class="form-group ">
			                      <label><p>Votre message</p></label>
			                     <textarea  class="form-control" placeholder="Description"></textarea> 
			                    </div>
			                    <button type="submit" class="btn btn-default btn-danger">ENVOYER</button>
			                  </form>
			
			                  <hr>

			                  <ul class="list-inline banner-social-buttons">
			                    <li><a href="#" class="btn btn-default btn-lg"><i class="fa fa-twitter"> <span class="network-name">Twitter</span></i></a></li>
			                    <li><a href="#" class="btn btn-default btn-lg"><i class="fa fa-facebook"> <span class="network-name">Facebook</span></i></a></li>
			                    <li><a href="#" class="btn btn-default btn-lg"><i class="fa fa-youtube-play"> <span class="network-name">Youtube</span></i></a></li>
			                  </ul>
			                </div>
			              </div>
			            </div>
			        </div>
			      </section>
	</body>
</html>