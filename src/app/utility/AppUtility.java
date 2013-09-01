/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.utility;

import java.sql.Connection;
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
    private static final String username = "sa";
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
}
