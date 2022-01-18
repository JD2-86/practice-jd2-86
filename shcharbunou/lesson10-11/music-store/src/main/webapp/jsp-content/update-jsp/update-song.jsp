<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update Song</title>
</head>
<body>
<form action="<c:url value="/update-song"/>" method="post">
    <fieldset>
        <legend>Update Song</legend>
        <label for="old_title">Old Song</label>
        <input name="old_title" id="old_title" type="text" required oninvalid="this.setCustomValidity('Enter old title')" oninput="setCustomValidity('')">
        <br>
        <label for="artist">Artist</label>
        <input name="artist" id="artist" type="text" required oninvalid="this.setCustomValidity('Enter artist')" oninput="setCustomValidity('')">
        <br>
        <label for="new_title">New Song</label>
        <input name="new_title" id="new_title" type="text" required oninvalid="this.setCustomValidity('Enter new title')" oninput="setCustomValidity('')">
        <br>
        <label for="new_album">New Album</label>
        <input name="new_album" id="new_album" type="text" required oninvalid="this.setCustomValidity('Enter new album')" oninput="setCustomValidity('')">
        <br>
        <label for="new_recorded">New Year of record</label>
        <input name="new_recorded" id="new_recorded" type="number" required oninvalid="this.setCustomValidity('Enter new recorded year')" oninput="setCustomValidity('')">
        <br>
        <label for="new_length">Length</label>
        <input name="new_length" id="new_length" type="text" required oninvalid="this.setCustomValidity('Enter song length')" oninput="setCustomValidity('')">
        <br>
    </fieldset>
    <br>
    <input type="submit" value="Submit">
</form><br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Main Page</a></p>
</body>
</html>