<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 12.11.2016
  Time: 0:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <script src="${pageContext.request.contextPath}/js/custom/custom.js"></script>
    <script src="${pageContext.request.contextPath}/js/dropdown/script.min.js"></script>

</head>
<body>
    <jsp:useBean id="user" class="entity.User" scope="session"/>
    <c:if test="${user.getUsername() == null}">
        <c:redirect url="/"/>
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
                                <li class="nav-item"><a class="nav-link link"
                                                        href="${pageContext.request.contextPath}/jsp/account.jsp">ACCOUNT</a>
                                </li>

                                <c:choose>
                                <c:when test="${user.isAdmin()}">
                                    <li class="nav-item"><a class="nav-link link" href="${pageContext.request.contextPath}/ShowUsers">USERS</a>
                                    </li>
                                    <li class="nav-item"><a class="nav-link link" href="${pageContext.request.contextPath}/jsp/about.jsp">ABOUT US</a>
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="dropdown-toggle nav-link link" style="background: transparent;"
                                           data-toggle="dropdown" href="#">REPORTS
                                            <span class="caret"></span></a>
                                        <ul class="dropdown-menu" style="min-width: 100%;background: #282828;padding: 10px 10px 10px 20px;border-radius: 5px;">
                                            <li class="nav-link link" style="margin: 0.5rem;"><a href="${pageContext.request.contextPath}/jsp/topUsers.jsp">TOP 20 USERS</a></li>
                                            <li class="nav-link link" style="margin: 0.5rem;"><a href="${pageContext.request.contextPath}/jsp/ordersOnDate.jsp">ORDERS ON DATE</a></li>
                                            <li class="nav-link link" style="margin: 0.5rem;"><a href="${pageContext.request.contextPath}/jsp/yearReport.jsp">YEAR REPORT</a></li>
                                        </ul>
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="dropdown-toggle nav-link link" style="background: transparent;"
                                           data-toggle="dropdown" href="#">STATISTICS
                                            <span class="caret"></span></a>
                                        <ul class="dropdown-menu" style="min-width: 100%;background: #282828;padding: 10px 10px 10px 20px;border-radius: 5px;">
                                            <li class="nav-link link" style="margin: 0.5rem;"><a href="${pageContext.request.contextPath}/UsersStat">USERS</a></li>
                                            <li class="nav-link link" style="margin: 0.5rem;"><a href="${pageContext.request.contextPath}/jsp/orderStatistic.jsp">ORDERS</a></li>
                                        </ul>
                                    </li>
                                </c:when>
                                    <c:when test="${user.isSimpleUser()}">
                                        <li class="nav-item"><a class="nav-link link" href="${pageContext.request.contextPath}/UserOrders">MY HISTORY</a>
                                        </li>
                                        <li class="nav-item nav-btn"><a class="nav-link btn btn-white btn-white-outline" href="${pageContext.request.contextPath}/NewOrder">New ORDER</a></li>
                                    </c:when>
                                </c:choose>

                                <li class="nav-item nav-btn"><a class="nav-link btn btn-info" href="${pageContext.request.contextPath}/SignOut">Sign Out</a>
                                </li>
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
                <form role="form" method="POST" action="${pageContext.request.contextPath}/EditUser" novalidate>

                <div class="form-group col-md-12" style="color: #ff0000">
                    <c:out value="${sessionScope.PasswordMessage}"/>
                    <c:remove var="PasswordMessage" scope="session"/>
                    <c:out value="${sessionScope.Message}"/>
                    <c:remove var="Message" scope="session"/>
                </div>


                <legend style="font-size: xx-large;">My account details</legend>

                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">Username: <c:out value="${user.getUsername()}"/>
                    </label>
                </div>

                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">Email: <c:out value="${user.getEmail()}"/>
                        <a data-toggle="collapse" href="#collapse6">
                            edit
                        </a>
                    </label>
                    <div id="collapse6" class="panel-collapse collapse">
                        <label for="newEmail">New Email: </label>
                        <input maxlength="50" type="email" class="form-control" name="newEmail"
                                   id="newEmail" pattern="[a-z0-9._%+-]+@[a-z0-9]+\.[a-z]{2,4}$" value="${user.getEmail()}"
                                   placeholder="new email"
                                   title="Enter your email, please. Format: example@example.com."
                                   oninvalid="setCustomValidity('Wrong email form. Try one more time, please.')"
                                   onchange="try{setCustomValidity('')}catch(e){}">
                </div>
                </div>

                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">First name: <c:out value="${user.getFirstName()}"/>
                        <a data-toggle="collapse" href="#collapse1">
                            edit
                        </a>
                    </label>
                    <div id="collapse1" class="panel-collapse collapse">
                        <label for="newFirstName">New First name: </label>
                        <input type="text" class="form-control" name="newFirstName" id="newFirstName"
                               maxlength="30" value="${user.getFirstName()}" pattern="^[A-Z][a-z]{2,30}$"
                               placeholder="new first name"
                               title="Enter your new first name. Only letters. The first letter should be capitalized. From 3 to 30 characters."
                               oninvalid="setCustomValidity('Wrong new first name.' +
                                ' Only letters. The first letter should be capitalized. From 3 to 30 characters.')"
                               onchange="try{setCustomValidity('')}catch(e){}">
                    </div>
                </div>
                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">Second name: <c:out value="${user.getLastName()}"/>
                        <a data-toggle="collapse" href="#collapse2">
                            edit
                        </a>
                    </label>
                    <div id="collapse2" class="panel-collapse collapse">
                        <label for="newSecondName">New Second name: </label>
                        <input type="text" class="form-control" name="newSecondName" id="newSecondName"
                               maxlength="30" value="${user.getLastName()}" pattern="^[A-Z][a-z]{2,30}$"
                               placeholder="new second name"
                               title="Enter your new last name. Only letters. The first letter should be capitalized. From 3 to 30 characters."
                               oninvalid="setCustomValidity('Wrong new last name.' +
                                ' Only letters. The first letter should be capitalized. From 3 to 30 characters.')"
                               onchange="try{setCustomValidity('')}catch(e){}">
                    </div>
                </div>

                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">Phone number: <c:out value="${user.getPhoneNumber()}"/>
                        <a data-toggle="collapse" href="#collapse3">
                            edit
                        </a>
                    </label>
                    <div id="collapse3" class="panel-collapse collapse">
                        <label for="newPhoneNumber">New Phone number: </label>
                        <input type="text" class="form-control" name="newPhoneNumber" pattern="(\d){7,13}"
                               id="newPhoneNumber" value="${user.getPhoneNumber()}"
                               placeholder="new phone number" maxlength="13"
                               title="Enter your new phone number. Only digits. No spaces. From 7 to 13 digits."
                               oninvalid="setCustomValidity('Wrong new phone number format.' +
                                ' Only digits. No spaces. From 7 to 13 digits.')"
                               onchange="try{setCustomValidity('')}catch(e){}">
                    </div>
                </div>

                <div class="form-group col-md-12 center-block" style="margin-bottom: 1px;">
                    <label style="font-size: x-large">Address: <c:out value="${user.getAddress()}"/>
                        <a data-toggle="collapse" href="#collapse4">
                            edit
                        </a>
                    </label>
                    <div id="collapse4" class="panel-collapse collapse">
                        <label for="newAddress">New Address: </label>
                        <input type="text" class="form-control" name="newAddress" id="newAddress" value="${user.getAddress()}"
                               maxlength="100" placeholder="New address" pattern="^[a-zA-Z][a-zA-Z0-9-_\. ]{2,100}$"
                               title="Enter your new address. From 3 to 100 characters. Only letters, digits, dots, commas and next symbols: - \\ _. "
                               oninvalid="setCustomValidity('Wrong new address format.' +
                                ' Only letters, digits, dots, commas and next symbols: - \\ _.  From 3 to 100 characters.')"
                               onchange="try{setCustomValidity('')}catch(e){}">
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
                        <input maxlength="20" type="password" class="form-control" name="oldPassword" id="oldPassword"
                               placeholder="Old password">
                        <div class="form-group col-md-6" style="padding-left: 0px;  padding-top: 5px">
                            <label for="newPassword">New password: </label>
                            <input type="password" class="form-control" name="newPassword" id="newPassword"
                                   placeholder="New password"  pattern="^[a-zA-Z0-9]{2,20}$" maxlength="20"
                                   title="Enter your new password. First character only letter. Other - letters or digits. From 3 to 20 characters."
                                   oninvalid="setCustomValidity('Wrong new password.' +
                                ' First character only letter. Other - letters or digits. From 3 to 20 characters.')"
                                   onchange="try{setCustomValidity('')}catch(e){}">
                        </div>
                        <div class="form-group col-md-6" style="padding-left: 0px; padding-right: 0px; padding-top: 5px">
                            <label for="newPassword2">One more time: </label>
                            <input type="password" class="form-control" name="newPassword2" id="newPassword2"
                                   placeholder="New password one more time" pattern="^[a-zA-Z0-9]{2,20}$" maxlength="20"
                                   title="Enter your new password one more time, please."
                                   oninvalid="setCustomValidity('Wrong new password.' +
                                ' First character only letter. Other - letters or digits. From 3 to 20 characters.')"
                                   onchange="try{setCustomValidity('')}catch(e){}">
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
