<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Songs</title>
</head>
<body>
<c:if test="${requestScope.artist.name!=null}">
    <p>Имя артиста (группы): ${requestScope.artist.name}</p> <br>
</c:if>
<c:if test="${requestScope.artist.name==null}">
    <p>Имя артиста (группы): ${applicationScope.artist.name}</p> <br>
</c:if>

<table border="1">
    <caption>Список композиций</caption>
    <tr>
        <th>Номер</th>
        <th>Название композиции</th>
        <th>Альбом</th>
        <th>Год записи</th>
        <th>Длина композиции</th>
    </tr>
    <c:forEach var="entry" items="${requestScope.allSongs}">
        <tr>
            <td><c:out value="${entry.value.id}"/></td>
            <td><c:out value="${entry.value.title}"/></td>
            <td><c:out value="${entry.value.album}"/></td>
            <td><c:out value="${entry.value.recorded}"/></td>
            <td><c:out value="${entry.value.length}"/></td>
        </tr>
    </c:forEach>
</table><br>
<c:if test="${param.page!=null}">
    <c:forEach begin="1" end="${requestScope.pagesNumber}" var="i">
        <a href="${pageContext.request.contextPath}/artist/songs?page=${i}&pageSize=${requestScope.pageSize}">${i}</a>
    </c:forEach>
</c:if>
<br>
<p><a href="${pageContext.request.contextPath}/service/get-artist-songs.jsp">Back</a></p>
</body>
</html>
