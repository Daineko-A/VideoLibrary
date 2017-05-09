<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="jstl-connect.jsp" %>
<%@ include file="styles-connect.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navbar navbar-default">
    <ul class="nav navbar-nav">
        <li><a href="/index">Главная</a></li>
        <li><a href="/find-film">Найти фильм</a></li>
        <li><a href="/questions">Вопросы</a></li>
        <%--<li><a href="/cabinet">Личный кабинет</a></li>--%>
    <%--<li><a href="/registration">Регистрация</a></li>--%>
    <%--<li><a href="/users">Пользователи</a></li>--%>
    <%--<li><a href="/add-movie">Добавить фильм</a></li>--%>
    <%--<li><a href="/add-movie-member">Добавить актёра</a></li>--%>

        <c:if test="${role > 0}">
            <li><a href="/add-movie">Добавить фильм</a></li>
            <li><a href="/add-movie-member">Добавить актёра</a></li>
            <li><a href="/add-member-to-movie">Добавить актёров</a></li>
        </c:if>


        <%--<c:forEach var="movie" items="${requestScope.movies}">--%>
            <%--<div class="col col-md-2">--%>
                <%--<p><a href="${pageContext.request.contextPath}/movie-details?id=${movie.id}">--%>
                    <%--<img src="./img/posters/${movie.id}poster.jpg" alt="${movie.title}" class="thumbnail"></a></p>--%>
                <%--<div class="caption">--%>
                    <%--<h3>${movie.title}</h3>--%>
                    <%--<p>${movie.genre}</p>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</c:forEach>--%>


    </ul>
</nav>