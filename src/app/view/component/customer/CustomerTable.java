/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.customer;

import app.model.Customer;
import javax.swing.table.DefaultTableModel;
import app.service.CustomerService;
import java.awt.TrayIcon;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicArrowButton;

/**
 *
 * @author kiendv
 */
public class CustomerTable extends javax.swing.JPanel {

    float itemsPerPage = 10;
    float total = 0;
    static int cur = 1;
    static boolean isSearch = false;
    CustomerService service;
    String kword = "";
    String sql = "exec pagingcustomers " + cur + "," + itemsPerPage;
    String getTotal = "";
    int from, to;

    /**
     * Creates new form CustomerTable
     */
    public CustomerTable() {
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
        service = new CustomerService();
        if (isSearch) {
            try {
                total = service.executeQuery(getTotal).size();
            } catch (Exception ex) {
                total = 0;
            }
            String[] colName = {""};
            model.setColumnIdentifiers(new String[]{"ID", "Name", "Address", "Phone"});
            List<Customer> lst = service.executeQuery(sql);
            if (model == null) {
                model = new DefaultTableModel();
            }
            if(cur>1){
            from = Math.round(itemsPerPage*(cur-1));
            to = Math.round((cur * itemsPerPage));
            }else{
                from = 0;
                to = Math.round(itemsPerPage);
            }
            if(to>=total){
                to=Math.round(total)-1;
            }
            if(total<itemsPerPage){
                from = 0;
                to = to=Math.round(total)-1;
            }
            if(lst.size()<2){
                for (int i = 0; i <lst.size(); i++) {
                model.addRow(new Object[]{lst.get(i).getId(), lst.get(i).getName(), lst.get(i).getAddress(), lst.get(i).getPhone()});
            }
            }
            else{
            for (int i = from; i <=to; i++) {
                model.addRow(new Object[]{lst.get(i).getId(), lst.get(i).getName(), lst.get(i).getAddress(), lst.get(i).getPhone()});
            }
            }
            tableCustomer.setModel(model);
            paging();
        } else {
            total = service.getAll().size();
            String[] colName = {""};
            model.setColumnIdentifiers(new String[]{"ID", "Name", "Address", "Phone"});
            List<Customer> lst = service.executeQuery(sql);
            if (model == null) {
                model = new DefaultTableModel();
            }
            for (int i = 0; i < lst.size(); i++) {
                model.addRow(new Object[]{lst.get(i).getId(), lst.get(i).getName(), lst.get(i).getAddress(), lst.get(i).getPhone()});
            }
            tableCustomer.setModel(model);
            paging();
        }
    }

