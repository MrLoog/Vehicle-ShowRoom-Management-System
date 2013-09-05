
package app.view.customer;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import app.listener.UpdateCustomerListener;
import app.model.Customer;
import app.utility.AppUtility;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kiendv_c00505
 */
public class TableCustomerModel extends AbstractTableModel{
List<Customer> customers;
UpdateCustomerListener update;

    public TableCustomerModel() {
        customers = new ArrayList();
        String sql = "SELECT * FROM Customers";
        try {
            Statement stm = AppUtility.getConnection().createStatement();
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                Customer c = new Customer();
                c.setId(rs.getInt("id"));
                c.setName(rs.getString("name"));
                c.setAddress(rs.getString("address"));
                c.setPhone(rs.getString("phone"));
                customers.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TableCustomerModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    public void setUpdateListener(UpdateCustomerListener update) {
        this.update = update;
    }

    public int getRowCount() {
      return  customers.size();
    }

    public int getColumnCount() {
        return 4;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }
    
    public void addCustomer(Customer c){
        customers.add(c);
    }
    public Object getValueAt(int rowIndex, int columnIndex) {
        Customer c = customers.get(rowIndex);
        switch(columnIndex){
            case 0: return c.getId();
            case 1: return c.getName();
            case 2: return c.getAddress();
            case 3: return c.getPhone();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Full Name";
            case 2: return "Address";
            case 3: return "Phone number";
            default: return null;
        }
    }


}
