<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<form action="send-name" method="post">
  <fieldset>
    <legend>Registration Form</legend>
    <label for="name">Name</label>
    <input name="name" id="name" type="text">
    <br>
    <label for="surname">Surname</label>
    <input name="surname" id="surname" type="text">
  </fieldset>
  <br>
  <input type="submit" value="Send">
</form>
</body>
</html>