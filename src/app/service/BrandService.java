/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.Brand;
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
public class BrandService extends BaseService {
    
    @Override
    public String getTableName() {
        return "Brands";
    }
    
    @Override
    protected List<Brand> ResultSetToList(ResultSet rs) {
        List<Brand> output = new ArrayList<Brand>();
        try {
            while (rs.next()) {
                Brand temp = new Brand();
                temp.setId(rs.getInt("ID"));
                temp.setName(rs.getString("Name"));
                temp.setBrandCode(rs.getString("BrandCode"));
                temp.setDescription(rs.getString("Description"));
                output.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BrandService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    
    @Override
    protected String getQueryInsert() {
        return "insert into " + getTableName() + " values(?,?,?)";
    }
    
    @Override
    protected void setParameterForInsert(Object obj) {
        try {
            Brand brand = (Brand) obj;
            insertStmt.setString(1, brand.getName());
            insertStmt.setString(2, brand.getBrandCode());
            insertStmt.setString(3, brand.getDescription());
        } catch (SQLException ex) {
            Logger.getLogger(BrandService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String getQueryUpdate() {
        return "update " + getTableName() + " set Name=?,BrandCode=?,Description=? where ID=?";
    }
    
    @Override
    protected void setParameterForUpdate(Object obj) {
        try {
            Brand brand = (Brand) obj;
            updateStmt.setString(1, brand.getName());
            updateStmt.setString(2, brand.getBrandCode());
            updateStmt.setString(3, brand.getDescription());
            updateStmt.setInt(4, brand.getId());
        } catch (SQLException ex) {
            Logger.getLogger(BrandService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    protected String getQueryDelete() {
        return "delete from " + getTableName() + " where ID=?";
    }
    
    @Override
    protected void setParameterForDelete(Object obj) {
        try {
            Brand brand = (Brand) obj;
            deleteStmt.setInt(1, brand.getId());
        } catch (SQLException ex) {
            Logger.getLogger(BrandService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
