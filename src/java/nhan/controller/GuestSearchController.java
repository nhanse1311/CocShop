/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhan.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import nhannt.beans.CocShopBeans;
import nhannt.product.ProductDTO;

/**
 *
 * @author Nhan
 */
public class GuestSearchController extends HttpServlet {
    
    

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
        try {
            
            String name = request.getParameter("txtSearchName");
            String price = request.getParameter("txtSearchPrice");
            String categoryID = request.getParameter("txtCategory");
            String min = "";
            String max = "";
            if (!price.equals("Lựa Chọn")) {
                String[] priceArr = price.split("-");
                min = priceArr[0];
                max = priceArr[1];
            }

            CocShopBeans beans = new CocShopBeans();
            beans.setSearchName(name);
            beans.setSearchCategory(categoryID);
            if (name.length() > 0 && categoryID == null && min.length() == 0) {//search by Name
                List<ProductDTO> result = beans.searchByName();
                request.setAttribute("INFO", result);
            } else if (min.length() > 0 && name.length() == 0 && categoryID == null) {//search by Prices
                beans.setMin(Float.parseFloat(min));
                beans.setMax(Float.parseFloat(max));
                List<ProductDTO> result = beans.searchByPrice();
                request.setAttribute("INFO", result);
            } else if (categoryID != null && min.length() == 0 && name.length() == 0) {//search by category
                List<ProductDTO> result = beans.searchByCategory();
                request.setAttribute("INFO", result);
            } else if (name.length() > 0 && categoryID != null && min.length() == 0) {//search by name and category
                List<ProductDTO> result = beans.searchByNameAndCategory();
                request.setAttribute("INFO", result);
            } else if (name.length() > 0 && min.length() > 0 && categoryID == null) {// search by Name and Prices
                beans.setMin(Float.parseFloat(min));
                beans.setMax(Float.parseFloat(max));
                List<ProductDTO> result = beans.searchByNameAndPrice();
                request.setAttribute("INFO", result);
            } else if (name.length() == 0 && categoryID != null && min.length() > 0) {//search by Price and Category
                beans.setMin(Float.parseFloat(min));
                beans.setMax(Float.parseFloat(max));
                List<ProductDTO> result = beans.searchByPriceAndCategory();
                request.setAttribute("INFO", result);
            } else if (name.length() > 0 && categoryID != null && min.length() > 0) {//Search by name and prices and category
                beans.setMin(Float.parseFloat(min));
                beans.setMax(Float.parseFloat(max));
                List<ProductDTO> result = beans.searchByNameAndPriceAndCategory();
                request.setAttribute("INFO", result);
            }
        } catch (Exception e) {
            log("Error at GuestSearchController: " + e.getMessage());
        } finally {
            request.getRequestDispatcher("home.jsp").forward(request, response);
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
