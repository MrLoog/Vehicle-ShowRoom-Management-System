/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.customer;

import app.model.Customer;
import app.model.Dealer;
import javax.swing.table.DefaultTableModel;
import app.service.CustomerService;
import app.service.DealerService;
import app.view.Main;
import app.view.model.TableCustomerModel;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author kiendv
 */
public class CustomerTable extends javax.swing.JPanel {

    CustomerService customerService;
    DealerService dealerService;
    AtomicReference<Integer> totalpage = new AtomicReference<Integer>(0);
    int curpage = 1;
    String search = "";
    TableCustomerModel model = new TableCustomerModel();

    public void setTotalpage(Integer totalpage) {
        this.totalpage.set(totalpage);
        fillPage();
    }

    public void setCurpage(int curpage) {
        this.curpage = curpage;
        fillDataCustomer(curpage);
    }

    private void fillDataCustomer(int page) {
        String pagingsql = "";
        if (search.equals("")) {
            pagingsql = customerService.BuildPagingSql(customerService.getTableName(), null, Main.PerPage, page, totalpage);
        } else {
            pagingsql = customerService.BuildPagingSql(customerService.getTableName(), customerService.getConditionSearch(search), Main.PerPage, page, totalpage);
        }
        List<Customer> lst = customerService.executeQuery(pagingsql);
        for (Customer customer : lst) {
            customer.setDealer((Dealer) dealerService.getById(customer.getDealerId()));
        }
        model.setData(lst);
        tableCustomer.setModel(model);
        tableCustomer.revalidate();
        tableCustomer.repaint();
    }

    private int getTotalPage() {
        int temptotal = totalpage.get();
        int temp = temptotal % Main.PerPage;
        if (temp == 0) {
            return (temptotal / Main.PerPage);
        } else {
            return (temptotal / Main.PerPage) + 1;
        }
    }

    private void fillPage() {
        comboCustomer.removeAllItems();
        for (int i = 1; i <= getTotalPage(); i++) {
            comboCustomer.addItem(i);
        }
        comboCustomer.setSelectedItem(curpage);
        comboCustomer.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                Object temppage = comboCustomer.getSelectedItem();
                if (temppage != null) {
                    setCurpage((Integer) temppage);
                }
            }
        });
        comboCustomer.revalidate();
        comboCustomer.repaint();
    }

    /**
     * Creates new form CustomerTable
     */
    public CustomerTable() {
        initComponents();
        customerService = CustomerService.getInstance();
        dealerService = DealerService.getInstance();
        fillDataCustomer(1);
        fillPage();
    }

    public Customer getSelectedCustomer() {
        int index = tableCustomer.getSelectedRow();
        if (index == -1) {
            return null;
        } else {
            return ((TableCustomerModel) tableCustomer.getModel()).getData(index);
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
        comboCustomer = new javax.swing.JComboBox();
        txtKeyword = new javax.swing.JTextField();
        btnSearch = new javax.swing.JButton();
        btnNew = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

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

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 50));
        jPanel1.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

        comboCustomer.setPreferredSize(new java.awt.Dimension(28, 41));
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
        txtKeyword.setPreferredSize(new java.awt.Dimension(100, 41));
        jPanel1.add(txtKeyword);

        btnSearch.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/view/resource/find.png"))); // NOI18N
        btnSearch.setText("Search");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });
        jPanel1.add(btnSearch);

        btnNew.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/view/resource/add.png"))); // NOI18N
        btnNew.setText("New");
        btnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNewActionPerformed(evt);
            }
        });
        jPanel1.add(btnNew);

        btnEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/view/resource/edit.png"))); // NOI18N
        btnEdit.setText("Edit");
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });
        jPanel1.add(btnEdit);

        btnRefresh.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/view/resource/refresh.png"))); // NOI18N
        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });
        jPanel1.add(btnRefresh);

        add(jPanel1, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void comboCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCustomerActionPerformed
    }//GEN-LAST:event_comboCustomerActionPerformed

    private void tableCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCustomerMouseClicked
    }//GEN-LAST:event_tableCustomerMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        refresh();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void comboCustomerPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_comboCustomerPropertyChange
    }//GEN-LAST:event_comboCustomerPropertyChange

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        search = txtKeyword.getText();
        fillDataCustomer(1);
        fillPage();
    }//GEN-LAST:event_btnSearchActionPerformed

    private void btnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNewActionPerformed
        final DialogCustomerForm dialog = new DialogCustomerForm(null, true);
        dialog.setEditMode(false);
        dialog.setLocationRelativeTo(null);
        dialog.setSaveListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                fillDataCustomer(curpage);
                dialog.dispose();
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btnNewActionPerformed

    private void comboCustomerItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_comboCustomerItemStateChanged
    }//GEN-LAST:event_comboCustomerItemStateChanged

    private void comboCustomerMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_comboCustomerMouseClicked
    }//GEN-LAST:event_comboCustomerMouseClicked

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        // TODO add your handling code here:
        Customer c = getSelectedCustomer();
        if (c == null) {
            JOptionPane.showMessageDialog(null, "Select a row to perform this action.");
            return;
        } else {
            final DialogCustomerForm dialog = new DialogCustomerForm(null, true);
            dialog.setModel(c);
            dialog.setEditMode(true);
            dialog.setLocationRelativeTo(null);
            dialog.setSaveListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    fillDataCustomer(curpage);
                    dialog.dispose();
                }
            });
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_btnEditActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnNew;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnSearch;
    private javax.swing.JComboBox comboCustomer;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tableCustomer;
    private javax.swing.JTextField txtKeyword;
    // End of variables declaration//GEN-END:variables

    public void reloadData() {
        fillDataCustomer(curpage);
        fillPage();
    }

    public void refresh() {
        search = "";
        txtKeyword.setText(search);
        fillDataCustomer(1);
        fillPage();
    }
}
