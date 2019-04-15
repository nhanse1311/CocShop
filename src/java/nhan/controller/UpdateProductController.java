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
import nhannt.beans.CocShopBeans;
import nhannt.error.ReceiveError;
import nhannt.product.ProductDTO;

/**
 *
 * @author Nhan
 */
public class UpdateProductController extends HttpServlet {

    private static final String ERROR = "error.jsp";
    private static final String SUCCESS = "StaffSearchController";
    private static final String INVALID = "update-product.jsp";
    private static final String OUT = "home.jsp";
    private static final String IN = "update-product.jsp";

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
        String url = IN;
        try {
            HttpSession session = request.getSession();

            if (session.getAttribute("USER") == null) {
                url = OUT;
            }
            String productID = request.getParameter("txtProductID").toUpperCase();
            String productName = request.getParameter("txtProductName");
            String brand = request.getParameter("txtBrand");
            String description = request.getParameter("txtDescription");
            String price = request.getParameter("txtPrice");
            String quantity = request.getParameter("txtQuantity");
            String status = request.getParameter("txtStatusU");
            String categoryID = request.getParameter("txtCategoryID");
            ReceiveError error = new ReceiveError();
            String[] categoryIDArr = categoryID.split("-");
            categoryID = categoryIDArr[1];
            boolean valid = true;
            if (productName.length() == 0) {
                error.setProductNameErr("Tên sản phẩm không được trống!");
                valid = false;
            }
            if (!price.matches("([0-9]{1,10}).[0-9]{1,10}|[0-9]{1,10}") || Float.parseFloat(price) == 0) {
                error.setPriceErr("Giá tiền phải là số và lớn hơn 0!");
                valid = false;
            }
            if (!quantity.matches("\\d+") || Integer.parseInt(quantity) == 0) {
                error.setQuantityErr("Số lượng phải là số và lớn hơn 0!");
                valid = false;
            }
            if (valid) {
                ProductDTO dto = new ProductDTO(productID, productName, Float.parseFloat(price), brand, description, Integer.parseInt(quantity), status, categoryID);
                CocShopBeans beans = new CocShopBeans();
                beans.setDtoP(dto);
                if (beans.updateProduct()) {
                    url = SUCCESS;
                } else {
                    request.setAttribute("ERRORUPDATE", "Cập Nhập Thất Bại!");
                    url = ERROR;
                }
            } else {
                ProductDTO dto = new ProductDTO(productID, productName, brand, description, status, categoryID);
                request.setAttribute("DTO", dto);
                request.setAttribute("INVALID", error);
                url = INVALID;
            }
        } catch (Exception e) {
            log("Error at UpdateProductController: " + e.getMessage());
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
