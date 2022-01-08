<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="common/jstl-connect.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common/css-connect.jsp"/>
    <title>Heroes</title>
</head>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<body>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-auto">
                    <c:forEach var="hero" items="${heroes}">
                        <br>
                        <a href="${pageContext.request.contextPath}/specific-hero/${hero}">${hero}</a>
                    </c:forEach>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
