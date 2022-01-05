<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>My form</title>
    <link rel="stylesheet" href="resources/style.css"/>
</head>

<body>
<form action="servletForOutputData" id="myForm" method="get">
    <fieldset>
        <legend>Registration Form</legend>
        <label for="name">Name</label>
        <input name="name" id="name" type="text" required minlength="1" oninvalid="this.setCustomValidity('Enter name')" oninput="setCustomValidity('')">
        <br>
        <label for="surname">Surname</label>
        <input name="surname" id="surname" type="text" required minlength="1" oninvalid="this.setCustomValidity('Enter surname')" oninput="setCustomValidity('')">
        <br>
        <label for="email">E-mail</label>
        <input name="email" id="email" type="text" required minlength="1" oninvalid="this.setCustomValidity('Enter email')" oninput="setCustomValidity('')">
        <br>
        <label for="telephoneNumber">Telephone number</label>
        <input name="telephoneNumber" id="telephoneNumber" type="text" required minlength="7" oninvalid="this.setCustomValidity('Enter phone number')" oninput="setCustomValidity('')">
        <br>
    </fieldset>
    <br>
    <input type="submit" value="Send">
</form>
</body>

</html>