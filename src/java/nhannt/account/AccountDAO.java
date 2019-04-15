/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.account;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import nhannt.connnection.MyConnection;

/**
 *
 * @author Nhan
 */
public class AccountDAO implements Serializable{
    private Connection con = null;
    private PreparedStatement stm = null;
    private ResultSet rs = null;
    
    private void closeConnection() throws SQLException{
        if (rs!=null) {
            rs.close();
        }
        if (stm!=null) {
            stm.close();
        }
        if (con!=null) {
            stm.close();
        }
    }
    public String checkLogin(String username,String password)throws Exception{
        String check = "failed";
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql="Select role from tbl_Account where username = ? and password = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                stm.setString(2, password);
                rs = stm.executeQuery();
                if (rs.next()) {
                    check = rs.getString("role");
                }
            }
        } finally{
            closeConnection();
        }
        return check;
    }
    public boolean insertAccount(AccountDTO dto)throws Exception{
        boolean check = false;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "insert into tbl_Account(username,password,role) values(?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setString(2, dto.getPassword());
                stm.setString(3, dto.getRole());
                check = stm.executeUpdate()>0;
            }
        } finally{
            closeConnection();
        }
        return check;
    }
}
