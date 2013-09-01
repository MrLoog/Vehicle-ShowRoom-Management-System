/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

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
public class VehicleService extends BaseService {

    public VehicleService() {
        super();
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
                output.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(VehicleService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
}
