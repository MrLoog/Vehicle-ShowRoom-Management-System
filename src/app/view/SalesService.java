/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

import app.listener.IMainFrame;
import app.listener.ISalesService;
import app.service.OrderService;
import app.service.VehicleService;
import app.view.component.invoice.ImportOrderPlusContent;
import app.view.component.vehicle.ImportVehicleContent;
import app.view.composite.SalesVehicle;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class SalesService extends javax.swing.JPanel implements ISalesService {

    private VehicleService vehicleService;
    private OrderService orderService;
    private IMainFrame listener;
    private JPanel activePanel;
    private SalesVehicle salesVehicle;

    public void setListener(IMainFrame listener) {
        this.listener = listener;
    }

    /**
     * Creates new form SalesService
     */
    public SalesService() {
        initComponents();
        showVehicleView();
        salesVehicle.viewTableVehicle();
    }

    public void showVehicleView() {
        if (salesVehicle == null) {
            salesVehicle = new SalesVehicle();
        }
        activePanel = salesVehicle;
        jPanel2.removeAll();
        jPanel2.add(salesVehicle);
        jPanel2.revalidate();
        jPanel2.repaint();
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
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.GridLayout(4, 1));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Vehicle");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1);

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Customer");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Manage Order");
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Report");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3);

        add(jPanel1, java.awt.BorderLayout.WEST);

        jPanel2.setLayout(new java.awt.BorderLayout());
        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        // TODO add your handling code here:
        if (activePanel instanceof SalesVehicle) {
            salesVehicle.viewTableVehicle();
        } else {
            showVehicleView();
            salesVehicle.viewTableVehicle();
        }
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        // TODO add your handling code here:
        if (activePanel instanceof SalesVehicle) {
            salesVehicle.viewTableCustomer();
        } else {
            showVehicleView();
            salesVehicle.viewTableCustomer();
        }
    }//GEN-LAST:event_jLabel4MouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void BodyChanged() {
        this.revalidate();
        this.repaint();
    }
}
