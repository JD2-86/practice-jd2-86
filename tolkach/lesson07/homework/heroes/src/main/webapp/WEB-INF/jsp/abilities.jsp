<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% Integer i = (Integer) request.getAttribute("Count"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE>
<html>
<head>
    <jsp:include page="common/css-connect.jsp"/>
    <title>Abilities</title>
</head>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<body>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-auto">
                    <br>
                    <c:forEach var="ability" items="${abilities}">
                        <p>${ability}</p>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
