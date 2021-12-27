<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>User manager</title>
</head>
<body>
<h1><%= "Welcome to user management system" %>
</h1>
<br/>
<p><a href="/web-servlets/view/users/1">Get user</a></p>
<p><a href="/web-servlets/view/command/create-user">Create user form</a></p>
<p><a href="/web-servlets/api/users?firstName=Ivan&lastName=Ivanov&email=iv@iv.com&username=ivan&password=pass">Post user</a></p>
<p><a href="/web-servlets/view/users?page=1&pageSize=20">Get all users</a></p>
</body>
</html>
