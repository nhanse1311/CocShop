/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.order;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import nhannt.connnection.MyConnection;

/**
 *
 * @author Nhan
 */
public class OrderDAO implements Serializable {

    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;

    private void closeConnection() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (stm != null) {
            stm.close();
        }
        if (con != null) {
            stm.close();
        }
    }

    public int getQuantityBill() throws Exception {
        int quantity = 0;
        try {
            con = MyConnection.getMyconConnection();
            if (con != null) {
                String sql = "select count(orderID) as quantity from tbl_Order ";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                if (rs.next()) {
                    quantity = rs.getInt("quantity");
                }
            }
        } finally {
            closeConnection();
        }
        return quantity;
    }

    public boolean insertOrder(OrderDTO dto) throws Exception {
        boolean check = false;
        try {
            con = MyConnection.getMyconConnection();
            if (con != null) {
                String sql = "insert into tbl_Order(orderID,username,total) values(?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getOrderID());
                stm.setString(2, dto.getUsername());
                stm.setFloat(3, dto.getAllTotal());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<OrderDTO> getListOrder() throws Exception {
        List<OrderDTO> result = null;
        String orderID = null;
        String username = null;
        float total = 0;
        Date orderDate;
        OrderDTO dto = null;
        try {
            con = MyConnection.getMyconConnection();
            if (con != null) {
                String sql = "select orderID,username,orderDate,total "
                        + "from tbl_Order";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {
                    orderID = rs.getString("orderID");
                    username = rs.getString("username");
                    total = rs.getFloat("total");
                    orderDate = rs.getDate("orderDate");
                    dto = new OrderDTO(orderID, username, orderDate, total);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
