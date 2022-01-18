<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Delete artist</title>
</head>
<body>
<form action="<c:url value="/delete-artist"/>" method="post">
    <fieldset>
        <legend>Delete artist</legend>
        <label for="name">Name</label>
        <input name="name" id="name" type="text" required oninvalid="this.setCustomValidity('Enter artist')" oninput="setCustomValidity('')">
        <br>
    </fieldset>
    <br>
    <input type="submit" value="Submit">
</form><br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Main Page</a></p>
</body>
</html>
