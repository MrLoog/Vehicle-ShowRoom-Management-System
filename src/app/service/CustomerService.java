/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class CustomerService extends BaseService{
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
}
