<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="add-song" method="post">
    <fieldset>
        <legend>New Song Registration</legend>
        <label for="artist">New Song</label>
        <input name="artist" id="artist" type="text" required oninvalid="this.setCustomValidity('Enter artist')" oninput="setCustomValidity('')">
        <br>
        <label for="title">New Song</label>
        <input name="title" id="title" type="text" required oninvalid="this.setCustomValidity('Enter title')" oninput="setCustomValidity('')">
        <br>
        <label for="album">Album</label>
        <input name="album" id="album" type="text" required oninvalid="this.setCustomValidity('Enter album')" oninput="setCustomValidity('')">
        <br>
        <label for="recorded">Year of record</label>
        <input name="recorded" id="recorded" type="number" required oninvalid="this.setCustomValidity('Enter recorded year')" oninput="setCustomValidity('')">
        <br>
        <label for="length">Year of record</label>
        <input name="length" id="length" type="time" required oninvalid="this.setCustomValidity('Enter song length')" oninput="setCustomValidity('')">
        <br>
    </fieldset>
    <br>
    <input type="submit" value="Send">
</form>

</body>
</html>
