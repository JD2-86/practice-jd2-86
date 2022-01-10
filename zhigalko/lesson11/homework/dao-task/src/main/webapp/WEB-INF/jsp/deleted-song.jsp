<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Deleted song</title>
</head>
<body>
<h3>Удалена композиция:</h3>
<p>Песня: ${requestScope.song.title}</p>
<p>Имя артиста (группы): ${requestScope.artist.name}</p>
<br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p>
</body>
</html>
