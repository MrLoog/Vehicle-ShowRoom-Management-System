/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.ImportOrder;
import app.model.Order;
import app.model.Vehicle;
import app.utility.AppUtility;
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
public class ImportOrderService extends BaseService {

    private static ImportOrderService instance;

    public static ImportOrderService getInstance() {
        if (instance == null) {
            instance = new ImportOrderService();
        }
        return instance;
    }

    private ImportOrderService() {
        super();
    }

    @Override
    public String getTableName() {
        return "ImportOrders";
    }

    @Override
    protected List<ImportOrder> ResultSetToList(ResultSet rs) {
        List<ImportOrder> output = new ArrayList<ImportOrder>();
        try {
            while (rs.next()) {
                ImportOrder temp = new ImportOrder();
                temp.setId(rs.getInt("ID"));
                temp.setPrice(rs.getInt("Price"));
                temp.setVehicleID(rs.getInt("VehicleID"));
                temp.setQuantity(rs.getInt("Quantity"));
                temp.setDealerId(rs.getInt("DealerID"));
                temp.setCreated(rs.getDate("Created"));
                temp.setModified(rs.getDate("Modified"));
                temp.setIsDeleted(rs.getBoolean("IsDeleted"));
                temp.setDealerModifiedID(rs.getInt("DealerModifiedID"));
                output.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportOrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    protected String getQueryInsert() {
        return "insert into " + getTableName() + "(VehicleID,Price,Quantity,DealerID,Created,Modified,IsDeleted,DealerModifiedID) values(?,?,?,?,?,?,?,?)";
    }

    @Override
    protected void setParameterForInsert(Object obj) {
        try {
            ImportOrder order = (ImportOrder) obj;
            insertStmt.setInt(1, order.getVehicleID());
            insertStmt.setInt(2, order.getPrice());
            insertStmt.setInt(3, order.getQuantity());
            insertStmt.setInt(4, order.getDealerId());
            insertStmt.setDate(5, order.getCreated());
            insertStmt.setDate(6, order.getModified());
            insertStmt.setBoolean(7, order.isIsDeleted());
            insertStmt.setInt(8, order.getDealerModifiedID());
        } catch (SQLException ex) {
            Logger.getLogger(ImportOrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryUpdate() {
        return "update " + getTableName() + " set Price=?,VehicleID=?,Quantity=?,DealerID=?,Created=?,Modified=?,IsDeleted=?,DealerModifiedID=? where ID=?";
    }

    @Override
    protected void setParameterForUpdate(Object obj) {
        try {
            ImportOrder order = (ImportOrder) obj;
            updateStmt.setInt(1, order.getPrice());
            updateStmt.setInt(2, order.getVehicleID());
            updateStmt.setInt(3, order.getQuantity());
            updateStmt.setInt(4, order.getDealerId());
            updateStmt.setDate(5, order.getCreated());
            updateStmt.setDate(6, order.getModified());
            updateStmt.setBoolean(7, order.isIsDeleted());
            updateStmt.setInt(8, order.getDealerModifiedID());
            updateStmt.setInt(9, order.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ImportOrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryDelete() {
        return "delete from " + getTableName() + " where ID=?";
    }

    @Override
    protected void setParameterForDelete(Object obj) {
        try {
            ImportOrder order = (ImportOrder) obj;
            deleteStmt.setInt(1, order.getId());
        } catch (SQLException ex) {
            Logger.getLogger(ImportOrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getConditionSearchWithStatusAndJoin(List<Integer> lstVehicle) {
        String pre = "";
        String search = "";
        if (!(lstVehicle.size() <= 0 && lstVehicle.size() <= 0)) {
            pre = "(VehicleID in paraVehicle) and ";
        }
        String searchVehicle = AppUtility.buildStringInSql(lstVehicle);
        pre += " 1=1 ";
        String result = pre.replaceAll("search", search);
        result = result.replaceAll("paraVehicle", searchVehicle);
        return result;
    }

    public PreparedStatement getPrepareStmtGetByVehicleID(Date from, Date to) {
        PreparedStatement ps = null;
        if(from==null){
            from=new Date(0);
        }
        if(to==null){
            to=new Date(new java.util.Date().getTime());
        }
        try {
            String query="select VehicleID,Sum(Quantity) as sum,Sum(Price*Quantity) as total from " + getTableName()+ " where IsDeleted=0 and (Created between ? and ?) group by VehicleID ";
            ps = conn.prepareStatement(query);
            ps.setDate(1, from);
            ps.setDate(2, to);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }

    public PreparedStatement getPrepareStmtAllOrder(Date from, Date to) {
        PreparedStatement ps = null;
        if(from==null){
            from=new Date(0);
        }
        if(to==null){
            to=new Date(new java.util.Date().getTime());
        }
        try {
            String query="select * from " + getTableName()+ " where IsDeleted=0 and (Created between ? and ?) ";
            ps = conn.prepareStatement(query);
            ps.setDate(1, from);
            ps.setDate(2, to);
        } catch (SQLException ex) {
            Logger.getLogger(OrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }
}
