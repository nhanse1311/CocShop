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
        <title>Home Page</title>
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
        <span style="font-size: 60px;text-shadow: 0 0 0.5em chocolate"><strong>Cóc Shop Xin Chào! </strong></span>
        <form action="MainController" method="POST" style="margin-left: 68%; margin-top: -5%">
            <fieldset style="width: 410px;height: 70px;">
                <legend style="color: white">Đăng Nhập - Đăng Ký Tại Đây</legend>
                <input type="text" name="txtUsername" value="" placeholder="Username" />
                <input type="password" name="txtPassword" value="" placeholder="Password"/>
                <input type="submit" name="action" value="Đăng Nhập" style="border: 2.5px solid chocolate;color: chocolate ;width: 100px; background-color: white"/>
                <a href="register.jsp" style="color: white;text-decoration: none    ">◄Đăng ký►</a>
            </fieldset>           
        </form>
        <br/>
        <span style="font-size: 30px;" ><strong>Hãy tìm kiếm sản phẩm  </strong></span>
        <form action="MainController" method="POST" >
            <input type="hidden" name="role" value="guest" />
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
        </form><br/>
        
        <c:if test="${requestScope.INFO !=null}">
            <c:if test="${not empty requestScope.INFO}" var="check">
                Nếu muốn mua bạn phải đăng nhập!
                <table rules="groups" style="text-align: center;border: 1px solid white"; cellpadding="5">
                    <thead style="border-bottom: 1px solid white">
                        <tr>
                            <th>No</th>
                            <th>Tên Sản Phẩm</th>
                            <th>Hiệu</th>
                            <th>Mô Tả</th>
                            <th>Giá Tiền</th>
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
