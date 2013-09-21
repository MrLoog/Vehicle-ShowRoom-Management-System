/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.model;

import app.model.Dealer;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class TableDealerModel extends AbstractTableModel {

    List<Dealer> data;

    public TableDealerModel(List<Dealer> data) {
        this.data = data;
    }

    public Dealer getData(int index) {
        return data.get(index);
    }

    public void setData(List<Dealer> data) {
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
        Dealer c = data.get(i);
        switch (i1) {
            case 0:
                return c.getName();
            case 1:
                return c.getLoginName();
            case 2:
                return c.isIsManager();
            case 3:
                return c.getCreated();
            case 4:
                return c.isIsDeleted();
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
                return "Login Name";
            case 2:
                return "Manager";
            case 3:
                return "Created";
            case 4:
                return "Lock";
            default:
                return null;
        }
    }
}
