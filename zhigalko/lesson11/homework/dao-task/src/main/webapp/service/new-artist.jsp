<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Registration new artist</title>
</head>
<body>
<form action="<c:url value="/new-artist"/>" method="post">
    <fieldset>
        <legend>Registration new artist</legend>
        <label for="artist">New Artist</label>
        <input name="artist" id="artist" type="text" required oninvalid="this.setCustomValidity('Enter artist')" oninput="setCustomValidity('')">
        <br>
        <label for="country">Country</label>
        <input name="country" id="country" type="text" required oninvalid="this.setCustomValidity('Enter country')" oninput="setCustomValidity('')">
        <br>
    </fieldset>
    <br>
    <input type="submit" value="Send">
</form><br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p>
</body>
</html>
