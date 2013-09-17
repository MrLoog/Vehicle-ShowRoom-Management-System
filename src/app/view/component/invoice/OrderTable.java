/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.invoice;

import app.model.Order;
import app.view.model.TableOrderModelV2;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class OrderTable extends javax.swing.JPanel {

    private List<Order> model;

    public void setModel(List<Order> model) {
        this.model = model;
        TableOrderModelV2 tablemodel = new TableOrderModelV2(model);
        jTable1.setModel(tablemodel);
        jTable1.revalidate();
        jTable1.repaint();
    }

    public Order getSelectedOrder() {
        int index = jTable1.getSelectedRow();
        if (index == -1) {
            return null;
        } else {
            return ((TableOrderModelV2) jTable1.getModel()).getData(index);
        }
    }

    public Object getSelectedObject() {
        return getSelectedOrder();
    }

    /**
     * Creates new form OrderTable
     */
    public OrderTable() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}