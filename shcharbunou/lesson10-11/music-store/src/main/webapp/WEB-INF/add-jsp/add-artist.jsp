<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add Artist</title>
</head>
<body>
<form action="<c:url value="/add-artist"/>" method="post">
    <fieldset>
        <legend>Add Artist</legend>
        <label for="name">Name</label>
        <input name="name" id="name" type="text" required oninvalid="this.setCustomValidity('Enter name')" oninput="setCustomValidity('')">
        <br>
        <label for="country">Country</label>
        <input name="country" id="country" type="text" required oninvalid="this.setCustomValidity('Enter country')" oninput="setCustomValidity('')">
        <br>
    </fieldset>
    <br>
    <input type="submit" value="Submit">
</form><br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Main Page</a></p>
</body>
</html>
