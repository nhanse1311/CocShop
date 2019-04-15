<%-- 
    Document   : register
    Created on : Dec 15, 2018, 3:13:53 PM
    Author     : Nhan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register Page</title>
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
        <span style="font-size: 60px;text-shadow: 0 0 0.5em chocolate"><strong>Cóc Shop Xin Chào! </strong></span><br/>
        
         <div style="margin-left: 8%;margin-top: 5%">
            <form action="MainController" method="POST">   
                <span style="font-size: 30px;" ><strong>Đăng ký thành viên </strong></span><br/>
                <input id="fiel" type="text" name="txtUsername" value="${param.txtUsername}" placeholder="Tên Đăng Nhập"/>
                <font color="red">
                ${requestScope.INVALID.usernameErr}
                </font><br/>
                <input id="fiel" type="password" name="txtPassword" value="${param.txtPassword}" placeholder="Mật Khẩu"/>
                <font color="red">
                ${requestScope.INVALID.passwordErr}
                </font><br/>
                <input id="fiel" type="password" name="txtConfirm" value="${param.txtConfirm}" placeholder="Nhập Lại Mật Khẩu"/>
                <font color="red">
                ${requestScope.INVALID.confirmErr}
                </font><br/>
                <input id="fiel" type="text" name="txtFirstName" value="${param.txtFirstName}" placeholder="Tên"/>
                <font color="red">
                ${requestScope.INVALID.firstNameErr}
                </font><br/>
                <input id="fiel" type="text" name="txtMidleName" value="${param.txtMidleName}" placeholder="Tên Lót"/><br/>
                <input id="fiel" type="text" name="txtLastName" value="${param.txtLastName}" placeholder="Họ"/>
                <font color="red">
                ${requestScope.INVALID.lastNameErr}
                </font><br/>
                <input id="fiel" type="text" name="txtEmail" value="${param.txtEmail}" placeholder="Email"/>
                <font color="red">
                ${requestScope.INVALID.emailErr}
                </font><br/>
                <input id="fiel" type="text" name="txtPhone" value="${param.txtPhone}" placeholder="Số Điện Thoại"/>
                <font color="red">
                ${requestScope.INVALID.phoneErr}
                </font><br/>
                <input id="fiel" type="text" name="txtAddress" value="${param.txtAddress}" placeholder="Địa Chỉ"/>
                <font color="red">
                ${requestScope.INVALID.addressErr}
                </font><br/>
                
                <input type="submit" value="Đăng Ký" name="action" id="but" style="width: 305px;height: 30px;font-size: 20px"/>               
            </form>
                <a href="home.jsp" style="color: white">Trở Về</a>
        </div>
    </body>
</html>
