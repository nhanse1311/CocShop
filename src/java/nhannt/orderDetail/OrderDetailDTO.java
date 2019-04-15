/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.orderDetail;

import java.io.Serializable;

/**
 *
 * @author Nhan
 */
public class OrderDetailDTO implements Serializable{
    private int detailID;
    private String productID;
    private String productName;
    private int quantity;
    private float unitPrice;
    private float total;
    private String orderID;

    public OrderDetailDTO() {
    }

    public OrderDetailDTO(String productID, String productName, int quantity, float unitPrice) {
        this.productID = productID;
        this.productName = productName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public OrderDetailDTO(String productID, int quantity, float unitPrice, float total, String orderID) {
        this.productID = productID;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.total = total;
        this.orderID = orderID;
    }
    

    public int getDetailID() {
        return detailID;
    }

    public void setDetailID(int detailID) {
        this.detailID = detailID;
    }

    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public float getTotal() {
        return total = quantity*unitPrice;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }
    
    
}
