<%@ page import="jakarta.servlet.http.HttpServletRequest"%>
<%--
  Created by IntelliJ IDEA.
  User: hoho
  Date: 23.12.2021
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Привет!!!!</title>
</head>
<body>
FirstName:
<%= request.getParameter("firstName") %>
<br>
LastName:
<%= request.getParameter("lastName") %>
<br>
Role:
<%= request.getParameter("role") %>
</body>
</html>
