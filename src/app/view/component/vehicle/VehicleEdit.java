/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.vehicle;

import app.model.Vehicle;
import app.service.VehicleService;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kiendv
 */
public class VehicleEdit extends javax.swing.JDialog {
private VehicleService vehicleService;
    /**
     * Creates new form VehicleEdit
     */
    public VehicleEdit(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        vehicleService = new VehicleService();
    }
    public void showme(String id, String name, String brand, String price, String model, String quantity){
        lbID.setText(id);
        txtName.setText(name);
        txtBrand.setText(brand);
        txtPrice.setText(price);
        txtModel.setText(model);
        this.show();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCancel = new javax.swing.JButton();
        eBrand = new javax.swing.JLabel();
        ePrice = new javax.swing.JLabel();
        emodel = new javax.swing.JLabel();
        eName = new javax.swing.JLabel();
        btnChange = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtPrice = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtBrand = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        lbResult = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnCancel.setText("Cancel");
        btnCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelActionPerformed(evt);
            }
        });

        eBrand.setForeground(new java.awt.Color(255, 0, 0));
        eBrand.setText(".");

        ePrice.setForeground(new java.awt.Color(255, 0, 0));
        ePrice.setText(".");

        emodel.setForeground(new java.awt.Color(255, 0, 0));
        emodel.setText(".");

        eName.setForeground(new java.awt.Color(255, 0, 0));
        eName.setText(".");

        btnChange.setText("Change");
        btnChange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChangeActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("EDIT  VEHICLE");

        jLabel2.setText("Model Number :");

        txtModel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtModelFocusLost(evt);
            }
        });

        jLabel5.setText("Price :");

        jLabel4.setText("Brand :");

        jLabel3.setText("Name :");

        jLabel1.setText("ID");

        lbID.setText(".");

        lbResult.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lbResult.setForeground(new java.awt.Color(0, 102, 102));
        lbResult.setText("...");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(88, 88, 88)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emodel)
                            .addComponent(eName)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtModel, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eBrand)
                            .addComponent(ePrice)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnChange)
                                .addGap(66, 66, 66)
                                .addComponent(btnCancel))
                            .addComponent(lbResult)))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(114, 114, 114)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbID)
                            .addComponent(jLabel7))))
                .addContainerGap(67, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel7)
                .addGap(17, 17, 17)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbID))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addComponent(emodel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addComponent(eName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addComponent(eBrand)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(12, 12, 12)
                .addComponent(ePrice)
                .addGap(45, 45, 45)
                .addComponent(lbResult)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnChange)
                    .addComponent(btnCancel))
                .addGap(52, 52, 52))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelActionPerformed
    public boolean valid() {
        boolean flag = true;
        if (txtName.getText().length() < 4) {
            eName.setText("Name invalid, min: 4 chars, max: 255 chars");
            flag = false;
        }
        if (txtBrand.getText().length() < 3) {
            eBrand.setText("Brand invalid, min: 3 chars, max: 255 chars");
            flag = false;
        }
        if (txtPrice.getText().equals("")) {
            ePrice.setText("Price invalid");
            flag = false;
        }
        try {
            Integer.parseInt(txtPrice.getText());
        } catch (NumberFormatException numberFormatException) {
            ePrice.setText("Price must is number.");
            flag = false;
        }
        if (txtModel.getText().equals("")) {
            emodel.setText("Model invalid");
            flag = false;
        }
        return flag;
    }
    private void btnChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChangeActionPerformed
        if (valid()) {
            btnChange.setText("Saving Data...");
            Vehicle v = new Vehicle();
            int id = Integer.parseInt(lbID.getText());
            String name = (txtName.getText());
            String brand = (txtBrand.getText());
            String price = ((txtPrice.getText()));
            String modelNumber = (txtModel.getText());
            String quantity = txtModel.getText();
            int r = vehicleService.update(name, brand, modelNumber, price, quantity, price);
                if (r>0) {
                    lbResult.setText("Save Vehicle Success");
                    reset();
                }
                else if(r==0){
                    JOptionPane.showMessageDialog(emodel, "Existed this vehicle with Model, Name, Brand similar: ");
                }
                else {
                    JOptionPane.showMessageDialog(emodel, "Error, cannot save vehicle: " + txtName.getText());
                    lbResult.setText("");
                }
            btnChange.setText("Save");
        }
    }//GEN-LAST:event_btnChangeActionPerformed
    public void reset() {
        eName.setText("");
        eBrand.setText("");
        emodel.setText("");
        ePrice.setText("");
    }
    private void txtModelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtModelFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VehicleEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VehicleEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VehicleEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VehicleEdit.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VehicleEdit dialog = new VehicleEdit(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancel;
    private javax.swing.JButton btnChange;
    private javax.swing.JLabel eBrand;
    private javax.swing.JLabel eName;
    private javax.swing.JLabel ePrice;
    private javax.swing.JLabel emodel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbResult;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables
}
