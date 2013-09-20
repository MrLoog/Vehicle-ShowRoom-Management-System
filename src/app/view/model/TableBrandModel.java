/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.model;

import app.model.Brand;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class TableBrandModel extends AbstractTableModel {

    List<Brand> data;

    public TableBrandModel(List<Brand> data) {
        this.data = data;
    }

    public TableBrandModel() {
        data = new ArrayList<Brand>();
    }

    public Brand getData(int index) {
        return data.get(index);
    }

    public void setData(List<Brand> data) {
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public Object getValueAt(int i, int i1) {
        Brand c = data.get(i);
        switch (i1) {
            case 0:
                return c.getId();
            case 1:
                return c.getName();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID";
            case 1:
                return "Name";
            default:
                return null;
        }
    }
}
