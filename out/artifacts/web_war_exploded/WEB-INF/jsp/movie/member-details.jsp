<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="../jstl-connect.jsp" %>
<html>
<head>
    <title>Member details</title>
    <%@ include file="../styles-connect.jsp" %>
</head>
<body>
<div class="wrapper container">
    <header><%@ include file="../header.jsp"%></header>
    <%@ include file="../nav.jsp"%>
    <div class="heading"></div>
    <div class="row">
        <aside class="col-md-7"></aside>
        <section class="col-md-17">

            <div class="container">
            </div>

            <div class="team">

                <div class="container">

                    <h3>${member.firstName} ${member.lastName}</h3>
                    <p>${member.dateOfBirth}</p>

                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead style="background: #eee">
                            <tr>
                                <td>- Актёр -</td>
                                <td>- Роль -</td>
                            </tr>
                            </thead>
                            <c:forEach var="memberFilm" items="${requestScope.memberFilm}">
                                <tr>
                                    <th><p><a href="${pageContext.request.contextPath}/movie-details?id=${memberFilm.id}">${memberFilm.title}</a></p></th>
                                    <th><p>${memberFilm.genre}</p></th>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>
                </div>
            </div>
        </section>
</div>
</div>
<footer><%@ include file="../footer.jsp"%></footer>
</body>
</html>
