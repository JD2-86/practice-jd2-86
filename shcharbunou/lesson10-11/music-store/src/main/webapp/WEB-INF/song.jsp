<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Song</title>
</head>
<body>
<h2>Song</h2>
<p>Artist: ${requestScope.artist.name}</p>
<p>Title: ${requestScope.song.title}</p>
<p>Album: ${requestScope.song.album}</p>
<p>Year: ${requestScope.song.recorded}</p>
<p>Length: ${requestScope.song.length}</p>
<p><a href="${pageContext.request.contextPath}/index.jsp">Main Page</a></p>
</body>
</html>
