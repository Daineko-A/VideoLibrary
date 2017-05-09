<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="jstl-connect.jsp" %>
<%@ include file="styles-connect.jsp" %>

<div class="row">
    <div class="col-md-8">

        <a href="/index"><img src="img/logo.png" alt=""></a>

    </div>
    <div class="col-md-4">


        <div class="row">
            <div class="col-md-4">

                <form method="get" action="${pageContext.request.contextPath}/login">
                <button type="submit" class="btn btn-success">Войти</button>
                </form>

            </div>
            <div class="col-md-4">

                <form method="get" action="${pageContext.request.contextPath}/logout">
                <button type="submit" class="btn btn-danger">Выйти</button>
                </form>

            </div>
        </div>
    </div>
</div>