/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.product;

import java.io.Serializable;

/**
 *
 * @author Nhan
 */
public class ProductDTO implements Serializable{
    private String productID;
    private String name;
    private float price;
    private String brand;
    private String description;
    private int quantity;
    private String status;
    private String categoryID;

    public ProductDTO() {
    }

    public ProductDTO(String productID, String name, float price, String brand, String description, int quantity, String status, String categoryID) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
        this.quantity = quantity;
        this.status = status;
        this.categoryID = categoryID;
    }

    public ProductDTO(String productID, String name, float price, String brand, String description) {
        this.productID = productID;
        this.name = name;
        this.price = price;
        this.brand = brand;
        this.description = description;
    }

    public ProductDTO(String productID, String name, String brand, String description, String status, String categoryID) {
        this.productID = productID;
        this.name = name;
        this.brand = brand;
        this.description = description;
        this.status = status;
        this.categoryID = categoryID;
    }
    
    public String getProductID() {
        return productID;
    }

    public void setProductID(String productID) {
        this.productID = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }
    
}
