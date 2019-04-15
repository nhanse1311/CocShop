/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhan.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import nhannt.beans.CocShopBeans;

/**
 *
 * @author Nhan
 */
public class LoginController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String USER = "user.jsp";
    private static final String STAFF = "staff.jsp";

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
            CocShopBeans beans = new CocShopBeans();
            String username = request.getParameter("txtUsername");
            String password = request.getParameter("txtPassword");
            beans.setUsername(username);
            beans.setPassword(password);
            String fullName = beans.getFullName();
            HttpSession session = request.getSession();
            session.setAttribute("USER", fullName);

            if (beans.checkLogin().equals("failed")) {
                request.setAttribute("ERROR", "Tên đăng nhập hoặc mật khẩu không đúng!");
            } else {
                if (beans.checkLogin().equals("user")) {
                    url = USER;
                }else if (beans.checkLogin().equals("staff")) {
                    url = STAFF;
                }else{
                    request.setAttribute("ERROR", "Phân quyền của bạn không tồn tại!");
                }
            }
        } catch (Exception e) {
            log("Error at LoginController: " + e.getMessage());
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
