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
import javax.servlet.http.HttpSession;
import nhannt.cart.CartObj;
import nhannt.order.OrderDAO;
import nhannt.orderDetail.OrderDetailDTO;

/**
 *
 * @author Nhan
 */
public class AddToCartController extends HttpServlet {

    private static final String SUCCESS = "UserSearchController";
    
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
        String url = SUCCESS;
        try {
            String username = request.getParameter("txtUsername");
            HttpSession session = request.getSession();
            CartObj cart = (CartObj) session.getAttribute("SHOPPING");
            if (cart == null) {
                cart = new CartObj(username);
            }
            String productID = request.getParameter("txtProductID");
            String productName = request.getParameter("txtProductName");
            float unitPrice = Float.parseFloat(request.getParameter("txtUnitPrice"));
            String name = request.getParameter("txtSearchName");
            String price = request.getParameter("txtSearchPrice");
            OrderDetailDTO dto = new OrderDetailDTO(productID, productName, 1, unitPrice);
            cart.addToCart(dto);
            session.setAttribute("SHOPPING", cart);
        } catch (Exception e) {
            log("Error at AddToCartController: " + e.getMessage());
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
