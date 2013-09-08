/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.subview;

import app.listener.IImportOrderManage;
import app.model.ImportOrder;
import app.service.ImportOrderService;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Administrator
 */
public class ImportOrderManage extends javax.swing.JPanel implements IImportOrderManage {

    private ImportOrderService importOrderService;

    /**
     * Creates new form ImportOrderManage
     */
    public ImportOrderManage() {
        initComponents();
        importOrderService = new ImportOrderService();
        importOrderForm1.setListener(this);
        reloadTableImportOrder();
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
        jPanel2 = new javax.swing.JPanel();
        importOrderTable1 = new app.view.order.ImportOrderTable();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        importOrderForm1 = new app.view.order.ImportOrderForm();

        setLayout(new java.awt.BorderLayout());

        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setPreferredSize(new java.awt.Dimension(700, 402));
        jPanel2.setLayout(new java.awt.BorderLayout());
        jPanel2.add(importOrderTable1, java.awt.BorderLayout.PAGE_START);

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(172, 50));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        jButton4.setText("New");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton4);

        jButton2.setText("Edit");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2);

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3);

        jPanel3.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel5.add(importOrderForm1, java.awt.BorderLayout.CENTER);

        jPanel3.add(jPanel5, java.awt.BorderLayout.CENTER);

        jPanel1.add(jPanel3, java.awt.BorderLayout.EAST);

        add(jPanel1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        ImportOrder order = importOrderTable1.getSelectedImportOrder();
        importOrderForm1.setEditMode(false);
        importOrderForm1.clearForm();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ImportOrder v = importOrderTable1.getSelectedImportOrder();
        importOrderForm1.setModel(v);
        importOrderForm1.setEditMode(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        ImportOrder v = importOrderTable1.getSelectedImportOrder();
        int y = JOptionPane.showConfirmDialog(null, "Do you want to DELETE Vehicle : " + v.getName() + ", model number : " + v.getModelNumber() + "?", "Confirm Deleted", JOptionPane.YES_NO_OPTION);
        if (y == JOptionPane.NO_OPTION) {
            return;
        }
        if (v != null) {
            importOrderService.delete(v);
        }
        reloadTableImportOrder();
    }//GEN-LAST:event_jButton3ActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private app.view.order.ImportOrderForm importOrderForm1;
    private app.view.order.ImportOrderTable importOrderTable1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    // End of variables declaration//GEN-END:variables

    @Override
    public void reloadTableImportOrder() {
        importOrderTable1.setModel(loadDataImportOrder());
    }

    private List<ImportOrder> loadDataImportOrder() {
        return importOrderService.getAll();
    }

    @Override
    public void BodyChanged() {
        this.revalidate();
        this.repaint();
    }
}
