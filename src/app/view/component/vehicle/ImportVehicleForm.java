/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.vehicle;

import app.model.Vehicle;
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
    private boolean isEdit = false;
    private Vehicle model;
    private ActionListener saveListener;

    public void setCreateListener(ActionListener createListener) {
        this.saveListener = createListener;
    }

    public Vehicle getModel() {
        return model;
    }

    public void setModel(Vehicle model) {
        this.model = model;
        txtName.setText(model.getName());
        cbbBrand.setSelectedItem(model.getBrand());
        cbbCategory.setSelectedItem(model.getCategory());
        txtPrice.setText(model.getPrice().toString());
        txtModel.setText(model.getModelNumber());
    }

    /**
     * Creates new form ImportVehicle
     */
    public ImportVehicleForm() {
        initComponents();
        vehicleService = VehicleService.getInstance();
        initCbb();
    }

    private void initCbb() {
        cbbBrand.removeAllItems();
        List<String> brands = vehicleService.getListBrandName();
        for (String brand : brands) {
            cbbBrand.addItem(brand);
        }
        cbbBrand.revalidate();
        cbbBrand.repaint();

        cbbCategory.removeAllItems();
        List<String> categorys = vehicleService.getListCategoryName();
        for (String category : categorys) {
            cbbCategory.addItem(category);
        }
    }

    public boolean valid() {
        boolean flag = true;
        if (txtName.getText().length() < 4) {
            eName.setText("Name invalid, min: 4 chars, max: 255 chars");
            flag = false;
        }
        String brand = (String) cbbBrand.getSelectedItem();
        if (brand.length() < 3) {
            eBrand.setText("Brand invalid, min: 3 chars, max: 255 chars");
            flag = false;
        }
        String category = (String) cbbCategory.getSelectedItem();
        if (brand.length() < 3) {
            eCategory.setText("Brand invalid, min: 3 chars, max: 255 chars");
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
            emodel.setText("Model is required");
            flag = false;
        }
        if (!(isEdit && (model.getModelNumber() != null && model.getModelNumber() != "" && model.getModelNumber().equals(txtModel.getText())))) {
            List<Vehicle> lst = vehicleService.executeQuery(vehicleService.getByModelNumberQueryNew(txtModel.getText()));
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
        txtPrice = new javax.swing.JTextField();
        btnCreate = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        emodel = new javax.swing.JLabel();
        eName = new javax.swing.JLabel();
        eBrand = new javax.swing.JLabel();
        ePrice = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        eCategory = new javax.swing.JLabel();
        cbbBrand = new javax.swing.JComboBox();
        cbbCategory = new javax.swing.JComboBox();

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

        btnCreate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/view/resource/accept.png"))); // NOI18N
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

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/view/resource/page_refresh.png"))); // NOI18N
        jButton1.setText("Reset");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Category :");

        cbbBrand.setEditable(true);

        cbbCategory.setEditable(true);

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
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel1)
                            .addComponent(jLabel5)
                            .addComponent(btnCreate))
                        .addGap(83, 83, 83)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1)
                            .addComponent(ePrice, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(eCategory, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtModel)
                                .addComponent(txtName)
                                .addComponent(eBrand, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(emodel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(eName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbBrand, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(34, Short.MAX_VALUE))
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
                    .addComponent(cbbBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(2, 2, 2)
                .addComponent(eBrand)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(cbbCategory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(eCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ePrice)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(btnCreate))
                .addContainerGap(28, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtModelFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtModelFocusLost
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModelFocusLost

    private void btnCreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCreateActionPerformed
        if (valid()) {
            loadDataToModel();
            if (isEdit) {
                if (vehicleService.update(model)) {
                    JOptionPane.showMessageDialog(emodel, "Update Vehicle Success.");
                } else {
                    JOptionPane.showMessageDialog(emodel, "Error, cannot save vehicle: " + txtName.getText());
                }
            } else {
                int x = vehicleService.add(model);
                if (x > 0) {
                    JOptionPane.showMessageDialog(emodel, "Create new Vehicle Success.");
                } else {
                    JOptionPane.showMessageDialog(null, "Error, cannot create vehicle");
                }
            }
            if (saveListener != null) {
                saveListener.actionPerformed(evt);
            }
        }
    }//GEN-LAST:event_btnCreateActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        clearForm();
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCreate;
    private javax.swing.JComboBox cbbBrand;
    private javax.swing.JComboBox cbbCategory;
    private javax.swing.JLabel eBrand;
    private javax.swing.JLabel eCategory;
    private javax.swing.JLabel eName;
    private javax.swing.JLabel ePrice;
    private javax.swing.JLabel emodel;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
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
            v.setCategory("");
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
        model.setBrand((String) cbbBrand.getSelectedItem());
        model.setCategory((String) cbbCategory.getSelectedItem());
        model.setModelNumber(txtModel.getText());
        model.setName(txtName.getText());
        model.setPrice(Integer.parseInt(txtPrice.getText()));
    }
}
