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
    <div class="col-md-6 col-md-offset-3">
        <aside class="col-md-6 col-md-offset-3"></aside>

        <button type="button" class="btn btn-primary btn-lg btn-block">Block level button</button>
        <button type="button" class="btn btn-default btn-lg btn-block">Block level button</button>
        
        

    </div>
</div>
<footer><%@ include file="footer.jsp"%></footer>
</body>
</html>
