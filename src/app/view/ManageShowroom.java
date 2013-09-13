/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

import app.listener.IMainFrame;
import app.listener.IManageShowroom;
import app.view.composite.ImportOrderManage;
import app.view.composite.VehicleManage;
import app.view.component.vehicle.ImportVehicleContent;
import app.view.component.vehicle.VehicleTable;
import java.awt.BorderLayout;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 *
 * @author Administrator
 */
public class ManageShowroom extends javax.swing.JPanel implements IManageShowroom {

    private IMainFrame listener;
    private VehicleManage vehicleManage;
    private ImportOrderManage importOrderManage;

    public void setListener(IMainFrame listener) {
        this.listener = listener;
    }

    /**
     * Creates new form ManageShowroom
     */
    public ManageShowroom() {
        initComponents();
        callViewVehicleManage();
    }

    @Override
    public void BodyChanged() {
        this.revalidate();
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jTabbedPane1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jTabbedPane1StateChanged(evt);
            }
        });

        jPanel1.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Vehicle", jPanel1);

        jPanel2.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Import Order", jPanel2);

        jPanel3.setLayout(new java.awt.BorderLayout());
        jTabbedPane1.addTab("Customer", jPanel3);

        add(jTabbedPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jTabbedPane1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jTabbedPane1StateChanged
        // TODO add your handling code here:
        int index=jTabbedPane1.getSelectedIndex();
        if(index==0){
            callViewVehicleManage();
        }
        else if(index==1){
            callViewImportOrderManage();
        }
    }//GEN-LAST:event_jTabbedPane1StateChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables

    private void callViewVehicleManage() {
        if(vehicleManage==null){
            vehicleManage=new VehicleManage();
            jPanel1.removeAll();
            jPanel1.add(vehicleManage,BorderLayout.CENTER);
            jPanel1.revalidate();
            jPanel1.repaint();
        }
    }

    private void callViewImportOrderManage() {
        if(importOrderManage==null){
            importOrderManage=new ImportOrderManage();
            jPanel2.removeAll();
            jPanel2.add(importOrderManage,BorderLayout.CENTER);
            jPanel2.revalidate();
            jPanel2.repaint();
        }
    }
}
