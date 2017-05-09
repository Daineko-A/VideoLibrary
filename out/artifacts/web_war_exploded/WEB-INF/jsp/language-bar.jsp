<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="jstl-connect.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="styles-connect.jsp" %>

<div class="row">
    <div class="col-xs-6">

        <form action="${pageContext.request.contextPath}/language" method="get">
            <select name="language" onchange="submit()">
                <option value="en_US" ${sessionScope.currentLanguage eq 'en_US' ? 'selected' : ''}>English</option>
                <option value="ru_RU" ${sessionScope.currentLanguage eq 'ru_RU' ? 'selected' : ''}>Русский</option>
            </select>
        </form>

        <%--<a href="${pageContext.request.contextPath}/language?language=en_US">English</a>--%>
        <%--<a href="${pageContext.request.contextPath}/language?language=ru_RU">Русский</a>--%>

    </div>
</div>
