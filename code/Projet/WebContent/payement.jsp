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

    <link href="resources/bootstrap/css/bootstrap.css" rel="stylesheet">
    <link href="resources/css/payement.css" rel="stylesheet">
    <link href="resources/js/payement.js" rel="stylesheet">



  </head>
<body>
  <div class="container">

           <div class="col-xs-5 col-md-5" id="pos">
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
                </br>
                	<div id="detail">
        					 <h3> Type : </h3>
        					 <h3> Montant : </h3>
        			</div>
            <div class="panel-body">
                <form role="form" id="payment-form">
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-group">
                            <label for="cardNumber">CARD NUMBER</label>
                                <div class="input-group">
                                    <input
                                    type="tel"
                                    class="form-control"
                                    name="cardNumber"
                                    placeholder="Valid Card Number"
                                    autocomplete="cc-number"
                                    required autofocus
                                    />
                                <span class="input-group-addon"><i class="fa fa-credit-card"></i></span>
                                </div>
                            </div>
                        </div>
                    </div>
                <div class="row">
                  <div class="col-xs-7 col-md-7">
                      <div class="form-group">
                      <label for="cardExpiry"><span class="hidden-xs">EXPIRATION</span><span class="visible-xs-inline">EXP</span> DATE</label>
                      <input
                          type="tel"
                          class="form-control"
                          name="cardExpiry"
                          placeholder="MM / YY"
                          autocomplete="cc-exp"
                          required/>
                      </div>
                  </div>
                  <div class="col-xs-5 col-md-5 pull-right">
                      <div class="form-group">
                        <label for="cardCVC">CV CODE</label>
                        <input
                          type="tel"
                          class="form-control"
                          name="cardCVC"
                          placeholder="CVC"
                          autocomplete="cc-csc"
                          required/>
                      </div>
                  </div>
                </div>
                    <div class="row">
                        <div class="col-xs-12">
                            <div class="form-group">
                                <label for="couponCode">COUPON CODE</label>
                                <input type="text" class="form-control" name="couponCode" />
                            </div>
                        </div>
                    </div>
                  <div class="row">
                    <div class="col-xs-12">
                        <button class="btn btn-success btn-lg btn-block" type="submit">BUY</button>
                    </div>
                  </div>
                  <div class="row" style="display:none;">
                    <div class="col-xs-12">
                    <p class="payment-errors"></p>
                    </div>
                  </div>
                </form>
            </div>
            </div>
            <!-- CREDIT CARD FORM ENDS HERE -->
            </div>
        </div>
       
 

  	<!-- If you're using Stripe for payments -->
  <script type="text/javascript" src="https://js.stripe.com/v2/"></script>
</body>
</html>
