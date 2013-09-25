/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.composite;

import app.icomponent.IPanelTable;
import app.model.Customer;
import app.model.Dealer;
import app.model.Vehicle;
import app.service.CustomerService;
import app.service.DealerService;
import app.service.OrderService;
import app.service.VehicleService;
import app.view.Main;
import app.view.component.customer.CustomerTableForSales;
import app.view.component.invoice.OrderForm;
import app.view.component.vehicle.VehicleDetails;
import app.view.component.vehicle.VehicleTable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import javax.swing.JPanel;

/**
 *
 * @author Administrator
 */
public class OrderForCustomer extends javax.swing.JPanel {
    
    private VehicleService vehicleService;
    private OrderService orderService;
    private CustomerService customerService;
    private DealerService dealerService;
    /**
     * Creates new form OrderStep1
     */
    public OrderForCustomer() {
        initComponents();
        vehicleService = VehicleService.getInstance();
        orderService = OrderService.getInstance();
        customerService = CustomerService.getInstance();
        dealerService=DealerService.getInstance();
        initCbbFilter();
        viewTableVehicle();
        viewVehicleDetails();
    }
    
    private void showCbbFilter() {
        cbbrand.setVisible(true);
        cbbcategory.setVisible(true);
    }
    
    private void hideCbbFilter() {
        cbbrand.setVisible(false);
        cbbcategory.setVisible(false);
    }
    
    private void initCbbFilter() {
        cbbrand.removeAllItems();
        List<String> brands = vehicleService.getListBrandName();
        cbbrand.addItem(Main.ALL);
        for (String brand : brands) {
            cbbrand.addItem(brand);
        }
        cbbrand.revalidate();
        cbbrand.repaint();
        
        cbbcategory.removeAllItems();
        List<String> categorys = vehicleService.getListCategoryName();
        cbbcategory.addItem(Main.ALL);
        for (String category : categorys) {
            cbbcategory.addItem(category);
        }
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
        if (activeTable instanceof VehicleTable) {
            fillDataVehicle(curpage);
        } else {
            fillDataCustomer(curpage);
        }
    }
    
    private void fillDataVehicle(int page) {
        String pagingsql = "";
        String brand = (String) cbbrand.getSelectedItem();
        String category = (String) cbbcategory.getSelectedItem();
        if (search.equals("")) {
            pagingsql = vehicleService.BuildPagingSql(vehicleService.getTableName(), vehicleService.getConditionFilter(brand, category), Main.PerPage, page, totalpage);
        } else {
            pagingsql = vehicleService.BuildPagingSql(vehicleService.getTableName(), vehicleService.getConditionSearch(search, brand, category), Main.PerPage, page, totalpage);
        }
        List<Vehicle> lst = vehicleService.executeQuery(pagingsql);
        vehicleTable.setModel(lst);
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
            customer.setDealer((Dealer)dealerService.getById(customer.getDealerId()));
        }
        customerTable.setModel(lst);
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
    private VehicleTable vehicleTable;
    private CustomerTableForSales customerTable;
    private IPanelTable activeTable;
    
