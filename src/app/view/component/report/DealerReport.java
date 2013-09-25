/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.report;

import app.model.Dealer;
import app.model.Order;
import app.model.Vehicle;
import app.service.CustomerService;
import app.service.OrderService;
import app.utility.AppUtility;
import app.view.Main;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Administrator
 */
public class DealerReport extends javax.swing.JPanel {

     private Date from;
    private Date to;
    private int step = 1;

    public void setStep(int step) {
        this.step = step;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public void setTo(Date to) {
        this.to = to;
    }

    private Date adjustStartDate(Date startdate) {
        if (step == StatisticLib.STEP_DATE) {
            return startdate;
        }
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(startdate.getTime());
        if (step == StatisticLib.STEP_MONTH) {
            c.set(Calendar.DATE, 1);
        } else if (step == StatisticLib.STEP_YEAR) {
            c.set(Calendar.DATE, 1);
            c.set(Calendar.MONTH, Calendar.JANUARY);
        }
        return new Date(c.getTimeInMillis());
    }

    private Date incrementDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date.getTime());
        if (step == StatisticLib.STEP_MONTH) {
            c.add(Calendar.MONTH, 1);
        } else if (step == StatisticLib.STEP_YEAR) {
            c.add(Calendar.YEAR, 1);
        } else {
            c.add(Calendar.DATE, 1);
        }
        return new Date(c.getTimeInMillis());
    }

    private boolean checkIsEqual(Date date1, Date date2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTimeInMillis(date1.getTime());
        c2.setTimeInMillis(date2.getTime());
        if (step == StatisticLib.STEP_YEAR) {
            if (c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) {
                return true;
            }
            return false;
        } else if (step == StatisticLib.STEP_MONTH) {
            if (c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) {
                return true;
            }
            return false;
        } else {
            if (c1.get(Calendar.DATE) == c2.get(Calendar.DATE) && c1.get(Calendar.MONTH) == c2.get(Calendar.MONTH) && c1.get(Calendar.YEAR) == c2.get(Calendar.YEAR)) {
                return true;
            }
            return false;
        }
    }

    private String getDisplayLabelDate(Date date) {
        Calendar c = Calendar.getInstance();
        c.setTimeInMillis(date.getTime());
        if (step == StatisticLib.STEP_YEAR) {
            return c.get(Calendar.YEAR) + "";
        } else if (step == StatisticLib.STEP_MONTH) {
            return c.getDisplayName(Calendar.MONTH, Calendar.SHORT, Locale.ENGLISH);
        } else {
            return c.get(Calendar.DATE) + "";
        }
    }
    private JPanel activePanel;

    private void changePanelReport(JPanel panel) {
        jPanel3.removeAll();
        jPanel3.add(panel);
        activePanel = panel;
        jPanel3.revalidate();
        jPanel3.repaint();
    }

    private void showOrderStatistic() {
       DefaultPieDataset dataset = new DefaultPieDataset();
      PreparedStatement ps = orderService.getStatusOrderByDealerID(Main.activeUser.getId(), from, to);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                dataset.setValue(AppUtility.getStatusString(rs.getInt("Status")), rs.getInt("total"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if(ps!=null){
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StatisticVehicle.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        JFreeChart chart = ChartFactory.createPieChart3D("Order and Status", // chart title
                dataset, // data
                true, // include legend
                true,
                false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
                "Status {0} : {2}({1})", new DecimalFormat("0"), new DecimalFormat("0.00%"));
        plot.setLabelGenerator(generator);
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        changePanelReport(chartPanel);
    }
    private OrderService orderService;
    private CustomerService customerService;
    private Dealer model;

    private void activeStatistic() {
        Date from = null;
        Date to = null;
        Calendar fromCal = jDateChooser1.getCalendar();
        if (fromCal != null) {
            from = new Date(fromCal.getTimeInMillis());
        }
        Calendar toCal = jDateChooser2.getCalendar();
        if (toCal != null) {
            to = new Date(toCal.getTimeInMillis());
        }
        if ((from != null && to == null && from.getTime() > new Date((new java.util.Date().getTime())).getTime()) || (from != null && to != null && from.getTime() > to.getTime())) {
            JOptionPane.showMessageDialog(this, "Warning : From time greater To time.");
        }
        setFrom(from);
        setTo(to);
        showOrderStatistic();
    }
    

    /**
     * Creates new form DealerReport
     */
    public DealerReport() {
        initComponents();
        orderService = OrderService.getInstance();
        customerService = CustomerService.getInstance();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(700, 300));
        setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 100));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel4.setPreferredSize(new java.awt.Dimension(400, 100));

        jLabel1.setText("From :");

        jLabel2.setText("To :");

        jButton1.setText("Show Me");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Step :");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78)
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(31, 31, 31)
                        .addComponent(jLabel3)
                        .addGap(18, 18, 18)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(95, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, java.awt.BorderLayout.CENTER);

        add(jPanel1, java.awt.BorderLayout.NORTH);

        jPanel2.setMaximumSize(new java.awt.Dimension(200, 32767));
        jPanel2.setPreferredSize(new java.awt.Dimension(200, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 200, Short.MAX_VALUE)
        );

        add(jPanel2, java.awt.BorderLayout.WEST);

        jPanel3.setPreferredSize(new java.awt.Dimension(500, 400));
        jPanel3.setLayout(new java.awt.BorderLayout());
        add(jPanel3, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       activeStatistic();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox3;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    // End of variables declaration//GEN-END:variables
}
