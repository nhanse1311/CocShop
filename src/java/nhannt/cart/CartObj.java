/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.cart;

import java.io.Serializable;
import java.util.HashMap;
import nhannt.orderDetail.OrderDetailDTO;

/**
 *
 * @author Nhan
 */
public class CartObj implements Serializable {

    private String username;
    private HashMap<String, OrderDetailDTO> cart;
    
    

    public CartObj(String username) {
        this.username = username;
        this.cart = new HashMap<>();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public HashMap<String, OrderDetailDTO> getCart() {
        return cart;
    }

    public void addToCart(OrderDetailDTO dto) throws Exception {
        if (this.cart.containsKey(dto.getProductID())) {
            int quantity = this.cart.get(dto.getProductID()).getQuantity() + 1;
            dto.setQuantity(quantity);
        }
        this.cart.put(dto.getProductID(), dto);
    }

    public void removeCart(String id) throws Exception {
        if (this.cart.containsKey(id)) {
            this.cart.remove(id);
        }
    }
    public float getTotal() throws Exception {
        float result = 0;
        for (OrderDetailDTO dto : this.cart.values()) {
            result += dto.getQuantity() * dto.getUnitPrice();
        }
        return result;
    }
}
