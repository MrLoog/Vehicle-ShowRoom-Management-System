/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.OrderPlus;
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
    public String getTableName() {
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
    
    public int create(int dealerId,int customerId,int vehicleId, int price, int q){
        int flag = 0;
        String updateQuantity = "UPDATE Vehicles SET quantity = "+(q-1)+" WHERE id = "+vehicleId;
        String created = "05/09/2013";
        String sql = "INSERT INTO Orders VALUES ("+dealerId+", "+customerId+", "+vehicleId+", "+price+", 0, '"+created+"', '"+created+"')";
        try {
            Statement stm = AppUtility.getConnection().createStatement();
            stm.executeUpdate(updateQuantity);
            flag = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    public List<OrderPlus> getAllOrder(){
        String sql = "select o.ID as oid, c.Name as cname, o.Price as op, d.Name as dname, v.Name as vname, v.Brand as vbrand, o.Status as stt from Orders o join Dealers d on o.DealerID = d.ID join Customers c on o.CustomerID = c.ID join Vehicles v on o.VehicleID = v.ID order by (oid) DESC";
        List<OrderPlus> l = new ArrayList<OrderPlus>();
        try {
            Statement statement = AppUtility.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while(rs.next()){
                OrderPlus o = new OrderPlus();
                o.setOid(rs.getInt("oid"));
                o.setCname(rs.getString("cname"));
                o.setOprice(rs.getInt("op"));
                o.setDname(rs.getString("dname"));
                o.setVname(rs.getString("vname"));
                o.setBrand(rs.getString("vbrand"));
                o.setStt(rs.getInt("stt"));
                l.add(o);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return l;
    }
    public int confirmOrder(int id){
        String sql1 = "SELECT * FROM Orders WHERE id="+id;
        int stt = 0;
        try {
            Statement stm = AppUtility.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql1);
            int stt2 = -1;
            while(rs.next()){
                stt2 = rs.getInt("status");
            }
            if(stt2==0){
                Statement stm2 = AppUtility.getConnection().createStatement();
                String sql2 = "UPDATE Orders SET Status = 1 WHERE id = "+id;
                int xx = stm2.executeUpdate(sql2);
                stt = 1;
            }
            if(stt2==1){
                Statement stm3 = AppUtility.getConnection().createStatement();
                String sql2 = "UPDATE Orders SET Status = 0 WHERE id = "+id;
                int xx = stm3.executeUpdate(sql2);
                stt = 1;
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return stt;
    }
}
