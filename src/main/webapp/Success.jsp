<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Notebook
  Date: 26.06.2023
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
</head>
<body>
<h1>Done</h1>
<c:forEach var="elem" items="${products}">
    <h1><c:out value="${elem.name}"></c:out></h1>
</c:forEach>
</body>
</html>
