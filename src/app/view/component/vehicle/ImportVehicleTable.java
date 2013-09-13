/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.vehicle;

import app.listener.IImportVehicleContent;
import app.listener.IImportVehicleListener;
import app.model.Vehicle;
import app.service.ImportOrderService;
import app.service.VehicleService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kiendv
 */
public class ImportVehicleTable extends javax.swing.JPanel {

    private IImportVehicleContent listener;
    VehicleService vehicleService;
    private int getall = 0;
    private int p=15;
    int cur = 1;
    int from = 0;

    public void setListener(IImportVehicleContent listener) {
        this.listener = listener;
    }

    /**
     * Creates new form ImportVehicleTable
     */
    public ImportVehicleTable() {
        initComponents();
        IncludeData();
        initcom();
    }
    
    public void IncludeData() {
        vehicleService = new VehicleService();
        int to = p*cur;
        String[] colName = {""};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Model", "Name", "Brand", "Price", "Quantity"});
        List<Vehicle> lst = vehicleService.search("", "", 0);
        if(to>lst.size()){
            to = lst.size()-1;
        }
        for (int i=from; i<=to; i++) {
            model.addRow(new Object[]{lst.get(i).getId(), lst.get(i).getModelNumber(), lst.get(i).getName(), lst.get(i).getBrand(), lst.get(i).getPrice(), lst.get(i).getQuantity()});
        }
        cbPage.removeAllItems();
        int page  = lst.size()/p;
        for(int i=0; i<=page; i++){
            cbPage.addItem(i+1);
        }
        tableVehicle.setModel(model);
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
        tableVehicle = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnPurchase = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        lbName = new javax.swing.JLabel();
        lbBrand = new javax.swing.JLabel();
        lbPrice = new javax.swing.JLabel();
        lbModel = new javax.swing.JLabel();
        lbQuantity = new javax.swing.JLabel();
        btnEdit = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        lbID = new javax.swing.JLabel();
        txtID = new javax.swing.JTextField();
        txtName = new javax.swing.JTextField();
        txtBrand = new javax.swing.JTextField();
        txtPrice = new javax.swing.JTextField();
        txtModel = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        btnHomeVehicle = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        lbRowVehicle = new javax.swing.JLabel();
        emodel = new javax.swing.JLabel();
        eName = new javax.swing.JLabel();
        eBrand = new javax.swing.JLabel();
        ePrice = new javax.swing.JLabel();
        eQuantity = new javax.swing.JLabel();
        lbResult = new javax.swing.JLabel();
        btnDelete = new javax.swing.JButton();
        panelSearch = new javax.swing.JPanel();
        txtKeyword = new javax.swing.JTextField();
        comboType = new javax.swing.JComboBox();
        btnsearch = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        cbPage = new javax.swing.JComboBox();

        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });

        tableVehicle.setModel(new javax.swing.table.DefaultTableModel(
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
        tableVehicle.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableVehicleMouseClicked(evt);
            }
        });
        tableVehicle.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tableVehicleFocusGained(evt);
            }
        });
        jScrollPane1.setViewportView(tableVehicle);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 102, 102));
        jLabel1.setText("VEHICLE MANAGEMENT");

        btnPurchase.setText("Pucharse");
        btnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseActionPerformed(evt);
            }
        });

        jLabel2.setText("Name");

        jLabel3.setText("Brand");

        jLabel4.setText("Price");

        jLabel5.setText("Model");

        jLabel6.setText("Quantity");

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        jLabel7.setText("ID");

        txtID.setEditable(false);

        btnHomeVehicle.setText("Vehicle Home");
        btnHomeVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHomeVehicleActionPerformed(evt);
            }
        });

        jLabel8.setText("Row");

        lbRowVehicle.setText("...");

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
        lbResult.setForeground(new java.awt.Color(0, 153, 153));
        lbResult.setText("...");

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });

        comboType.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "ID", "Name", "Brand", "ModelNumber", "Price", "Quantity" }));

        btnsearch.setText("Search");
        btnsearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsearchActionPerformed(evt);
            }
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelSearchLayout = new javax.swing.GroupLayout(panelSearch);
        panelSearch.setLayout(panelSearchLayout);
        panelSearchLayout.setHorizontalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnsearch)
                .addGap(18, 18, 18)
                .addComponent(btnRefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelSearchLayout.setVerticalGroup(
            panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelSearchLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelSearchLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtKeyword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboType, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnsearch)
                    .addComponent(btnRefresh))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel9.setText("Go To Page");

        cbPage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbPageMouseClicked(evt);
            }
        });
        cbPage.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbPageItemStateChanged(evt);
            }
        });
        cbPage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbPageActionPerformed(evt);
            }
        });
        cbPage.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                cbPagePropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1)
                                .addComponent(panelSearch, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(101, 101, 101))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbResult)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtID, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtName, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtBrand, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtModel, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(txtQuantity, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(btnPurchase)
                            .addGap(35, 35, 35)
                            .addComponent(btnEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnDelete)
                            .addGap(9, 9, 9)))
                    .addComponent(lbRowVehicle)
                    .addComponent(emodel)
                    .addComponent(eName)
                    .addComponent(eBrand)
                    .addComponent(ePrice)
                    .addComponent(eQuantity))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbPrice)
                    .addComponent(lbModel)
                    .addComponent(lbQuantity)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbID))
                    .addComponent(lbBrand)))
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnHomeVehicle)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnHomeVehicle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lbResult))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(7, 7, 7)
                        .addComponent(eName)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtBrand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(eBrand)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ePrice)
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtModel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(emodel)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eQuantity)
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(lbRowVehicle))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnEdit)
                            .addComponent(btnPurchase)
                            .addComponent(btnDelete)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(panelSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbPage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(7, 7, 7))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbName)
                    .addComponent(lbID))
                .addGap(27, 27, 27)
                .addComponent(lbBrand)
                .addGap(44, 44, 44)
                .addComponent(lbPrice)
                .addGap(50, 50, 50)
                .addComponent(lbModel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbQuantity)
                .addGap(102, 102, 102))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tableVehicleFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tableVehicleFocusGained
    }//GEN-LAST:event_tableVehicleFocusGained

    private void tableVehicleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableVehicleMouseClicked
        int row = tableVehicle.getSelectedRow();
        txtID.setText(tableVehicle.getValueAt(row, 0).toString());
        txtName.setText(tableVehicle.getValueAt(row, 2).toString());
        txtBrand.setText(tableVehicle.getValueAt(row, 3).toString());
        txtModel.setText(tableVehicle.getValueAt(row, 1).toString());
        txtPrice.setText(tableVehicle.getValueAt(row, 4).toString());
        txtQuantity.setText(tableVehicle.getValueAt(row, 5).toString());
        lbRowVehicle.setText(row + "");
    }//GEN-LAST:event_tableVehicleMouseClicked

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        if (txtID.getText() == null || txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(tableVehicle, "Select a vehicle to Purchase!");
        } else {
            Purchase p = new Purchase(null, true);
            p.showme(txtID.getText());
            reset();
        }
    }//GEN-LAST:event_btnPurchaseActionPerformed
    public void reset() {
        IncludeData();
        int row = Integer.parseInt(lbRowVehicle.getText());
        txtID.setText(tableVehicle.getValueAt(row, 0).toString());
        txtName.setText(tableVehicle.getValueAt(row, 2).toString());
        txtBrand.setText(tableVehicle.getValueAt(row, 3).toString());
        txtModel.setText(tableVehicle.getValueAt(row, 1).toString());
        txtPrice.setText(tableVehicle.getValueAt(row, 4).toString());
        txtQuantity.setText(tableVehicle.getValueAt(row, 5).toString());
    }
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
//        cur = 1;
//        from = 0;
//        IncludeData();
    }//GEN-LAST:event_formMouseClicked

    private void btnHomeVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHomeVehicleActionPerformed
        listener.viewImportVehicleMenu();
    }//GEN-LAST:event_btnHomeVehicleActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(tableVehicle, "Have not a vehicle to edit.");
        } else {
            int x = JOptionPane.showConfirmDialog(txtModel, "Do you want to update this vehicle ID: " + txtID.getText() + " (" + txtName.getText() + ") ?");
            if (x == 0) {
                if (valid()) {
                    int r = new VehicleService().update(txtName.getText(), txtBrand.getText(), txtModel.getText(), txtPrice.getText(), txtQuantity.getText(), txtID.getText());
                    if (r <= 0) {
                        JOptionPane.showMessageDialog(tableVehicle, "Error, cannot edit this vehicle at this time.");
                    } else {
                        reset();
                        lbResult.setText("Changed ID: " + txtID.getText() + " to: " + txtName.getText());
                    }
                }
            }
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        String id = txtID.getText();
        String name = txtName.getText();
        if (txtID.getText().equals("")) {
            JOptionPane.showMessageDialog(tableVehicle, "Have not a vehicle to edit.");
        } else {
            int y = JOptionPane.showConfirmDialog(txtModel, "Do you want to DELETE ID: " + txtID.getText() + " (" + txtName.getText() + ") ?");
            if (y == 0) {
            int x = new VehicleService().remove(txtID.getText());
            if(x<=0){
                JOptionPane.showMessageDialog(emodel, "Error, cannot delete ID: "+id+" ("+name+")");
                lbResult.setText("");
            }else{
                lbResult.setText("Deleted ID: "+id+" ("+name+")");
            }
            }
        }
        reset();
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnsearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsearchActionPerformed
        getall = 1;
        cur = 1;
        from = 0;
        paging();
    }//GEN-LAST:event_btnsearchActionPerformed
    public void paging(){
        getall = 1;
        if(getall!=0){
        int from = (cur-1)*p;
        int to = cur*p;
        String keyword = txtKeyword.getText().replace("'", "''");
        String cbtype = comboType.getSelectedItem().toString();
        vehicleService = new VehicleService();
        String[] colName = {""};
        DefaultTableModel model = new DefaultTableModel();
        model.setColumnIdentifiers(new String[]{"ID", "Model", "Name", "Brand", "Price", "Quantity"});
        List<Vehicle> lst = vehicleService.search(keyword, cbtype, getall);
        if(to>lst.size()){
            to = lst.size();
        }
        for (int i=from; i<to; i++) {
            model.addRow(new Object[]{lst.get(i).getId(), lst.get(i).getModelNumber(), lst.get(i).getName(), lst.get(i).getBrand(), lst.get(i).getPrice(), lst.get(i).getQuantity()});
        }
        cbPage.removeAllItems();
        int page  = lst.size()/p;
        for(int i=0; i<=page; i++){
            cbPage.addItem(i+1);
        }
        tableVehicle.setModel(model);
        }
    }
    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        getall = 0;
        cur = 1;
        from = 0;
        cbPage.removeAllItems();
        IncludeData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void cbPageItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbPageItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPageItemStateChanged

    private void cbPagePropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_cbPagePropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_cbPagePropertyChange

    private void cbPageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbPageMouseClicked
         
    }//GEN-LAST:event_cbPageMouseClicked

    private void cbPageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbPageActionPerformed
        // TODO add your handling code here:
        if(getall==0){try{
        cur = Integer.parseInt(cbPage.getSelectedItem().toString());
        from = (cur-1)*p;
        IncludeData();
        }catch(Exception ex){
            cbPage.removeAllItems();
        }
        }
        if(getall==1){try{
        cur = Integer.parseInt(cbPage.getSelectedItem().toString());
        paging();
        }catch(Exception ex){
            cbPage.removeAllItems();
        }
        }
    }//GEN-LAST:event_cbPageActionPerformed
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
        if (txtQuantity.getText().equals("")) {
            eQuantity.setText("Quantity Invalid");
            flag = false;
        }
        if (txtPrice.getText().equals("")) {
            ePrice.setText("Price invalid");
            flag = false;
        }
        if (txtModel.getText().equals("")) {
            emodel.setText("Model invalid");
            flag = false;
        }

        return flag;
    }

    public void initcom() {
        lbRowVehicle.setText("");
        lbResult.setText("");
        eName.setText("");
        eBrand.setText("");
        emodel.setText("");
        ePrice.setText("");
        eQuantity.setText("");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnHomeVehicle;
    private javax.swing.JButton btnPurchase;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnsearch;
    private javax.swing.JComboBox cbPage;
    private javax.swing.JComboBox comboType;
    private javax.swing.JLabel eBrand;
    private javax.swing.JLabel eName;
    private javax.swing.JLabel ePrice;
    private javax.swing.JLabel eQuantity;
    private javax.swing.JLabel emodel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbBrand;
    private javax.swing.JLabel lbID;
    private javax.swing.JLabel lbModel;
    private javax.swing.JLabel lbName;
    private javax.swing.JLabel lbPrice;
    private javax.swing.JLabel lbQuantity;
    private javax.swing.JLabel lbResult;
    private javax.swing.JLabel lbRowVehicle;
    private javax.swing.JPanel panelSearch;
    private javax.swing.JTable tableVehicle;
    private javax.swing.JTextField txtBrand;
    private javax.swing.JTextField txtID;
    private javax.swing.JTextField txtKeyword;
    private javax.swing.JTextField txtModel;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    // End of variables declaration//GEN-END:variables
}