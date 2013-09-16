/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.Vehicle;
import app.utility.AppUtility;
import java.sql.PreparedStatement;
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
public class VehicleService extends BaseService {

    public VehicleService() {
        super();
    }

    public String getByModelNumberQuery(String modelNumber) {
        return "getVehicleByModelNumber '" + modelNumber + "'";
    }

    @Override
    public String getTableName() {
        return "Vehicles";
    }

    @Override
    protected List<Vehicle> ResultSetToList(ResultSet rs) {
        List<Vehicle> output = new ArrayList<Vehicle>();
        try {
            while (rs.next()) {
                Vehicle temp = new Vehicle();
                temp.setId(rs.getInt("ID"));
                temp.setName(rs.getString("Name"));
                temp.setBrand(rs.getString("Brand"));
                temp.setPrice(rs.getInt("Price"));
                temp.setModelNumber(rs.getString("ModelNumber"));
                temp.setQuantity(rs.getInt("Quantity"));
                output.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    @Override
    protected void setParameterForInsert(Object obj) {
        try {
            Vehicle vehicle = (Vehicle) obj;
            insertStmt.setString(1, vehicle.getName());
            insertStmt.setString(2, vehicle.getBrand());
            insertStmt.setInt(3, vehicle.getPrice());
            insertStmt.setString(4, vehicle.getModelNumber());
            insertStmt.setInt(5, vehicle.getQuantity());
        } catch (SQLException ex) {
            Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void setParameterForUpdate(Object obj) {
        try {
            Vehicle vehicle = (Vehicle) obj;
            updateStmt.setString(1, vehicle.getName());
            updateStmt.setString(2, vehicle.getBrand());
            updateStmt.setInt(3, vehicle.getPrice());
            updateStmt.setString(4, vehicle.getModelNumber());
            updateStmt.setInt(5, vehicle.getQuantity());
            updateStmt.setInt(6, vehicle.getId());
        } catch (SQLException ex) {
            Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void setParameterForDelete(Object obj) {
        try {
            Vehicle vehicle = (Vehicle) obj;
            deleteStmt.setInt(1, vehicle.getId());
        } catch (SQLException ex) {
            Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryInsert() {
        return "insert into " + getTableName() + " values(?,?,?,?,?)";
    }

    @Override
    protected String getQueryUpdate() {
        return "update " + getTableName() + " set Name=?,Brand=?,Price=?,ModelNumber=?,Quantity=? where ID=?";
    }

    @Override
    protected String getQueryDelete() {
        return "delete from " + getTableName() + " where ID=?";
    }

    public Vehicle getVehicleById(String id) {
        Vehicle v = null;
        String sql = "SELECT * FROM Vehicles WHERE id = " + id;
        try {
            Statement stm = AppUtility.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            v = new Vehicle();
            while (rs.next()) {
                v.setName(rs.getString("name"));
                v.setBrand(rs.getString("brand"));
                v.setModelNumber(rs.getString("modelNumber"));
                v.setPrice(rs.getInt("price"));
                v.setQuantity(rs.getInt("quantity"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return v;
    }

    public int update(String name, String brand, String modelnumber, String price, String quantity, String id) {
        String sql = "UPDATE Vehicles SET name = N'" + name.replace("'", "''") + "', brand = N'" + brand.replace("'", "''") + "', modelNumber=" + modelnumber.replace("'", "''") + ", price=" + price.replace("'", "''") + ", quantity=" + quantity.replace("'", "''") + " WHERE id=" + id;
        try {
            Statement stm = AppUtility.getConnection().createStatement();
            return stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }

    public int create(String name, String brand, String modelnumber, String price, String quantity) {
        int x = 0;
        if (isExisted(modelnumber, name, brand) > 0) {
            x = 0;
        } else {
            String sql = "INSERT INTO Vehicles VALUES(N'" + name.replace("'", "''") + "', N'" + brand.replace("'", "''") + "', " + price.replace("'", "''") + ", " + modelnumber.replace("'", "''") + ", " + quantity.replace("'", "''") + ")";
            try {
                Statement stm = AppUtility.getConnection().createStatement();
                x = stm.executeUpdate(sql);
            } catch (SQLException ex) {
                Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
                x = -1;
            }
        }
        return x;
    }

    public int isExisted(String model, String name, String brand) {
        String sql = "SELECT * FROM Vehicles WHERE modelNumber = " + model.replace("'", "''") + " and name = N'" + name.replace("'", "''") + "' and brand=N'" + brand.replace("'", "''") + "'";
        try {
            Statement stm = AppUtility.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                return 1;
            } else {
                return 0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public int remove(String id) {
        int x = 0;
        String sql = "DELETE FROM Vehicles WHERE id=" + id.replace("'", "''");
        try {
            Statement stm = AppUtility.getConnection().createStatement();
            x = stm.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return x;
    }

    public List<Vehicle> search(String key, String sort, int getall) {
        if (getall != 0) {
            List<Vehicle> l = new ArrayList<Vehicle>();
            String sql = "";
            if (sort.equals("Name") || sort.equals("Brand")) {
                sql = "SELECT * FROM Vehicles WHERE " + sort + " like '%" + key + "%'";
            } else {
                sql = "SELECT * FROM Vehicles WHERE " + sort + " = " + key + "";
            }
            try {
                Statement stm = AppUtility.getConnection().createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    Vehicle v = new Vehicle();
                    v.setId(rs.getInt("id"));
                    v.setName(rs.getString("name"));
                    v.setBrand(rs.getString("brand"));
                    v.setModelNumber(rs.getString("modelNumber"));
                    v.setPrice(rs.getInt("price"));
                    v.setQuantity(rs.getInt("quantity"));
                    l.add(v);
                }
            } catch (SQLException ex) {
                Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return l;
        } else {
            List<Vehicle> l = new ArrayList<Vehicle>();
            String sql = "SELECT * FROM Vehicles";
            try {
                Statement stm = AppUtility.getConnection().createStatement();
                ResultSet rs = stm.executeQuery(sql);
                while (rs.next()) {
                    Vehicle v = new Vehicle();
                    v.setId(rs.getInt("id"));
                    v.setName(rs.getString("name"));
                    v.setBrand(rs.getString("brand"));
                    v.setModelNumber(rs.getString("modelNumber"));
                    v.setPrice(rs.getInt("price"));
                    v.setQuantity(rs.getInt("quantity"));
                    l.add(v);
                }
            } catch (SQLException ex) {
                Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
            }
            return l;
        }
    }

    public PreparedStatement getPrepareStmtAllAvaiable() {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from " + getTableName() + " where Quantity>0");
        } catch (SQLException ex) {
            Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }
}
