<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3>User data:</h3>
<p>FirstName: <%= request.getParameter("firstName")%>
</p>
<p>LastName: <%= request.getParameter("lastName")%>
</p>
<p>Role: <%= request.getAttribute("role")%>
</p>
</body>
</html>
