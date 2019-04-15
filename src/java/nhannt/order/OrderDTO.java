/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.order;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author Nhan
 */
public class OrderDTO implements Serializable{
    private String orderID;
    private String username;
    private Date orderDate;
    private float allTotal;

    public OrderDTO() {
    }

    public OrderDTO(String orderID, String username, float allTotal) {
        this.orderID = orderID;
        this.username = username;
        this.allTotal = allTotal;
    }

    public OrderDTO(String orderID, String username, Date orderDate, float allTotal) {
        this.orderID = orderID;
        this.username = username;
        this.orderDate = orderDate;
        this.allTotal = allTotal;
    }


    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    
    

    public String getOrderID() {
        return orderID;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getAllTotal() {
        return allTotal;
    }

    public void setAllTotal(float allTotal) {
        this.allTotal = allTotal;
    }
    
}
