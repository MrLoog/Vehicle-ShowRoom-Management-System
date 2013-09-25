/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.utility;

import app.model.Order;
import app.view.DialogConfig;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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

    public static Connection getConnection(){
        if (conn == null) {
            loadConnection();
        }
        return conn;
    }

    private static void loadConnection(){
        BufferedReader br = null;
        File f = new File("src\\databaseconnection.vsm");
        if(!f.exists()){
            try {
                f.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(AppUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            br = new BufferedReader(new FileReader("src\\databaseconnection.vsm"));
            String driver = br.readLine();
            String url = br.readLine();
            String username = br.readLine();
            String password = br.readLine();
            String databasename = br.readLine();
            url = url +";database="+ databasename;
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch(Exception e){
        } 
    }
    
    public static boolean testConnection(){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("src\\databaseconnection.vsm"));
            String driver = br.readLine();
            String url = br.readLine();
            String username = br.readLine();
            String password = br.readLine();
            String databasename = br.readLine();
            url = url +";database="+ databasename;
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch(Exception e){
          return false;
        }
        if(conn!=null){
            try {
                conn.close();
                conn=null;
            } catch (SQLException ex) {
                Logger.getLogger(AppUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return true;
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
                return "Is Creating";
            case Order.STATUS_DONE:
                return "Done";
            case Order.STATUS_CANCEL:
                return "Cancel";
            default:
                return null;
        }
    }

    public static java.sql.Date getCurrentDateSql() {
        java.util.Date date = new java.util.Date();
        java.sql.Date inputdate = new java.sql.Date(date.getTime());
        return inputdate;
    }

    public static Date getMinDate(List<Date> lst) {
        if (lst.size() <= 0) {
            return null;
        }
        Date output = lst.get(0);
        for (Date date : lst) {
            if (output.getTime() > date.getTime()) {
                output = date;
            }
        }
        return output;
    }

    public static Date getMaxDate(List<Date> lst) {
        if (lst.size() <= 0) {
            return null;
        }
        Date output = lst.get(0);
        for (Date date : lst) {
            if (output.getTime() < date.getTime()) {
                output = date;
            }
        }
        return output;
    }
}
