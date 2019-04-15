<%-- 
    Document   : view-cart
    Created on : Dec 16, 2018, 3:31:15 AM
    Author     : Nhan
--%>

<%@page import="nhannt.orderDetail.OrderDetailDTO"%>
<%@page import="nhannt.cart.CartObj"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>View Cart Page</title>
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
            #but2{
                border: 2.5px solid chocolate;
                color: chocolate ;width: 100px;
                height: 30px; 
                background-color: white;
            }
        </style>
    </head>
    <body>
        <span style="font-size: 60px;text-shadow: 0 0 0.5em chocolate"><strong>Cóc Shop Xin Chào! </strong></span>
        <span style="margin-left: 24%; margin-top: -10%;font-size: 20px">
            Thành Viên <font color="red">${sessionScope.USER}</font>
        </span><br/>
        <form action="MainController" method="POST" style="margin-left: 90%; margin-top: -2.9%">
            <input type="submit" name="action" value="Đăng Xuất" id="but"/>
        </form>        
        <br/><br/>
        <div style="margin-left: 2%">
            <h1>Thông Tin Giỏ Hàng</h1>
            <%
                CartObj cart = (CartObj) session.getAttribute("SHOPPING");
                if (cart != null) {
            %>
            <form  action="MainController" method="POST">
                <table style="border: 2px solid white; text-align: center" rules="groups" cellpadding="10">
                    <thead style="border-bottom: 2px solid white">
                        <tr>
                            <th>Số</th>
                            <th>Tên sản phẩm</th>
                            <th>Giá tiền</th>
                            <th>Số lượng</th>
                            <th>Tổng</th>
                            <th>Xóa</th>
                        </tr>
                    </thead>
                    <tbody style="border-bottom: 2px solid white"> 
                        <%
                            int count = 0;
                            for (OrderDetailDTO dto : cart.getCart().values()) {
                                count++;
                        %>
                        <tr>
                            <td><%= count%></td>
                            <td>
                                <%= dto.getProductName()%>
                                <input type="hidden" name="txtProductID" value="<%= dto.getProductID()%>" />
                            </td>
                            <td>
                                <%= dto.getUnitPrice()%>
                                <input type="hidden" name="txtPrice" value="<%= dto.getUnitPrice()%>" />
                            </td>
                            <td>
                                <%= dto.getQuantity()%>
                                <input type="hidden" name="txtQuantity" value="<%= dto.getQuantity()%>" />
                            </td>
                            <td>
                                <%= dto.getTotal()%>
                                <input type="hidden" name="txtTotal" value="<%= dto.getTotal()%>" />
                            </td>
                            <td>
                                <input type="checkbox" name="rmv" value="<%= dto.getProductID()%>" />
                            </td>
                        </tr>
                        <%
                            }
                        %>
                    </tbody>

                    <tr>
                        <th align="left" colspan="4">Tổng Cộng</th>
                        <th>
                            ${sessionScope.SHOPPING.total}
                            <input type="hidden" name="txtAllTotal" value="${sessionScope.SHOPPING.total}" />
                        </th>
                        <th></th>
                    </tr>
                    <tfoot style="border-top: 2px solid white">
                        <tr>
                            <td colspan="4">
                                <input type="hidden" name="txtUsername" value="${sessionScope.USERNAME}"/>
                                <input type="submit" value="Thanh Toán" name="action" id="but2" style="width: 450px"/>
                            </td>
                            <td colspan="2">
                                <input type="submit" value="Bỏ Sản Phẩm" name="action" id="but2"/>
                            </td>
                        </tr>
                    </tfoot>
                </table>
            </form>
            <%
                }%><%
else {
            %>
            Giỏ hàng trống
            <%
                }%>
            <a href="user.jsp" style="color: white">Trở về</a>
        </div>

    </body>
</html>
