/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.invoice;

import app.model.Order;
import app.model.Vehicle;
import app.service.OrderService;
import app.service.VehicleService;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import sun.misc.Cache;

/**
 *
 * @author Administrator
 */
public class OrderUpdateStatus extends javax.swing.JPanel {

    private OrderService orderService;
    private VehicleService vehicleService;
    private ActionListener purchaseListener;
    private int newStatus = 0;

    public int getNewStatus() {
        return newStatus;
    }

    public void setPurchaseListener(ActionListener purchaseListener) {
        this.purchaseListener = purchaseListener;
    }
    private ActionListener cancelListener;

    public void setCancelListener(ActionListener cancelListener) {
        this.cancelListener = cancelListener;
    }

    /**
     * Creates new form OrderUpdateStatus
     */
    public OrderUpdateStatus() {
        initComponents();
        orderService = new OrderService();
        vehicleService = new VehicleService();
        jComboBox1.removeAllItems();
        jComboBox1.addItem(getStringOrderStatus(Order.STATUS_NEW));
        jComboBox1.addItem(getStringOrderStatus(Order.STATUS_CANCEL));
        jComboBox1.addItem(getStringOrderStatus(Order.STATUS_DONE));
        jComboBox1.revalidate();
        jComboBox1.repaint();
    }

    private String getStringOrderStatus(int status) {
        switch (status) {
            case Order.STATUS_NEW:
                return "New";
            case Order.STATUS_DONE:
                return "Done";
            case Order.STATUS_CANCEL:
                return "Cancel";
            default:
                return "New";
        }
    }

    private int getStatusFromString(String str) {
        if (str.equals(getStringOrderStatus(Order.STATUS_NEW))) {
            return Order.STATUS_NEW;
        } else if (str.equals(getStringOrderStatus(Order.STATUS_DONE))) {
            return Order.STATUS_DONE;
        } else if (str.equals(getStringOrderStatus(Order.STATUS_CANCEL))) {
            return Order.STATUS_CANCEL;
        }
        return Order.STATUS_NEW;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();

        jLabel1.setText("Name :");

        jLabel2.setText("No Info");

        jLabel3.setText("Phone :");

        jLabel4.setText("No Info");

        jLabel5.setText("Address :");

        jLabel6.setText("No Info");

        jLabel7.setText("Vehicle");

        jLabel8.setText("Name :");

        jLabel9.setText("No Info");

        jLabel10.setText("Customer");

        jLabel11.setText("Model :");

        jLabel12.setText("No Info");

        jLabel13.setText("Price :");

        jLabel14.setText("No Info");

        jLabel15.setText("Quantity :");

        jLabel16.setText("No Info");

        jLabel17.setText("Created :");

        jLabel18.setText("Modified :");

        jLabel19.setText("Status :");

        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel20.setText("No Info");

        jLabel21.setText("No Info");

        jLabel23.setText("Total :");

        jLabel24.setText("No Info");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addGap(33, 33, 33))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(45, 45, 45)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jLabel9))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel2)))))
                    .addComponent(jLabel10)
                    .addComponent(jButton1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel13)
                            .addComponent(jLabel15)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel17)
                            .addComponent(jLabel23))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel21, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel24, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(173, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(26, 26, 26)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel23)
                    .addComponent(jLabel24))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel17)
                    .addComponent(jLabel20))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        loadStatus();
        int choice = JOptionPane.showConfirmDialog(this, "Are you sure to update status order to " + getStringOrderStatus(newStatus) + " ?", "Confirm Update", JOptionPane.YES_NO_OPTION);
        if (choice == JOptionPane.YES_OPTION) {
            if (purchaseListener != null) {
                purchaseListener.actionPerformed(evt);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    // End of variables declaration//GEN-END:variables
    private Order model;

    public void setModel(Order o) {
        model = o;
        setDisplayData(model);
    }

    public Order getModel() {
        return model;
    }

    private void loadStatus() {
        newStatus = (getStatusFromString((String) jComboBox1.getSelectedItem()));
    }

    public void setDisplayData(Order o) {
        jLabel14.setText(o.getPrice() + "");
        jLabel16.setText(o.getQuantity() + "");
        jLabel20.setText(o.getCreated().toString());
        jLabel21.setText(o.getModified().toString());
        jComboBox1.setSelectedItem(getStringOrderStatus(o.getStatus()));
        jLabel24.setText((o.getQuantity() * o.getPrice()) + "");
//        else if (o.getStatus() == Order.STATUS_DONE) {
//            jButton1.setEnabled(false);
//            jButton2.setEnabled(true);
//        } else if (o.getStatus() == Order.STATUS_CANCEL) {
//            jButton1.setEnabled(true);
//            jButton2.setEnabled(false);
//        }
        if (o.getCustomer() != null) {
            jLabel2.setText(o.getCustomer().getName());
            jLabel4.setText(o.getCustomer().getPhone());
            jLabel6.setText(o.getCustomer().getAddress());
        } else {
            jLabel2.setText("No Info");
            jLabel4.setText("No Info");
            jLabel6.setText("No Info");
        }
        if (o.getVehicle() != null) {
            jLabel9.setText(o.getVehicle().getName());
            jLabel12.setText(o.getVehicle().getModelNumber());
        } else {
            jLabel9.setText("No Info");
            jLabel12.setText("No Info");
        }
    }
}
