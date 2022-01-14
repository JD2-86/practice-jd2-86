<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Get song</title>
</head>
<body>
<form action="<c:url value="/get-song"/>" method="get">
  <fieldset>
    <legend>Get song</legend>
    <label for="title">Song title</label>
    <input name="title" id="title" type="text" required oninvalid="this.setCustomValidity('Enter title')" oninput="setCustomValidity('')">
  </fieldset>
  <br>
  <input type="submit" value="Send">
</form><br>
<p><a href="${pageContext.request.contextPath}/index.jsp">Back</a></p>
</body>
</html>
