<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="jstl-connect.jsp"%>
<html>
<head>
    <title>Create Hero</title>
    <%@ include file="css-connect.jsp" %>
</head>
<body>
<%@ include file="header.jsp" %>
<div class="create-hero-form">
    <form action="<c:url value="/hero/create"/>" method="post">
            <p><b>Псевдоним: </b></p>
            <label>
                <input class="input_field" name="nickname" type="text" size="40" required>
            </label><br>
            <p><b>Реальное имя: </b></p>
            <label>
                <input class="input_field" name="true_name" type="text" size="40" required>
            </label><br>
            <p><b>Возраст: </b></p>
            <label>
                <input class="input_field" name="age" type="number" min="1" required>
            </label><br>
        <p>
            <label>
                <input type="radio" name="gender" value="MALE" required>
                Мужчина
            </label>
            <label>
                <input type="radio" name="gender" value="FEMALE" required>
                Женщина
            </label> <br>
        </p>
        <label>
            <select class="select_abilities" name="select_abilities" required>
                <c:forEach items="${requestScope.ability_storage.ability_db}" var="ability">
                    <option>${ability.value.nameOfAbility}</option>
                </c:forEach>
            </select>
        </label>
        <br>
        <p><input class="save_button" type="submit" value="Сохранить"></p>
    </form>
</div>
</body>
</html>
