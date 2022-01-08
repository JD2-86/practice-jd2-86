<footer>
    <nav class="navbar navbar-dark bg-primary">
        <div class="container-fluid">
            <div class="navbar-header">
                <a href="${pageContext.request.contextPath}/">
                    <img alt="Brand" src="${pageContext.request.contextPath}/src/main/webapp/static/icon.png">
                </a>
            </div>
            <div class="collapse navbar-collapse navbar-center" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="<c:url value="/abilities"/>">Abilities</a>
                    </li>
                    <li>
                        <a href="<c:url value="/heroes"/>">Heroes</a>
                    </li>
                    <li>
                        <a href="<c:url value="/hero/create"/>">Create Hero</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</footer>