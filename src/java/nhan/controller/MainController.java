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

/**
 *
 * @author Nhan
 */
public class MainController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String LOGIN = "LoginController";
    private static final String GUESTSEARCH = "GuestSearchController";
    private static final String USERSEARCH = "UserSearchController";
    private static final String STAFFSEARCH = "StaffSearchController";
    private static final String DELETEPRODUCT = "DeleteProductController";
    private static final String LOGOUT = "LogoutController";
    private static final String INSERT = "InsertController";
    private static final String EDITPRODUCT = "EditProductController";
    private static final String UPDATEPRODUCT = "UpdateProductController";
    private static final String REGISTER = "RegisterController";
    private static final String ADDTOCART = "AddToCartController";
    private static final String REMOVEFROMCART = "RemoveFormCartController";
    private static final String PAY = "PayController";
    private static final String VIEWCART = "view-cart.jsp";
    private static final String INSERTPAGE = "insert-product.jsp";
    private static final String ORDERPAGE = "ViewOrderController";
    private static final String DETAILPAGE = "ViewOrderDetailController";

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
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String url = ERROR;
        try {
            String action = request.getParameter("action");
            String role = request.getParameter("role");
            if (action.equals("Đăng Nhập")) {
                url = LOGIN;
            } else if (action.equals("Tìm Kiếm") && role.equals("guest")) {
                url = GUESTSEARCH;
            } else if (action.equals("Tìm Kiếm") && role.equals("user")) {
                url = USERSEARCH;
            } else if (action.equals("Tìm Kiếm") && role.equals("staff")) {
                url = STAFFSEARCH;
            } else if (action.equals("delete")) {
                url = DELETEPRODUCT;
            } else if (action.equals("Đăng Xuất")) {
                url = LOGOUT;
            } else if (action.equals("Thêm sản phẩm")) {
                url = INSERTPAGE;
            } else if (action.equals("Thêm Sản Phẩm")) {
                url = INSERT;
            } else if (action.equals("Chỉnh Sửa")) {
                url = EDITPRODUCT;
            } else if (action.equals("Cập Nhập Sản Phẩm")) {
                url = UPDATEPRODUCT;
            } else if (action.equals("Đăng Ký")) {
                url = REGISTER;
            } else if (action.equals("Mua")) {
                url = ADDTOCART;
            } else if (action.equals("Xem Giỏi Hàng")) {
                url = VIEWCART;
            } else if (action.equals("Bỏ Sản Phẩm")) {
                url = REMOVEFROMCART;
            } else if (action.equals("Thanh Toán")) {
                url = PAY;
            } else if (action.equals("Xem Đơn Hàng")) {
                url = ORDERPAGE;
            } else if (action.equals("Xem")) {
                url = DETAILPAGE;
            } else {
                request.setAttribute("ERROR", "Không có chức năng này!");
            }
        } catch (Exception e) {
            log("Error at MainController: " + e.getMessage());
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
