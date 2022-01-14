<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>Имя артиста (группы): ${requestScope.artist.name}</p>
<p>Страна происхождения артиста (группы): ${requestScope.artist.country}</p>
<br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p>
</body>
</html>
