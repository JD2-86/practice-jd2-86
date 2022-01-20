<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Get Song And Artist</title>
</head>
<body>
<form action="<c:url value="/get-song-and-artist"/>" method="get">
    <fieldset>
        <legend>Get Song And Artist</legend>
        <label for="title">Song Title</label>
        <input name="title" id="title" type="text" required oninvalid="this.setCustomValidity('Enter title')" oninput="setCustomValidity('')">
    </fieldset>
    <br>
    <input type="submit" value="Submit">
</form><br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Main Page</a></p>
</body>
</html>
