<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>login</title>
</head>
<body>
<div class="wrapper container">
    <header><%@ include file="../header.jsp"%></header>
    <nav class="navbar navbar-default"> <%@ include file="../nav.jsp"%> </nav>
    <div class="heading"></div>


    <div class="row">
        <div class="col-xs-6">

            <form method="post" action="${pageContext.request.contextPath}/login">
                <div class="container">
                </div>
                <div class="form-group">
                    <label for="login">Логин</label>
                    <input id="login" type="text" name="login" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pass">Пароль</label>
                    <input id="pass" type="password" name="pass" class="form-control">
                </div>
                <button type="submit" class="btn btn-default">Войти</button>
            </form>

        </div>
        <div class="col-xs-6">

            <form method="post" action="${pageContext.request.contextPath}/registration">
                <div class="container">
                </div>
                <div class="form-group">
                    <label for="login">Логин</label>
                    <input id="login" type="text" name="login" class="form-control">
                </div>
                <div class="form-group">
                    <label for="email">Email</label>
                    <input id="email" type="email" name="email" class="form-control">
                </div>
                <div class="form-group">
                    <label for="pass">Пароль</label>
                    <input id="pass" type="password" name="pass" class="form-control">
                </div>
                <button type="submit" class="btn btn-default">Зарегестрироватся</button>
            </form>

        </div>
    </div>

    <%--<div class="row">--%>
        <%--<aside class="col-md-1"></aside>--%>
        <%--<section class="col-md-5">--%>

            <%--<form method="post" action="${pageContext.request.contextPath}/login">--%>
                <%--<div class="container">--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="login">Логин</label>--%>
                    <%--<input id="login" type="text" name="login" class="form-control">--%>
                <%--</div>--%>
                <%--<div class="form-group">--%>
                    <%--<label for="pass">Пароль</label>--%>
                    <%--<input id="pass" type="password" name="pass" class="form-control">--%>
                <%--</div>--%>
                <%--<button type="submit" class="btn btn-default">Войти</button>--%>
            <%--</form>--%>
        <%--</section>--%>


    <%--</div>--%>
    <%--<div class="row">--%>
    <%--<aside class="col-md-1"></aside>--%>
    <%--<section class="col-md-5">--%>

        <%--<form method="get" action="${pageContext.request.contextPath}/logout">--%>
            <%--<button type="submit" class="btn btn-danger">Выйти</button>--%>
        <%--</form>--%>
    <%--</section>--%>
    <%--</div>--%>
<%--</div>--%>


<%--<div class="row">--%>
    <%--<aside class="col-md-1"></aside>--%>
    <%--<section class="col-md-5">--%>

        <%--<form method="post" action="${pageContext.request.contextPath}/registration">--%>
            <%--<div class="container">--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label for="login">Логин</label>--%>
                <%--<input id="login" type="text" name="login" class="form-control">--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label for="email">Email</label>--%>
                <%--<input id="email" type="email" name="email" class="form-control">--%>
            <%--</div>--%>
            <%--<div class="form-group">--%>
                <%--<label for="pass">Пароль</label>--%>
                <%--<input id="pass" type="password" name="pass" class="form-control">--%>
            <%--</div>--%>
            <%--<button type="submit" class="btn btn-default">Зарегестрироватся</button>--%>
        <%--</form>--%>

    <%--</section>--%>
<%--</div>--%>


<footer><%@ include file="../footer.jsp"%></footer>

</body>
</html>
