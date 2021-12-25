<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form of creation of new user</title>
</head>
<body>
<form method="post" action="/lesson5/api/users">
    <fieldset>
        <legend>Form to fill in fields</legend>
        <label for="firstName">FirstName:</label>
        <input type="text" id="firstName" name="firstName">
        <p>
            <label for="lastName">LastName</label>
            <input type="text" id="lastName" name="lastName">
        </p>
        <p>
            <label for="email">E-mail</label>
            <input type="email" id="email" name="email">
        </p>
        <p>
            <label for="userName">UserName</label>
            <input type="text" id="userName" name="userName">
        </p>
        <p>
            <label for="password">Password</label>
            <input type="password" id="password" name="password">
        </p>
        <p>
            <input type="submit" name="Send">
        </p>
    </fieldset>
</form>
</body>
</html>
