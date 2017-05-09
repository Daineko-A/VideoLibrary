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

            <form method="post" action="${pageContext.request.contextPath}/users">
                <div class="form-group">
                    <select name="dropdownChoiceUser">
                        <c:forEach var="users" items="${requestScope.users}">
                            <option value="${users.id}">${users.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div class="form-group">
                    <select multiple rows="10" name="dropdownChoiceRole">
                        <c:forEach var="role" items="${requestScope.roles}">
                            <option value="${role}">${role}</option>
                        </c:forEach>
                    </select>
                </div>

                <button type="submit" class="btn btn-default">Изменить права пользователя</button>
            </form>
        </section>
    </div>
</div>
<footer><%@ include file="../footer.jsp"%></footer>


</body>
</html>
