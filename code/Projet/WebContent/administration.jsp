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

<!-- administeur view-->

<!-- Main content -->



  <!-- Small boxes (Stat box) -->
  <div class="row" id="smalpanel">
    <div class="col-xs-2 col-xs-2">
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
    <div class="col-xs-2 col-xs-2">
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
    <div class="col-xs-2 col-xs-2">
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
      	<div class="col-md-6">
              <div class="panel with-nav-tabs panel-default">
                  <div class="panel-body">
                      <div class="tab-content">
                          <div class="tab-pane fade in active" id="tab1default">Default 1</div>
                          <div class="tab-pane fade" id="tab2default">Default 2</div>
                          <div class="tab-pane fade" id="tab3default">Default 3</div>
                          <div class="tab-pane fade" id="tab4default">Default 4</div>
                          <div class="tab-pane fade" id="tab5default">Default 5</div>
                      </div>
                  </div>
                  <div class="panel-heading">
                          <ul class="nav nav-tabs">
                              <li class="active"><a href="#tab1default" data-toggle="tab">Default 1</a></li>
                              <li><a href="#tab2default" data-toggle="tab">Default 2</a></li>
                              <li><a href="#tab3default" data-toggle="tab">Default 3</a></li>
                          </ul>
                  </div>
              </div>
          </div>
  	</div>
 </div>






  </body>
</html>
