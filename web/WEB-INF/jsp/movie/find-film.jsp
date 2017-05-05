<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jstl-connect.jsp" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="../styles-connect.jsp" %>
</head>
<body>
<div class="wrapper container">
    <header><%@ include file="../header.jsp"%></header>
    <%@ include file="../nav.jsp"%>
    <div class="heading"></div>

    <div class="row">
        <aside class="col-md-1"></aside>
        <section class="col-md-5">

            <form method="get" action="${pageContext.request.contextPath}/find-film">
                <div class="container">
                </div>
                <div class="form-group">
                    <label for="namePart">Введите название фильма или его часть:</label>
                    <input id="namePart" type="text" name="namePart" class="form-control">
                </div>
                <button type="submit" class="btn btn-default">Найти по названию</button>
            </form>

        </section>
    </div>

    <br>

    <div class="row">
        <aside class="col-md-1"></aside>
        <section class="col-md-5">

            <form method="get" action="${pageContext.request.contextPath}/find-film">
                <div class="container">
                </div>
                <div class="form-group">
                    <label for="year">Введите год выхода фильма:</label>
                    <input id="year" type="number" name="year" class="form-control">
                </div>
                <button type="submit" class="btn btn-default">Найти по году выхода.</button>
            </form>

        </section>
    </div>

    <br>
    <br>

    <div class="row">
        <aside class="col-md-7"></aside>
        <section class="col-md-17">
            <div class="container">
            </div>

            <div class="team">
                <div class="row">
                    <c:forEach var="movie" items="${requestScope.movies}">
                        <div class="col col-md-2">
                            <p><a href="${pageContext.request.contextPath}/movie-details?id=${movie.id}">
                                <img src="./img/posters/${movie.id}poster.jpg" alt="${movie.title}" class="thumbnail"></a></p>
                            <div class="caption">
                                <h3>${movie.title}</h3>
                                <p>${movie.genre}</p>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </div>

        </section>
    </div>
</div>
<footer><%@ include file="../footer.jsp"%></footer>
</body>
</html>
