/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.Customer;
import app.utility.AppUtility;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class CustomerService extends BaseService {

    @Override
    protected String getTableName() {
        return "Customers";
    }

    @Override
    protected List<Customer> ResultSetToList(ResultSet rs) {
        List<Customer> output = new ArrayList<Customer>();
        try {
            while (rs.next()) {
                Customer temp = new Customer();
                temp.setId(rs.getInt("ID"));
                temp.setName(rs.getString("Name"));
                temp.setAddress(rs.getString("Address"));
                temp.setPhone(rs.getString("Phone"));
                output.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    protected String getQueryInsert() {
        return "insert into " + getTableName() + " values(?,?,?)";
    }

    @Override
    protected void setParameterForInsert(Object obj) {
        try {
            Customer brand = (Customer) obj;
            insertStmt.setString(1, brand.getName());
            insertStmt.setString(2, brand.getAddress());
            insertStmt.setString(3, brand.getPhone());
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryUpdate() {
        return "update " + getTableName() + " set Name=?,Address=?,Phone=? where ID=?";
    }

    @Override
    protected void setParameterForUpdate(Object obj) {
        try {
            Customer brand = (Customer) obj;
            updateStmt.setString(1, brand.getName());
            updateStmt.setString(2, brand.getAddress());
            updateStmt.setString(3, brand.getPhone());
            updateStmt.setInt(4, brand.getId());
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryDelete() {
        return "delete from " + getTableName() + " where ID=?";
    }

    @Override
    protected void setParameterForDelete(Object obj) {
        try {
            Customer brand = (Customer) obj;
            deleteStmt.setInt(1, brand.getId());
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public int create(String name, String addr, String phone) {
        //if existed customer, not create new
        Statement stm;
        int cID = -1;
        Connection con = AppUtility.getConnection();
        try {
            stm = con.createStatement();
            if (!AppUtility.isExistAnObject("SELECT * FROM Customers WHERE name = N'" + name + "' and phone = '" + phone + "'", con)) {
                String sql = "insert into Customers values (N'" + name + "', N'" + addr + "', '" + phone + "')";
                int rs = stm.executeUpdate(sql);
                String sql2 = "SELECT TOP(1) * FROM Customers WHERE name = '" + name + "' order by(id) DESC";
                ResultSet r = stm.executeQuery(sql2);
                while (r.next()) {
                    cID = r.getInt("id");
                }
            } else {
                String sql2 = "SELECT TOP(1) * FROM Customers WHERE name = '" + name + "' order by(id) DESC";
                ResultSet r = stm.executeQuery(sql2);
                while (r.next()) {
                    cID = r.getInt("id");
                }
            }
            stm.close();
        } catch (SQLException ex) {
            System.out.println("KQ: " + ex.getMessage());
        }
        return cID;
    }
}
