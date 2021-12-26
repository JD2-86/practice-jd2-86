<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="jstl-connect.jsp"%>
<html>
<head>
    <title>Super Heroes</title>
    <%@ include file="css-connect.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
    <div class="one_hero">
        <p>Псевдоним: ${requestScope.hero.nickname}</p>
        <p>Реальное имя: ${requestScope.hero.true_name}</p>
        <p>Пол: ${requestScope.hero.gender.genderName}</p>
        <p>Возраст: ${requestScope.hero.age} лет</p>
        <p>Способность: ${requestScope.hero.ability.nameOfAbility}</p>
    </div>
</body>
</html>
