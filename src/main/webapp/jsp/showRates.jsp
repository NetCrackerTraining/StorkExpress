<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 11.11.2016
  Time: 23:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Rates</title>
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

    <script src="${pageContext.request.contextPath}/js/web/assets/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/dropdown/script.min.js"></script>

</head>
<body>
<c:redirect url="/"></c:redirect>
<section id="ext_menu-9">
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

<div class="col-md-8 col-md-offset-2" style="position: relative; top: 8rem;">
    <legend style="font-size: xx-large;">Rates:</legend>
    <div class="col-md-12">
        <a data-toggle="collapse" href="#collapse1" style="font-size: x-large;">
            Add new rate
        </a>
    </div>
    <div id="collapse1" class="panel-collapse collapse">
    <div class="col-md-12">
        <form  role="form" method="POST" action="${pageContext.request.contextPath}">
        <div class="form-group col-md-3">
            <label for="rate">Rate</label>
            <input type="text" class="form-control" name="rate" id="rate" placeholder="Rate">
        </div>
        <div class="form-group col-md-3">
            <label for="start_date">Start date</label>
            <input type="text" class="form-control" name="startDate" id="start_date" placeholder="Start date">
        </div>
        <div class="form-group col-md-3">
            <label for="end_date">End date</label>
            <input type="text" class="form-control" name="endDate" id="end_date" placeholder="End date">
        </div>
        <div class="form-group" class="col-md-3">
                <button type="submit" class="btn btn-primary" style="margin-top: 2.2rem; margin-left: 0.5rem;">
                    Save
                </button>
        </div>
        </form>
    </div>
    </div>
    <table class="table table-bordered" style="margin-top: 4rem">
        <%--Шапка таблицы. Не менять--%>
        <thead>
        <tr>
            <th>#</th>
            <th>Rate</th>
            <th>Start date</th>
            <th>End Date</th>
            <th> </th>
        </tr>
        </thead>
        <tbody>
            <tr>
                <td> 1 </td>
                <td>0.5 $/kg</td>
                <td>22.02.2012</td>
                <td>22.02.2013</td>
                <td style="text-align: center">del</td>
            </tr>
        </tbody>
    </table>


</div>

</body>
</html>
