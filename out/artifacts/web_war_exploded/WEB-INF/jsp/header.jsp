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

        <%--<div class="row">--%>
            <%--<div class="col-md-1">--%>

                <%--<form method="get" action="${pageContext.request.contextPath}/login">--%>
                    <%--<button type="submit" class="btn btn-success">Войти</button>--%>
                <%--</form>--%>


            <%--</div>--%>
            <%--<div class="col-md-1">--%>

                <%--<form method="get" action="${pageContext.request.contextPath}/logout">--%>
                <%--<button type="submit" class="btn btn-danger">Выйти</button>--%>
                <%--</form>--%>

            <%--</div>--%>
        <%--</div>--%>

    </div>
</div>


<%--<div class="col-xs-6"><a href="/index"><img src="img/logo.png" alt=""></a></div>--%>
<%--<div class="row">--%>

    <%--<form name="search" action="${pageContext.request.contextPath}/find-film" method="get">--%>

        <%--&lt;%&ndash;<div class="col-xs-6">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<input type="text" name="namePart" id="namePart" placeholder="Поиск фильма по названию"><button type="submit" class="btn btn-default">Поиск</button>&ndash;%&gt;--%>
        <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--</form>--%>
<%--</div>--%>
<%--<div class="row">--%>
<%--&lt;%&ndash;<form class="form-inline" method="post" action="${pageContext.request.contextPath}/login">&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<label for="login"></label>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="text" class="form-control" id="login" name="login" placeholder="Введите имя пользователя">&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<div class="form-group">&ndash;%&gt;--%>
        <%--&lt;%&ndash;<label for="pass"></label>&ndash;%&gt;--%>
        <%--&lt;%&ndash;<input type="password" class="form-control" id="pass" name="pass" placeholder="Введите пароль">&ndash;%&gt;--%>
    <%--&lt;%&ndash;</div>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<button type="submit" class="btn btn-default">Войти</button>&ndash;%&gt;--%>
<%--&lt;%&ndash;</form>&ndash;%&gt;--%>
<%--</div>--%>


