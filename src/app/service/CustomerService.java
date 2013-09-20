/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.Customer;
import app.utility.AppUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.AbstractList;
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
    public String getTableName() {
        return "Customers";
    }

    @Override
    public <Customer> List<Customer> executeQuery(String query) {
        return super.executeQuery(query);
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
                temp.setDealerId(rs.getInt("DealerID"));
                output.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    protected String getQueryInsert() {
        return "insert into " + getTableName() + " values(?,?,?,?)";
    }

    @Override
    protected void setParameterForInsert(Object obj) {
        try {
            Customer brand = (Customer) obj;
            insertStmt.setString(1, brand.getName());
            insertStmt.setString(2, brand.getAddress());
            insertStmt.setString(3, brand.getPhone());
            insertStmt.setInt(4, brand.getDealerId());
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryUpdate() {
        return "update " + getTableName() + " set Name=?,Address=?,Phone=?,DealerID=? where ID=?";
    }

    @Override
    protected void setParameterForUpdate(Object obj) {
        try {
            Customer brand = (Customer) obj;
            updateStmt.setString(1, brand.getName());
            updateStmt.setString(2, brand.getAddress());
            updateStmt.setString(3, brand.getPhone());
            updateStmt.setInt(4, brand.getDealerId());
            updateStmt.setInt(5, brand.getId());
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

    @Override
    public Customer getById(int id) {
        return super.getById(id);
    }
//
//    public int create(String name, String addr, String phone) {
//        //if existed customer, not create new
//        Statement stm;
//        int cID = -1;
//        Connection con = AppUtility.getConnection();
//        try {
//            stm = con.createStatement();
//            if (!AppUtility.isExistAnObject("SELECT * FROM Customers WHERE name = N'" + name + "' and phone = '" + phone + "'", con)) {
//                String sql = "insert into Customers values (N'" + name + "', N'" + addr + "', '" + phone + "', 1)";
//                int rs = stm.executeUpdate(sql);
//                String sql2 = "SELECT TOP(1) * FROM Customers WHERE name = '" + name + "' order by(id) DESC";
//                ResultSet r = stm.executeQuery(sql2);
//                while (r.next()) {
//                    cID = r.getInt("id");
//                }
//            } else {
//                String sql2 = "SELECT TOP(1) * FROM Customers WHERE name = '" + name + "' order by(id) DESC";
//                ResultSet r = stm.executeQuery(sql2);
//                while (r.next()) {
//                    cID = r.getInt("id");
//                }
//                cID = -2;
//            }
//            stm.close();
//        } catch (SQLException ex) {
//            System.out.println("KQ: " + ex.getMessage());
//        }
//        return cID;
//    }

    public PreparedStatement getPStmtFindCustomer(String phone) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from " + getTableName() + " where Phone=?");
            ps.setString(1, phone);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public PreparedStatement getPrepareStmtCountByDealer(int id) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select COUNT(*) as total from " + getTableName() + " where DealerID=?");
            ps.setInt(1, id);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }
//
//    public List<Customer> paging(String query) {
//        Statement stm = null;
//        List<Customer> customers = new ArrayList<Customer>();
//        Connection con = AppUtility.getConnection();
//        try {
//            stm = con.createStatement();
//            stm.executeQuery(query);
//            ResultSet rs = stm.executeQuery(query);
//            while (rs.next()) {
//                Customer c = new Customer();
//                c.setId(rs.getInt("id"));
//                c.setName(rs.getString("name"));
//                c.setAddress(rs.getString("address"));
//                c.setPhone(rs.getString("phone"));
//                customers.add(c);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            stm.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return customers;
//    }

    public String getConditionSearch(String search) {
        String pre = "Name like '%search%' or Address like '%search%' or Phone like '%search%'";
        String result = pre.replaceAll("search", search);
        return result;
    }
}
