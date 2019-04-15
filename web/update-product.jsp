<%-- 
    Document   : insert-produtc
    Created on : Dec 15, 2018, 12:35:31 AM
    Author     : Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Page</title>
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
            #fiel{

                width: 300px;
                font-size: 20px;
            }
        </style>
    </head>
    <body>
        <span style="font-size: 60px;text-shadow: 0 0 0.5em chocolate"><strong>Cóc Shop Xin Chào! </strong></span>
        <span style="margin-left: 25%; margin-top: -10%;font-size: 20px">
            Nhân Viên <font color="red">${sessionScope.USER}</font>
        </span>
        <form action="MainController" method="POST" style="margin-left: 90%; margin-top: -2.9%">
            <input type="submit" name="action" value="Đăng Xuất" id="but"/>
        </form><br/>
        <div style="margin-left: 2%">
            <h1>Thông Tin Sản Phẩm Cập Nhập</h1>
            <form action="MainController" method="POST">
                <table>
                    <tr>
                        <th>Mã Sản Phẩm</th>
                        <td><input id="fiel" type="text" name="txtProductID" value="${requestScope.DTO.productID}" readonly="true"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>Tên Sản Phẩm</th>
                        <td><input id="fiel" type="text" name="txtProductName" value="${requestScope.DTO.name}"/></td>
                        <td>
                            <font color="red">
                            ${requestScope.INVALID.productNameErr}
                            </font>
                        </td>
                    </tr>
                    <tr>
                        <th>Giá Tiền</th>
                        <td><input id="fiel" type="text" name="txtPrice" value="${requestScope.DTO.price}"/></td>
                        <td>
                            <font color="red">
                            ${requestScope.INVALID.priceErr}
                            </font>
                        </td>
                    </tr>
                    <tr>
                        <th>Nhãn Hiệu</th>
                        <td><input id="fiel" type="text" name="txtBrand" value="${requestScope.DTO.brand}"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>Mô Tả</th>
                        <td><input id="fiel" type="text" name="txtDescription" value="${requestScope.DTO.description}"/></td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>Số Lượng</th>
                        <td><input id="fiel" type="text" name="txtQuantity" value="${requestScope.DTO.quantity}"/></td>
                        <td>
                            <font color="red">
                            ${requestScope.INVALID.quantityErr}
                            </font>
                        </td>
                    </tr>
                    <tr>
                        <th>Trạng Thái</th>
                        <td>
                            <select name="txtStatusU" style="width:305px;font-size: 20px">
                                <c:if test="${requestScope.DTO.status == 'bán'}">
                                    <option selected>bán</option>
                                    <option>không bán</option>
                                </c:if>
                                <c:if test="${requestScope.DTO.status == 'không bán'}">
                                    <option>bán</option>
                                    <option selected>không bán</option>
                                </c:if>
                                
                            </select>
                        </td>
                        <td></td>
                    </tr>
                    <tr>
                        <th>Phân Loại</th>
                        <td>
                            <select name="txtCategoryID" style="width:305px;font-size: 20px">
                                <c:if test="${requestScope.DTO.categoryID == 'FF'}">
                                    <option selected>Món Ăn Nhanh-FF</option>
                                </c:if>
                                <c:if test="${requestScope.DTO.categoryID == 'MF'}">
                                    <option selected>Món Ăn Chính-MF</option>
                                </c:if>
                                <c:if test="${requestScope.DTO.categoryID == 'FD'}">
                                    <option selected>Đồ Uống Nhanh-FD</option>
                                </c:if>
                                <c:if test="${requestScope.DTO.categoryID == 'MD'}">
                                    <option selected>Đồ Uống Chính-MD</option>
                                </c:if>
                            </select>
                        </td>
                        <td></td>
                    </tr>
                </table>
                <input type="hidden" name="txtStatus" value="${param.txtStatus}" />
                <input type="submit" value="Cập Nhập Sản Phẩm" name="action" id="but" style="margin-left: 8.5%;width: 305px;height: 30px;font-size: 20px;"/>               
            </form>
            <a href="staff.jsp" style="color: white;font-size: 20px">Trở Về</a>
        </div>
    </body>
</html>
