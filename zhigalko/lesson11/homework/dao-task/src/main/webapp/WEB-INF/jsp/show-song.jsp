<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test="${requestScope.artist.name!=null}">
    <p>Имя артиста (группы): ${requestScope.artist.name}</p>
</c:if>
<p>Название композиции: ${requestScope.song.title}</p>
<p>Альбом: ${requestScope.song.album}</p>
<p>Год записи: ${requestScope.song.recorded}</p>
<p>Длина композиции: ${requestScope.song.length}</p>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p>
</body>
</html>
