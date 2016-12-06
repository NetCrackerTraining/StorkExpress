<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <script src="${pageContext.request.contextPath}/js/custom/custom.js"></script>

</head>
<body>

<jsp:useBean id="user" class="entity.User" scope="session"/>
<c:if test="${user.getUsername() == null || !user.isSimpleUser()}">
    <c:redirect url="/"></c:redirect>
</c:if>

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
                        <li class="nav-item"><a class="nav-link link" href="${pageContext.request.contextPath}/jsp/account.jsp">ACCOUNT</a></li>
                        <li class="nav-item"><a class="nav-link link" href="${pageContext.request.contextPath}/jsp/about.jsp">ABOUT US</a></li>
                        <li class="nav-item nav-btn"><a class="nav-link btn btn-white btn-white-outline"
                                                        href="${pageContext.request.contextPath}/jsp/newOrder.jsp">New ORDER</a></li>
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

<jsp:useBean id="countries" class="java.util.ArrayList" scope="session"/>
<jsp:useBean id="currencies" class="java.util.ArrayList" scope="session"/>

<div class="container-fluid" style="position: relative; top: 8rem;">
    <div class="row">
        <div class="col-md-4">
            <form action="${pageContext.request.contextPath}/AddParcel" method="post"
                  onsubmit="
                  document.getElementById('currency').disabled = false;
                  var e = document.getElementById('currency');
                var selectedCurrency = e.options[e.selectedIndex].value;
                localStorage.setItem('selectedCurrency', selectedCurrency);
                ">
            <fieldset>
                <div class="form-group col-md-12" style="color: #ff0000">
                    <c:out value="${sessionScope.ParcelError}"/>
                    <c:remove var="ParcelError" scope="session"/>
                </div>
                <legend>Add information about your parcel:</legend>

                    <label for="description">Description:</label>
                    <input maxlength="30" type="text" class="form-control" name="description" id="description" required
                           placeholder="Parcel with..."  pattern="^[a-zA-Z][a-zA-Z0-9 ]{2,30}$"
                           title="Enter your description. First character only letter. Other - letters or digits. From 3 to 30 characters."
                           oninvalid="setCustomValidity('Wrong description.' +
                                ' First character only letter. Other - letters or digits. From 3 to 30 characters.')"
                           onchange="try{setCustomValidity('')}catch(e){}">

                    <label for="weight">Weight:</label>
                    <input maxlength="3" type="number" class="form-control" name="weight" id="weight" min="0.1" max="100" step="0.1"
                           required placeholder="1.5 kg"
                           title="Only digits. Min weight - 0.1 kg, max weight - 100 kg."
                           oninvalid="setCustomValidity('Wrong weight.' +
                                ' Only digits. Min weight - 0.1 kg, max weight - 100 kg.')"
                           onchange="try{setCustomValidity('')}catch(e){}">

                    <label for="from">I will send it from...</label>
                    <select name="fromCountry" id="from" required class="form-control">
                        <c:forEach items="${countries}" var="country">
                            <option value="${country.getId()}">${country.getCountryNameEN()}</option>
                        </c:forEach>
                    </select>
                    <label for="to">Country destination...</label>
                    <select name="toCountry" id="to" required class="form-control">
                        <c:forEach items="${countries}" var="country">
                            <option value="${country.getId()}">${country.getCountryNameEN()}</option>
                        </c:forEach>
                    </select>

                    <label for="recipient">This parcel will receive</label>
                    <input maxlength="30" type="text" class="form-control" name="recipient" id="recipient" required
                           placeholder="Recipient's name" pattern="^[A-Z][a-z]{3,29}[a-zA-Z. ]{0,29}$"
                           title="Enter the recipient's name. The first letter should be capitalized. Only letters, spaces and dots. From 3 to 30 characters."
                           oninvalid="setCustomValidity('Wrong name format.' +
                                ' The first letter should be capitalized. Only letters, spaces and dots. From 3 to 30 characters.' +
                                ' For example: Donald Trump, Trump D., Trump.')"
                           onchange="try{setCustomValidity('')}catch(e){}">

                <div class="form-group" style="margin-top: 15px">
                    <div class="checkbox">
                        <label style="margin-top: 15px; padding-left: 30px;">
                            <input type="checkbox" name="express" id="express" style="transform: scale(2.0)"/> Express
                        </label>
                        <div class="col-md-4" style="padding-left: 0px">
                        <select name="currency" id="currency" required class="form-control">
                            <c:forEach items="${currencies}" var="currency">
                                <option value="${currency.getCurrencyAbbreviation()}">${currency.getCurrencyAbbreviation()}</option>
                            </c:forEach>
                        </select>
                        </div>
                        <button type="submit" class="btn btn-primary" style="float: right;">
                            Add
                        </button>
                    </div>
                </div>
            </fieldset>
            </form>
        </div>

        <jsp:useBean id="order" class="entity.Order" scope="session"/>
        <jsp:useBean id="parcel" class="entity.Parcel" scope="session"/>

        <div class="col-md-8">
            <legend>Your order</legend>
            <div class="form-group col-md-12" style="color: #ff0000">
                <c:out value="${sessionScope.ErrorMessage}"/>
                <c:remove var="ErrorMessage" scope="session"/>
            </div>
            <table class="table table-bordered" style="margin-top: 40px">
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
                <c:forEach items="${order.getParcels()}" var="parcel" varStatus="loop">
                    <tr>
                        <td>${loop.index + 1}</td>
                        <td><c:out value="${parcel.getDescription()}"/></td>
                        <td>${parcel.getWeight()} kg</td>
                        <td>${parcel.getFromCountry()}</td>
                        <td>${parcel.getToCountry()}</td>
                        <td><c:out value="${parcel.getRecipientInfo()}"/></td>
                        <td>${parcel.isExpress()}</td>
                        <td>${parcel.getCost()}</td>
                        <td><a href="${pageContext.request.contextPath}/DeleteParcel?id=${loop.index}">delete</a></td>
                    </tr>
                </c:forEach>
                <tr>
                    <td colspan="9" style="text-align: right;">
                        Total number: ${order.getParcels().size()}; price - ${order.getTotalCost()}
                        <c:set var="count" value="${order.getParcels().size()}" scope="session"/>
                        <c:if test="${count != 0}">
                            <c:set var="name" value="${order.getParcels().get(0).getCurrency()}" scope="session"/>
                            ${name}
                        </c:if>
                    </td>
                </tr>
                </tbody>
            </table>
            <form role="form" method="POST" action="${pageContext.request.contextPath}/AddOrder">
                <button type="submit" class="btn btn-primary" style="float: right; margin-top: 24px;">
                    Confirm
                </button>
            </form>
        </div>
    </div>
</div>
<script>
    var numb = ${order.getParcels().size()};

    if (numb != 0) {
        var getCurrency = localStorage.getItem('selectedCurrency')
        $('#currency').val(getCurrency);
        document.getElementById('currency').disabled = true;
    }
    else {
        document.getElementById('currency').disabled = false;
    }
</script>
</body>

</html>
