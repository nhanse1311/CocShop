<%-- 
    Document   : insert-produtc
    Created on : Dec 15, 2018, 12:35:31 AM
    Author     : Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Insert Page</title>
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
        <div style="margin-left: 8%">
            <h2>Nhập Thông Tin Sản Phẩm</h2>
            <form action="MainController" method="POST">      
                <input id="fiel" type="text" name="txtProductID" value="${param.txtProductID}" placeholder="Mã Sản Phẩm"/>
                <font color="red">
                ${requestScope.INVALID.productIDErr}
                </font><br/>
                <input id="fiel" type="text" name="txtProductName" value="${param.txtProductName}" placeholder="Tên Sản Phẩm"/>
                <font color="red">
                ${requestScope.INVALID.productNameErr}
                </font><br/>
                <input id="fiel" type="text" name="txtPrice" value="${param.txtPrice}" placeholder="Giá Tiền"/>
                <font color="red">
                ${requestScope.INVALID.priceErr}
                </font><br/>
                <input id="fiel" type="text" name="txtBrand" value="${param.txtBrand}" placeholder="Nhãn Hiệu"/><br/>
                <input id="fiel" type="text" name="txtDescription" value="${param.txtDescription}" placeholder="Mô Tả"/><br/>
                <input id="fiel" type="text" name="txtQuantity" value="${param.txtQuantity}" placeholder="Số Lượng"/>
                <font color="red">
                ${requestScope.INVALID.quantityErr}
                </font><br/>
                <select name="txtCategoryID" style="width:305px;font-size: 20px">
                    <option>Phân Loại Sản Phẩm</option>
                    <option>Món Ăn Nhanh-FF</option>
                    <option>Món Ăn Chính-MF</option>
                    <option>Đồ Uống Nhanh-FD</option>
                    <option>Đồ Uống Chính-MD</option>
                </select>
                <font color="red">
                ${requestScope.INVALID.categoryIDErr}
                </font><br/>
                <input type="submit" value="Thêm Sản Phẩm" name="action" id="but" style="width: 305px;height: 30px;font-size: 20px"/>               
            </form>
                <a href="staff.jsp" style="color: white">Trở Về</a>
        </div>
    </body>
</html>
