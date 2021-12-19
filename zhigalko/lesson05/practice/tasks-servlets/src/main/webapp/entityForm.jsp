<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Entity Form</title>
</head>
<body>

<form action="servletGetDataFromForm" method="post">
    <fieldset>
        <legend>Registration Form</legend>
        <label for="name">Name</label>
        <input name="name" id="name" type="text" required>
        <br>
        <label for="surname">Surname</label>
        <input name="surname" id="surname" type="text" required>
        <br>
        <label for="email">E-mail</label>
        <input name="email" id="email" type="text" required>
        <br>
    </fieldset>
    <br>
    <input type="submit" value="Send">
</form>

</body>
</html>
