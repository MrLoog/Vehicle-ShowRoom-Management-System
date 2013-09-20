/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.model.Category;
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
public class CategoryService extends BaseService {

    @Override
    public String getTableName() {
        return "Categorys";
    }

    @Override
    protected List<Category> ResultSetToList(ResultSet rs) {
        List<Category> output = new ArrayList<Category>();
        try {
            while (rs.next()) {
                Category temp = new Category();
                temp.setId(rs.getInt("ID"));
                temp.setTitle(rs.getString("Title"));
                temp.setDescription(rs.getString("Description"));
                output.add(temp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
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
            Category temp = (Category) obj;
            insertStmt.setString(1, temp.getTitle());
            insertStmt.setString(2, temp.getDescription());
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryUpdate() {
        return "update " + getTableName() + " set Title=?,Description=? where ID=?";
    }

    @Override
    protected void setParameterForUpdate(Object obj) {
        try {
            Category temp = (Category) obj;
            updateStmt.setString(1, temp.getTitle());
            updateStmt.setString(2, temp.getDescription());
            updateStmt.setInt(3, temp.getId());
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected String getQueryDelete() {
        return "delete from " + getTableName() + " where ID=?";
    }

    @Override
    protected void setParameterForDelete(Object obj) {
        try {
            Category temp = (Category) obj;
            deleteStmt.setInt(1, temp.getId());
        } catch (SQLException ex) {
            Logger.getLogger(CategoryService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
