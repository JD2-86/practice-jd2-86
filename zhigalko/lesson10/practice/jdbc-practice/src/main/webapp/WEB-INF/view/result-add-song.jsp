<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>В нашу программу добавлена новая композиция:</h3>
<p>Имя артиста (группы): ${requestScope.artist}</p>
<p>Название композиции: ${requestScope.title}</p>
<p>Альбом: ${requestScope.album}</p>
<p>Год записи: ${requestScope.recorded}</p>
<p>Длина композиции: ${requestScope.length}</p>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p>
</body>
</html>
