<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<% Integer i = (Integer) request.getAttribute("CountOfHeroes"); %>
<!DOCTYPE html>
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
                    <%for (int j = 0; j < i; j++) {
                                response.getWriter().println("<p>" + request.getAttribute("Ability" + j) + "</p>");

                    }%>
                </div>
            </div>
        </div>
    </section>
</body>
</html>