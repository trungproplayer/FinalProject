<%-- 
    Document   : detail
    Created on : Jun 15, 2021, 1:33:00 PM
    Author     : bookm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/styleFull.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include  file="header.jsp"%>   
            <div class="main">
                <div class="letf">       
                    <h3>${detail.title}</h3>

                    <div class="images">
                        <img src="${detail.image}" alt="i1"/>      
                    </div>

                    <div class="detail">
                        <p>${detail.content}</p>
                    </div>

                    <div class="author">
                        <p>
                            <img src="./images/timeicon.gif" alt=""/>
                            <img src="./images/comment.gif" alt=""/>
                            ${detail.author} | ${detail.getDateConvert()}</p>
                    </div>
                </div>
                <div class="right">
                    <%@include  file="right.jsp"%>
                </div>
            </div>
            <%@include  file="footer.jsp"%>
        </div>
    </body>
</html>
