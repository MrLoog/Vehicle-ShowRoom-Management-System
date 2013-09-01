/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.utility.AppUtility;
import java.sql.Connection;
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
public abstract class BaseService {

    protected Connection conn;
    protected Statement stmt;

    public BaseService() {
        conn = AppUtility.getConnection();
    }

    public <T> List<T> getAll() {
        List<T> output=new ArrayList<T>();
        try {
            stmt = conn.createStatement();
            String sql = "select * from " + getTableName();
            ResultSet rs = stmt.executeQuery(sql);
            output=ResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    protected abstract String getTableName();

    protected abstract <T> List<T> ResultSetToList(ResultSet rs);
}
