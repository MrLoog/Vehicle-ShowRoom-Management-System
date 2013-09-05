/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.Order;
import app.utility.AppUtility;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class OrderService extends BaseService {

    @Override
    protected String getTableName() {
        return "Orders";
    }

    @Override
    protected List<Order> ResultSetToList(ResultSet rs) {
        List<Order> output = new ArrayList<Order>();
        try {
            while (rs.next()) {
                Order temp = new Order();
                temp.setId(rs.getInt("ID"));
                temp.setDealerId(rs.getInt("DealerID"));
                temp.setCustomerId(rs.getInt("CustomerID"));
                temp.setVehicleId(rs.getInt("VehicleID"));
                temp.setPrice(rs.getInt("Price"));
                temp.setStatus(rs.getInt("Status"));
                temp.setCreated(rs.getDate("Created"));
                temp.setModified(rs.getDate("Modified"));
                output.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    protected String getQueryInsert() {
        return "insert into " + getTableName() + " values(?,?,?,?,?,?,?)";
    }

    @Override
    protected void setParameterForInsert(Object obj) {
        try {
            Order brand = (Order) obj;
            insertStmt.setInt(1, brand.getDealerId());
            insertStmt.setInt(2, brand.getCustomerId());
            insertStmt.setInt(3, brand.getVehicleId());
            insertStmt.setInt(4, brand.getPrice());
            insertStmt.setInt(5, brand.getStatus());
            insertStmt.setDate(6, brand.getCreated());
            insertStmt.setDate(7, brand.getModified());
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryUpdate() {
        return "update " + getTableName() + " set DealerID=?,CustomerID=?,VehicleID=?,Price=?,Status=?,Created=?,Modified=? where ID=?";
    }

    @Override
    protected void setParameterForUpdate(Object obj) {
        try {
            Order brand = (Order) obj;
            updateStmt.setInt(1, brand.getDealerId());
            updateStmt.setInt(2, brand.getCustomerId());
            updateStmt.setInt(3, brand.getVehicleId());
            updateStmt.setInt(4, brand.getPrice());
            updateStmt.setInt(5, brand.getStatus());
            updateStmt.setDate(6, brand.getCreated());
            updateStmt.setDate(7, brand.getModified());
            updateStmt.setInt(8, brand.getId());
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryDelete() {
        return "delete from " + getTableName() + " where ID=?";
    }

    @Override
    protected void setParameterForDelete(Object obj) {
        try {
            Order brand = (Order) obj;
            deleteStmt.setInt(1, brand.getId());
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int create(int dealerId,int customerId,int vehicleId, int price){
        int flag = 0;
        
        String created = "05/09/2013";
        String sql = "INSERT INTO Orders VALUES ("+dealerId+", "+customerId+", "+vehicleId+", "+price+", 0, '"+created+"', '"+created+"')";
        try {
            Statement stm = AppUtility.getConnection().createStatement();
            flag = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
