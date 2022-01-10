<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Artist's list</title>
</head>
<body>
<table border="1">
    <caption>Список артистов</caption>
    <tr>
        <th>Номер артиста (группы)</th>
        <th>Имя артиста (группы)</th>
        <th>Страна Происхождения</th>
    </tr>
    <c:forEach var="entry" items="${requestScope.allArtists}">
            <tr>
                <td><c:out value="${entry.value.id}"/></td>
                <td><c:out value="${entry.value.name}"/></td>
                <td><c:out value="${entry.value.country}"/></td>
            </tr>
        </c:forEach>
</table>
<br>
<c:forEach begin="1" end="${requestScope.pagesNumber}" var="i">
    <a href="${pageContext.request.contextPath}/get-all-artists?page=${i}&pageSize=${requestScope.pageSize}">${i}</a>
</c:forEach>
<br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p><br>
</body>
</html>
