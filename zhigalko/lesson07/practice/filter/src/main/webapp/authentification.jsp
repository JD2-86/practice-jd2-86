<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authentification.jsp</title>
</head>
<body>
<form action="process" method="post">
    <fieldset>
        <legend>Authentification Form</legend>
        <label for="username">Username</label>
        <input name="username" id="username" type="text" required>
        <br>
        <label for="password">Password</label>
        <input name="password" id="password" type="text" required>
        <br>
        <input type="submit" value="Send">
    </fieldset>
</form>
</body>
</html>
