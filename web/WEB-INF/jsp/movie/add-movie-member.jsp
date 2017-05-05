<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="wrapper container">
    <header> <a href="/"><img src="img/logo.png" alt=""></a> </header>
    <nav class="navbar navbar-default"> <%@ include file="../nav.jsp"%> </nav>
    <div class="heading"></div>

    <div class="row">
        <aside class="col-md-1"></aside>
        <section class="col-md-5">

            <form method="post" action="${pageContext.request.contextPath}/add-movie-member">
                <div class="container">
                </div>
                <div class="form-group">
                    <label for="firstName">Имя</label>
                    <input id="firstName" type="text" name="firstName" class="form-control">
                </div>
                <div class="form-group">
                    <label for="lastName">Фамилия</label>
                    <input id="lastName" type="text" name="lastName" class="form-control">
                </div>
                <div class="form-group">
                    <label for="dateOfBirth">Дата рождения</label>
                    <input id="dateOfBirth" type="date" name="dateOfBirth" class="form-control">
                </div>
                <button type="submit" class="btn btn-default">Добавить актёра</button>
            </form>
        </section>
    </div>
</div>
<footer><%@ include file="../footer.jsp"%></footer>


</body>
</html>
