/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.vehicle;

import app.icomponent.IPanelTable;
import app.model.Vehicle;
import app.view.model.TableVehicleModel;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

/**
 *
 * @author Administrator
 */
public class VehicleTable extends javax.swing.JPanel implements IPanelTable {
    
    private List<Vehicle> model;

    /**
     * Creates new form VehicleTable
     */
    public VehicleTable() {
        initComponents();
    }

    private ActionListener selectListener;
    public void setSelectListener(ActionListener listener) {
        this.selectListener = listener;
        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

            @Override
            public void valueChanged(ListSelectionEvent lse) {
                if (selectListener != null) {
                    selectListener.actionPerformed(null);
                }
            }
        });
    }

    public void setModel(List<Vehicle> model) {
        this.model = model;
        TableVehicleModel tablemodel = new TableVehicleModel(model);
        jTable1.setModel(tablemodel);
        jTable1.revalidate();
        jTable1.repaint();
    }
    
    public Vehicle getSelectedVehicle() {
        int index = jTable1.getSelectedRow();
        if (index == -1) {
            return null;
        } else {
            return ((TableVehicleModel) jTable1.getModel()).getData(index);
        }
    }

    public Object getSelectedObject() {
        return getSelectedVehicle();
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

    public void setDataModel(List<Vehicle> lst) {
        
    }
}
