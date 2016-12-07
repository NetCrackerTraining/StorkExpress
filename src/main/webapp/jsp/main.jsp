<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Main</title>
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
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/theme/css/style.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/mobirise/css/mbr-additional.css"
          type="text/css">

    <script src="${pageContext.request.contextPath}/js/web/assets/jquery/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/bootstrap/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/dropdown/script.min.js"></script>

    <script type="text/javascript">
        jQuery(document).ready(function($) {
            var target = document.location.hash.replace("#", "");
            if (target.length) {
                if(target=="SignIn"){
                    $('#myModal').modal('show');
                }
            }
        });
    </script>

</head>
<body>
<section class="mbr-section mbr-section-hero mbr-section-full mbr-parallax-background" id="header1-2"
         style="background-image: url(${pageContext.request.contextPath}/images/photo-1454165804606-c3d57bc86b40-2000x1334-34.jpg);">

    <jsp:useBean id="user" class="entity.User" scope="session"/>
    <c:if test="${user.getUsername() != null}">
        <c:redirect url="/jsp/account.jsp"></c:redirect>
    </c:if>

    <div class="mbr-overlay" style="opacity: 0.5; background-color: rgb(0, 0, 0);"></div>

    <div class="mbr-table-cell">

        <div class="container">
            <div class="row">
                <div class="mbr-section col-md-10">

                    <h1 class="mbr-section-title display-1">Stork Express</h1>
                    <p class="mbr-section-lead lead">Your package is in good hands.
                        <br>Fast and accurate delivery
                        service.<br>
                    </p>
                    <div class="mbr-section-btn">
                        <a class="btn btn-lg btn-white" data-toggle="modal" data-target="#myModal"
                           >LOG IN!</a>

                        <a class="btn btn-lg btn-white btn-white-outline"
                                href="${pageContext.request.contextPath}/jsp/registration.jsp"
                                >SIGN UP
                        </a>

                        <a class="btn btn-lg btn-white btn-white-outline"
                                href="${pageContext.request.contextPath}/jsp/about.jsp"
                                >ABOUT US
                        </a>
                    </div>

                </div>
            </div>
        </div>
    </div>

</section>
<form role="form" method="POST" action="${pageContext.request.contextPath}/SignIn">
    <div id="myModal" class="modal fade" role="dialog">
        <div class="modal-dialog">

            <!-- Modal content-->
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal">&times;</button>
                    <h4 class="modal-title">Sign in to Stork Express</h4>
                </div>
                <div class="modal-body">
                    <div class="container-fluid bd-example-row">



                        <div class="row">
                            <div class="form-group col-md-6">
                                <label for="username">Username</label>
                                <input maxlength="30" type="text" class="form-control" name="username" id="username"
                                       required
                                       placeholder="Username">
                            </div>
                            <div class="form-group col-md-6" >
                                <label for="password">Password</label>
                                <input maxlength="20" type="password" class="form-control" name="password" id="password"
                                       required
                                       placeholder="Password">
                            </div>
                        </div>
                    </div>
                </div>
                <div class="modal-footer">
                    <div class="form-group col-md-6" style="color: #ff0000">
                        <c:out value="${sessionScope.SignInError}"/>
                        <c:remove var="SignInError" scope="session"/>
                    </div>
                    <button type="submit" class="btn btn-primary" style="margin-bottom: 0px">Sign in</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal" style="margin-right: 15px">Close</button>

                </div>
            </div>
        </div>
    </div>
</form>
</body>
</html>
