/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.Dealer;
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
public class DealerService extends BaseService{
    @Override
    public String getTableName() {
        return "Dealers";
    }
    
    @Override
    protected List<Dealer> ResultSetToList(ResultSet rs) {
        List<Dealer> output = new ArrayList<Dealer>();
        try {
            while (rs.next()) {
                Dealer temp = new Dealer();
                temp.setId(rs.getInt("ID"));
                temp.setName(rs.getString("Name"));
                temp.setLoginName(rs.getString("LoginName"));
                temp.setPassword(rs.getString("Password"));
                temp.setIsAdmin(rs.getBoolean("IsManager"));
                output.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
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
            Dealer brand = (Dealer) obj;
            insertStmt.setString(1, brand.getName());
            insertStmt.setString(2, brand.getLoginName());
            insertStmt.setString(3, brand.getPassword());
            insertStmt.setBoolean(4, brand.isIsAdmin());
        } catch (SQLException ex) {
            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String getQueryUpdate() {
        return "update " + getTableName() + " set Name=?,LoginName=?,Password=?,IsManager=? where ID=?";
    }
    public int updaterole(String status, int id) {
        String sql = "update Dealers set IsManager='"+status+"' where ID="+id;
        try {
            Statement stm = AppUtility.getConnection().createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }
    @Override
    protected void setParameterForUpdate(Object obj) {
        try {
            Dealer brand = (Dealer) obj;
            updateStmt.setString(1, brand.getName());
            updateStmt.setString(2, brand.getLoginName());
            updateStmt.setString(3, brand.getPassword());
            updateStmt.setBoolean(4, brand.isIsAdmin());
            updateStmt.setInt(5, brand.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String getQueryDelete() {
        return "delete from " + getTableName() + " where ID=?";
    }
    
    @Override
    protected void setParameterForDelete(Object obj) {
        try {
            Dealer brand = (Dealer) obj;
            deleteStmt.setInt(1, brand.getId());
        } catch (SQLException ex) {
            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //
//    public List<Dealer> paging(String query) {
//        Statement stm = null;
//        List<Dealer> customers = new ArrayList<Dealer>();
//        Connection con = AppUtility.getConnection();
//        try {
//            stm = con.createStatement();
//            stm.executeQuery(query);
//            ResultSet rs = stm.executeQuery(query);
//            while (rs.next()) {
//                Dealer c = new Dealer();
//                c.setId(rs.getInt("id"));
//                c.setName(rs.getString("name"));
//                c.setLoginName(rs.getString("loginName"));
//                c.setIsAdmin(rs.getBoolean("isManager"));
//                customers.add(c);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        try {
//            stm.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return customers;
//    }
//    
}
