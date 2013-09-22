/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.Dealer;
import app.utility.AppUtility;
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
public class DealerService extends BaseService {

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
                temp.setIsManager(rs.getBoolean("IsManager"));
                temp.setCreated(rs.getDate("Created"));
                temp.setModified(rs.getDate("Modified"));
                temp.setIsDeleted(rs.getBoolean("IsDeleted"));
                output.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    protected String getQueryInsert() {
        return "insert into " + getTableName() + "(Name,LoginName,Password,IsManager,Created,Modified,IsDeleted) values(?,?,?,?,?,?,?)";
    }

    @Override
    protected void setParameterForInsert(Object obj) {
        try {
            Dealer temp = (Dealer) obj;
            insertStmt.setString(1, temp.getName());
            insertStmt.setString(2, temp.getLoginName());
            insertStmt.setString(3, temp.getPassword());
            insertStmt.setBoolean(4, temp.isIsManager());
            insertStmt.setDate(5, temp.getCreated());
            insertStmt.setDate(6, temp.getModified());
            insertStmt.setBoolean(7, temp.isIsDeleted());
        } catch (SQLException ex) {
            Logger.getLogger(DealerService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryUpdate() {
        return "update " + getTableName() + " set Name=?,LoginName=?,Password=?,IsManager=?,Created=?,Modified=?,IsDeleted=? where ID=?";
    }

    public int updaterole(String status, int id) {
        String sql = "update Dealers set IsManager='" + status + "' where ID=" + id;
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
            Dealer temp = (Dealer) obj;
            updateStmt.setString(1, temp.getName());
            updateStmt.setString(2, temp.getLoginName());
            updateStmt.setString(3, temp.getPassword());
            updateStmt.setBoolean(4, temp.isIsManager());
            updateStmt.setDate(5, temp.getCreated());
            updateStmt.setDate(6, temp.getModified());
            updateStmt.setBoolean(7, temp.isIsDeleted());
            updateStmt.setInt(8, temp.getId());
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

    public String getConditionSearch(String search) {
        String pre = " Name like '%search%' or LoginName like '%search%' ";
        String result = pre.replaceAll("search", search);
        return result;
    }
}
