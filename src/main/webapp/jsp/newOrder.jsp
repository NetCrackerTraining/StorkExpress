<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 11.11.2016
  Time: 23:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Order</title>
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

</head>
<body>

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
                        <li class="nav-item"><a class="nav-link link" href="${pageContext.request.contextPath}/UserOrders">MY HISTORY</a></li>
                        <li class="nav-item"><a class="nav-link link" href="${pageContext.request.contextPath}/UserInfo">ACCOUNT</a></li>
                        <li class="nav-item"><a class="nav-link link" href="${pageContext.request.contextPath}/jsp/about.jsp">ABOUT US</a></li>
                        <li class="nav-item nav-btn"><a class="nav-link btn btn-white btn-white-outline"
                                                        href="${pageContext.request.contextPath}/NewOrder">New ORDER</a></li>
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



<div class="container-fluid" style="position: relative; top: 20%;">
    <div class="row">
        <div class="col-md-4">
            <fieldset>
                <legend>Add information about your parcel:</legend>

                    <label for="descrition">Descrition:</label>
                    <input type="text" class="form-control" name="descrition" id="descrition"
                           placeholder="Parcel with...">

                    <label for="weight">Weight:</label>
                    <input type="text" class="form-control" name="weight" id="weight" required placeholder="1.5 kg">

                    <label for="from">I will send it from...</label>
                    <input type="text" class="form-control" name="from" id="from" required
                           placeholder="Belarus">

                    <label for="to">Country destination...</label>
                    <input type="text" class="form-control" name="to" id="to" required
                           placeholder="USA">

                    <label for="recipient">This parcel will receive</label>
                    <input type="text" class="form-control" name="recipient" id="recipient" required
                           placeholder="Donald Trump">

                <div class="form-group" style="margin-top: 10px">
                    <div class="checkbox">
                        <label style="margin-top: 10px">
                            <input type="checkbox" required style="transform: scale(1.5)"/> Express
                        </label>
                        <button type="submit" class="btn btn-primary" style="float: right;">
                            Add
                        </button>
                    </div>

            </fieldset>
        </div>
        <div class="col-md-8">
            <legend>Your order</legend>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>
                        #
                    </th>
                    <th>
                        Description
                    </th>
                    <th>
                        Weight
                    </th>
                    <th>
                        From
                    </th>
                    <th>
                        To
                    </th>
                    <th>
                        Recipient
                    </th>
                    <th>
                        Express
                    </th>
                    <th>
                        Price
                    </th>
                    <th>
                        del
                    </th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>
                        1
                    </td>
                    <td>
                        Book
                    </td>
                    <td>
                        0.3 kg
                    </td>
                    <td>
                        Belarus
                    </td>
                    <td>
                        USA
                    </td>
                    <td>
                        Donald Trump
                    </td>
                    <td>
                        Yes
                    </td>
                    <td>
                        42.4 $
                    </td>
                    <td>
                        del
                    </td>
                </tr>
                <tr>
                    <td>
                        2
                    </td>
                    <td>
                        Apple
                    </td>
                    <td>
                        0.1 kg
                    </td>
                    <td>
                        Poland
                    </td>
                    <td>
                        Belarus
                    </td>
                    <td>
                        Mr. Smith
                    </td>
                    <td>
                        No
                    </td>
                    <td>
                        2.4 $
                    </td>
                    <td>
                        del
                    </td>
                </tr>
                <tr>
                    <td>
                        3
                    </td>
                    <td>
                        New laptop
                    </td>
                    <td>
                        2.5 kg
                    </td>
                    <td>
                        USA
                    </td>
                    <td>
                        Russia
                    </td>
                    <td>
                        V. Putin
                    </td>
                    <td>
                        Yes
                    </td>
                    <td>
                        66.0 $
                    </td>
                    <td>
                        del
                    </td>
                </tr>
                <tr >
                    <td>
                        4
                    </td>
                    <td>
                        Book
                    </td>
                    <td>
                        0.3 kg
                    </td>
                    <td>
                        Belarus
                    </td>
                    <td>
                        USA
                    </td>
                    <td>
                        Donald Trump
                    </td>
                    <td>
                        Yes
                    </td>
                    <td>
                        42.4 $
                    </td>
                    <td>
                        del
                    </td>
                </tr>
                <tr >
                    <td>
                        5
                    </td>
                    <td>
                        Book
                    </td>
                    <td>
                        0.3 kg
                    </td>
                    <td>
                        Belarus
                    </td>
                    <td>
                        USA
                    </td>
                    <td>
                        Donald Trump
                    </td>
                    <td>
                        Yes
                    </td>
                    <td>
                        42.4 $
                    </td>
                    <td>
                        del
                    </td>
                </tr>
                <tr>
                    <td colspan="9" style="text-align: right;">
                        Total: 5 parcels: weight - 3.5 kg; prise - 195.6 $
                    </td>
                </tr>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
