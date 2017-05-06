<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                    <img src="./img/posters/${requestScope.movie.id}poster.jpg" alt="${requestScope.movie.title}" class="thumbnail">
                    <h3>${movie.title}</h3>
                    <p>${movie.genre}</p>
                    <p>${movie.releaseDate}</p>
                    <p>${movie.country}</p>
                    <p>${movie.description}</p>

                    <div class="col-md-2"><p class="bg-danger">
                        <c:forEach var="i" begin="1" end="${rating}">
                            &#9733;
                        </c:forEach>
                    </p></div>

                    <div class="table-responsive">
                        <table class="table table-hover">
                            <thead style="background: #eee">

                            <tr>
                                <td>- Актёр -</td>
                                <td>- Роль -</td>
                            </tr>
                            </thead>

                            <c:forEach var="movieMembers" items="${requestScope.movieMembers}">
                                <tr>
                                    <th><p><a href="${pageContext.request.contextPath}/member-details?id=${movieMembers.id}">${movieMembers.firstName} ${movieMembers.lastName}</a></p></th>
                                    <th><p>${movieMembers.role}</p></th>
                                </tr>
                            </c:forEach>
                        </table>
                    </div>


                    <br>
                    <br>
                    <br>


                    <c:forEach var="review" items="${requestScope.review}">
                        <p class="bg-primary">${review.user.name}. ${review.date}</p>
                        <%--<p>${review.user.name}. ${review.date}</p>--%>
                        <p>${review.text}</p>
                        <div class="col-md-2"><p class="bg-danger">
                            <c:forEach var="i" begin="1" end="${review.stars}">
                                &#9733;
                            </c:forEach>
                        </p></div>
                        <br>
                        <br>
                    </c:forEach>
                </div>

                <br>

                <div class="container">
                    <form method="post" action="${pageContext.request.contextPath}/movie-details?id=${movie.id}">
                        <div class="container">
                        </div>
                        <div class="form-group">
                            <label for="reviewtext">Отзыв</label>
                            <textarea id="reviewtext" type="text" name="reviewtext" class="form-control" rows="3"></textarea>
                        </div>
                        <div class="form-group">
                            <input type="radio" name="review_stars" value="1"> 1
                            <input type="radio" name="review_stars" value="2"> 2
                            <input type="radio" name="review_stars" value="3"> 3
                            <input type="radio" name="review_stars" value="4"> 4
                            <input type="radio" name="review_stars" value="5"> 5
                            <input type="radio" name="review_stars" value="6"> 6
                            <input type="radio" name="review_stars" value="7"> 7
                            <input type="radio" name="review_stars" value="8"> 8
                            <input type="radio" name="review_stars" value="9"> 9
                            <input type="radio" name="review_stars" value="10"> 10
                        </div>
                        <button type="submit" class="btn btn-default">Оставить отзыв</button>
                    </form>
                </div>
            </div>


        </section>
    </div>
</div>
<footer><%@ include file="../footer.jsp"%></footer>

</body>
</html>
