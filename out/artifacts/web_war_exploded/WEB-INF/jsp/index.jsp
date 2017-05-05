<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="jstl-connect.jsp" %>
<html>
<head>
    <title>Video Library</title>
    <%@ include file="styles-connect.jsp" %>
</head>
<body>
    <div class="wrapper container">
        <header><%@ include file="header.jsp"%></header>
        <%@ include file="nav.jsp"%>
        <div class="heading"></div>
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
    <footer><%@ include file="footer.jsp"%></footer>
</body>
</html>
