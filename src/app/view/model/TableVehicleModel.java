/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.model;

import app.model.Vehicle;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Administrator
 */
public class TableVehicleModel extends AbstractTableModel{
    List<Vehicle> data;

    public TableVehicleModel(List<Vehicle> data) {
        this.data=data;
    }
    public Vehicle getData(int index){
        return data.get(index);
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
       Vehicle c = data.get(i);
        switch(i1){
            case 0: return c.getId();
            case 1: return c.getName();
            case 2: return c.getModelNumber();
            case 3: return c.getBrand();
            case 4: return c.getPrice();
            case 5: return c.getQuantity();
            default: return null;
        }
    }
     @Override
    public String getColumnName(int column) {
        switch(column){
            case 0: return "ID";
            case 1: return "Vehicle Name";
            case 2: return "Model";
            case 3: return "Brand";
            case 4: return "Price";
            case 5: return "Quantity";
            default: return null;
        }
    }
}
