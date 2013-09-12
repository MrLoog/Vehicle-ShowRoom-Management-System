/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.Dealer;
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
}
