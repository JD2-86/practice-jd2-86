<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="common/jstl-connect.jsp" %>
<html>
<head>
    <title>Create Hero</title>
    <%@ include file="common/css-connect.jsp" %>
</head>
<body>
<%@ include file="common/header.jsp" %>
<div class="container">
    <form method="post" action="${pageContext.request.contextPath}/hero/create">
        <div class="form-group">
            <label for="name" class="form-label">Псевдоним: </label>
            <input id="name" type="text" name="name" class="form-control">
        </div>
        <div class="form-group">
            <label for="identity" class="form-label">Реальное имя: </label>
            <input id="identity" type="text" name="identity" class="form-control">
        </div>
        <div class="form-group">
            <label for="age" class="form-label">Возраст: </label>
            <input id="age" type="number" name="age" class="form-control">
        </div>
        <div class="form-group">
            <label class="radio-inline">
                <input id="gender" type="radio" name="gender" value="MALE" checked="checked">Мужчина</label>
            <label class="radio-inline">
                <input type="radio" name="gender" value="FEMALE">Женщина</label>
        </div>
        <div class="form-group">
            <label class="form-label" for="ability"></label>
            <select id="ability" class="form-control" name="ability">
                <c:forEach items="${requestScope.abilities.database}" var="ability">
                    <option>${ability.value.abilityDesignation}</option>
                </c:forEach>
            </select>
        </div>
        <button type="submit" class="btn btn-success">Сохранить</button>
    </form>
</div>
</body>
</html>
