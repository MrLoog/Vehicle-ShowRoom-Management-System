/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.utility;

import app.model.Order;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public class AppUtility {

    private static Connection conn;
//    private static final String username = "admin";
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

    public static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
    //check this customer is exist or not

    public static boolean isExistAnObject(String sql, Connection conn) {
        boolean flag = true;
        try {
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery(sql);
            if (rs.next()) {
                flag = true;
            } else {
                flag = false;
            }
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(AppUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return flag;
    }
    //get time

    public static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    public static String buildStringInSql(List<Integer> lst) {
        String search = "";
        if (!(lst == null || lst.size() <= 0)) {
            if (lst.size() > 1) {
                for (int i = 0; i < lst.size(); i++) {
                    if (search.equals("")) {
                        search = "(" + lst.get(i);
                    } else if (i == (lst.size() - 1)) {
                        search += "," + lst.get(i) + ")";
                    } else {
                        search += "," + lst.get(i);
                    }
                }
            } else {
                search = "(" + lst.get(0) + ")";
            }
        } else {
            search = "(0)";
        }
        return search;
    }

    public static String EncryptPassword(String password) {
        String s = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] text = md.digest();
            s = new String(text);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(AppUtility.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;
    }

    public static String getStatusString(int status) {
        switch (status) {
            case Order.STATUS_NEW:
                return "New";
            case Order.STATUS_WAIT_CREATE:
                return "Pre Created";
            case Order.STATUS_DONE:
                return "Done";
            case Order.STATUS_CANCEL:
                return "Cancel";
            default:
                return null;
        }
    }
}
