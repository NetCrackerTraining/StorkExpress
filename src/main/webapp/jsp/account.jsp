<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 12.11.2016
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Account</title>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png" type="image/x-icon">
    <meta name="description" content="">

    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Lora:400,700,400italic,700italic&amp;subset=latin">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Montserrat:400,700">
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/et-line-font-plugin/style.css">
    <link rel="stylesheet"
          href="${pageContext.request.contextPath}/css/bootstrap-material-design-font/css/material.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/tether/tether.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/socicon/css/socicon.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/animate.css/animate.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/dropdown/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mobirise/css/mbr-additional.css"
          type="text/css">

    <script src="${pageContext.request.contextPath}/js/tether/tether.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/web/assets/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
    <<section id="ext_menu-9">

        <nav class="navbar navbar-dropdown">
            <div class="container">

                <div class="mbr-table">
                    <div class="mbr-table-cell">

                        <div class="navbar-brand">
                            <a href="${pageContext.request.contextPath}" class="navbar-logo"><img
                                    src="${pageContext.request.contextPath}/images/stork-express-logo-138x128-21.png"
                                    alt="Stork Express"></a>
                            <a class="navbar-caption" href="${pageContext.request.contextPath}">Stork Express</a>
                        </div>

                    </div>
                    <div class="mbr-table-cell">

                        <button class="navbar-toggler pull-xs-right hidden-md-up" type="button" data-toggle="collapse"
                                data-target="#exCollapsingNavbar">
                            <div class="hamburger-icon"></div>
                        </button>

                        <ul class="nav-dropdown collapse pull-xs-right nav navbar-nav navbar-toggleable-sm"
                            id="exCollapsingNavbar">
                            <li class="nav-item"><a class="nav-link link" href="${pageContext.request.contextPath}">RATES</a></li>
                            <li class="nav-item"><a class="nav-link link" href="${pageContext.request.contextPath}/ShowUsers">USERS</a></li>
                            <li class="nav-item nav-btn"><a class="nav-link btn btn-white btn-white-outline"
                                                            href="${pageContext.request.contextPath}/ShowOrders">ORDERS</a></li>
                            <li class="nav-item nav-btn"><a class="nav-link btn btn-info" href="${pageContext.request.contextPath}/SignOut">Sign
                                Out</a></li>
                        </ul>
                        <button hidden="" class="navbar-toggler navbar-close" type="button" data-toggle="collapse"
                                data-target="#exCollapsingNavbar">
                            <div class="close-icon"></div>
                        </button>

                    </div>
                </div>

            </div>
        </nav>
    </section>

    <div class="container" style="margin-top: 8rem">
        <div class="row">

            <div class="col-md-8 col-md-offset-2" >
                <form  role="form" method="POST" action="${pageContext.request.contextPath}">

                <legend style="font-size: xx-large;">My account details</legend>

                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">Username: username1
                    </label>
                </div>

                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">Email: email@gmail.com
                    </label>
                </div>

                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">First name: Alexander
                        <a data-toggle="collapse" href="#collapse1">
                            edit
                        </a>
                    </label>
                    <div id="collapse1" class="panel-collapse collapse">
                        <label for="newFirstName">New First name: </label>
                        <input type="text" class="form-control" name="newFirstName" id="newFirstName"
                               placeholder="new first name">
                    </div>
                </div>
                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">Second name: Alexander
                        <a data-toggle="collapse" href="#collapse2">
                            edit
                        </a>
                    </label>
                    <div id="collapse2" class="panel-collapse collapse">
                        <label for="newSecondName">New Second name: </label>
                        <input type="text" class="form-control" name="newSecondName" id="newSecondName"
                               placeholder="new second name">
                    </div>
                </div>

                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">Phone number: +375295552233
                        <a data-toggle="collapse" href="#collapse3">
                            edit
                        </a>
                    </label>
                    <div id="collapse3" class="panel-collapse collapse">
                        <label for="newPhoneNumber">New Phone number: </label>
                        <input type="text" class="form-control" name="newPhoneNumber" id="newPhoneNumber"
                               placeholder="+375...">
                    </div>
                </div>

                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">Address: Belarus, Minsk, Pushkin Str. 12 - 33
                        <a data-toggle="collapse" href="#collapse4">
                            edit
                        </a>
                    </label>
                    <div id="collapse4" class="panel-collapse collapse">
                        <label for="newAddress">New Address: </label>
                        <input type="text" class="form-control" name="newAddress" id="newAddress"
                               placeholder="New address">
                    </div>
                </div>
                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">
                        <a data-toggle="collapse" href="#collapse5">
                            Change password
                        </a>
                    </label>
                    <div id="collapse5" class="panel-collapse collapse">
                        <label for="oldPassword">Old password: </label>
                        <input type="password" class="form-control" name="oldPassword" id="oldPassword"
                               placeholder="Old password">
                        <div class="form-group col-md-6" style="padding-left: 0px;  padding-top: 5px">
                            <label for="newPassword">New password: </label>
                            <input type="password" class="form-control" name="newPassword" id="newPassword"
                                   placeholder="New password">
                        </div>
                        <div class="form-group col-md-6" style="padding-left: 0px; padding-right: 0px; padding-top: 5px">
                            <label for="newPassword2">One more time: </label>
                            <input type="password" class="form-control" name="newPassword2" id="newPassword2"
                                   placeholder="New password one more time">
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-md-12" style="padding-left: 0px">
                            <button type="submit" class="btn btn-primary" >
                                Save
                            </button>
                        </div>
                    </div>

                    </div>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
