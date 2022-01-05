<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Task 2: Form Page</title>
</head>
<body>

<form method="get">
    <fieldset>
        <legend>Registration Form</legend>
        <label for="firstName">Name</label>
        <input name="firstName" id="firstName" type="text" required oninvalid="this.setCustomValidity('Enter firstname')" oninput="setCustomValidity('')">
        <br>
        <label for="lastName">Lastname</label>
        <input name="lastName" id="lastName" type="text" required oninvalid="this.setCustomValidity('Enter lastname')" oninput="setCustomValidity('')">
        <br>
        <label for="email">E-mail</label>
        <input name="email" id="email" type="text" required oninvalid="this.setCustomValidity('Enter email')" oninput="setCustomValidity('')">
        <br>
        <label for="username">Username</label>
        <input name="username" id="username" type="text" required oninvalid="this.setCustomValidity('Enter username')" oninput="setCustomValidity('')">
        <br>
        <label for="password">Password</label>
        <input name="password" id="password" type="text" required oninvalid="this.setCustomValidity('Enter password')" oninput="setCustomValidity('')">
        <br>
    </fieldset>
    <br>
    <input type="submit" value="Send">
</form>

</body>
</html>