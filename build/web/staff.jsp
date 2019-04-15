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
        <title>Staff Page</title>
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
        <span style="font-size: 30px;" ><strong>Tìm kiếm sản phẩm quản lý </strong></span>
        
        <c:if   test="${requestScope.INVALID}">
            <span style="color: red">${requestScope.INVALID}</span>
        </c:if>
        <form action="MainController" method="POST" >
            <input type="hidden" name="role" value="staff" />
            <input type="radio" name="txtStatus" value="bán"> Sản Phẩm Còn Hàng 
            <input type="radio" name="txtStatus" value="không bán"> Sản Phẩm Hết Hàng
            <input type="radio" name="txtStatus" value="tất cả"> Tất Cả<br/>
            <input type="submit" name="action" value="Tìm Kiếm" id="but"/><br/>
        </form>
        <form action="MainController" method="POST">
            <input type="submit" name="action" value="Thêm sản phẩm" id="but" style="width: 150px"/>   
        </form> 
        <br/>
        <form action="MainController" method="POST" style=" margin-left: 75%; margin-top: 1%">
            <input type="submit" value="Xem Đơn Hàng" name="action" id="but" style="width: 150px;" />
        </form>        
        <c:if test="${requestScope.INFO !=null}">
            <c:if test="${not empty requestScope.INFO}" var="check">
                <table rules="groups" style="text-align: center;border: 1px solid white"; cellpadding="5">
                    <thead style="border-bottom: 1px solid white">
                        <tr>
                            <th>No</th>
                            <th>Tên Sản Phẩm</th>
                            <th>Giá Tiền</th>
                            <th>Hiệu</th>
                            <th>Mô Tả</th>
                            <th>Số Lượng</th>
                            <th>Trạng Thái</th>
                            <th>Xóa</th>
                            <th>Cập Nhập</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${requestScope.INFO}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.name}</td>
                                <td>${dto.price} VNĐ</td>
                                <td>${dto.brand}</td>
                                <td>${dto.description}</td>
                                <td>${dto.quantity}</td>
                                <td>${dto.status}</td>
                                <td>
                                    <c:url var="deleteLink" value="MainController">
                                        <c:param name="action" value="delete"/>
                                        <c:param name="id" value="${dto.productID}"/>
                                        <c:param name="txtStatus" value="${param.txtStatus}"/>
                                    </c:url>
                                    <a href="${deleteLink}" style="color: white">Xóa</a>
                                </td>
                                <td>
                                    <form action="MainController" method="POST">
                                        <input type="hidden" name="id" value="${dto.productID}" />
                                        <input type="hidden" name="txtStatus" value="${param.txtStatus}" />
                                        <input type="submit" value="Chỉnh Sửa" name="action" style="border: 1px solid chocolate; background-color: white"  />
                                    </form>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </c:if>
            <c:if test="${check == false}">
                No record is searched!
            </c:if>
        </c:if>
    </body>
</html>
