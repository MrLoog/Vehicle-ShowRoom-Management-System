/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.report;

import app.model.Vehicle;
import app.service.OrderService;
import app.service.VehicleService;
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
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.util.Rotation;

/**
 *
 * @author Administrator
 */
public class StatisticVehicle extends javax.swing.JPanel {

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
        this.removeAll();
        this.add(panel);
        activePanel = panel;
        this.revalidate();
        this.repaint();
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

    private void showVehicleSell() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        PreparedStatement ps = orderService.getTopVehicleOrderAll(from, to);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                dataset.setValue((Number) new Integer(rs.getInt("totalquantity")), "Quantity", ((Vehicle) vehicleService.getById(rs.getInt("VehicleID"))).getModelNumber());
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticCustomer.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
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
        JFreeChart jfreechart = ChartFactory.createBarChart("Top Vehicle",
                "Vehicle", "Quantity", dataset, PlotOrientation.VERTICAL,
                false, true, false);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        changePanelReport(chartpanel);
    }

    public void showStatistic(int showwat) {
        switch (showwat) {
            case StatisticLib.CATEGORY_VEHICLE_IN_STORE:
                showVehicleInStore();
                break;
            case StatisticLib.CATEGORY_VEHICLE_SELL:
                showVehicleSell();
                break;
            default:
                break;
        }
    }
    private VehicleService vehicleService;
    private OrderService orderService;

    /**
     * Creates new form StatisticVehicle
     */
    public StatisticVehicle() {
        initComponents();
        vehicleService = VehicleService.getInstance();
        orderService = OrderService.getInstance();
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
}
