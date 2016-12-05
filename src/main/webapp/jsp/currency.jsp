<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Alexandr
  Date: 04.12.2016
  Time: 21:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency test</title>
</head>
<body>
<jsp:useBean id="currency" class="java.util.ArrayList" scope="session"/>

<select name="fromCountry" id="from" required class="form-control">
    <c:forEach items="${countries}" var="country">
        <option value="${country.getId()}">${country.getCountryNameEN()}</option>
    </c:forEach>
</select>

</body>
</html>
