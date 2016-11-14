<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 11.11.2016
  Time: 23:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Registration</title>
    <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/logo.png" type="image/x-icon">
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
</head>
<body>
<div class="container">
    <div class="row">

        <div class="col-md-8 col-md-offset-2">
            <form role="form" method="POST" action="${pageContext.request.contextPath}/SignUp" style="margin-top: 4rem">

                <c:out value="${sessionScope.SignUpError}"/>
                <c:remove var="SignUpError" scope="session"/>


                <legend class="text-center">Registration</legend>

                <fieldset>
                    <legend>Account Details</legend>

                    <div class="form-group col-md-6">
                        <label for="username">Username</label>
                        <input type="text" class="form-control" name="username" id="username" required
                               placeholder="Username">
                    </div>


                    <div class="form-group col-md-6">
                        <label for="email">Email</label>
                        <input type="email" class="form-control" name="email" id="email" required placeholder="Email">
                    </div>

                    <div class="form-group col-md-6">
                        <label for="password">Password</label>
                        <input type="password" class="form-control" name="password" id="password" required
                               placeholder="Password">
                    </div>

                    <div class="form-group col-md-6">
                        <label for="confirm_password">Confirm Password</label>
                        <input type="password" class="form-control" name="" id="confirm_password" required
                               placeholder="Confirm Password">
                    </div>


                </fieldset>

                <fieldset>
                    <legend>Optional Details</legend>

                    <div class="form-group col-md-6">
                        <label for="first_name">First name</label>
                        <input type="text" class="form-control" name="firstName" id="first_name" placeholder="First Name">
                    </div>

                    <div class="form-group col-md-6">
                        <label for="last_name">Last name</label>
                        <input type="text" class="form-control" name="lastName" id="last_name" placeholder="Last Name">
                    </div>

                    <div class="form-group col-md-6">
                        <label for="phone_number">Phone number</label>
                        <input type="tel" class="form-control" name="phoneNumber" id="phone_number"
                               placeholder="Phone number">
                    </div>

                    <div class="form-group col-md-6">
                        <label for="address">Address</label>
                        <input type="text" class="form-control" name="address" id="address" placeholder="Your address">
                    </div>


                </fieldset>


                <div class="form-group">
                    <div class="col-md-12">
                        <button type="submit" class="btn btn-primary">
                            Sign up
                        </button>
                        <a href="${pageContext.request.contextPath}#SignIn" style="margin-left: 20px"
                        >Already have an account?</a>
                    </div>
                </div>

            </form>
        </div>

    </div>
</div>

</body>
</html>
