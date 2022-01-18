<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Songs</title>
</head>
<body>
<c:if test="${requestScope.artist.name!=null}">
    <p>Artist: ${requestScope.artist.name}</p> <br>
</c:if>
<c:if test="${requestScope.artist.name==null}">
    <p>Artist: ${applicationScope.artist.name}</p> <br>
</c:if>

<table border="1">
    <caption>Songs</caption>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Album</th>
        <th>Year</th>
        <th>Length</th>
    </tr>
    <c:forEach var="entry" items="${requestScope.songs}">
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
    <c:forEach begin="1" end="${requestScope.pagesCount}" var="i">
        <a href="${pageContext.request.contextPath}/artist/songs?page=${i}&pageSize=${requestScope.pageSize}">${i}</a>
    </c:forEach>
</c:if>
<br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Main Page</a></p>
</body>
</html>
