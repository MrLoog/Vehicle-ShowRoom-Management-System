/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.report;

import app.model.Order;
import app.model.Vehicle;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.util.Rotation;
import app.service.*;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.ClusteredXYBarRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Administrator
 */
public class ShowroomReport extends javax.swing.JPanel {
    
    private DealerService dealerService;
    private CustomerService customerService;
    private VehicleService vehicleService;
    private OrderService orderService;
    private ImportOrderService importOrderService;

    /**
     * Creates new form ShowroomReport
     */
    public ShowroomReport() {
        initComponents();
        dealerService = new DealerService();
        customerService = new CustomerService();
        vehicleService = new VehicleService();
        orderService = new OrderService();
        importOrderService = new ImportOrderService();
        lib = new StatisticLib();
        initCbb();
    }
    private StatisticLib lib;
    
    private void initCbb() {
        jComboBox1.removeAll();
        for (String item : lib.getListCategory()) {
            jComboBox1.addItem(item);
        }
    }
    private JPanel activePanel;
    
    private void changePanelReport(JPanel panel) {
        jPanel2.removeAll();
        jPanel2.add(panel);
        activePanel = panel;
        jPanel2.revalidate();
        jPanel2.repaint();
    }
    
    private void showVehicleInStore() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        List<Vehicle> vs = vehicleService.getAll();
        for (Vehicle vehicle : vs) {
            if (vehicle.getQuantity() > 0) {
                dataset.setValue(vehicle.getModelNumber(), vehicle.getQuantity());
            }
        }
        JFreeChart chart = ChartFactory.createPieChart3D("Vehicle In Store", // chart title
                dataset, // data
                true, // include legend
                true,
                false);
        
        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        PieSectionLabelGenerator generator = new StandardPieSectionLabelGenerator(
                "Model No {0} : {2}({1})", new DecimalFormat("0"), new DecimalFormat("0.00%"));
        plot.setLabelGenerator(generator);
        plot.setStartAngle(290);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        // we put the chart into a panel
        ChartPanel chartPanel = new ChartPanel(chart);
        changePanelReport(chartPanel);
    }
    
    private void showRevenueOverPeriod() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<Order> orders = orderService.executePrepareStmt(orderService.getPrepareStmtAllOrderDone());
        List<Order> temps = new ArrayList<Order>();
        for (Order o : orders) {
            temps.add(o);
        }
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DATE, 1);
        cal.set(Calendar.MONTH, 9);
        cal.set(Calendar.YEAR, 2013);
        Date starteddate = new Date(cal.getTimeInMillis());
        Date cudate = new Date((new java.util.Date()).getTime());
        Calendar calTemp = Calendar.getInstance();
        Calendar calTemp1 = Calendar.getInstance();
        calTemp1.setTimeInMillis(starteddate.getTime());
        Calendar calTemp2 = Calendar.getInstance();
        calTemp2.setTimeInMillis(cudate.getTime());
        boolean isstart = false;
        while (calTemp1.get(Calendar.DATE) <= calTemp2.get(Calendar.DATE)) {
            int count = 0;
            for (Order o : orders) {
                calTemp.setTimeInMillis(o.getCreated().getTime());
                if (calTemp.get(Calendar.DATE) == calTemp1.get(Calendar.DATE)) {
                    count += (o.getPrice() * o.getQuantity());
                }
            }
            if (!isstart && count > 0) {
                isstart = true;
            }
            if (isstart) {
                dataset.setValue((Number) (new Integer(count)), "Quantity", calTemp1.get(Calendar.DATE) + "");
            }
            calTemp1.add(Calendar.DATE, 1);
        }
        JFreeChart jfreechart = ChartFactory.createBarChart("Revenue Showroom",
                "Date", "Quantity", dataset, PlotOrientation.VERTICAL,
                false, true, false);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        changePanelReport(chartpanel);
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
        jLabel1 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jDateChooser2 = new com.toedter.calendar.JDateChooser();
        jComboBox1 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jComboBox2 = new javax.swing.JComboBox();

        setLayout(new java.awt.BorderLayout());

        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel1.setPreferredSize(new java.awt.Dimension(400, 100));

        jLabel1.setText("From :");

        jLabel2.setText("To :");

        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });

        jButton1.setText("Show Me");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(31, 31, 31)
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel2)
                        .addGap(40, 40, 40)
                        .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(71, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jDateChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel1, java.awt.BorderLayout.PAGE_START);

        add(jPanel2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        String selected = (String) jComboBox1.getSelectedItem();
        int constant = lib.getConstantByString(selected);
        if (constant == -1) {
            return;
        }
        switch (constant) {
            case StatisticLib.CATEGORY_VEHICLE:
                showVehicleInStore();
                break;
            case StatisticLib.CATEGORY_ORDER:
                showRevenueOverPeriod();
            default:
                break;
        }
    }//GEN-LAST:event_jButton1ActionPerformed
    
    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        String selected = (String) jComboBox1.getSelectedItem();
        int constant = lib.getConstantByString(selected);
        if (constant == -1) {
            return;
        }
        List<String> sublst = null;
        sublst = lib.getSubListofCategory(constant);
        jComboBox2.removeAllItems();
        for (String string : sublst) {
            jComboBox2.addItem(string);
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox2;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private com.toedter.calendar.JDateChooser jDateChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
