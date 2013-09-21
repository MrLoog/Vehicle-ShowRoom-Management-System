/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.model;

import app.model.Customer;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class TableCustomerModel extends AbstractTableModel {

    List<Customer> data;

    public TableCustomerModel(List<Customer> data) {
        this.data = data;
    }

    public TableCustomerModel() {
        data = new ArrayList<Customer>();
    }

    public Customer getData(int index) {
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
        return 5;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Customer c = data.get(i);
        switch (i1) {
            case 0:
                return c.getName();
            case 1:
                return c.getAddress();
            case 2:
                return c.getPhone();
            case 3:
                return c.getDealer().getName();
            case 4:
                return c.getCreated();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Name";
            case 1:
                return "Address";
            case 2:
                return "Phone";
            case 3:
                return "Dealer Add";
            case 4:
                return "Created";
            default:
                return null;
        }
    }
}
