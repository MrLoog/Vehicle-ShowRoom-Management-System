/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.Order;
import app.utility.AppUtility;
import app.view.Main;
import java.sql.Date;
import java.sql.PreparedStatement;
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
public class OrderService extends BaseService {

    private static OrderService instance;

    public static OrderService getInstance() {
        if (instance == null) {
            instance = new OrderService();
        }
        return instance;
    }

    private OrderService() {
        super();
    }

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
                temp.setQuantity(rs.getInt("Quantity"));
                temp.setIsDeleted(rs.getBoolean("IsDeleted"));
                output.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    protected String getQueryInsert() {
        return "insert into " + getTableName() + "(DealerID,CustomerID,VehicleID,Price,Status,Created,Modified,Quantity,IsDeleted) values(?,?,?,?,?,?,?,?,?)";
    }

    @Override
    protected void setParameterForInsert(Object obj) {
        try {
            Order temp = (Order) obj;
            insertStmt.setInt(1, temp.getDealerId());
            insertStmt.setInt(2, temp.getCustomerId());
            insertStmt.setInt(3, temp.getVehicleId());
            insertStmt.setInt(4, temp.getPrice());
            insertStmt.setInt(5, temp.getStatus());
            insertStmt.setDate(6, temp.getCreated());
            insertStmt.setDate(7, temp.getModified());
            insertStmt.setInt(8, temp.getQuantity());
            insertStmt.setBoolean(9, temp.isIsDeleted());
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryUpdate() {
        return "update " + getTableName() + " set DealerID=?,CustomerID=?,VehicleID=?,Price=?,Status=?,Created=?,Modified=?,Quantity=?,IsDeleted=? where ID=?";
    }

    @Override
    protected void setParameterForUpdate(Object obj) {
        try {
            Order temp = (Order) obj;
            updateStmt.setInt(1, temp.getDealerId());
            updateStmt.setInt(2, temp.getCustomerId());
            updateStmt.setInt(3, temp.getVehicleId());
            updateStmt.setInt(4, temp.getPrice());
            updateStmt.setInt(5, temp.getStatus());
            updateStmt.setDate(6, temp.getCreated());
            updateStmt.setDate(7, temp.getModified());
            updateStmt.setInt(8, temp.getQuantity());
            updateStmt.setBoolean(9, temp.isIsDeleted());
            updateStmt.setInt(10, temp.getId());
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
//    
//    public int create(int dealerId, int customerId, int vehicleId, int price, int q) {
//        int flag = 0;
//        String updateQuantity = "UPDATE Vehicles SET quantity = " + (q - 1) + " WHERE id = " + vehicleId;
//        String created = "05/09/2013";
//        String sql = "INSERT INTO Orders VALUES (" + dealerId + ", " + customerId + ", " + vehicleId + ", " + price + ", 0, '" + created + "', '" + created + "')";
//        try {
//            Statement stm = AppUtility.getConnection().createStatement();
//            stm.executeUpdate(updateQuantity);
//            flag = stm.executeUpdate(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return flag;
//    }
//    
//    public List<OrderPlus> getAllOrder() {
//        String sql = "select o.ID as oid, c.Name as cname, o.Price as op, d.Name as dname, v.Name as vname, v.Brand as vbrand, o.Status as stt from Orders o join Dealers d on o.DealerID = d.ID join Customers c on o.CustomerID = c.ID join Vehicles v on o.VehicleID = v.ID order by (oid) DESC";
//        List<OrderPlus> l = new ArrayList<OrderPlus>();
//        try {
//            Statement statement = AppUtility.getConnection().createStatement();
//            ResultSet rs = statement.executeQuery(sql);
//            while (rs.next()) {
//                OrderPlus o = new OrderPlus();
//                o.setOid(rs.getInt("oid"));
//                o.setCname(rs.getString("cname"));
//                o.setOprice(rs.getInt("op"));
//                o.setDname(rs.getString("dname"));
//                o.setVname(rs.getString("vname"));
//                o.setBrand(rs.getString("vbrand"));
//                o.setStt(rs.getInt("stt"));
//                l.add(o);
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return l;
//    }
//    
//    public int confirmOrder(int id) {
//        String sql1 = "SELECT * FROM Orders WHERE id=" + id;
//        int stt = 0;
//        try {
//            Statement stm = AppUtility.getConnection().createStatement();
//            ResultSet rs = stm.executeQuery(sql1);
//            int stt2 = -1;
//            while (rs.next()) {
//                stt2 = rs.getInt("status");
//            }
//            if (stt2 == 0) {
//                Statement stm2 = AppUtility.getConnection().createStatement();
//                String sql2 = "UPDATE Orders SET Status = 1 WHERE id = " + id;
//                int xx = stm2.executeUpdate(sql2);
//                stt = 1;
//            }
//            if (stt2 == 1) {
//                Statement stm3 = AppUtility.getConnection().createStatement();
//                String sql2 = "UPDATE Orders SET Status = 0 WHERE id = " + id;
//                int xx = stm3.executeUpdate(sql2);
//                stt = 1;
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return stt;
//    }
//    

    public PreparedStatement getPrepareStmtFindByDealerID(int id) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from " + getTableName() + " where DealerID=?");
            ps.setInt(1, id);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public PreparedStatement getPrepareStmtCountOrder(int dealerid) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select COUNT(*) as total from " + getTableName() + " where DealerID=?");
            ps.setInt(1, dealerid);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public PreparedStatement getPrepareStmtCountOrderWithStatus(int dealerid, int status) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select COUNT(*) as total from " + getTableName() + " where DealerID=? and Status=?");
            ps.setInt(1, dealerid);
            ps.setInt(2, status);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public String getConditionSearchWithStatus(int id, String search, boolean selected) {
        String pre = "(CustomerID=search or VehicleID=search) and DealerID=id ";
        if (selected) {
            pre += "and Status=" + Order.STATUS_NEW;
        }
        String result = pre.replaceAll("search", search);
        result = result.replaceAll("id", id + "");
        return result;
    }

    public String getConditionSearchWithStatusAndJoin(int id, List<Integer> restrictVehicle, List<Integer> restrictCustomer, boolean selected) {
        String pre = "";
        String search = "";
        if (!(restrictVehicle.size() <= 0 && restrictCustomer.size() <= 0)) {
            pre = "(CustomerID in paraCustomer or VehicleID in paraVehicle) and ";
        }
        String searchCustomer = AppUtility.buildStringInSql(restrictCustomer);
        String searchVehicle = AppUtility.buildStringInSql(restrictVehicle);
        pre += " DealerID=id ";
        if (selected) {
            pre += "and [Status]=" + Order.STATUS_NEW;
        }
        String result = pre.replaceAll("search", search);
        result = result.replaceAll("id", id + "");
        result = result.replaceAll("paraCustomer", searchCustomer);
        result = result.replaceAll("paraVehicle", searchVehicle);
        return result;
    }

    public PreparedStatement getPrepareStmtAllOrderDone() {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from " + getTableName() + " where IsDeleted=0 and Status=?");
            ps.setInt(1, Order.STATUS_DONE);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public PreparedStatement getTopCustomerOrder(Date from, Date to) {
        PreparedStatement ps = null;
        if(from==null){
            from=new Date(0);
        }
        if(to==null){
            to=new Date(new java.util.Date().getTime());
        }
        try {
            String query="select Top "+Main.LIMIT+" CustomerID,Sum(Price * Quantity) as total from " + getTableName()+ " where IsDeleted=0 and [Status]=3 and (Created between ? and ?) group by CustomerID order by total desc";
            ps = conn.prepareStatement(query);
            ps.setDate(1, from);
            ps.setDate(2, to);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public PreparedStatement getTopCustomerOrderAll(Date from, Date to) {
        PreparedStatement ps = null;
        if(from==null){
            from=new Date(0);
        }
        if(to==null){
            to=new Date(new java.util.Date().getTime());
        }
        try {
            String query="select CustomerID,Sum(Price * Quantity) as total from " + getTableName()+ " where IsDeleted=0 and [Status]=3 and (Created between ? and ?) group by CustomerID order by total desc";
            ps = conn.prepareStatement(query);
            ps.setDate(1, from);
            ps.setDate(2, to);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public PreparedStatement getTopDealerOrder(Date from, Date to) {
        PreparedStatement ps = null;
        if(from==null){
            from=new Date(0);
        }
        if(to==null){
            to=new Date(new java.util.Date().getTime());
        }
        try {
            String query="select Top "+Main.LIMIT+" DealerID,Sum(Price * Quantity) as total from " + getTableName()+ " where IsDeleted=0 and [Status]=3 and (Created between ? and ?) group by DealerID order by total desc";
            ps = conn.prepareStatement(query);
            ps.setDate(1, from);
            ps.setDate(2, to);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }
    
     public PreparedStatement getTopDealerOrderAll(Date from, Date to) {
        PreparedStatement ps = null;
        if(from==null){
            from=new Date(0);
        }
        if(to==null){
            to=new Date(new java.util.Date().getTime());
        }
        try {
            String query="select DealerID,Sum(Price * Quantity) as total from " + getTableName()+ " where IsDeleted=0 and [Status]=3 and (Created between ? and ?) group by DealerID order by total desc";
            ps = conn.prepareStatement(query);
            ps.setDate(1, from);
            ps.setDate(2, to);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public PreparedStatement getTopVehicleOrderAll(Date from, Date to) {
       PreparedStatement ps = null;
        if(from==null){
            from=new Date(0);
        }
        if(to==null){
            to=new Date(new java.util.Date().getTime());
        }
        try {
            String query="select VehicleID,Sum(Quantity) as totalquantity,Sum(Price * Quantity) as total from " + getTableName()+ " where IsDeleted=0 and [Status]=3 and (Created between ? and ?) group by VehicleID order by totalquantity";
            ps = conn.prepareStatement(query);
            ps.setDate(1, from);
            ps.setDate(2, to);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public PreparedStatement getStatusOrderAll(Date from, Date to) {
        PreparedStatement ps = null;
        if(from==null){
            from=new Date(0);
        }
        if(to==null){
            to=new Date(new java.util.Date().getTime());
        }
        try {
            String query="select [Status],Count(*) as total from " + getTableName()+ " where IsDeleted=0 and (Created between ? and ?) group by [Status] ";
            ps = conn.prepareStatement(query);
            ps.setDate(1, from);
            ps.setDate(2, to);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }
}
