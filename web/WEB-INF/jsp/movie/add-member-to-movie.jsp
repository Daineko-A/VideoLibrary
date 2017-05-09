<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../jstl-connect.jsp" %>
<html>
<head>
    <title>Title</title>
    <%@ include file="../styles-connect.jsp" %>
</head>
<body>
<div class="wrapper container">
    <header> <a href="/"><img src="img/logo.png" alt=""></a> </header>
    <nav class="navbar navbar-default"> <%@ include file="../nav.jsp"%> </nav>
    <div class="heading"></div>




    <div class="row">
        <aside class="col-md-1"></aside>
        <section class="col-md-5">

            ${movie.title}

            <form method="post" action="${pageContext.request.contextPath}/add-member-to-movie">
                <div class="form-group">
                    <select name="dropdownChoiceMovie">
                        <c:forEach var="movies" items="${requestScope.movies}">
                            <option value="${movies.id}">${movies.title}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <select multiple rows="10" name="dropdownChoiceMembers">
                    <c:forEach var="movieMembers" items="${requestScope.movieMembers}">
                    <option value="${movieMembers.id}">${movieMembers.firstName} ${movieMembers.lastName}</option>
                    </c:forEach>
                    </select>
                </div>
                <div class="form-group">
                    <label for="role">Роль</label>
                    <input id="role" type="text" name="role" class="form-control">
                </div>

                <button type="submit" class="btn btn-default">Добавить актёра</button>
            </form>
        </section>
    </div>
</div>
<footer><%@ include file="../footer.jsp"%></footer>


</body>
</html>
