<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html lang="fr">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Netflox</title>
    <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/payement.css" rel="stylesheet">
   <!--   <link href="resources/js/payement.js" rel="stylesheet">-->



  </head>



<body>
  <div class="container">

            <div class="col-xs-5 col-md-5" id="pos">
			 <h3>${type} : ${nom} </h3>
			 <h3>Prix: ${prix} </h3>

            <!-- CREDIT CARD FORM STARTS HERE -->
            <div class="panel panel-default credit-card-box">
              <div class="panel-heading display-table" >
                <div class="row display-tr" >
                <h3 class="panel-title display-td" >Payment Details</h3>
                  <div class="display-td" >
                    <img class="img-responsive pull-right" src="http://i76.imgup.net/accepted_c22e0.png">
                  </div>
                </div>
               
                
              </div>
            <div class="panel-body">
                <form id="payment-form">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-group">
                            <label for="cardNumber">CARD NUMBER</label>
                                <div class="input-group">
                                    <input class="form-control" name="cardNumber"placeholder="Valid Card Number"/>
                       
                                </div>
                            </div>
                        </div>
                    </div>
                <div class="row">
                  <div class="col-xs-7 col-md-7">
                      <div class="form-group">
                    <label> <span>EXPIRATION</span><span >EXP</span> DATE</label>
                      <input
                           class="form-control" placeholder="MM / YY"/>
                      </div>
                  </div>
                  <div class="col-xs-5 col-md-5 pull-right">
                      <div class="form-group">
                        <label>CV CODE</label>
                        <input  name="cardCVC" class="form-control" placeholder="CVC" />
                      </div>
                  </div>
                </div>
                  <div class="row">
                    <div class="col-xs-12">
                        <button href="/Projet-TER/AfficheVideo?idVideo=${idVideo}" class="btn btn-success btn-lg btn-block" type="submit">PAYER</button>
                    </div>
                  </div>
                </form>
            </div>
            </div>
            <!-- CREDIT CARD FORM ENDS HERE -->
            </div>
        </div>
  

  	<!-- If you're using Stripe for payments -->
 
</body>
</html>
