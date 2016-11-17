<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 11.11.2016
  Time: 23:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Users</title>
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

<div class="container-fluid" style="position: relative; top: 15%;">
    <div class="row">
        <div class="col-md-12">
            <legend>List of users:</legend>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th>
                        Username:
                    </th>
                    <th>
                        Email:
                    </th>
                    <th>
                        Phone number:
                    </th>
                    <th>
                        Number of orders:
                    </th>
                    <th>
                        Total spending:
                    </th>
                </tr>
                </thead>
                <tbody>
<%--
                    <c:forEach items="${users}" var="users">
                    </c:forEach>
--%>

                    <tr>
                        <td>${users.username}</td>
                        <td>${users.email}</td>
                        <td>${users.phoneNumber}</td>
                        <td>number of orders.. <%--add there--%>
                        </td>
                        <td>total spending.. <%--add there--%>
                        </td>
                    </tr>
                    <tr>
                        <td>${users.username}</td>
                        <td>${users.email}</td>
                        <td>${users.phoneNumber}</td>
                        <td>number of orders.. <%--add there--%>
                        </td>
                        <td>total spending.. <%--add there--%>
                        </td>
                    </tr>
                    <tr>
                        <td>${users.username}</td>
                        <td>${users.email}</td>
                        <td>${users.phoneNumber}</td>
                        <td>number of orders.. <%--add there--%>
                        </td>
                        <td>total spending.. <%--add there--%>
                        </td>
                    </tr>
                    <tr>
                        <td>${users.username}</td>
                        <td>${users.email}</td>
                        <td>${users.phoneNumber}</td>
                        <td>number of orders.. <%--add there--%>
                        </td>
                        <td>total spending.. <%--add there--%>
                        </td>
                    </tr>
                    <tr>
                        <td>${users.username}</td>
                        <td>${users.email}</td>
                        <td>${users.phoneNumber}</td>
                        <td>number of orders.. <%--add there--%>
                        </td>
                        <td>total spending.. <%--add there--%>
                        </td>
                    </tr>
                    <tr>
                        <td>${users.username}</td>
                        <td>${users.email}</td>
                        <td>${users.phoneNumber}</td>
                        <td>number of orders.. <%--add there--%>
                        </td>
                        <td>total spending.. <%--add there--%>
                        </td>
                    </tr>
                    <tr>
                        <td>${users.username}</td>
                        <td>${users.email}</td>
                        <td>${users.phoneNumber}</td>
                        <td>number of orders.. <%--add there--%>
                        </td>
                        <td>total spending.. <%--add there--%>
                        </td>
                    </tr>
                    <tr>
                        <td>${users.username}</td>
                        <td>${users.email}</td>
                        <td>${users.phoneNumber}</td>
                        <td>number of orders.. <%--add there--%>
                        </td>
                        <td>total spending.. <%--add there--%>
                        </td>
                    </tr>
                    <tr>
                        <td>${users.username}</td>
                        <td>${users.email}</td>
                        <td>${users.phoneNumber}</td>
                        <td>number of orders.. <%--add there--%>
                        </td>
                        <td>total spending.. <%--add there--%>
                        </td>
                    </tr>
                    <tr>
                        <td>${users.username}</td>
                        <td>${users.email}</td>
                        <td>${users.phoneNumber}</td>
                        <td>number of orders.. <%--add there--%>
                        </td>
                        <td>total spending.. <%--add there--%>
                        </td>
                    </tr>

                </tbody>
                <tfoot>
                <tr>
                    <td colspan="5">
                        <nav aria-label="Page navigation">
                            <ul class="pagination" style="margin-top: 0.2rem; margin-bottom: 0.2rem; float: right">
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                        <span class="sr-only">Previous</span>
                                    </a>
                                </li>
                                <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li>
                                <li class="page-item"><a class="page-link" href="#">3</a></li>
                                <li class="page-item"><a class="page-link" href="#">4</a></li>
                                <li class="page-item"><a class="page-link" href="#">5</a></li>
                                <li class="page-item">
                                    <a class="page-link" href="#" aria-label="Next">
                                        <span aria-hidden="true">&raquo;</span>
                                        <span class="sr-only">Next</span>
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </td>
                </tr>
                </tfoot>
            </table>
        </div>
    </div>
</div>
</div>

</body>
</html>
