/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.utility;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class AppUtility {

    private static Connection conn;
    private static final String username = "admin";
    private static final String password = "123456";

    public static Connection getConnection() {
        if (conn == null) {
            loadConnection();
        }
        return conn;
    }
    private static void loadConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=ShowRoom", username, password);
        } catch (SQLException ex) {
            Logger.getLogger(AppUtility.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AppUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static boolean isNumber(String s){
        try{
            Integer.parseInt(s);
            return true;
        }catch(Exception ex){
            return false;
        }
    }
    //check this customer is exist or not
    public static boolean isExistAnObject(String sql, Connection conn){
        boolean flag = true;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if(rs.next()){
                flag = true;
            }else{
                flag = false;
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(AppUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
}
