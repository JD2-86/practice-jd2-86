<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="jstl-connect.jsp"%>
<html>
<head>
    <title>Heroes</title>
    <%@ include file="css-connect.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="heroes">
    <c:forEach items="${requestScope.hero_storage.database}" var="hero">
        <p><a href="${pageContext.request.contextPath}/hero?id=${hero.key}">${hero.value.nickname}</a></p>
    </c:forEach>
</div>
</body>
</html>
