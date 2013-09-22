/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.composite;

import app.model.Customer;
import app.model.Order;
import app.model.Vehicle;
import app.service.CustomerService;
import app.service.OrderService;
import app.service.VehicleService;
import app.view.Main;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class SalesOrder extends javax.swing.JPanel {

    private OrderService orderService;
    private VehicleService vehicleService;
    private CustomerService customerService;

    /**
     * Creates new form SalesOrder
     */
    public SalesOrder() {
        initComponents();
        orderService = OrderService.getInstance();
        vehicleService = VehicleService.getInstance();
        customerService = CustomerService.getInstance();
        reloadTableOrder();
        orderTable1.setSelectListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Order o = orderTable1.getSelectedOrder();
                if (o != null) {
                    orderUpdateStatus1.setModel(o);
                    orderUpdateStatus1.setPurchaseListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent ae) {
                            int stt = orderUpdateStatus1.getNewStatus();
                            Order o = orderUpdateStatus1.getModel();
                            if (stt != o.getStatus() && stt == Order.STATUS_CANCEL) {
                                Vehicle v = vehicleService.getById(o.getVehicleId());
                                v.setQuantity(v.getQuantity() + o.getQuantity());
                                vehicleService.update(v);
                                o.setStatus(stt);
                                orderService.update(o);
                                JOptionPane.showMessageDialog(null, "Return Vehicle to store, Update order success.");
                            } else if (stt != o.getStatus() && o.getStatus() == Order.STATUS_CANCEL) {
                                Vehicle v = vehicleService.getById(o.getVehicleId());
                                if (v.getQuantity() >= o.getQuantity()) {
                                    v.setQuantity(v.getQuantity() - o.getQuantity());
                                    vehicleService.update(v);
                                    o.setStatus(stt);
                                    orderService.update(o);
                                    JOptionPane.showMessageDialog(null, "Get Vehicle from store, Update order success.");
                                } else {
                                    JOptionPane.showMessageDialog(null, "Vehicle in store not avaiable to order. Update failed.");
                                }
                            } else {
                                o.setStatus(stt);
                                orderService.update(o);
                                JOptionPane.showMessageDialog(null, "Update order success.");
                            }
                            fillData(curpage);
                        }
                    });
                }
            }
        });
    }
    AtomicReference<Integer> totalpage = new AtomicReference<Integer>(0);
    int curpage = 1;
    String search = "";

    public void setTotalpage(Integer totalpage) {
        this.totalpage.set(totalpage);
        fillPage();
    }

    public void setCurpage(int curpage) {
        this.curpage = curpage;
        fillData(curpage);
    }

    private void fillData(int page) {
        String pagingsql = "";
        if (search.equals("")) {
            pagingsql = orderService.BuildPagingSql(orderService.getTableName(), orderService.getConditionSearchWithStatusAndJoin(Main.activeUser.getId(), new ArrayList<Integer>(), new ArrayList<Integer>(), jCheckBox1.isSelected()), Main.PerPage, page, totalpage);
        } else {
            List<Vehicle> lst1 = vehicleService.executeQuery("select * from " + vehicleService.getTableName() + " where " + vehicleService.getConditionSearch(search, Main.ALL, Main.ALL));
            List<Customer> lst2 = customerService.executeQuery("select * from " + customerService.getTableName() + " where " + customerService.getConditionSearch(search));
            List<Integer> lstintv = new ArrayList<Integer>();
            List<Integer> lstintc = new ArrayList<Integer>();
            for (Vehicle v : lst1) {
                if (!lstintv.contains(v.getId())) {
                    lstintv.add(v.getId());
                }
            }
            for (Customer v : lst2) {
                if (!lstintc.contains(v.getId())) {
                    lstintc.add(v.getId());
                }
            }
            pagingsql = orderService.BuildPagingSql(orderService.getTableName(), orderService.getConditionSearchWithStatusAndJoin(Main.activeUser.getId(), lstintv, lstintc, jCheckBox1.isSelected()), Main.PerPage, page, totalpage);
        }
        List<Order> lst = orderService.executeQuery(pagingsql);
        for (Order order : lst) {
            order.setCustomer(customerService.getById(order.getCustomerId()));
            order.setVehicle((Vehicle) vehicleService.getById(order.getVehicleId()));
        }
        orderTable1.setModel(lst);
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
        jComboBox1.removeAllItems();
        for (int i = 1; i <= getTotalPage(); i++) {
            jComboBox1.addItem(i);
        }
        jComboBox1.setSelectedItem(curpage);
        jComboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent ie) {
                Object temppage = jComboBox1.getSelectedItem();
                if (temppage != null) {
                    setCurpage((Integer) temppage);
                }
            }
        });
        jComboBox1.revalidate();
        jComboBox1.repaint();
    }

    public void reloadTableOrder() {
        search = "";
        jTextField1.setText(search);
        fillData(1);
        fillPage();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jCheckBox1 = new javax.swing.JCheckBox();
        jButton5 = new javax.swing.JButton();
        orderTable1 = new app.view.component.invoice.OrderTable();
        jPanel2 = new javax.swing.JPanel();
        orderUpdateStatus1 = new app.view.component.invoice.OrderUpdateStatus();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.FlowLayout(0));
        jPanel3.add(jComboBox1);

        jTextField1.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel3.add(jTextField1);

        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1);

        jCheckBox1.setSelected(true);
        jCheckBox1.setText("Wait Only");
        jPanel3.add(jCheckBox1);

        jButton5.setText("Refresh");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5);

        jPanel1.add(jPanel3, java.awt.BorderLayout.NORTH);
        jPanel1.add(orderTable1, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(orderUpdateStatus1, java.awt.BorderLayout.PAGE_END);

        add(jPanel2, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        reloadTableOrder();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        search = jTextField1.getText();
        fillData(1);
        fillPage();
    }//GEN-LAST:event_jButton1ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton5;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField jTextField1;
    private app.view.component.invoice.OrderTable orderTable1;
    private app.view.component.invoice.OrderUpdateStatus orderUpdateStatus1;
    // End of variables declaration//GEN-END:variables
}
