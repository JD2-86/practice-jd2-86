<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@ include file="common/jstl-connect.jsp"%>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common/css-connect.jsp"/>
    <title>Heroes</title>
</head>
<jsp:include page="/WEB-INF/jsp/header.jsp"/>
<body>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-auto">
                    <br>
                    <form action="/heroes/create-hero" method="POST">
                        <label for="login" class="form-label">Псевдоним</label>
                        <input type="text" class="form-control" id="login" name="login">
                        <label for="name" class="form-label">Реальное имя</label>
                        <input type="text" class="form-control" id="name" name="name">
                        <label for="age" class="form-label">Возраст</label>
                        <input type="text" class="form-control" id="age" name="age">
                        <br>
                        <label class="form-check-label" for="male">Мужчина</label>
                        <input class="form-check-input" type="radio" name="male" id="male" value="male">
                        <label class="form-check-label" for="female">Женщина</label>
                        <input class="form-check-input" type="radio" name="male" id="female" value="female">
                        <br>
                        <select class="form-select" aria-label="Default select example" name="abil">
                            <c:forEach var="ability" items="${abilities}">
                                <option>${ability}</option>
                            </c:forEach>
                        </select>
                        <br>
                        <button class="btn btn-outline-secondary" type="submit">Сохранить</button>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>
