/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.order;

import app.listener.IImportOrderContent;
import app.listener.IImportOrderManage;
import app.model.Brand;
import app.model.ImportOrder;
import app.model.Vehicle;
import app.service.BrandService;
import app.service.ImportOrderService;
import app.service.VehicleService;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class ImportOrderForm extends javax.swing.JPanel {

    private VehicleService vehicleService;
    private ImportOrderService importOrderService;
    private IImportOrderManage listener;
    private BrandService brandService;
    private List<Brand> lstBrands = new ArrayList<Brand>();
    private List<String> lstBrandsName = new ArrayList<String>();
    private ImportOrder model;
    private boolean isEdit = false;

    public ImportOrder getModel() {
        return model;
    }

    public void setModel(ImportOrder model) {
        this.model = model;
        jTextField1.setText(model.getModelNumber());
        jTextField2.setText(model.getName());
        jComboBox1.setSelectedItem(model.getBrand());
        jTextField4.setText(model.getPrice().toString());
    }

    public void setListener(IImportOrderManage listener) {
        this.listener = listener;
    }

    /**
     * Creates new form ImportOrder
     */
    public ImportOrderForm() {
        initComponents();
        vehicleService = new VehicleService();
        importOrderService = new ImportOrderService();
        brandService = new BrandService();
        lstBrands = brandService.getAll();
        for (Brand item : lstBrands) {
            jComboBox1.addItem(item.getName());
            lstBrandsName.add(item.getName());
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        jLabel2.setText("Model Number :");

        jLabel3.setText("Name :");

        jLabel4.setText("Brand :");

        jLabel5.setText("Price :");

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        jLabel6.setText("Quantity :");

        jComboBox1.setEditable(true);

        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5)
                                    .addComponent(jLabel6)
                                    .addComponent(jButton1))
                                .addGap(50, 50, 50)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextField5)
                                        .addComponent(jTextField4)
                                        .addComponent(jComboBox1, 0, 129, Short.MAX_VALUE)
                                        .addComponent(jTextField2)
                                        .addComponent(jTextField1)))))
                        .addGap(0, 39, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(18, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void clear() {
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
    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
        // TODO add your handling code here:
        String modelnumber = jTextField1.getText();
        List<Vehicle> lst = vehicleService.executeQuery(vehicleService.getByModelNumberQuery(modelnumber));
        if (lst.size() > 0) {
            Vehicle vehicle = lst.get(0);
            setModel(vehicle);
            setEditMode(true);
        }
    }//GEN-LAST:event_jTextField1FocusLost

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        createOrder();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed
    private void createOrder() {
        if (validateImportOrder()) {
            //auto create new brand
            String modelnumber = jTextField1.getText();
            List<Vehicle> lst = vehicleService.executeQuery(vehicleService.getByModelNumberQuery(modelnumber));
            String selectbrand = jComboBox1.getSelectedItem().toString();
            if (!selectbrand.equals("")) {
                if (lstBrands.size() <= 0 || !lstBrandsName.contains(selectbrand)) {
                    Brand brand = new Brand();
                    brand.setName(selectbrand);
                    brand.setId(brandService.add(brand));
                    lstBrands.add(brand);
                    lstBrandsName.add(selectbrand);
                    jComboBox1.addItem(selectbrand);
                    jComboBox1.revalidate();
                    jComboBox1.repaint();
                }
            }
            //auto create new vehicle or update quantity
            if (lst.size() > 0) {
                Vehicle vehicle = lst.get(0);
                vehicle.setName(jTextField2.getText());
                vehicle.setBrand(selectbrand);
                vehicle.setPrice(Integer.parseInt(jTextField4.getText()));
                if (isEdit) {
                    int dif = model.getQuantity() - Integer.parseInt(jTextField5.getText());
                    vehicle.setQuantity(vehicle.getQuantity() - dif);
                } else {
                    vehicle.setQuantity(vehicle.getQuantity() + Integer.parseInt(jTextField5.getText()));
                }
                vehicleService.update(vehicle);
            } else {
                Vehicle vehicle = new Vehicle();
                vehicle.setModelNumber(modelnumber);
                vehicle.setName(jTextField2.getText());
                vehicle.setBrand(selectbrand);
                vehicle.setPrice(Integer.parseInt(jTextField4.getText()));
                //if new vehicle so new order and quantity input first time
                vehicle.setQuantity(vehicle.getQuantity() + Integer.parseInt(jTextField5.getText()));
                vehicleService.add(vehicle);
            }

            loadDataToModel();
            if (isEdit) {
                importOrderService.update(model);
            } else {
                importOrderService.add(model);
            }
            jLabel1.setText("Save Order Success.");
            listener.reloadTableImportOrder();
        }
    }

    private boolean validateImportOrder() {
        return true;
    }

    public void setEditMode(boolean b) {
        isEdit = b;
    }

    public void clearForm() {
        if (isEdit) {
            setModel(model);
        } else {
            ImportOrder v = new ImportOrder();
            v.setBrand("");
            v.setName("");
            v.setPrice(0);
            v.setModelNumber("");
            v.setQuantity(0);
            setModel(v);
        }
    }

    private void loadDataToModel() {
        if (model == null) {
            model = new ImportOrder();
        }
        model.setBrand(jComboBox1.getSelectedItem().toString());
        model.setModelNumber(jTextField1.getText());
        model.setName(jTextField2.getText());
        model.setPrice(Integer.parseInt(jTextField4.getText()));
        model.setQuantity(Integer.parseInt(jTextField5.getText()));
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    // End of variables declaration//GEN-END:variables

    public void setModel(Vehicle v) {
        ImportOrder o = new ImportOrder();
        o.setBrand(v.getBrand());
        o.setName(v.getName());
        o.setModelNumber(v.getModelNumber());
        o.setPrice(v.getPrice());
        o.setQuantity(0);
        setModel(o);
    }
}
