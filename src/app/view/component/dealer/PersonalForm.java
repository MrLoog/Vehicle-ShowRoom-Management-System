/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.dealer;

import app.model.Dealer;
import app.service.DealerService;
import app.utility.AppUtility;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class PersonalForm extends javax.swing.JPanel {

    private DealerService dealerService;
    private Dealer model;

    public Dealer getModel() {
        return model;
    }

    public void setModel(Dealer model) {
        this.model = model;
        setDefaultValue(model);
    }

    private void setDefaultValue(Dealer d) {
        jTextField1.setText(d.getName());
        jTextField2.setText(d.getLoginName());
    }

    private void clear() {
        setModel(model);
        jPasswordField1.setText("");
        jPasswordField2.setText("");
        jPasswordField3.setText("");
        clearError();
    }

    private void loadDataToModel() {
        if (model == null) {
            model = new Dealer();
        }
        model.setName(jTextField1.getText());
        model.setLoginName(jTextField2.getText());
        model.setPassword(AppUtility.EncryptPassword(new String(jPasswordField2.getPassword())));
    }

    public void clearError() {
        lbleName.setText("");
        lbleLoginName.setText("");
        lblePW.setText("");
        lbleNP.setText("");
        lbleReP.setText("");
        lblprocess.setText("");
    }

    private boolean isFormValid() {
        boolean output = true;
        clearError();
        String name = jTextField1.getText();
        if (name.equals("")) {
            lbleName.setText("Name is required.");
            output = false;
        }
        String inputln = jTextField2.getText();
        if (inputln.equals("")) {
            lbleLoginName.setText("Login Name is required.");
            output = false;
        } else {
            if (!inputln.equals(model.getLoginName())) {
                List<Dealer> ds = dealerService.executeQuery("select * from " + dealerService.getTableName() + " where LoginName='" + inputln + "'");
                if (ds.size() > 0) {
                    lbleLoginName.setText("Login Name is exists.");
                    output = false;
                }
            }
        }
        String password = new String(jPasswordField1.getPassword());
        if (password.equals("")) {
            lblePW.setText("Password is required.");
            output = false;
        } else if (!model.getPassword().equals(AppUtility.EncryptPassword(password))) {
            lblePW.setText("Wrong Password.");
            output = false;
        }
        String newpassword = new String(jPasswordField2.getPassword());
        String repass = new String(jPasswordField3.getPassword());
        if (newpassword.equals("")) {
            lbleNP.setText("New Password is required.");
            output = false;
        }
        if (repass.equals("")) {
            lbleReP.setText("Retype new password is required.");
            output = false;
        }
        if (!newpassword.equals(repass)) {
            lbleReP.setText("New Password and retype new password need match.");
            output = false;
        }
        return output;
    }

    /**
     * Creates new form PersonalForm
     */
    public PersonalForm() {
        initComponents();
        dealerService = new DealerService();
        clearError();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblName = new javax.swing.JLabel();
        lblLoginName = new javax.swing.JLabel();
        lblPassword = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jTextField2 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        lblNewPassword = new javax.swing.JLabel();
        lblReNewPassword = new javax.swing.JLabel();
        lbleName = new javax.swing.JLabel();
        lbleLoginName = new javax.swing.JLabel();
        lblePW = new javax.swing.JLabel();
        lbleNP = new javax.swing.JLabel();
        lbleReP = new javax.swing.JLabel();
        lblprocess = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jPasswordField2 = new javax.swing.JPasswordField();
        jPasswordField3 = new javax.swing.JPasswordField();

        lblName.setText("Name :");

        lblLoginName.setText("Login Name :");

        lblPassword.setText("Password :");

        jButton1.setText("Save");
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

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 255));
        jLabel5.setText("Change Your Information");

        lblNewPassword.setText("New Password :");

        lblReNewPassword.setText("Re-Password :");

        lbleName.setForeground(new java.awt.Color(255, 0, 0));
        lbleName.setText("jLabel1");

        lbleLoginName.setForeground(new java.awt.Color(255, 0, 0));
        lbleLoginName.setText("jLabel2");

        lblePW.setForeground(new java.awt.Color(255, 0, 0));
        lblePW.setText("jLabel3");

        lbleNP.setForeground(new java.awt.Color(255, 0, 0));
        lbleNP.setText("jLabel4");

        lbleReP.setForeground(new java.awt.Color(255, 0, 0));
        lbleReP.setText("jLabel6");

        lblprocess.setText("jLabel1");

        jPasswordField3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jPasswordField3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblName)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(59, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(lblprocess, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblLoginName)
                                    .addComponent(lblPassword)
                                    .addComponent(lblNewPassword)
                                    .addComponent(lblReNewPassword))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(lbleNP, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                    .addComponent(lbleLoginName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jTextField1)
                                    .addComponent(jTextField2)
                                    .addComponent(lbleName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lblePW, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jPasswordField1)
                                    .addComponent(jPasswordField2)
                                    .addComponent(jPasswordField3)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButton1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButton2)
                                    .addComponent(lbleReP, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(74, 74, 74))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(lblprocess)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblName)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbleName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblLoginName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbleLoginName)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPassword)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblePW)
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNewPassword)
                    .addComponent(jPasswordField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbleNP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblReNewPassword)
                    .addComponent(jPasswordField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbleReP)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(63, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if (isFormValid()) {
            lblprocess.setText("Saving...");
            loadDataToModel();
            try {
                dealerService.update(model);
                lblprocess.setText("Save Success.");
            } catch (Exception e) {
                lblprocess.setText("Save Failed.");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jPasswordField3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jPasswordField3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jPasswordField3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JPasswordField jPasswordField3;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel lblLoginName;
    private javax.swing.JLabel lblName;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblReNewPassword;
    private javax.swing.JLabel lbleLoginName;
    private javax.swing.JLabel lbleNP;
    private javax.swing.JLabel lbleName;
    private javax.swing.JLabel lblePW;
    private javax.swing.JLabel lbleReP;
    private javax.swing.JLabel lblprocess;
    // End of variables declaration//GEN-END:variables
}
