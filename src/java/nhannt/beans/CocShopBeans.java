/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.beans;

import java.io.Serializable;
import java.util.List;
import nhan.registration.RegistrationDAO;
import nhan.registration.RegistrationDTO;
import nhannt.account.AccountDAO;
import nhannt.account.AccountDTO;
import nhannt.order.OrderDAO;
import nhannt.order.OrderDTO;
import nhannt.orderDetail.OrderDetailDAO;
import nhannt.orderDetail.OrderDetailDTO;
import nhannt.product.ProductDAO;
import nhannt.product.ProductDTO;

/**
 *
 * @author Nhan
 */
public class CocShopBeans implements Serializable {

    private String username;
    private String password;
    private String searchName;
    private float min, max;
    private String searchCategory;
    private String searchStatus;
    private String productId;
    private ProductDTO dtoP;
    private AccountDTO dtoA;
    private RegistrationDTO dtoR;
    private OrderDTO dtoO;
    private OrderDetailDTO dtoOD;
    private String orderID;

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getOrderID() {
        return orderID;
    }

    public OrderDTO getDtoO() {
        return dtoO;
    }

    public void setDtoO(OrderDTO dtoO) {
        this.dtoO = dtoO;
    }

    public OrderDetailDTO getDtoOD() {
        return dtoOD;
    }

    public void setDtoOD(OrderDetailDTO dtoOD) {
        this.dtoOD = dtoOD;
    }

    public ProductDTO getDtoP() {
        return dtoP;
    }

    public void setDtoP(ProductDTO dtoP) {
        this.dtoP = dtoP;
    }

    public AccountDTO getDtoA() {
        return dtoA;
    }

    public void setDtoA(AccountDTO dtoA) {
        this.dtoA = dtoA;
    }

    public RegistrationDTO getDtoR() {
        return dtoR;
    }

    public void setDtoR(RegistrationDTO dtoR) {
        this.dtoR = dtoR;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getSearchStatus() {
        return searchStatus;
    }

    public void setSearchStatus(String searchStatus) {
        this.searchStatus = searchStatus;
    }

    public String getSearchCategory() {
        return searchCategory;
    }

    public void setSearchCategory(String searchCategory) {
        this.searchCategory = searchCategory;
    }

    public float getMin() {
        return min;
    }

    public void setMin(float min) {
        this.min = min;
    }

    public float getMax() {
        return max;
    }

    public void setMax(float max) {
        this.max = max;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSearchName() {
        return searchName;
    }

    public void setSearchName(String searchName) {
        this.searchName = searchName;
    }

    public String checkLogin() throws Exception {
        AccountDAO dao = new AccountDAO();
        return dao.checkLogin(username, password);
    }

    public String getFullName() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.getFullName(username);
    }

    public List<ProductDTO> searchByName() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.searchByName(searchName);
    }

    public List<ProductDTO> searchByPrice() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.searchByPrice(min, max);
    }

    public List<ProductDTO> searchByCategory() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.searchByCategory(searchCategory);
    }

    public List<ProductDTO> searchByNameAndCategory() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.searchByNameAndCategory(searchName, searchCategory);
    }

    public List<ProductDTO> searchByPriceAndCategory() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.searchByPriceAndCategory(searchCategory, min, max);
    }

    public List<ProductDTO> searchByNameAndPrice() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.searchByNameAndPrice(searchName, min, max);
    }

    public List<ProductDTO> searchByNameAndPriceAndCategory() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.searchByNameAndPriceAndCategory(searchName, min, max, searchCategory);
    }

    public List<ProductDTO> searchByStatus() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.searchByStatus(searchStatus);
    }

    public List<ProductDTO> getListProduct() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.getListProduct();
    }

    public boolean deleteProduct() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.deleteProduct(productId);
    }

    public boolean insertProduct() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.insertProduct(dtoP);
    }

    public ProductDTO findByPrimaryKey() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.findByPrimaryKey(productId);
    }

    public boolean updateProduct() throws Exception {
        ProductDAO dao = new ProductDAO();
        return dao.updateProduct(dtoP);
    }

    public boolean insertAccount() throws Exception {
        AccountDAO dao = new AccountDAO();
        return dao.insertAccount(dtoA);
    }

    public boolean insertRegistration() throws Exception {
        RegistrationDAO dao = new RegistrationDAO();
        return dao.insertRegistration(dtoR);
    }

    public int getQuantityBill() throws Exception {
        OrderDAO dao = new OrderDAO();
        return dao.getQuantityBill();
    }

    public boolean inserOrder() throws Exception {
        OrderDAO dao = new OrderDAO();
        return dao.insertOrder(dtoO);
    }

    public boolean inserOrderDetail() throws Exception {
        OrderDetailDAO dao = new OrderDetailDAO();
        return dao.insertOrderDetail(dtoOD);
    }

    public List<OrderDTO> getListOrder() throws Exception {
        OrderDAO dao = new OrderDAO();
        return dao.getListOrder();
    }
    public List<OrderDetailDTO> getListOrderDetail() throws Exception {
        OrderDetailDAO dao = new OrderDetailDAO();
        return dao.getListDetail(orderID);
    }
}
