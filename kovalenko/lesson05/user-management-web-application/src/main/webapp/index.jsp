<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Lesson 5</title>
</head>
<body>
<h1><%= "Options page" %>
</h1>
<br/>
<p><a href="${pageContext.request.contextPath}/admin/init">Initialize 10 users</a></p>
<p><a href="${pageContext.request.contextPath}/view/users/*">Inferring the user information</a> Instead of * in the
    address bar, enter a user ID</p>
<p><a href="${pageContext.request.contextPath}/view/command/create-user">Create a new user</a></p>
<p><a href="${pageContext.request.contextPath}/view/users">User information in tabular form</a> Enter a page and
    pageSize in the address line as parameters</p>
</body>
</html>
