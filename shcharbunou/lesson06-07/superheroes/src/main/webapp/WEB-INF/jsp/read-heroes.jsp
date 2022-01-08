<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/jstl-connect.jsp" %>
<html>
<head>
    <title>Heroes</title>
    <%@ include file="common/css-connect.jsp" %>
</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="container">
    <c:forEach items="${requestScope.heroes}" var="hero">
        <p><a href="${pageContext.request.contextPath}/hero?id=${hero.id}">${hero.name}</a></p>
    </c:forEach>
</div>
</body>
</html>