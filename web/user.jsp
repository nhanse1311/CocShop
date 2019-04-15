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
        <title>User Page</title>
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
        <span style="margin-left: 24%; margin-top: -10%;font-size: 20px">
            Thành Viên <font color="red">${sessionScope.USER}</font>
        </span><br/>
        <form action="MainController" method="POST" style="margin-left: 90%; margin-top: -2.9%">
            <input type="submit" name="action" value="Đăng Xuất" id="but"/>
        </form>
        <br/><br/>
        <span style="font-size: 30px;" ><strong>Hãy tìm kiếm sản phẩm  </strong></span>
        <form action="MainController" method="POST" >
            <input type="hidden" name="role" value="user" />
            <table>
                <tr>
                    <th>Lựa chọn theo tên </th>
                    <td><input type="text" name="txtSearchName" value="${param.txtSearchName}" placeholder="Nhập tên Sản Phẩm..."/></td>
                </tr>
                <tr><th>Lựa chọn theo giá </th>
                    <td>
                        <select name="txtSearchPrice" style="width: 152px">
                            <option>Lựa Chọn</option>
                            <option>1000-5000</option>
                            <option>5000-10000</option>
                            <option>10000-20000</option>
                            <option>20000-30000</option>
                            <option>30000-40000</option>
                            <option>40000-50000</option>
                        </select> VNĐ</td>
                </tr>
            </table>
            <input type="radio" name="txtCategory" value="FF"> Món ăn nhanh
            <input type="radio" name="txtCategory" value="MF"> Món ăn chính
            <input type="radio" name="txtCategory" value="FD"> Đồ uống nhanh
            <input type="radio" name="txtCategory" value="MD"> Đồ uống chính<br/><br/>
            <input type="submit" name="action" value="Tìm Kiếm" style="border: 2.5px solid chocolate;color: chocolate ;width: 200px;height: 30px; background-color: white;border-radius: 50%;margin-left: 8%" /><br/>
        </form>
        <form action="MainController" method="POST" style=" margin-left: 75%; margin-top: -4%">
            <input type="submit" value="Xem Giỏi Hàng" name="action" id="but" style="width: 150px;" />
        </form>        
        <br/><br/>
        <c:if test="${requestScope.INFO !=null}">
            <c:if test="${not empty requestScope.INFO}" var="check">
                <table rules="groups" style="text-align: center;border: 1px solid white"; cellpadding="5">
                    <thead style="border-bottom: 1px solid white">
                        <tr>
                            <th>No</th>
                            <th>Tên Sản Phẩm</th>
                            <th>Hiệu</th>
                            <th>Mô Tả</th>
                            <th>Giá Tiền</th>
                            <th>Mua</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="dto" items="${requestScope.INFO}" varStatus="counter">
                            <tr>
                                <td>${counter.count}</td>
                                <td>${dto.name}</td>
                                <td>${dto.brand}</td>
                                <td>${dto.description}</td>
                                <td>${dto.price} VNĐ</td>
                                <td>
                                    <form action="MainController" method="POST">
                                        <input type="hidden" name="txtUsername" value="${sessionScope.USERNAME}"/>
                                        <input type="hidden" name="txtProductID" value="${dto.productID}" />
                                        <input type="hidden" name="txtProductName" value="${dto.name}" />
                                        <input type="hidden" name="txtUnitPrice" value="${dto.price}" />
                                        <input type="hidden" name="txtSearchName" value="${param.txtSearchName}" />
                                        <input type="hidden" name="txtSearchPrice" value="${param.txtSearchPrice}" />
                                        <input type="hidden" name="txtCategory" value="${param.txtCategory}" />
                                        <input type="submit" value="Mua" name="action" style="border: 1px solid chocolate; background-color: white"  />
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