    public void viewTableVehicle() {
        if (vehicleTable == null) {
            vehicleTable = new VehicleTable();
            reloadTableVehicle();
        }
        activeTable = vehicleTable;
        showCbbFilter();
        jPanel1.removeAll();
        jPanel1.add(vehicleTable);
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    private void reloadTableVehicle() {
        fillDataVehicle(1);
        fillPage();
        vehicleTable.setSelectListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionSelectVehiclePerformed(ae);
            }
        });
    }
    
    public void viewTableCustomer() {
        if (customerTable == null) {
            customerTable = new CustomerTableForSales();
            reloadTableCustomer();
        }
        activeTable = customerTable;
        hideCbbFilter();
        jPanel1.removeAll();
        jPanel1.add(customerTable);
        jPanel1.revalidate();
        jPanel1.repaint();
    }
    
    private void reloadTableCustomer() {
        fillDataCustomer(1);
        fillPage();
        customerTable.setSelectListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                actionSelectCustomerPerformed(ae);
            }
        });
    }
    private VehicleDetails vehicleDetails;
    private OrderForm orderForm;
    private JPanel activeForm;
    
    private void viewVehicleDetails() {
        if (vehicleDetails == null) {
            vehicleDetails = new VehicleDetails();
            vehicleDetails.setOrderCommand(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    actionOrderPerform(ae);
                }
            });
        }
        activeForm = vehicleDetails;
        jPanel3.removeAll();
        jPanel3.add(vehicleDetails);
        jPanel3.revalidate();
        jPanel3.repaint();
    }
    
    private void viewOrderForm() {
        if (orderForm == null) {
            orderForm = new OrderForm();
            orderForm.setPurchaseListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    actionPurchasePerformed(ae);
                }
            });
            orderForm.setCancelListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    actionCancelPerformed(ae);
                }
            });
            orderForm.setOrderSuccessListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    actionOrderSuccessPerformed(ae);
                }
            });
        }
        activeForm = orderForm;
        jPanel3.removeAll();
        jPanel3.add(orderForm);
        jPanel3.revalidate();
        jPanel3.repaint();
    }
    
    private void actionOrderPerform(ActionEvent obj) {
        viewTableCustomer();
        viewOrderForm();
        orderForm.setDataModel(vehicleDetails.getModel());
        orderForm.setBuyQuantity(vehicleDetails.getBuyquantity());
    }
    
    private void actionPurchasePerformed(ActionEvent ae) {
    }
    
    private void actionCancelPerformed(ActionEvent ae) {
        viewTableVehicle();
        viewVehicleDetails();
    }
    
    private void actionSelectVehiclePerformed(ActionEvent ae) {
        Vehicle selectobj = vehicleTable.getSelectedVehicle();
        if (selectobj != null) {
            viewVehicleDetails();
            vehicleDetails.setDataModel((Vehicle) selectobj);
        }
    }
    
    private void actionSelectCustomerPerformed(ActionEvent ae) {
        Customer selectobj = customerTable.getSelectedCustomer();
        if (selectobj != null) {
            viewOrderForm();
            orderForm.setDataModel((Customer) selectobj);
        }
    }
    
    private void actionOrderSuccessPerformed(ActionEvent ae) {
        reloadTableVehicle();
        reloadTableCustomer();
        viewTableVehicle();
        viewVehicleDetails();
    }
    
    private void actionSearch() {
        search = jTextField1.getText();
        if (activeTable instanceof VehicleTable) {
            fillDataVehicle(1);
            fillPage();
        }
        if (activeTable instanceof CustomerTableForSales) {
            fillDataCustomer(1);
            fillPage();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        cbbrand = new javax.swing.JComboBox();
        cbbcategory = new javax.swing.JComboBox();
        jPanel3 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(700, 500));
        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jPanel1, java.awt.BorderLayout.CENTER);

        jPanel4.setPreferredSize(new java.awt.Dimension(355, 50));
        jPanel4.setLayout(new java.awt.FlowLayout(0));

        jComboBox1.setPreferredSize(new java.awt.Dimension(50, 25));
        jPanel4.add(jComboBox1);

        jTextField1.setMinimumSize(new java.awt.Dimension(10, 20));
        jTextField1.setPreferredSize(new java.awt.Dimension(100, 25));
        jPanel4.add(jTextField1);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/view/resource/find.png"))); // NOI18N
        jButton1.setText("Search");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/app/view/resource/refresh.png"))); // NOI18N
        jButton3.setText("Refresh");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        cbbrand.setPreferredSize(new java.awt.Dimension(100, 25));
        cbbrand.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbrandItemStateChanged(evt);
            }
        });
        jPanel4.add(cbbrand);

        cbbcategory.setPreferredSize(new java.awt.Dimension(100, 25));
        cbbcategory.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbcategoryItemStateChanged(evt);
            }
        });
        jPanel4.add(cbbcategory);

        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        add(jPanel2, java.awt.BorderLayout.CENTER);
        add(jPanel3, java.awt.BorderLayout.EAST);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        actionSearch();
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        search = "";
        jTextField1.setText(search);
        cbbrand.setSelectedItem(Main.ALL);
        cbbcategory.setSelectedItem(Main.ALL);
        if (activeTable instanceof VehicleTable) {
            reloadTableVehicle();
        }
        if (activeTable instanceof CustomerTableForSales) {
            reloadTableCustomer();
        }
    }//GEN-LAST:event_jButton3ActionPerformed
    
    private void cbbrandItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbrandItemStateChanged
        // TODO add your handling code here:
        actionSearch();
    }//GEN-LAST:event_cbbrandItemStateChanged
    
    private void cbbcategoryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbcategoryItemStateChanged
        // TODO add your handling code here:
        actionSearch();
    }//GEN-LAST:event_cbbcategoryItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbbcategory;
    private javax.swing.JComboBox cbbrand;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    public void reloadData() {
        if (activeTable instanceof VehicleTable) {
            reloadTableVehicle();
        }
        if (activeTable instanceof CustomerTableForSales) {
            reloadTableCustomer();
        }
    }
}
