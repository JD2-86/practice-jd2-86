<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Artist</title>
</head>
<body>
<h2>Artist</h2>
<p>Name: ${requestScope.artist.name}</p>
<p>Country: ${requestScope.artist.country}</p>
<br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Main Page</a></p>
</body>
</html>
