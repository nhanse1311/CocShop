/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nhannt.product;

import java.io.Serializable;
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
public class ProductDAO implements Serializable {

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

    public List<ProductDTO> searchByName(String searchName) throws Exception {
        List<ProductDTO> result = null;
        String productID=null;
        String name=null;
        float price= 0;
        String brand=null;
        String description=null;
        ProductDTO dto = null;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "select productID,name,price,brand,description "
                        + "from tbl_Product where name like ? "
                        + "and (status ='bán' or quantity > 0)";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%"+searchName+"%");
                rs = stm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {                    
                    productID = rs.getString("productID");
                    name = rs.getNString("name");
                    price = rs.getFloat("price");
                    brand = rs.getNString("brand");
                    description = rs.getNString("description");
                    dto = new ProductDTO(productID, name, price, brand, description);
                    result.add(dto);
                }
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    public List<ProductDTO> searchByPrice(float min, float max) throws Exception {
        List<ProductDTO> result = null;
        String productID=null;
        String name=null;
        float price= 0;
        String brand=null;
        String description=null;
        ProductDTO dto = null;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "select productID,name,price,brand,description "
                        + "from tbl_Product where price between ? and ? "
                        + "and (status ='bán' or quantity > 0)";
                stm = con.prepareStatement(sql);
                stm.setFloat(1, min);
                stm.setFloat(2, max);
                rs = stm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {                    
                    productID = rs.getString("productID");
                    name = rs.getNString("name");
                    price = rs.getFloat("price");
                    brand = rs.getNString("brand");
                    description = rs.getNString("description");
                    dto = new ProductDTO(productID, name, price, brand, description);
                    result.add(dto);
                }
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    public List<ProductDTO> searchByCategory(String searchCategory) throws Exception {
        List<ProductDTO> result = null;
        String productID=null;
        String name=null;
        float price= 0;
        String brand=null;
        String description=null;
        ProductDTO dto = null;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "select productID,name,price,brand,description "
                        + "from tbl_Product where categoryID = ? and "
                        + "(status ='bán' or quantity > 0)";
                stm = con.prepareStatement(sql);
                stm.setString(1, searchCategory);
                rs = stm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {                    
                    productID = rs.getString("productID");
                    name = rs.getNString("name");
                    price = rs.getFloat("price");
                    brand = rs.getNString("brand");
                    description = rs.getNString("description");
                    dto = new ProductDTO(productID, name, price, brand, description);
                    result.add(dto);
                }
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    public List<ProductDTO> searchByNameAndCategory(String searchName,String searchCategory) throws Exception {
        List<ProductDTO> result = null;
        String productID=null;
        String name=null;
        float price= 0;
        String brand=null;
        String description=null;
        ProductDTO dto = null;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "select productID,name,price,brand,description "
                        + "from tbl_Product where name like ? and categoryID = ? "
                        + "and (status ='bán' or quantity > 0)";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%"+searchName+"%");
                stm.setString(2, searchCategory);
                rs = stm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {                    
                    productID = rs.getString("productID");
                    name = rs.getNString("name");
                    price = rs.getFloat("price");
                    brand = rs.getNString("brand");
                    description = rs.getNString("description");
                    dto = new ProductDTO(productID, name, price, brand, description);
                    result.add(dto);
                }
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    public List<ProductDTO> searchByPriceAndCategory(String searchCategory,float min, float max) throws Exception {
        List<ProductDTO> result = null;
        String productID=null;
        String name=null;
        float price= 0;
        String brand=null;
        String description=null;
        ProductDTO dto = null;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "select productID,name,price,brand,description "
                        + "from tbl_Product where categoryID = ? and price between ? and ? "
                        + "and (status ='bán' or quantity > 0)";
                stm = con.prepareStatement(sql);
                stm.setString(1, searchCategory);
                stm.setFloat(2, min);
                stm.setFloat(3, max);
                rs = stm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {                    
                    productID = rs.getString("productID");
                    name = rs.getNString("name");
                    price = rs.getFloat("price");
                    brand = rs.getNString("brand");
                    description = rs.getNString("description");
                    dto = new ProductDTO(productID, name, price, brand, description);
                    result.add(dto);
                }
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    public List<ProductDTO> searchByNameAndPrice(String searchName,float min, float max) throws Exception {
        List<ProductDTO> result = null;
        String productID=null;
        String name=null;
        float price= 0;
        String brand=null;
        String description=null;
        ProductDTO dto = null;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "select productID,name,price,brand,description "
                        + "from tbl_Product where name like ? and price between ? and ? "
                        + "and (status ='bán' or quantity > 0)";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%"+searchName+"%");
                stm.setFloat(2, min);
                stm.setFloat(3, max);
                rs = stm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {                    
                    productID = rs.getString("productID");
                    name = rs.getNString("name");
                    price = rs.getFloat("price");
                    brand = rs.getNString("brand");
                    description = rs.getNString("description");
                    dto = new ProductDTO(productID, name, price, brand, description);
                    result.add(dto);
                }
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    public List<ProductDTO> searchByNameAndPriceAndCategory(String searchName,float min, float max,String searchCategory) throws Exception {
        List<ProductDTO> result = null;
        String productID=null;
        String name=null;
        float price= 0;
        String brand=null;
        String description=null;
        int quantity = 0;
        String status=null;
        String categoryID=null;
        ProductDTO dto = null;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "select productID,name,price,brand,description,status,categoryID "
                        + "from tbl_Product where name like ? and price between ? and ? "
                        + "and categoryID=? and (status ='bán' or quantity > 0)";
                stm = con.prepareStatement(sql);
                stm.setString(1, "%"+searchName+"%");
                stm.setFloat(2, min);
                stm.setFloat(3, max);
                stm.setString(4, searchCategory);
                rs = stm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {                    
                    productID = rs.getString("productID");
                    name = rs.getNString("name");
                    price = rs.getFloat("price");
                    brand = rs.getNString("brand");
                    description = rs.getNString("description");
                    quantity = rs.getInt("quantity");
                    status = rs.getNString("status");
                    categoryID = rs.getString("categoryID");
                    dto = new ProductDTO(productID, name, price, brand, description,quantity ,status, categoryID);
                    result.add(dto);
                }
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    
    public List<ProductDTO> searchByStatus(String searchStatus) throws Exception {
        List<ProductDTO> result = null;
        String productID=null;
        String name=null;
        float price= 0;
        String brand=null;
        String description=null;
        int quantity = 0;
        String status=null;
        String categoryID=null;
        ProductDTO dto = null;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "select productID,name,price,brand,description,quantity,status,categoryID "
                        + "from tbl_Product where status = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, searchStatus);
                rs = stm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {                    
                    productID = rs.getString("productID");
                    name = rs.getNString("name");
                    price = rs.getFloat("price");
                    brand = rs.getNString("brand");
                    description = rs.getNString("description");
                    quantity = rs.getInt("quantity");
                    status = rs.getNString("status");
                    categoryID = rs.getString("categoryID");
                    dto = new ProductDTO(productID, name, price, brand, description, quantity, status, categoryID);
                    result.add(dto);
                }
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    public List<ProductDTO> getListProduct() throws Exception {
        List<ProductDTO> result = null;
        String productID=null;
        String name=null;
        float price= 0;
        String brand=null;
        String description=null;
        int quantity = 0;
        String status=null;
        String categoryID=null;
        ProductDTO dto = null;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "select productID,name,price,brand,description,quantity,status,categoryID "
                        + "from tbl_Product order by status";
                stm = con.prepareStatement(sql);
                rs = stm.executeQuery();
                result = new ArrayList<>();
                while (rs.next()) {                    
                    productID = rs.getString("productID");
                    name = rs.getNString("name");
                    price = rs.getFloat("price");
                    brand = rs.getNString("brand");
                    description = rs.getNString("description");
                    quantity = rs.getInt("quantity");
                    status = rs.getNString("status");
                    categoryID = rs.getString("categoryID");
                    dto = new ProductDTO(productID, name, price, brand, description,quantity ,status, categoryID);
                    result.add(dto);
                }
            }
        } finally{
            closeConnection();
        }
        return result;
    }
    public boolean deleteProduct(String id)throws Exception{
        boolean check = false;
        try {
            con = MyConnection.getMyconConnection();
            if (con !=null) {
                String sql = "Delete from tbl_Product where productID = ?";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                check = stm.executeUpdate()>0;
            }
        } finally{
            closeConnection();
        }
        return check;
    }
    public boolean insertProduct(ProductDTO dto)throws Exception{
        boolean check = false;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "insert into tbl_Product(productID,name,price,brand,description,quantity,status,categoryID) "
                        + "values(?,?,?,?,?,?,?,?)";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getProductID());
                stm.setNString(2, dto.getName());
                stm.setFloat(3, dto.getPrice());
                stm.setNString(4, dto.getBrand());
                stm.setNString(5, dto.getDescription());
                stm.setInt(6, dto.getQuantity());
                stm.setNString(7, dto.getStatus());
                stm.setString(8, dto.getCategoryID());
                check = stm.executeUpdate() > 0;
            }
        } finally{
            closeConnection();
        }
        return check;
    }
    public ProductDTO findByPrimaryKey(String id)throws Exception{
        ProductDTO dto = null;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "select productID,name,price,brand,description,quantity,status,categoryID "
                        + "from tbl_Product where productID = ? ";
                stm = con.prepareStatement(sql);
                stm.setString(1, id);
                rs = stm.executeQuery();
                if (rs.next()) {
                    String productID = rs.getString("productID");
                    String productName = rs.getNString("name");
                    float price = rs.getFloat("price");
                    String brand = rs.getNString("brand");
                    String description = rs.getNString("description");
                    int quantity = rs.getInt("quantity");
                    String status = rs.getNString("status");
                    String categoryID = rs.getString("categoryID");
                    dto =  new ProductDTO(productID, productName, price, brand, description, quantity, status, categoryID);
                }
            }
        } finally {
            closeConnection();
        }
        return dto;
    }
    public boolean updateProduct(ProductDTO dto)throws Exception{
        boolean check = false;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "update tbl_Product set "
                        + "name=?,price=?,brand=?,description=?,quantity=?,status=?,categoryID=? where productID=?";
                stm = con.prepareStatement(sql);
                stm.setString(1, dto.getName());
                stm.setFloat(2, dto.getPrice());
                stm.setNString(3, dto.getBrand());
                stm.setNString(4, dto.getDescription());
                stm.setInt(5, dto.getQuantity());
                stm.setString(6, dto.getStatus());
                stm.setString(7, dto.getCategoryID());
                stm.setString(8, dto.getProductID());
                check = stm.executeUpdate()>0;
            }
        }finally {
            closeConnection();
        }
        return check;
    }
    public boolean updateProductStatus(String id)throws Exception{
        boolean check = false;
        try {
            con = MyConnection.getMyconConnection();
            if (con!=null) {
                String sql = "update tbl_Product set "
                        + "status = 'không bán' where productID=?";
                stm = con.prepareStatement(sql);
                stm.setNString(1, id);
                check = stm.executeUpdate()>0;
            }
        }finally {
            closeConnection();
        }
        return check;
    }
}
