<%-- 
    Document   : Home
    Created on : Dec 13, 2018, 2:27:39 PM
    Author     : Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error Page</title>
        <style>
            body{
                background-image: url(img/background1.jpg);
                background-size: cover;
                font-family: cursive;
                color: white ;

            }

        </style>
    </head>
    <body>
        <span style="font-size: 60px;text-shadow: 0 0 0.5em chocolate"><strong>Cóc Shop Báo Lỗi! </strong></span><br/><br/>

        <c:if test="${requestScope.ERROR !=null}">
            <font color="red" style="font-size: 20px;margin-left: 2%">
            ${requestScope.ERROR}
            </font><br/>
            <a href="home.jsp" style="color: white">Quay Về</a>
        </c:if>
        <c:if test="${requestScope.ERRORDELETE !=null}">
            <font color="red" style="font-size: 20px;margin-left: 2%">
            ${requestScope.ERRORDELETE}
            </font><br/>
            <a href="staff.jsp" style="color: white">Quay Về</a>
        </c:if>
        <c:if test="${requestScope.ERRORINSERT !=null}">
            <font color="red" style="font-size: 20px;margin-left: 2%">
            ${requestScope.ERRORINSERT}
            </font><br/>
            <a href="insert-product.jsp" style="color: white">Quay Về</a>
        </c:if>
        <c:if test="${requestScope.ERRORREGISTER !=null}">
            <font color="red" style="font-size: 20px;margin-left: 2%">
            ${requestScope.ERRORREGISTER}
            </font><br/>
            <a href="home.jsp" style="color: white">Quay Về</a>
        </c:if>
    </body>
</html>
