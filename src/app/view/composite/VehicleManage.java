/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.composite;

import app.model.Vehicle;
import app.service.VehicleService;
import app.view.component.order.ImportOrderForm;
import app.view.component.vehicle.ImportVehicleForm;
import com.sun.org.apache.xerces.internal.impl.dv.xs.YearDV;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Administrator
 */
public class VehicleManage extends javax.swing.JPanel  {

    private VehicleService vehicleService;
    private ImportVehicleForm importVehicleForm;
    private ImportOrderForm importOrderForm;

    /**
     * Creates new form ImportOrderWithVehicle
     */
    public VehicleManage() {
        initComponents();
        vehicleService = new VehicleService();
        displayImportOrderForm();
        reloadTableVehicle();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        vehicleTable1 = new app.view.component.vehicle.VehicleTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(700, 402));
        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel1.add(vehicleTable1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(172, 50));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        jButton4.setText("New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton4);

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton2);

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3);

        jButton1.setText("Order");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1);

        jPanel3.add(jPanel2, java.awt.BorderLayout.PAGE_START);

        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel3.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel3, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Vehicle v = vehicleTable1.getSelectedVehicle();
        if (importOrderForm == null) {
            importOrderForm = new ImportOrderForm();
        }
        importOrderForm.setModel(v);
        changeDisplayForm(importOrderForm);
    }//GEN-LAST:event_jButton1ActionPerformed
    private void displayImportOrderForm() {
        if (importOrderForm == null) {
            importOrderForm = new ImportOrderForm();
        }
//        importOrderForm.setLayoutistener(this);
        changeDisplayForm(importOrderForm);
    }

    private void displayImportVehicleForm() {
        if (importVehicleForm == null) {
            importVehicleForm = new ImportVehicleForm();
        }
        changeDisplayForm(importVehicleForm);
    }

    private void changeDisplayForm(JPanel panel) {
        jPanel4.removeAll();
        jPanel4.add(panel);
        jPanel4.revalidate();
        jPanel4.repaint();
    }
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        displayImportVehicleForm();
        importVehicleForm.setEditMode(false);
        importVehicleForm.clearForm();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Vehicle v = vehicleTable1.getSelectedVehicle();
        if (importVehicleForm == null) {
            importVehicleForm = new ImportVehicleForm();
        }
        importVehicleForm.setModel(v);
        displayImportVehicleForm();
        importVehicleForm.setEditMode(true);

    }//GEN-LAST:event_jButton2ActionPerformed
    private List<Vehicle> loadDataVehicle() {
        return vehicleService.getAll();
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        Vehicle v = vehicleTable1.getSelectedVehicle();
        int y = JOptionPane.showConfirmDialog(null, "Do you want to DELETE Vehicle : " + v.getName() + ", model number : " + v.getModelNumber() + "?", "Confirm Deleted", JOptionPane.YES_NO_OPTION);
        if (y == JOptionPane.NO_OPTION) {
            return;
        }
        if (v != null) {
            vehicleService.delete(v);
        }
        reloadTableVehicle();
    }//GEN-LAST:event_jButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private app.view.component.vehicle.VehicleTable vehicleTable1;
    // End of variables declaration//GEN-END:variables

    
    public void BodyChanged() {
        this.revalidate();
        this.repaint();
    }

    
    public void reloadTableVehicle() {
        vehicleTable1.setModel(loadDataVehicle());
    }
}
