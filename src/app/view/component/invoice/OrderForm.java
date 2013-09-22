/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.invoice;

import app.model.Customer;
import app.model.Order;
import app.model.Vehicle;
import app.service.CustomerService;
import app.service.OrderService;
import app.service.VehicleService;
import app.utility.AppUtility;
import app.view.Main;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class OrderForm extends javax.swing.JPanel {

    private boolean isEdit = false;
    private Order model;
    private CustomerService customerService;
    private VehicleService vehicleService;
    private OrderService orderService;
    private List<Vehicle> vehicleAvaiable;
    private ActionListener purchaseListener;
    private ActionListener cancelListener;
    private int buyQuantity = 1;

    public void setCancelListener(ActionListener cancelListener) {
        this.cancelListener = cancelListener;
    }

    public void setBuyQuantity(int buyQuantity) {
        this.buyQuantity = buyQuantity;
        if (model != null && model.getPrice() != 0) {
            model.setQuantity(buyQuantity);
            jLabel15.setText(buyQuantity + "");
            jTextField5.setText(model.getPrice() + "");
            jLabel17.setText((model.getPrice() * buyQuantity) + "");
        }
    }

    public void setPurchaseListener(ActionListener purchaseListener) {
        this.purchaseListener = purchaseListener;
    }

    public void setEditMode(boolean isEdit) {
        this.isEdit = isEdit;
    }

    public Order getModel() {
        return model;
    }

    public void setModel(Order model) {
        this.model = model;
        setDefaultValue(model);
    }

    private void setDefaultValue(Order d) {
        jTextField5.setText(String.valueOf(d.getPrice()));
        jLabel12.setText(AppUtility.getStatusString(model.getStatus()));
        if (d.getVehicle() != null) {
            jLabel8.setText(d.getVehicle().getModelNumber());
        } else {
            jLabel8.setText("No Info");
        }
        if (d.getCustomer() != null) {
            jTextField1.setText(d.getCustomer().getName());
            jTextField2.setText(d.getCustomer().getAddress());
            jTextField3.setText(d.getCustomer().getPhone());
        } else {
            jTextField1.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
        }
    }

    private void clear() {
        clearErrorMes();
        model.setCustomerId(0);
        model.setCustomer(new Customer());
        setModel(model);
    }

    private void loadDataToModel() {
        if (model == null) {
            model = new Order();
        }
    }

    private boolean isFormValid() {
        boolean output = true;
        clearErrorMes();
        if (model != null && model.getId() != 0) {
            jLabel13.setText("Order has saved.");
            output = false;
            return output;
        }
        String cusname = jTextField1.getText();
        String cusphone = jTextField3.getText();
        //pre get and re set later
        String price = jTextField5.getText();
        Customer c = new Customer();
        c.setName(cusname);
        c.setPhone(cusphone);
        c.setAddress(jTextField2.getText());
        if (cusname.equals("")) {
            jLabel2.setText("Customer name is required.");
            output = false;
        }
        if (cusphone.equals("")) {
            jLabel6.setText("Customer Phone is required.");
            output = false;
        }
        if (!cusphone.equals("")) {
            List<Customer> customers = customerService.executePrepareStmt(customerService.getPStmtFindCustomer(cusphone));
            if (customers.size() <= 0 && !cusname.equals("")) {
                int choice = JOptionPane.showConfirmDialog(this, "Customer not exists, save this?", "Confirm for save", JOptionPane.YES_NO_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    c.setDealerId(Main.activeUser.getId());
                    Date date = new Date();
                    java.sql.Date inputdate = new java.sql.Date(date.getTime());
                    c.setCreated(inputdate);
                    c.setModified(inputdate);
                    int returnid = customerService.add(c);
                    c.setId(returnid);
                    setModelCustomer(c);
                } else {
                    jLabel6.setText("Wrong Phone or customer not exists");
                    setModelCustomer(c);
                    output = false;
                }
            } else if (customers.size() > 0 && !cusname.equals(customers.get(0).getName())) {
                jLabel2.setText("Wrong Customer Name.");
                setModelCustomer(c);
                output = false;
            } else if (customers.size() > 0 && cusname.equals(customers.get(0).getName())) {
                setModelCustomer(customers.get(0));
            }
        }
        jTextField5.setText(price);
        if (price.equals("")) {
            jLabel19.setText("Price is required.");
            output = false;
        } else {
            try {
                int intprice = Integer.parseInt(price);
                if (intprice <= 0) {
                    jLabel19.setText("Price is greater 0.");
                    output = false;
                }
            } catch (NumberFormatException e) {
                jLabel19.setText("Price is number.");
                output = false;
            }
        }
        return output;
    }

    private void clearErrorMes() {
        jLabel2.setText("");
        jLabel4.setText("");
        jLabel6.setText("");
        jLabel8.setText("");
        jLabel13.setText("");
    }

    /**
     * Creates new form OrderForm
     */
    public OrderForm() {
        initComponents();
        customerService = new CustomerService();
        vehicleService = new VehicleService();
        orderService = new OrderService();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();

        jLabel1.setText("Customer Name :");

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Customer Address :");

        jLabel5.setText("Customer Phone :");

        jLabel7.setText("Vehicle Model :");

        jLabel8.setText("No Info");

        jLabel9.setText("Price :");

        jLabel11.setText("Status :");

        jLabel12.setText("No Info");

        jButton1.setText("Purchase");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Reset");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Cancel");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel14.setText("Buy Quantity :");

        jLabel15.setText("No Info");

        jLabel16.setText("Total :");

        jLabel17.setText("No Info");

        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });

        jLabel19.setForeground(new java.awt.Color(255, 0, 0));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton3))
                            .addComponent(jTextField3)
                            .addComponent(jTextField2)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel14)
                            .addComponent(jLabel7)
                            .addComponent(jLabel16))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel17)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextField5)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel14))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel19)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(25, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (isFormValid()) {
            model.setDealerId(Main.activeUser.getId());
            model.setPrice(Integer.parseInt(jTextField5.getText()));
            model.setStatus(Order.STATUS_NEW);
            Date date = new Date();
            java.sql.Date inputdate = new java.sql.Date(date.getTime());
            model.setCreated(inputdate);
            model.setModified(inputdate);
//            int returnid = orderService.add(model);
//            model.setId(returnid);
            final DialogComfirmOrder d = new DialogComfirmOrder(null, true);
            d.setModel(model);
            d.setLocationRelativeTo(null);
            d.setPurchaseListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    saveModel();
                    d.dispose();
                }
            });
            d.setCancelListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent ae) {
                    JOptionPane.showMessageDialog(null, "Cancel Order, Dialog is closing.");
                    d.dispose();
                }
            });
            d.setVisible(true);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (cancelListener != null) {
            cancelListener.actionPerformed(evt);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
        // TODO add your handling code here:
        try {
            int price = Integer.parseInt(jTextField5.getText());
            if (price > 0) {
                jLabel17.setText("" + (price * model.getQuantity()));
            }
        } catch (NumberFormatException numberFormatException) {
            return;
        }
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        // TODO add your handling code here:
        try {
            int price = Integer.parseInt(jTextField5.getText());
            if (price > 0) {
                jLabel17.setText("" + (price * model.getQuantity()));
            }
        } catch (NumberFormatException numberFormatException) {
            return;
        }
    }//GEN-LAST:event_jTextField5KeyReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    public void setDataModel(Object selectobj) {
        if (selectobj instanceof Vehicle) {
            setModelVehicle(selectobj);
        }
        if (selectobj instanceof Customer) {
            setModelCustomer(selectobj);
        }
    }

    private void setModelVehicle(Object selectobj) {
        Vehicle v = (Vehicle) selectobj;
        if (selectobj != null) {
            if (model == null) {
                model = new Order();
            }
            model.setVehicleId(v.getId());
            model.setPrice(v.getPrice());
            model.setVehicle(v);
            setDefaultValue(model);
        }
    }

    private void setModelCustomer(Object selectobj) {
        Customer v = (Customer) selectobj;
        if (model == null) {
            model = new Order();
        }
        model.setCustomerId(v.getId());
        model.setCustomer(v);
        setDefaultValue(model);
    }
    private ActionListener orderSuccessListener;

    public void setOrderSuccessListener(ActionListener orderSuccessListener) {
        this.orderSuccessListener = orderSuccessListener;
    }

    private void saveModel() {
        int returnid = orderService.add(model);
        Vehicle v = vehicleService.getById(model.getVehicleId());
        v.setQuantity(v.getQuantity() - model.getQuantity());
        vehicleService.update(v);
        model = new Order();
        setDefaultValue(model);
        JOptionPane.showMessageDialog(null, "Confirm Success, Order status is wait and on order view, Dialog is closing.");
        if (orderSuccessListener != null) {
            orderSuccessListener.actionPerformed(null);
        }
    }
}
