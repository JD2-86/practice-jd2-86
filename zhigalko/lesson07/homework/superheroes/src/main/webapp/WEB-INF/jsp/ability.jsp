<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="jstl-connect.jsp"%>
<html>
<head>
    <title>Abilities</title>
    <%@ include file="css-connect.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="abilities">
    <c:forEach items="${requestScope.ability_storage.ability_db}" var="ability">
        <p>${ability.value.nameOfAbility}</p>
    </c:forEach>
</div>
</body>
</html>
