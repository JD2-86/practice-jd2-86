<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Update artist</title>
</head>
<body>
<form action="<c:url value="/update-artist"/>" method="post">
    <fieldset>
        <legend>Update artist</legend>
        <label for="old_artist">Old Artist</label>
        <input name="old_artist" id="old_artist" type="text" required oninvalid="this.setCustomValidity('Enter old artist')" oninput="setCustomValidity('')">
        <br>
        <label for="new_artist">New Artist</label>
        <input name="new_artist" id="new_artist" type="text" required oninvalid="this.setCustomValidity('Enter new artist')" oninput="setCustomValidity('')">
        <br>
        <label for="new_country">Country</label>
        <input name="new_country" id="new_country" type="text" required oninvalid="this.setCustomValidity('Enter new country')" oninput="setCustomValidity('')">
        <br>
    </fieldset>
    <br>
    <input type="submit" value="Send">
</form><br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p>
</body>
</html>
