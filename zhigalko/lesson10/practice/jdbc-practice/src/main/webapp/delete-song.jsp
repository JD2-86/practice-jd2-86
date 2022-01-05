<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="delete-song" method="post">
    <fieldset>
        <legend>New Song Registration</legend>
        <label for="del-song">Song</label>
        <input name="del-song" id="del-song" type="text" required oninvalid="this.setCustomValidity('Enter song')" oninput="setCustomValidity('')">
        <br>
    </fieldset>
    <br>
    <input type="submit" value="Send">
</form>
</body>
</html>
