/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.dealer;

import app.model.Dealer;
import app.view.model.TableDealerModel;
import java.util.List;

/**
 *
 * @author Administrator
 */
public class DealerTable extends javax.swing.JPanel {
    
    private List<Dealer> model;

    public void setModel(List<Dealer> model) {
        this.model = model;
        TableDealerModel tablemodel = new TableDealerModel(model);
        jTable1.setModel(tablemodel);
        jTable1.revalidate();
        jTable1.repaint();
    }
    public Dealer getSelectedDealer() {
        int index = jTable1.getSelectedRow();
        if (index == -1) {
            return null;
        } else {
            return ((TableDealerModel) jTable1.getModel()).getData(index);
        }
    }
    /**
     * Creates new form DealerTable
     */
    public DealerTable() {
        initComponents();
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
        jTable1 = new javax.swing.JTable();

        setLayout(new java.awt.BorderLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
