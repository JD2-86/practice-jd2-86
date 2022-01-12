<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Artist songs</title>
</head>
<body>
<form action="<c:url value="/get-all-artist-songs"/>" method="get">
    <fieldset>
        <legend>Artist</legend>
        <label for="artist">Artist</label>
        <input name="artist" id="artist" type="text" required oninvalid="this.setCustomValidity('Enter artist')" oninput="setCustomValidity('')">
    </fieldset>
    <br>
    <input type="submit" value="Send">
</form><br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p>
</body>
</html>