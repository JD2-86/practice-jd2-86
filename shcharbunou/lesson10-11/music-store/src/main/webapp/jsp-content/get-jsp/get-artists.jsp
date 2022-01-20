<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Artists</title>
</head>
<body>
<table border="1">
    <caption>Artists</caption>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Country</th>
    </tr>
    <c:forEach var="entry" items="${requestScope.artists}">
        <tr>
            <td><c:out value="${entry.value.id}"/></td>
            <td><c:out value="${entry.value.name}"/></td>
            <td><c:out value="${entry.value.country}"/></td>
        </tr>
    </c:forEach>
</table>
<br>
<c:forEach begin="1" end="${requestScope.pagesCount}" var="i">
    <a href="${pageContext.request.contextPath}/get-artists?page=${i}&pageSize=${requestScope.pageSize}">${i}</a>
</c:forEach>
<br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Main Page</a></p><br>
</body>
</html>
