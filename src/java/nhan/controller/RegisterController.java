/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhan.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nhan.registration.RegistrationDTO;
import nhannt.account.AccountDTO;
import nhannt.beans.CocShopBeans;
import nhannt.error.ReceiveError;

/**
 *
 * @author Nhan
 */
public class RegisterController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "home.jsp";
    private static final String INVALID = "register.jsp";

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            String confirm = request.getParameter("txtConfirm");
            String email = request.getParameter("txtEmail");
            String phone = request.getParameter("txtPhone");
            String address = request.getParameter("txtAddress");
            String firstName = request.getParameter("txtFirstName");
            String midleName = request.getParameter("txtMidleName");
            String lastName = request.getParameter("txtLastName");
            ReceiveError error = new ReceiveError();
            boolean valid = true;
            if (username.length() == 0) {
                error.setUsernameErr("Tên đăng nhập không được trống!");
                valid = false;
            }
            if (password.length() == 0) {
                error.setPasswordErr("Mật khẩu không được trống!");
                valid = false;
            }
            if (!confirm.equals(password)) {
                error.setConfirmErr("Mật khẩu nhập lại không khớp!");
                valid = false;
            }
            if (firstName.length() == 0) {
                error.setFirstNameErr("Tên không được trống!");
                valid = false;
            }
            if (lastName.length() == 0) {
                error.setLastNameErr("Họ không được trống!");
                valid = false;
            }
            if (!email.matches("\\w+([.]\\w+)?@\\w+[.]\\w+")) {
                error.setEmailErr("Email của không hợp lệ!");
                valid = false;
            }
            if (!phone.matches("(09|01)\\d{8,13}")) {
                error.setPhoneErr("Số điện thoại không hợp lệ!");
                valid = false;
            }
            if (address.length() == 0) {
                error.setAddressErr("Địa chỉ chưa được nhập!");
                valid = false;
            }
            if (valid) {
                RegistrationDTO dtoR = new RegistrationDTO(username, firstName, midleName, lastName, email, address, phone);
                AccountDTO dtoA = new AccountDTO(username, password, "user");
                CocShopBeans beans = new CocShopBeans();
                beans.setDtoA(dtoA);
                beans.setDtoR(dtoR);
                if (beans.insertAccount()) {
                    if (beans.insertRegistration()) {
                        url = SUCCESS;
                    } else {
                        request.setAttribute("ERRORREGISTER", "Đăng Ký Không Thành Công!");
                    }
                } else {
                    request.setAttribute("ERRORREGISTER", "Đăng Ký Không Thành Công!");
                }
            } else {
                request.setAttribute("INVALID", error);
                url = INVALID;
            }
        } catch (Exception e) {
            log("Error at RegisterController: " + e.getMessage());
            if (e.getMessage().contains("duplicate")) {
                url = INVALID;
                ReceiveError err = new ReceiveError();
                err.setProductIDErr("Tên đăng nhập đã tồn tại!");
                request.setAttribute("INVALID", err);
            }
        } finally {
            request.getRequestDispatcher(url).forward(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
