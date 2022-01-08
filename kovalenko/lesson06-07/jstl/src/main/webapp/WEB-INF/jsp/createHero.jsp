<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="common/jstl-connect.jsp" %>
<html>
<head>
    <title>Hero</title>
    <%@ include file="common/css-connect.jsp" %>
</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="container">
    <form action="${pageContext.request.contextPath}/hero" method="post">
        <div class="form-group">
            <label for="name" class="form-label">Псевдоним:</label>
            <input name="Псевдоним" type="text" id="name" class="form-control">
        </div>
        <div class="form-group">
            <label for="identity" class="form-label">Реальное имя:</label>
            <input name="Реальное имя" type="text" id="identity" class="form-control">
        </div>
        <div class="form-group">
            <label for="age" class="form-label">Возраст:</label>
            <input name="Возраст" type="text" id="age" class="form-control">
        </div>
        <div class="form-group">
            <label class="radio-inline">
                <input name="gender" type="radio" id="gender" value="MALE" checked="checked">Мужчина
            </label>
            <label class="radio-inline">
                <input name="gender" type="radio" value="FEMALE">Женщина
            </label>
        </div>
        <div class="form-group">
            <label class="form-label" for="ability"></label>
            <select name="ability" id="ability" class="form-control">
                <c:forEach items="${requestScope.abilities}" var="ability">
                    <option value="${ability.id}">${ability.name}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit">Сохранить</button>
    </form>
</div>
</body>
</html>
