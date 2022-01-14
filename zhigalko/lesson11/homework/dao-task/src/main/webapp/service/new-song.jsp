<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>registration new song</title>
</head>
<body>
<form action="<c:url value="/new-song"/>" method="post">
    <fieldset>
        <legend>New Song Registration</legend>
        <label for="artist">Artist</label>
        <input name="artist" id="artist" type="text" required oninvalid="this.setCustomValidity('Enter artist')" oninput="setCustomValidity('')">
        <br>
        <label for="title">New Song</label>
        <input name="title" id="title" type="text" required oninvalid="this.setCustomValidity('Enter title')" oninput="setCustomValidity('')">
        <br>
        <label for="album">Album</label>
        <input name="album" id="album" type="text" required oninvalid="this.setCustomValidity('Enter album')" oninput="setCustomValidity('')">
        <br>
        <label for="recorded">Year of record</label>
        <input name="recorded" id="recorded" type="number" required oninvalid="this.setCustomValidity('Enter recorded year')" oninput="setCustomValidity('')">
        <br>
        <label for="length">Length</label>
        <input name="length" id="length" type="text" required oninvalid="this.setCustomValidity('Enter song length')" oninput="setCustomValidity('')">
        <br>
    </fieldset>
    <br>
    <input type="submit" value="Send">
</form><br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p>
</body>
</html>
