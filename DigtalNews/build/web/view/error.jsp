<%-- 
    Document   : error
    Created on : Jun 17, 2021, 12:08:52 PM
    Author     : bookm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="./css/styleFull.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div class="container">
            <%@include  file="header.jsp"%>   
            <div class="main">
                <div class="letf">       
                    <h3>${error}</h3> 
                </div>
                <div class="right">
                    <%@include  file="right.jsp"%>
                </div>
            </div>
            <%@include  file="footer.jsp"%>
        </div>
    </body>
</html>
