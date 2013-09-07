/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.vehicle;

import app.listener.IImportVehicleListener;
import app.model.Vehicle;
import app.service.VehicleService;
import app.service.VehicleService;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kiendv
 */
public class ImportVehicleForm extends javax.swing.JPanel {

    private VehicleService vehicleService;
    private IImportVehicleListener listener;

    public void setListener(IImportVehicleListener listener) {
        this.listener = listener;
    }

    /**
     * Creates new form ImportVehicle
     */
    public ImportVehicleForm() {
        initComponents();
        vehicleService = new VehicleService();
        initcom();
        lbResult.setText("");
    }
    public boolean valid(){
        boolean flag = true;
        if(txtName.getText().length()<4){
            eName.setText("Name invalid, min: 4 chars, max: 255 chars");
            flag = false;
        }
        if(txtBrand.getText().length()<3){
            eBrand.setText("Brand invalid, min: 3 chars, max: 255 chars");
            flag = false;
        }
        if(txtQuantity.getText().equals("")){
            eQuantity.setText("Quantity Invalid");
            flag = false;
        }
        if(txtPrice.getText().equals("")){
            ePrice.setText("Price invalid");
            flag = false;
        }
        if(txtModel.getText().equals("")){
            emodel.setText("Model invalid");
            flag = false;
        }
        
        return flag;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtModel = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtBrand = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtQuantity = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        btnVieAll = new javax.swing.JButton();
        btnMenu = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        emodel = new javax.swing.JLabel();
        eName = new javax.swing.JLabel();
        eBrand = new javax.swing.JLabel();
        ePrice = new javax.swing.JLabel();
        eQuantity = new javax.swing.JLabel();
        lbResult = new javax.swing.JLabel();

        jLabel2.setText("Model Number :");

        jLabel3.setText("Name :");

        jLabel4.setText("Brand :");

        jLabel5.setText("Price :");

        txtModel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtModelFocusLost(evt);
            }
        });

        jLabel6.setText("Quantity :");

        btnCreate.setText("Create new vehicle");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
            }
        });

        btnVieAll.setText("View all");
        btnVieAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVieAllActionPerformed(evt);
            }
        });

        btnMenu.setText("Menu");
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(102, 0, 0));
        jLabel7.setText("CREATE NEW  VEHICLE");

        emodel.setForeground(new java.awt.Color(255, 0, 0));
        emodel.setText(".");

        eName.setForeground(new java.awt.Color(255, 0, 0));
        eName.setText(".");

        eBrand.setForeground(new java.awt.Color(255, 0, 0));
        eBrand.setText(".");

        ePrice.setForeground(new java.awt.Color(255, 0, 0));
        ePrice.setText(".");

        eQuantity.setForeground(new java.awt.Color(255, 0, 0));
        eQuantity.setText(".");

        lbResult.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbResult.setForeground(new java.awt.Color(0, 153, 51));
        lbResult.setText(".");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel7))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4))
                            .addGap(88, 88, 88)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(emodel)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtBrand, javax.swing.GroupLayout.DEFAULT_SIZE, 218, Short.MAX_VALUE)
                                    .addComponent(txtName)
                                    .addComponent(txtModel))
                                .addComponent(eName)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eQuantity)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lbResult)
                            .addComponent(jLabel6)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnCreate)
                        .addGap(125, 125, 125)
                        .addComponent(btnVieAll)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnMenu))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(eBrand)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ePrice))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel7)
                .addGap(23, 23, 23)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(txtQuantity, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(eQuantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(lbResult)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCreate)
                    .addComponent(btnVieAll)
                    .addComponent(btnMenu))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtModelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtModelFocusLost
        // TODO add your handling code here:
        
    }//GEN-LAST:event_txtModelFocusLost

    public void initcom(){
        eName.setText("");
        eBrand.setText("");
        emodel.setText("");
        ePrice.setText("");
        eQuantity.setText("");
    }
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (valid()) {
            btnCreate.setText("Creating");
            int x = vehicleService.create(txtName.getText(), txtBrand.getText(), txtPrice.getText(), txtModel.getText(), txtQuantity.getText());
            if(x>0){
            lbResult.setText("Created Vehicle: "+txtName.getText());
            initcom();
            }
            else if(x==0){
            JOptionPane.showMessageDialog(emodel, "Existed this vehicle with Model, Name, Brand similar: ");
            initcom();
            lbResult.setText("");
            }
            else{
                JOptionPane.showMessageDialog(emodel, "Error, cannot create vehicle: "+txtName.getText());
                lbResult.setText("");
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void btnVieAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVieAllActionPerformed
        // TODO add your handling code here:
        if (listener != null) {
            listener.viewImportVehicleTable();
        }
    }//GEN-LAST:event_btnVieAllActionPerformed

    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        // TODO add your handling code here:
        listener.viewImportVehicleMenu();
    }//GEN-LAST:event_btnMenuActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JButton btnMenu;
    private javax.swing.JButton btnVieAll;
    private javax.swing.JLabel eBrand;
    private javax.swing.JLabel eName;
    private javax.swing.JLabel ePrice;
    private javax.swing.JLabel eQuantity;
    private javax.swing.JLabel emodel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbResult;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}
