<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="add-artist" method="post">
    <fieldset>
        <legend>Registration Form</legend>
        <label for="artist">New Artist</label>
        <input name="artist" id="artist" type="text" required oninvalid="this.setCustomValidity('Enter artist')" oninput="setCustomValidity('')">
        <br>
        <label for="country">Country</label>
        <input name="country" id="country" type="text" required oninvalid="this.setCustomValidity('Enter country')" oninput="setCustomValidity('')">
        <br>
       </fieldset>
    <br>
    <input type="submit" value="Send">
</form>
</body>
</html>
