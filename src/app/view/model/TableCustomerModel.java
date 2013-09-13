/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.model;

import app.model.Customer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class TableCustomerModel extends AbstractTableModel{
    List<Customer> data;

    public TableCustomerModel(List<Customer> data) {
        this.data=data;
    }
    public Customer getData(int index){
        return data.get(index);
    }

    public void setData(List<Customer> data) {
        this.data = data;
    }
    
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
         return 6;
    }

    @Override
    public Object getValueAt(int i, int i1) {
       Customer c = data.get(i);
        switch(i1){
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
            case 1: return "Name";
            case 2: return "Address";
            case 3: return "Phone";
            default: return null;
        }
    }
}