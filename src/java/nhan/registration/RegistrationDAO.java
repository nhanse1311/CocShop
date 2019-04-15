/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhan.registration;

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
public class RegistrationDAO implements Serializable {

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
    public String getFullName(String username)throws Exception{
        String fullName = "failed";
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "select lastname+' '+midlename+' '+firstname as fullname from tbl_Registration where username = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, username);
                rs = stm.executeQuery();
                if (rs.next()) {
                    fullName = rs.getNString("fullname");
                }
            }
        } finally{
            closeConnection();
        }
        return fullName;
    }
    public boolean insertRegistration(RegistrationDTO dto)throws Exception{
        boolean check = false;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "insert into tbl_Registration(username,firstname,midlename,lastname,email,address,phone)"
                        + " values(?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getUsername());
                stm.setNString(2, dto.getFirstName());
                stm.setNString(3, dto.getMidleName());
                stm.setNString(4, dto.getLastName());
                stm.setString(5, dto.getEmail());
                stm.setNString(6, dto.getAddress());
                stm.setString(7, dto.getPhone());
                check = stm.executeUpdate()>0;
            }
        } finally{
            closeConnection();
        }
        return check;
    }
}