    public void paging() {
        if (isSearch) {
            comboCustomer.removeAllItems();
            comboCustomer.addItem("Go to page:");
            float pages = (total / itemsPerPage);
            for (int i = 0; i < pages; i++) {
                comboCustomer.addItem(i + 1);
            }
        } else {
            comboCustomer.removeAllItems();
            comboCustomer.addItem("Go to page:");
            float pages = (total / itemsPerPage);
            for (int i = 0; i < pages; i++) {
                comboCustomer.addItem(i + 1);
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
        tableCustomer = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        lbCur = new javax.swing.JLabel();
        comboCustomer = new javax.swing.JComboBox();
        txtKeyword = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        btnOrdered = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        tableCustomer.setModel(new javax.swing.table.DefaultTableModel(
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
        tableCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCustomerMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableCustomer);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 35));

        lbCur.setText("1");
        jPanel1.add(lbCur);

        comboCustomer.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                comboCustomerMouseClicked(evt);
            }
        });
        comboCustomer.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                comboCustomerItemStateChanged(evt);
            }
        });
        comboCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCustomerActionPerformed(evt);
            }
        });
        comboCustomer.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                comboCustomerPropertyChange(evt);
            }
        });
        jPanel1.add(comboCustomer);

        txtKeyword.setText(" ");
        txtKeyword.setMinimumSize(new java.awt.Dimension(6, 80));
        txtKeyword.setPreferredSize(new java.awt.Dimension(80, 30));
        jPanel1.add(txtKeyword);

        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch);

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

        btnOrdered.setText("Ordered");
        btnOrdered.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnOrderedActionPerformed(evt);
            }
        });
        jPanel1.add(btnOrdered);

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh);

        btnNew.setText("Create New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void comboCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCustomerActionPerformed
        if (!isSearch) {
            String s = "";
            try {
                s = comboCustomer.getSelectedItem().toString();
                cur = Integer.parseInt(s);
                comboCustomer.removeItem(comboCustomer.getSelectedItem());
            } catch (Exception ex) {
                cur = 1;
            }
            lbCur.setText(cur + "");
            sql = "exec pagingcustomers " + cur + "," + itemsPerPage;
            includeData();
        } else {
            String s = "";
            try {
                s = comboCustomer.getSelectedItem().toString();
                cur = Integer.parseInt(s);
                comboCustomer.removeItem(comboCustomer.getSelectedItem());
            } catch (Exception ex) {
                cur = 1;
            }
            lbCur.setText(cur + "");
            String kw = txtKeyword.getText().trim();
            if (isNumeric(kw)) {
                sql = "exec searchcustomer '" + kw + "', " + cur + ", " + itemsPerPage + ", 1";
                getTotal = "exec searchcustomerall '" + kword + "', 1";
            } else {
                sql = "exec searchcustomer '" + kw + "', " + cur + ", " + itemsPerPage + ", 0";
                getTotal = "exec searchcustomerall '" + kword + "', 0";
            }
            includeData();
        }
    }//GEN-LAST:event_comboCustomerActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed

        try {
            Edit ed = new Edit(null, true);
            int row = tableCustomer.getSelectedRow();
            int id = Integer.parseInt(tableCustomer.getValueAt(row, 0).toString());
            ed.callme(id);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tableCustomer, "Please choose item to edit");
        }
    }//GEN-LAST:event_btnEditActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
    }//GEN-LAST:event_tableCustomerMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        isSearch = false;
        String s = "";
        try {
            s = comboCustomer.getSelectedItem().toString();
            cur = Integer.parseInt(s);
            comboCustomer.removeItem(comboCustomer.getSelectedItem());
        } catch (Exception ex) {
            cur = 1;
        }
        lbCur.setText(cur + "");
        sql = "exec pagingcustomers " + cur + "," + itemsPerPage;
        includeData();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void comboCustomerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboCustomerPropertyChange
    }//GEN-LAST:event_comboCustomerPropertyChange

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
        try {
            int row = tableCustomer.getSelectedRow();
            int id = Integer.parseInt(tableCustomer.getValueAt(row, 0).toString());
            String name = tableCustomer.getValueAt(row, 1).toString();
            int x = JOptionPane.showConfirmDialog(tableCustomer, "Do you want to delete: " + name + " (" + id + ")");
            if (x == 0) {
                Customer c = new Customer();
                c.setId(id);
                c.setName(name);
                boolean r = service.delete(c);
                if (r) {
                    JOptionPane.showMessageDialog(tableCustomer, "Removed: " + name + " (" + id + "), click refresh.");
                } else {
                    JOptionPane.showMessageDialog(tableCustomer, "Error, cannot delete " + name, "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(tableCustomer, "Please choose item to delete");
        }
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        String kw = txtKeyword.getText().trim();
        if(kw == "" ||kw.equals("")||kw==null||kw.length()<1) {
            isSearch = false;
            sql = "exec pagingcustomers 1," + itemsPerPage;
            includeData();
        } else {
            isSearch = true;
            kword = kw;
            cur = 1;
            if (isNumeric(kw)) {
                sql = "exec searchcustomer '" + kw + "', " + cur + ", " + itemsPerPage + ", 1";
                getTotal = "exec searchcustomerall '" + kword + "', 1";
            } else {
                sql = "exec searchcustomer '" + kw + "', " + cur + ", " + itemsPerPage + ", 0";
                getTotal = "exec searchcustomerall '" + kword + "', 0";
            }
            includeData();
        }
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        CreateCustomer newcustomer = new CreateCustomer(null, true);
        newcustomer.show();
    }//GEN-LAST:event_btnNewActionPerformed

    private void btnOrderedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnOrderedActionPerformed
        JOptionPane.showMessageDialog(tableCustomer, "Go to orders of this customer.");
    }//GEN-LAST:event_btnOrderedActionPerformed

    private void comboCustomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCustomerItemStateChanged
    }//GEN-LAST:event_comboCustomerItemStateChanged

    private void comboCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCustomerMouseClicked
    }//GEN-LAST:event_comboCustomerMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnOrdered;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox comboCustomer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCur;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables
}
