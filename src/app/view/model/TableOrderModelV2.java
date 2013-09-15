/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.model;

import app.model.Order;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class TableOrderModelV2 extends AbstractTableModel {

    List<Order> data;

    public TableOrderModelV2(List<Order> data) {
        this.data = data;
    }

    public Order getData(int index) {
        return data.get(index);
    }

    public void setData(List<Order> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Order c = data.get(i);
        switch (i1) {
            case 0:
                return c.getCustomer().getName();
            case 1:
                return c.getCustomer().getPhone();
            case 2:
                return c.getVehicle().getModelNumber();
            case 3:
                return c.getPrice();
            case 4:
                return c.getStatus();
            case 5:
                return c.getCreated();
            case 6:
                return c.getModified();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Customer";
            case 1:
                return "Phone";
            case 2:
                return "Model";
            case 3:
                return "Price";
            case 4:
                return "Status";
            case 5:
                return "Created";
            case 6:
                return "Modified";
            default:
                return null;
        }
    }
}
