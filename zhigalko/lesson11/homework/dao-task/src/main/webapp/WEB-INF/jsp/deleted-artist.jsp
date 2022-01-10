<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Deleted artist</title>
</head>
<body>
<h3>Удален артист:</h3>
<p>Имя артиста (группы): ${requestScope.artist.name}</p>
<br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p>
</body>
</html>
