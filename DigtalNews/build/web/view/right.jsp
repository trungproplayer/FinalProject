<%-- 
    Document   : right
    Created on : Jun 15, 2021, 12:31:21 PM
    Author     : bookm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    </head>
    <body>
        <div class="right_digital">
            <h3>Digital News</h3>
            <p>${news.description}</p>
        </div>
        <div class="right_search">
            <h3>Search</h3>
            <form action="SearchController" method="get">
                <input class="input_search" type="text" name="txtSearch" value="${txtSearch}">
                <input class="button" type="submit" value="Go">
            </form>
        </div>
        <div class="right_articles">
            <h3>Last Articles</h3>
            <c:if test="${not empty listNews}">
                <c:forEach items="${listNews}" var="i">
                    <a href="DetailController?id=${i.id}">${i.title}</a><br>
                </c:forEach>
            </c:if> 
        </div>
    </body>
</html>

