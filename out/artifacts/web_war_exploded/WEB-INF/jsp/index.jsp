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
    <nav class="navbar navbar-default"> <%@ include file="nav.jsp"%> </nav>
    <div class="heading"></div>

    <div class="row">
        <div class="col-xs-12">

            <c:forEach var="movie" items="${requestScope.movies}">
                <div class="col-md-3">
                    <p><a href="${pageContext.request.contextPath}/movie-details?id=${movie.id}">
                        <img src="./img/posters/${movie.id}poster.jpg" alt="${movie.title}" class="img-thumbnail" width="50%" height="auto"></a></p>
                    <div class="caption">
                        <h3>${movie.title}</h3>
                        <p>${movie.genre}</p>
                    </div>
                </div>
            </c:forEach>

        </div>
    </div>
    <footer><%@ include file="footer.jsp"%></footer>
</body>
</html>
