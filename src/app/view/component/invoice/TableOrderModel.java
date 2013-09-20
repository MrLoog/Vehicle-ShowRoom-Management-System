package app.view.component.invoice;
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import app.model.OrderPlus;
import app.service.OrderService;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kiendv_c00505
 */
public class TableOrderModel extends AbstractTableModel {

    List<OrderPlus> orders;

    public TableOrderModel() {
//        orders = new OrderService().getAllOrder();
    }

    public int getRowCount() {
        return orders.size();
    }

    public int getColumnCount() {
        return 7;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public void addCustomer(OrderPlus c) {
        orders.add(c);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        OrderPlus c = orders.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return c.getOid();
            case 1:
                return c.getCname();
            case 2:
                return c.getOprice();
            case 3:
                return c.getDname();
            case 4:
                return c.getVname();
            case 5:
                return c.getBrand();
            case 6: {
                if (c.getStt() == 0) {
                    return "Waiting";
                } else {
                    return "Done";
                }
            }
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
                return "Customer Name";
            case 2:
                return "Price";
            case 3:
                return "Dealer Name";
            case 4:
                return "Vehicle Name";
            case 5:
                return "Vehicle Brand";
            case 6:
                return "Status";
            default:
                return null;
        }
    }
}
