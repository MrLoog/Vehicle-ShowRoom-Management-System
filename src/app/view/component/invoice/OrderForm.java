/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.invoice;

import app.listener.IFormListener;
import app.model.Customer;
import app.model.Order;
import app.model.Vehicle;
import app.service.CustomerService;
import app.service.OrderService;
import app.service.VehicleService;
import app.view.MainFrame;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class OrderForm extends javax.swing.JPanel {
    
    private boolean isEdit = false;
    private Order model;
    private List<IFormListener> listeners = new ArrayList<IFormListener>();
    private CustomerService customerService;
    private VehicleService vehicleService;
    private OrderService orderService;
    
    public void setEditMode(boolean isEdit) {
        this.isEdit = isEdit;
    }
    
    public void registerListen(IFormListener ls) {
        this.listeners.add(ls);
    }
    
    public Order getModel() {
        return model;
    }
    
    public void setModel(Order model) {
        this.model = model;
        setDefaultValue(model);
    }
    
    private void setDefaultValue(Order d) {
        jLabel10.setText(String.valueOf(d.getPrice()));
        jLabel12.setText("" + d.getStatus());
        if (d.getVehicle() != null) {
            jTextField4.setText(d.getVehicle().getModelNumber());
        } else {
            jTextField4.setText("");
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
        model = new Order();
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
        if (model!=null && model.getId() != 0) {
            jLabel13.setText("Order has saved.");
            output = false;
            return output;
        }
        String cusname = jTextField1.getText();
        String cusphone = jTextField3.getText();
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
                    c.setDealerId(MainFrame.activeUser.getId());
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
        String vehiclemodel = jTextField4.getText();
        if (vehiclemodel.equals("")) {
            jLabel8.setText("Vehicle Model is required.");
            output = false;
        } else {
            List<Vehicle> vehicles = vehicleService.executeQuery(vehicleService.getByModelNumberQuery(vehiclemodel));
            if (vehicles.size() <= 0) {
                jLabel8.setText("Vehicle Model is not exists.");
                output = false;
                Vehicle v = new Vehicle();
                v.setModelNumber(jTextField4.getText());
                setModelVehicle(v);
            } else {
                setModelVehicle(vehicles.get(0));
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
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();

        jLabel1.setText("Customer Name :");

        jLabel3.setText("Customer Address :");

        jLabel5.setText("Customer Phone :");

        jLabel7.setText("Vehicle Model :");

        jLabel9.setText("Price :");

        jLabel11.setText("Status :");

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

        jButton3.setText("New Order");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(31, 31, 31)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9)
                                    .addComponent(jLabel11)
                                    .addComponent(jButton1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jButton2)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jButton3)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField2)
                                    .addComponent(jTextField3)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField4)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2)
                    .addComponent(jButton3))
                .addContainerGap(36, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (isFormValid()) {
            jLabel13.setText("Saving...");
            model.setDealerId(MainFrame.activeUser.getId());
            model.setPrice(model.getVehicle().getPrice());
            model.setStatus(Order.STATUS_NEW);
            Date date = new Date();
            java.sql.Date inputdate = new java.sql.Date(date.getTime());
            model.setCreated(inputdate);
            model.setModified(inputdate);
            int returnid = orderService.add(model);
            model.setId(returnid);
            jLabel13.setText("Save Success");
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        clearErrorMes();
        if (model.getId() != 0) {
            model.setId(0);
        }
        setDefaultValue(model);
        jLabel13.setText("Ready for create new order.");
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
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
    private javax.swing.JTextField jTextField4;
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
        if (model == null) {
            model = new Order();
        }
        model.setVehicleId(v.getId());
        model.setPrice(v.getPrice());
        model.setVehicle(v);
        setDefaultValue(model);
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
}
