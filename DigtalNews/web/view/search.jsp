<%-- 
    Document   : search
    Created on : Jun 15, 2021, 3:55:26 PM
    Author     : bookm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/styleFull.css" rel="stylesheet" type="text/css"/>
        <link href="./css/styleSearch.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include  file="header.jsp"%>   
            <div class="main">

                <!--Left-->
                <div class="letf"> 
                    <c:if test="${listS != null}">
                        <span>Keyword "${txtSearch}" has ${count} result found</span>
                        <c:forEach items="${listS}" var="i">
                            <div class="detail_search">
                                <h3><a href="DetailController?id=${i.id}">${i.title}</a></h3>
                                <div class="image-search">
                                    <img src="${i.image}" alt="i1"/>
                                </div>
                                <div class="text-search">
                                    <p>${i.description}</p>
                                </div>
                            </div>
                        </c:forEach>
                    </c:if>
                    <!--Paging-->
                    <div class="paging">
                        <c:if test="${endPage != 1}">
                            <c:forEach begin="1" end="${endPage}" var="i">
                                <a class="${i==index?"active":""}" href="SearchController?index=${i}&txtSearch=${txtSearch}"> ${i} </a>
                            </c:forEach>
                        </c:if>
                    </div>
                    <!--End Paging-->
                </div>
                <!--End Left-->
                
                <!--Right-->
                <div class="right">
                    <%@include  file="right.jsp"%>
                </div>
                <!--End Right-->
            </div>

            <!--Footer-->
            <%@include  file="footer.jsp"%>
            <!--End Footer-->
        </div>
    </body>
</html>
