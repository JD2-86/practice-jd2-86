<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Song's list</title>
</head>
<body>
<table border="1">
    <caption>Список композиций</caption>
    <tr>
        <th>Номер</th>
        <th>Композиция</th>
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
</table>
<br>
<c:forEach begin="1" end="${requestScope.pagesNumber}" var="i">
    <a href="${pageContext.request.contextPath}/get-all-songs?page=${i}&pageSize=${requestScope.pageSize}">${i}</a>
</c:forEach>
<br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p><br>
</body>
</html>
