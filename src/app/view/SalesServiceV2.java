/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view;

import app.service.OrderService;
import app.service.VehicleService;
import app.view.component.report.DealerReport;
import app.view.composite.SalesOrder;
import app.view.composite.SalesVehicle;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class SalesServiceV2 extends javax.swing.JPanel {

    private VehicleService vehicleService;
    private OrderService orderService;
    private JPanel activePanel;
    private SalesVehicle salesVehicle;
    private SalesOrder salesOrder;
    private DealerReport report;

    /**
     * Creates new form SalesServiceV2
     */
    public SalesServiceV2() {
        initComponents();
        showVehicleView();
        salesVehicle.viewTableVehicle();
    }

    public void showVehicleView() {
        if (salesVehicle == null) {
            salesVehicle = new SalesVehicle();
        }
        activePanel = salesVehicle;
        mainpanel.removeAll();
        mainpanel.add(salesVehicle);
        mainpanel.revalidate();
        mainpanel.repaint();
    }

    public void showInvoiceView() {
        if (salesOrder == null) {
            salesOrder = new SalesOrder();
        }
        activePanel = salesOrder;
        mainpanel.removeAll();
        mainpanel.add(salesOrder);
        mainpanel.revalidate();
        mainpanel.repaint();
    }

    public void showDealerReportView() {
        if (report == null) {
            report = new DealerReport();
        }
        report.setModel(Main.activeUser);
        activePanel = report;
        mainpanel.removeAll();
        mainpanel.add(report);
        mainpanel.revalidate();
        mainpanel.repaint();
    }

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

        mainpanel = new javax.swing.JPanel();
        lbTitle = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        btnVehicle2 = new javax.swing.JButton();
        btnOrders = new javax.swing.JButton();
        btnCustomer = new javax.swing.JButton();
        btnCustomer1 = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        mainpanel.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        mainpanel.setLayout(new java.awt.BorderLayout());

        lbTitle.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbTitle.setForeground(new java.awt.Color(0, 102, 0));
        lbTitle.setText("Vehicle Showroom Management");
        mainpanel.add(lbTitle, java.awt.BorderLayout.PAGE_START);

        add(mainpanel, java.awt.BorderLayout.CENTER);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        btnVehicle2.setText("Vehicles");
        btnVehicle2.setPreferredSize(new java.awt.Dimension(100, 40));
        btnVehicle2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVehicle2ActionPerformed(evt);
            }
        });

        btnOrders.setText("Orders");
        btnOrders.setPreferredSize(new java.awt.Dimension(100, 40));
        btnOrders.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrdersActionPerformed(evt);
            }
        });

        btnCustomer.setText("Customers");
        btnCustomer.setPreferredSize(new java.awt.Dimension(100, 40));
        btnCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomerActionPerformed(evt);
            }
        });

        btnCustomer1.setText("Report");
        btnCustomer1.setPreferredSize(new java.awt.Dimension(100, 40));
        btnCustomer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCustomer1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnVehicle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCustomer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnVehicle2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnOrders, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnCustomer1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        add(jPanel3, java.awt.BorderLayout.LINE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void btnVehicle2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVehicle2ActionPerformed
        if (activePanel instanceof SalesVehicle) {
            salesVehicle.viewTableVehicle();
        } else {
            showVehicleView();
            salesVehicle.viewTableVehicle();
        }
    }//GEN-LAST:event_btnVehicle2ActionPerformed

    private void btnOrdersActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrdersActionPerformed
        // TODO add your handling code here:
        showInvoiceView();
    }//GEN-LAST:event_btnOrdersActionPerformed

    private void btnCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomerActionPerformed
        // TODO add your handling code here:
        if (activePanel instanceof SalesVehicle) {
            salesVehicle.viewTableCustomer();
        } else {
            showVehicleView();
            salesVehicle.viewTableCustomer();
        }
    }//GEN-LAST:event_btnCustomerActionPerformed

    private void btnCustomer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCustomer1ActionPerformed
        // TODO add your handling code here:
        showDealerReportView();
    }//GEN-LAST:event_btnCustomer1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCustomer;
    private javax.swing.JButton btnCustomer1;
    private javax.swing.JButton btnOrders;
    private javax.swing.JButton btnVehicle;
    private javax.swing.JButton btnVehicle1;
    private javax.swing.JButton btnVehicle2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel lbTitle;
    private javax.swing.JPanel mainpanel;
    // End of variables declaration//GEN-END:variables
}
