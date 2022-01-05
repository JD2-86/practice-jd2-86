<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Form for update user</title>
</head>
<body>

<h2>Please enter new user data for update: </h2>

<form action="view/command/update-user" method="get">
    <fieldset>
        <legend>Update user's form</legend>
        <label for="id">Id User for update</label>
        <input name="id" id="id" type="text" required oninvalid="this.setCustomValidity('Enter id user for update')" oninput="setCustomValidity('')">
        <br>
        <label for="firstName">New Name</label>
        <input name="firstName" id="firstName" type="text" required oninvalid="this.setCustomValidity('Enter new firstname')" oninput="setCustomValidity('')">
        <br>
        <label for="lastName">New Lastname</label>
        <input name="lastName" id="lastName" type="text" required oninvalid="this.setCustomValidity('Enter new lastname')" oninput="setCustomValidity('')">
        <br>
        <label for="email">New E-mail</label>
        <input name="email" id="email" type="text" required oninvalid="this.setCustomValidity('Enter new email')" oninput="setCustomValidity('')">
        <br>
        <label for="username">New Username</label>
        <input name="username" id="username" type="text" required oninvalid="this.setCustomValidity('Enter new username')" oninput="setCustomValidity('')">
        <br>
        <label for="password">New Password</label>
        <input name="password" id="password" type="text" required oninvalid="this.setCustomValidity('Enter new password')" oninput="setCustomValidity('')">
        <br>
    </fieldset>
    <br>
    <input type="submit" value="Send">
</form>
</body>
</html>