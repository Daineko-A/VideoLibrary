<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jstl-connect.jsp" %>



<html>
<head>
    <title>Добавление нового фильма</title>
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

            <form method="post" action="${pageContext.request.contextPath}/add-movie">
                <div class="container">
                </div>
                <div class="form-group">
                    <label for="title">Название фильма</label>
                    <input id="title" type="text" name="title" class="form-control">
                </div>
                <div class="form-group">
                    <label for="releaseDate">Дата выхода фильма (yyyy-MM-dd)</label>
                    <input id="releaseDate" type="date" name="releaseDate" class="form-control">
                </div>
                <div class="form-group">
                    <label for="country">Страна</label>
                    <input id="country" type="text" name="country" class="form-control">
                </div>
                <div class="form-group">
                    <label for="genre">Жанр</label>
                    <input id="genre" type="text" name="genre" class="form-control">
                </div>
                <div class="form-group">
                    <label for="description">Описание</label>
                    <textarea id="description" type="text" name="description" class="form-control" rows="3"></textarea>
                </div>
                <button type="submit" class="btn btn-default">Добавить фильм</button>
            </form>
        </section>
    </div>
</div>


<footer><%@ include file="../footer.jsp"%></footer>
</body>
</html>
