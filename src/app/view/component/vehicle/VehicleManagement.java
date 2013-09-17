/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.vehicle;

import app.model.Vehicle;
import app.service.VehicleService;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kiendv
 */
public class VehicleManagement extends javax.swing.JPanel {

    float itemsPerPage = 10;
    float total = 0;
    static int cur = 1;
    static boolean isSearch = false;
    VehicleService service;
    String kword = "";
    String sql = "exec pagingvehicles " + cur + "," + itemsPerPage;
    String getTotal = "";
    int from, to;

    /**
     * Creates new form VehicleManagement
     */
    public VehicleManagement() {
        initComponents();
        includeData();
    }

    public void includeData() {
        DefaultTableModel model = new DefaultTableModel();
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
        }
        if (cur == 0 || cur == -1) {
            cur = 1;
        }
        service = new VehicleService();
        if (isSearch) {
            try {
                total = service.executeQuery(getTotal).size();
            } catch (Exception ex) {
                total = 0;
            }
            String[] colName = {""};
            model.setColumnIdentifiers(new String[]{"ID", "Name", "Brand", "Price", "Model number", "Quantity"});
            List<Vehicle> lst = service.executeQuery(sql);
            if (model == null) {
                model = new DefaultTableModel();
            }
            if (cur > 1) {
                from = Math.round(itemsPerPage * (cur - 1));
                to = Math.round((cur * itemsPerPage));
            } else {
                from = 0;
                to = Math.round(itemsPerPage);
            }
            if (to >= total) {
                to = Math.round(total) - 1;
            }
            if (total < itemsPerPage) {
                from = 0;
                to = to = Math.round(total) - 1;
            }
            if (lst.size() < 2) {
                for (int i = 0; i < lst.size(); i++) {
                    model.addRow(new Object[]{lst.get(i).getId(), lst.get(i).getName(), lst.get(i).getBrand(), lst.get(i).getPrice(), lst.get(i).getModelNumber(), lst.get(i).getQuantity()});
                }
            } else {
                for (int i = from; i <= to; i++) {
                    model.addRow(new Object[]{lst.get(i).getId(), lst.get(i).getName(), lst.get(i).getBrand(), lst.get(i).getPrice(), lst.get(i).getModelNumber(), lst.get(i).getQuantity()});
                }
            }
            tableVehicle.setModel(model);
            paging();
        } else {
            total = service.getAll().size();
            String[] colName = {""};
            model.setColumnIdentifiers(new String[]{"ID", "Name", "Brand", "Price", "Model number", "Quantity"});
            List<Vehicle> lst = service.executeQuery(sql);
            if (model == null) {
                model = new DefaultTableModel();
            }
            for (int i = 0; i < lst.size(); i++) {
                model.addRow(new Object[]{lst.get(i).getId(), lst.get(i).getName(), lst.get(i).getBrand(), lst.get(i).getPrice(), lst.get(i).getModelNumber(), lst.get(i).getQuantity()});
            }
            tableVehicle.setModel(model);
            paging();
        }
    }

    public void paging() {
        if (isSearch) {
            comboVehicle.removeAllItems();
            comboVehicle.addItem("Go to page:");
            float pages = (total / itemsPerPage);
            for (int i = 0; i < pages; i++) {
                comboVehicle.addItem(i + 1);
            }
        } else {
            comboVehicle.removeAllItems();
            comboVehicle.addItem("Go to page:");
            float pages = (total / itemsPerPage);
            for (int i = 0; i < pages; i++) {
                comboVehicle.addItem(i + 1);
            }
        }
    }

    public boolean isNumeric(String str) {
        try {
            double d = Double.parseDouble(str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
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
        jPanel1 = new javax.swing.JPanel();
        lbCur = new javax.swing.JLabel();
        comboVehicle = new javax.swing.JComboBox();
        txtKeyword = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnPurchase = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

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
        jScrollPane1.setViewportView(tableVehicle);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 30));

        lbCur.setText(".");
        jPanel1.add(lbCur);

        comboVehicle.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboVehicle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboVehicleActionPerformed(evt);
            }
        });
        jPanel1.add(comboVehicle);

        txtKeyword.setPreferredSize(new java.awt.Dimension(59, 25));
        jPanel1.add(txtKeyword);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch);

        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew);

        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);

        btnDelete.setText("Delete");
        btnDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeleteActionPerformed(evt);
            }
        });
        jPanel1.add(btnDelete);

        btnPurchase.setText("Purchase");
        btnPurchase.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPurchaseActionPerformed(evt);
            }
        });
        jPanel1.add(btnPurchase);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void comboVehicleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboVehicleActionPerformed
        if (!isSearch) {
            String s = "";
            try {
                s = comboVehicle.getSelectedItem().toString();
                cur = Integer.parseInt(s);
                comboVehicle.removeItem(comboVehicle.getSelectedItem());
            } catch (Exception ex) {
                cur = 1;
            }
            lbCur.setText(cur + "");
            sql = "exec pagingvehicles " + cur + "," + itemsPerPage;
            includeData();
        } else {
            String s = "";
            try {
                s = comboVehicle.getSelectedItem().toString();
                cur = Integer.parseInt(s);
                comboVehicle.removeItem(comboVehicle.getSelectedItem());
            } catch (Exception ex) {
                cur = 1;
            }
            lbCur.setText(cur + "");
            String kw = txtKeyword.getText().trim();
            if (isNumeric(kw)) {
                sql = "exec searchvehicle '" + kw + "', " + cur + ", " + itemsPerPage + ", 1";
                getTotal = "exec searchvehicleall '" + kword + "', 1";
            } else {
                sql = "exec searchvehicle '" + kw + "', " + cur + ", " + itemsPerPage + ", 0";
                getTotal = "exec searchvehicleall '" + kword + "', 0";
            }
            includeData();
        }
    }//GEN-LAST:event_comboVehicleActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String kw = txtKeyword.getText().trim();
        if (kw == "" || kw.equals("") || kw == null || kw.length() < 1) {
            isSearch = false;
            sql = "exec pagingvehicles 1," + itemsPerPage;
            includeData();
        } else {
            isSearch = true;
            kword = kw;
            cur = 1;
            if (isNumeric(kw)) {
                sql = "exec searchvehicle '" + kw + "', " + cur + ", " + itemsPerPage + ", 1";
                getTotal = "exec searchvehicleall '" + kword + "', 1";
            } else {
                sql = "exec searchvehicle '" + kw + "', " + cur + ", " + itemsPerPage + ", 0";
                getTotal = "exec searchvehicleall '" + kword + "', 0";
            }
            includeData();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int row = tableVehicle.getSelectedRow();
            int id = Integer.parseInt(tableVehicle.getValueAt(row, 0).toString());
            String name = tableVehicle.getValueAt(row, 1).toString();
            int x = JOptionPane.showConfirmDialog(tableVehicle, "Do you want to delete: " + name + " (" + id + ")");
            if (x == 0) {
                Vehicle c = new Vehicle();
                c.setId(id);
                c.setName(name);
                boolean r = service.delete(c);
                if (r) {
                    JOptionPane.showMessageDialog(tableVehicle, "Removed: " + name + " (" + id + "), click refresh.");
                } else {
                    JOptionPane.showMessageDialog(tableVehicle, "Error, cannot delete " + name, "Error", JOptionPane.ERROR_MESSAGE);
                }
                reload();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tableVehicle, "Please choose item to delete");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        VehicleCreateNew newv = new VehicleCreateNew(null, false);
        newv.show();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnPurchaseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPurchaseActionPerformed
        try{    
        int row = tableVehicle.getSelectedRow();
            String id = tableVehicle.getValueAt(row, 0).toString();
            Purchase p = new Purchase(null, true);
            p.showme(id);
        }catch(Exception ex){
            
        }
    }//GEN-LAST:event_btnPurchaseActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
       reload();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        try{    
        int row = tableVehicle.getSelectedRow();
            String id = tableVehicle.getValueAt(row, 0).toString();
            String name = tableVehicle.getValueAt(row, 1).toString();
            String brand = tableVehicle.getValueAt(row, 2).toString();
            String price = tableVehicle.getValueAt(row, 3).toString();
            String model = tableVehicle.getValueAt(row, 4).toString();
            String quantity = tableVehicle.getValueAt(row, 5).toString();
            VehicleEdit vh = new VehicleEdit(null, isSearch);
            vh.showme(id, name, brand, price, model, quantity);
        }catch(Exception ex){
            
        }
    }//GEN-LAST:event_btnEditActionPerformed
    public void reload() {
        isSearch = false;
        String s = "";
        try {
            s = comboVehicle.getSelectedItem().toString();
            cur = Integer.parseInt(s);
            comboVehicle.removeItem(comboVehicle.getSelectedItem());
        } catch (Exception ex) {
            cur = 1;
        }
        lbCur.setText(cur + "");
        sql = "exec pagingvehicles " + cur + "," + itemsPerPage;
        includeData();
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnPurchase;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox comboVehicle;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCur;
    private javax.swing.JTable tableVehicle;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}
