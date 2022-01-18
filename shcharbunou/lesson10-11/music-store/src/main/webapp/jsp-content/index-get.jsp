<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Project 'Music Store'</title>
</head>
<body>
<h2>GET</h2>
<ul>
    <li><p><a href="get-jsp/get-artist.jsp">Get Artist</a></p></li>
    <li><p><a href="get-jsp/get-song.jsp">Get Song</a></p></li>
    <li><p><a href="${pageContext.request.contextPath}/get-artists?page=1&pageSize=5">Get All Artists</a></p></li>
    <li><p><a href="${pageContext.request.contextPath}/get-songs?page=1&pageSize=5">Get All Songs</a></p></li>
    <li><p><a href="get-jsp/get-artist-songs.jsp">Get All Artist Songs</a></p></li>
    <li><p><a href="get-jsp/get-song-and-artist.jsp">Get Song And Artist</a></p></li>
    <li><p><a href="get-jsp/get-artist-songs-pagination.jsp">Get All Artist Songs (Pagination)</a></p></li>
</ul>
<p><a href="${pageContext.request.contextPath}/index.jsp">Main Page</a></p>
</body>
</html>
