/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.invoice;

import app.view.order.*;
import app.listener.ContentListener;
import app.listener.IImportOrderPlusListener;
import java.awt.BorderLayout;

/**
 *
 * @author Administrator
 */
public class ImportOrderPlusContent extends javax.swing.JPanel implements IImportOrderPlusListener {

    private ImportOrderPlusTable importOrderPlusTable;
    private ContentListener listener;

    public void setListener(ContentListener listener) {
        this.listener = listener;
    }

    /**
     * Creates new form ImportOrderContent
     */
    public ImportOrderPlusContent() {
        initComponents();
        
    }
    public void init(){
        viewImportOrderPlusTable();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    @Override
    public void viewImportOrderPlusTable() {
        if (importOrderPlusTable == null) {
            importOrderPlusTable = new ImportOrderPlusTable();
            importOrderPlusTable.setListener(this);
        }
        this.removeAll();
        this.add(importOrderPlusTable, BorderLayout.CENTER);
        listener.changepanel();
    }

    @Override
    public void viewImportOrderPlusForm() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void viewImportOrderPlusMenu() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}