/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.ImportOrder;
import app.model.Vehicle;
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

    public ImportOrderService() {
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
                temp.setName(rs.getString("Name"));
                temp.setBrand(rs.getString("Brand"));
                temp.setPrice(rs.getInt("Price"));
                temp.setModelNumber(rs.getString("ModelNumber"));
                temp.setQuantity(rs.getInt("Quantity"));
                temp.setDealerId(rs.getInt("DealerID"));
                output.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ImportOrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    protected String getQueryInsert() {
        return "insert into " + getTableName() + " values(?,?,?,?,?,?)";
    }

    @Override
    protected void setParameterForInsert(Object obj) {
        try {
            ImportOrder order = (ImportOrder) obj;
            insertStmt.setString(1, order.getModelNumber());
            insertStmt.setString(2, order.getName());
            insertStmt.setString(3, order.getBrand());
            insertStmt.setInt(4, order.getPrice());
            insertStmt.setInt(5, order.getQuantity());
            insertStmt.setInt(6, order.getDealerId());
        } catch (SQLException ex) {
            Logger.getLogger(ImportOrderService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryUpdate() {
        return "update " + getTableName() + " set Name=?,Brand=?,Price=?,ModelNumber=?,Quantity=?,DealerID=? where ID=?";
    }

    @Override
    protected void setParameterForUpdate(Object obj) {
        try {
            ImportOrder order = (ImportOrder) obj;
            updateStmt.setString(1, order.getName());
            updateStmt.setString(2, order.getBrand());
            updateStmt.setInt(3, order.getPrice());
            updateStmt.setString(4, order.getModelNumber());
            updateStmt.setInt(5, order.getQuantity());
            updateStmt.setInt(6, order.getDealerId());
            updateStmt.setInt(7, order.getId());
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
    public String getConditionSearch(String search) {
        String pre = "Name like '%search%' or Brand like '%search%' or ModelNumber like '%search%'";
        String result = pre.replaceAll("search", search);
        return result;
    }
}
