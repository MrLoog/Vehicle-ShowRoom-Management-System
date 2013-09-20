/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.Brand;
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
        return "insert into " + getTableName() + " values(?,?)";
    }

    @Override
    protected void setParameterForInsert(Object obj) {
        try {
            Brand brand = (Brand) obj;
            insertStmt.setString(1, brand.getName());
            insertStmt.setString(2, brand.getDescription());
        } catch (SQLException ex) {
            Logger.getLogger(BrandService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryUpdate() {
        return "update " + getTableName() + " set Name=?,Description=? where ID=?";
    }

    @Override
    protected void setParameterForUpdate(Object obj) {
        try {
            Brand brand = (Brand) obj;
            updateStmt.setString(1, brand.getName());
            updateStmt.setString(2, brand.getDescription());
            updateStmt.setInt(3, brand.getId());
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

    public String getConditionSearch(String search) {
        String pre = "";
        pre += " (Name like '%search%' or Description like '%search%') ";
        String result = pre.replaceAll("search", search);
        return result;
    }

    public PreparedStatement getPrepareStmtBrandByName(String name) {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("select * from " + getTableName() + " where Name=? ");
            ps.setString(1, name);
        } catch (SQLException ex) {
            Logger.getLogger(BrandService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ps;
    }
}
