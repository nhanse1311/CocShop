/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.orderDetail;

import java.sql.Connection;
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
public class OrderDetailDAO {

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

    public boolean insertOrderDetail(OrderDetailDTO dto) throws Exception {
        boolean check = false;
        try {
            con = MyConnection.getMyconConnection();
            if (con != null) {
                String sql = "insert into tbl_OrderDetail(productID,quantity,unitPrice,total,orderID) values(?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getProductID());
                stm.setInt(2, dto.getQuantity());
                stm.setFloat(3, dto.getUnitPrice());
                stm.setFloat(4, dto.getTotal());
                stm.setString(5, dto.getOrderID());
                check = stm.executeUpdate() > 0;
            }
        } finally {
            closeConnection();
        }
        return check;
    }

    public List<OrderDetailDTO> getListDetail(String orderID) throws Exception {
        List<OrderDetailDTO> result = null;
        String productID = null;
        int quantity = 0;
        float unitPrice = 0;
        float total = 0;
        OrderDetailDTO dto = null;
        try {
            con = MyConnection.getMyconConnection();
            if (con != null) {
                String sql = "select productID,quantity,unitPrice,total "
                        + "from tbl_OrderDetail where orderID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, orderID);
                rs = stm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {
                    productID = rs.getString("productID");
                    quantity = rs.getInt("quantity");
                    unitPrice = rs.getFloat("unitPrice");
                    total = rs.getFloat("total");
                    dto = new OrderDetailDTO(productID, quantity, unitPrice, total, orderID);
                    result.add(dto);
                }
            }
        } finally {
            closeConnection();
        }
        return result;
    }
}
