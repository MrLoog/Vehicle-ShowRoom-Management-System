/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.model;

import app.model.ImportOrder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class TableImportOrderModel extends AbstractTableModel {

    List<ImportOrder> data;

    public TableImportOrderModel(List<ImportOrder> data) {
        this.data = data;
    }

    public TableImportOrderModel() {
        this.data = new ArrayList<ImportOrder>();
    }

    public ImportOrder getData(int index) {
        return data.get(index);
    }

    public void setData(List<ImportOrder> data) {
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
        ImportOrder c = data.get(i);
        switch (i1) {
            case 0:
                return c.getVehicle().getModelNumber();
            case 1:
                return c.getDealerModified().getName();
            case 2:
                return c.getCreated();
            case 3:
                return c.getPrice();
            case 4:
                return c.getQuantity();
            case 5:
                return (c.getPrice() * c.getQuantity());
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Vehicle Model";
            case 1:
                return "Dealer Modified";
            case 2:
                return "Created";
            case 3:
                return "Price";
            case 4:
                return "Quantity";
            case 5:
                return "Total";
            default:
                return null;
        }
    }
}
