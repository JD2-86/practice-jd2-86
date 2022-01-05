<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>В нашу программу добавлен новый артист:</h3>
<p>Имя артиста (группы): ${requestScope.artist}</p>
<p>Страна происхождения  артиста (группы): ${requestScope.country}</p>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p>
</body>
</html>
