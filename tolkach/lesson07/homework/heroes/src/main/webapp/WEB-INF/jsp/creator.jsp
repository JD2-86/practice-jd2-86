<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <jsp:include page="common/css-connect.jsp"/>
    <title>Heroes</title>
</head>
<body>
    <jsp:include page="/WEB-INF/jsp/header.jsp"/>
    <section>
        <div class="container">
            <div class="row">
                <div class="col-md-2"></div>
                <div class="col-md-auto">
                    <br>
                    <form>
                        <label for="login" class="form-label">Псевдоним</label>
                        <input type="text" class="form-control" id="login" placeholder="Бугермен">
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>