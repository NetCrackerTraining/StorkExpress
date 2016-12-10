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
    <script src="${pageContext.request.contextPath}/js/dropdown/script.min.js"></script>

</head>
<body>

<jsp:useBean id="user" class="entity.User" scope="session"/>
<c:if test="${user.getUsername() == null || !user.isAdmin()}">
    <c:redirect url="/jsp/account.jsp"></c:redirect>
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
                        <%--<li class="nav-item"><a class="nav-link link" href="${pageContext.request.contextPath}">RATES</a></li>--%>
                        <li class="nav-item"><a class="nav-link link"
                                                href="${pageContext.request.contextPath}/jsp/account.jsp">ACCOUNT</a>
                        </li>
                        <li class="nav-item"><a class="nav-link link"
                                                href="${pageContext.request.contextPath}/ShowUsers">USERS</a></li>
                        <%--<li class="nav-item nav-btn"><a class="nav-link btn btn-white btn-white-outline"--%>
                        <%--href="${pageContext.request.contextPath}/ShowOrders">ORDERS</a></li>--%>
                        <li class="nav-item"><a class="nav-link link"
                                                href="${pageContext.request.contextPath}/jsp/about.jsp">ABOUT US</a>
                        </li>
                        <li class="nav-item"><a class="nav-link link"
                                                href="${pageContext.request.contextPath}/jsp/report.jsp">REPORTS</a>
                        </li>

                        <li class="nav-item dropdown">
                            <a class="dropdown-toggle nav-link link" style="background: transparent;"
                               data-toggle="dropdown" href="#">STATISTICS
                                <span class="caret"></span></a>
                            <ul class="dropdown-menu"
                                style="min-width: 100%;background: #282828;padding: 10px 10px 10px 20px;border-radius: 5px;">
                                <li class="nav-link link" style="margin: 0.5rem;"><a
                                        href="${pageContext.request.contextPath}/jsp/userStatistic.jsp">USERS</a></li>
                                <li class="nav-link link" style="margin: 0.5rem;"><a
                                        href="${pageContext.request.contextPath}/jsp/orderStatistic.jsp">ORDERS</a></li>
                            </ul>
                        </li>

                        <li class="nav-item nav-btn"><a class="nav-link btn btn-info"
                                                        href="${pageContext.request.contextPath}/SignOut">Sign
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

<jsp:useBean id="users" class="java.util.ArrayList" scope="request"/>

<div class="container-fluid" style="position: relative; top: 15%;">
    <div class="row">
        <div class="col-md-12">
            <legend>List of users:</legend>
            <table class="table table-bordered">
                <thead style="background: rgba(228, 226, 224, 0.29);">
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
                    <%--TODO<th>Total spending:</th>--%>
                </tr>
                </thead>
                <tbody>

                <c:forEach items="${users}" var="user">
                    <tr>
                        <td><c:out value="${user.getUsername()}"/></td>
                        <td>${user.getEmail()}</td>
                        <td><c:out value="${user.getPhoneNumber()}"/></td>
                        <td>${user.getOrders().size()}</td>
                         <%--TODO <td>total spending.. add there</td>--%>
                    </tr>
                </c:forEach>

                </tbody>
                <tfoot style="background: rgba(228, 226, 224, 0.29);">
                <tr>
                    <td colspan="5" style="padding-top: 0.2rem; padding-bottom: 0.2rem;">
                        <nav aria-label="Page navigation">
                            <ul class="pagination" style="margin-top: 0.2rem; margin-bottom: 0.2rem; float: right">
                                <li class="page-item">
                                    <a class="page-link" href="${pageContext.request.contextPath}/ShowUsers?page=${pageNumber-1}" aria-label="Previous">
                                        <span aria-hidden="true">&laquo;</span>
                                        <span class="sr-only">Previous</span>
                                    </a>

                                <c:choose>
                                    <c:when test="${pageNumber-3>0}">
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ShowUsers?page=1">1</a></li>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <c:forEach var="i" begin="${pageNumber-1}" end="${pageNumber-1}">
                                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ShowUsers?page=${i}">${i}</a></li>
                                        </c:forEach>

                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="i" begin="1" end="${pageNumber-1}">
                                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ShowUsers?page=${i}">${i}</a></li>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>

                                <li class="page-item"><a class="page-link" style="color: black" href="#">${pageNumber}</a></li>


                                <c:choose>
                                    <c:when test="${pageAmount-pageNumber>2}">
                                        <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ShowUsers?page=${pageNumber+1}">${pageNumber+1}</a></li>
                                        <li class="page-item"><a class="page-link" href="#">...</a></li>
                                        <c:forEach var="i" begin="${pageAmount}" end="${pageAmount}">
                                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ShowUsers?page=${i}">${i}</a></li>
                                        </c:forEach>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="i" begin="${pageNumber+1}" end="${pageAmount}">
                                            <li class="page-item"><a class="page-link" href="${pageContext.request.contextPath}/ShowUsers?page=${i}">${i}</a></li>
                                        </c:forEach>
                                    </c:otherwise>
                                </c:choose>

                                    <a class="page-link" href="${pageContext.request.contextPath}/ShowUsers?page=${pageNumber+1}" aria-label="Next">
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
