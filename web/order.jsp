<%-- 
    Document   : order
    Created on : Dec 16, 2018, 4:14:39 PM
    Author     : Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Order Page</title>
        <style>
            body{
                background-image: url(img/background1.jpg);
                background-size: cover;
                font-family: cursive;
                color: white ;
            }
            #but{
                border: 2.5px solid chocolate;
                color: chocolate ;width: 100px;
                height: 22px; 
                background-color: white;
            }
        </style>
    </head>
    <body>
        <span style="font-size: 60px;text-shadow: 0 0 0.5em chocolate"><strong>Cóc Shop Xin Chào! </strong></span>
        <span style="margin-left: 25%; margin-top: -10%;font-size: 20px">
            Nhân Viên <font color="red">${sessionScope.USER}</font>
        </span><br/>
        <form action="MainController" method="POST" style="margin-left: 90%; margin-top: -2.9%">
            <input type="submit" name="action" value="Đăng Xuất" id="but"/>
        </form>
        <br/>
        <span style="font-size: 30px;" ><strong>Thông Tin Đơn Hàng </strong></span>
        <c:if test="${not empty requestScope.ORDER}" var="check">
            <table style="border: 2px solid white; text-align: center" rules="groups" cellpadding="10">
                <thead>
                    <tr>
                        <th>Số</th>
                        <th>Tên người dùng</th>
                        <th>Ngày đặt hàng</th>
                        <th>Tổng giá tiền</th>
                        <th>Chi tiết</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${requestScope.ORDER}" varStatus="counter">
                        <tr>
                            <td>${counter.count}</td>
                            <td>${dto.username}</td>
                            <td>${dto.orderDate}</td>
                            <td>${dto.allTotal}</td>
                            <td>
                                <form action="MainController" method="POST">
                                    <input type="hidden" name="txtOrderID" value="${dto.orderID}" />
                                    <input type="submit" value="Xem" name="action" id="but"/>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

        </c:if><br/>
        <c:if test="${check==false}">
            Không có đơn hàng!
        </c:if>
        <a href="staff.jsp" style="color: white">Trở về</a>
    </body>
</html>
