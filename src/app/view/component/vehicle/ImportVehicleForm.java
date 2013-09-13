/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.vehicle;

import app.listener.IImportOrderWithVehicle;
import app.listener.IImportVehicleContent;
import app.model.Vehicle;
import app.service.VehicleService;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author kiendv
 */
public class ImportVehicleForm extends javax.swing.JPanel {

    private VehicleService vehicleService;
    private IImportOrderWithVehicle listener;
    private boolean isEdit = false;
    private Vehicle model;

    public void setListener(IImportOrderWithVehicle listener) {
        this.listener = listener;
    }

    public Vehicle getModel() {
        return model;
    }

    public void setModel(Vehicle model) {
        this.model = model;
        txtName.setText(model.getName());
        txtBrand.setText(model.getBrand());
        txtPrice.setText(model.getPrice().toString());
        txtModel.setText(model.getModelNumber());
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
        if (!(isEdit && (model.getModelNumber() != null && model.getModelNumber() != "" && model.getModelNumber().equals(txtModel.getText())))) {
            List<Vehicle> lst = vehicleService.executeQuery(vehicleService.getByModelNumberQuery(txtModel.getText()));
            if (lst != null && lst.size() > 0) {
                emodel.setText("Model Number Exist");
                flag = false;
            }
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
        btnCreate = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        emodel = new javax.swing.JLabel();
        eName = new javax.swing.JLabel();
        eBrand = new javax.swing.JLabel();
        ePrice = new javax.swing.JLabel();
        lbResult = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(402, 400));

        jLabel2.setText("Model Number :");

        jLabel3.setText("Name :");

        jLabel4.setText("Brand :");

        jLabel5.setText("Price :");

        txtModel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtModelFocusLost(evt);
            }
        });

        btnCreate.setText("Save");
        btnCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCreateActionPerformed(evt);
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

        lbResult.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lbResult.setForeground(new java.awt.Color(0, 153, 51));
        lbResult.setText(".");

        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
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
                                .addComponent(txtModel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 182, Short.MAX_VALUE)
                                .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtBrand))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jLabel7))
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(lbResult, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnCreate))
                        .addGap(66, 66, 66)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(eBrand)
                            .addComponent(ePrice)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(65, Short.MAX_VALUE))
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(ePrice)
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCreate)
                            .addComponent(jButton1))
                        .addContainerGap(72, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lbResult)
                        .addGap(18, 18, 18))))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtModelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtModelFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelFocusLost

    public void initcom() {
        eName.setText("");
        eBrand.setText("");
        emodel.setText("");
        ePrice.setText("");
    }
    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (valid()) {
            btnCreate.setText("Saving Data...");
            if (isEdit) {
                loadDataToModel();
                if (vehicleService.update(model)) {
                    lbResult.setText("Save Vehicle Success");
                    initcom();
                    listener.reloadTableVehicle();
                } else {
                    JOptionPane.showMessageDialog(emodel, "Error, cannot save vehicle: " + txtName.getText());
                    lbResult.setText("");
                }
            } else {
                int x = vehicleService.create(txtName.getText(), txtBrand.getText(), txtPrice.getText(), txtModel.getText(), "0");
                if (x > 0) {
                    lbResult.setText("Created Vehicle: " + txtName.getText());
                    initcom();
                    listener.reloadTableVehicle();
                } else if (x == 0) {
                    JOptionPane.showMessageDialog(emodel, "Existed this vehicle with Model, Name, Brand similar: ");
                    initcom();
                    lbResult.setText("");
                } else {
                    JOptionPane.showMessageDialog(emodel, "Error, cannot create vehicle: " + txtName.getText());
                    lbResult.setText("");
                }
            }
            btnCreate.setText("Save");
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JLabel eBrand;
    private javax.swing.JLabel eName;
    private javax.swing.JLabel ePrice;
    private javax.swing.JLabel emodel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel lbResult;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    // End of variables declaration//GEN-END:variables

    public void setEditMode(boolean b) {
        isEdit = b;
    }

    public void clearForm() {
        if (isEdit) {
            setModel(model);
        } else {
            Vehicle v = new Vehicle();
            v.setBrand("");
            v.setName("");
            v.setPrice(0);
            v.setModelNumber("");
            setModel(v);
        }
    }

    private void loadDataToModel() {
        if (model == null) {
            model = new Vehicle();
        }
        model.setBrand(txtBrand.getText());
        model.setModelNumber(txtModel.getText());
        model.setName(txtName.getText());
        model.setPrice(Integer.parseInt(txtPrice.getText()));
    }
}