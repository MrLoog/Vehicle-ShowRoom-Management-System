/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.report;

import app.model.ImportOrder;
import app.model.Vehicle;
import app.service.ImportOrderService;
import app.service.VehicleService;
import app.utility.AppUtility;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
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
public class StatisticImportOrder extends javax.swing.JPanel {

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

    private void showQuantityPeriod() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<ImportOrder> orders = importOrderService.executePrepareStmt(importOrderService.getPrepareStmtAllOrder(from, to));
        if (orders.size() <= 0) {
            return;
        }
        List<ImportOrder> temp = new ArrayList<ImportOrder>();
        for (ImportOrder importOrder : orders) {
            temp.add(importOrder);
        }
        List<Date> dates = new ArrayList<Date>();
        for (ImportOrder o : orders) {
            dates.add(o.getCreated());
        }
        Date startedDate = adjustStartDate(AppUtility.getMinDate(dates));
        Date endDate = AppUtility.getMaxDate(dates);
        int size = orders.size();
        while (startedDate.getTime() <= endDate.getTime() && size > 0) {
            int count = 0;
            for (ImportOrder item : orders) {
                if (checkIsEqual(startedDate, item.getCreated())) {
                    count += item.getQuantity();
                    temp.remove(item);
                }
            }
            orders.clear();
            for (ImportOrder item : temp) {
                orders.add(item);
            }
            dataset.setValue((Number) new Integer(count), "Quantity", getDisplayLabelDate(startedDate));
            startedDate = incrementDate(startedDate);
        }
        JFreeChart jfreechart = ChartFactory.createBarChart("Import Order Quantity",
                "Time", "Quantity", dataset, PlotOrientation.VERTICAL,
                false, true, false);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        changePanelReport(chartpanel);
    }

    private void showQuantityRate() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        PreparedStatement ps = importOrderService.getPrepareStmtGetByVehicleID(from, to);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                dataset.setValue(((Vehicle) vehicleService.getById(rs.getInt("VehicleID"))).getModelNumber(), rs.getInt("sum"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticImportOrder.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(StatisticImportOrder.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        JFreeChart chart = ChartFactory.createPieChart3D("Vehicle Quantity Rate", // chart title
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

    private void showValuePeriod() {
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        List<ImportOrder> orders = importOrderService.executePrepareStmt(importOrderService.getPrepareStmtAllOrder(from, to));
        if (orders.size() <= 0) {
            return;
        }
        List<ImportOrder> temp = new ArrayList<ImportOrder>();
        for (ImportOrder importOrder : orders) {
            temp.add(importOrder);
        }
        List<Date> dates = new ArrayList<Date>();
        for (ImportOrder o : orders) {
            dates.add(o.getCreated());
        }
        Date startedDate = adjustStartDate(AppUtility.getMinDate(dates));
        Date endDate = AppUtility.getMaxDate(dates);
        int size = orders.size();
        while (startedDate.getTime() <= endDate.getTime() && size > 0) {
            int count = 0;
            for (ImportOrder item : orders) {
                if (checkIsEqual(startedDate, item.getCreated())) {
                    count += (item.getQuantity()*item.getPrice());
                    temp.remove(item);
                }
            }
            orders.clear();
            for (ImportOrder item : temp) {
                orders.add(item);
            }
            dataset.setValue((Number) new Integer(count), "Value", getDisplayLabelDate(startedDate));
            startedDate = incrementDate(startedDate);
        }
        JFreeChart jfreechart = ChartFactory.createBarChart("Import Order Quantity",
                "Time", "Value", dataset, PlotOrientation.VERTICAL,
                false, true, false);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        changePanelReport(chartpanel);
    }

    private void showValueRate() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        PreparedStatement ps = importOrderService.getPrepareStmtGetByVehicleID(from, to);
        ResultSet rs = null;
        try {
            rs = ps.executeQuery();
            while (rs.next()) {
                dataset.setValue(((Vehicle) vehicleService.getById(rs.getInt("VehicleID"))).getModelNumber(), rs.getInt("total"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(StatisticImportOrder.class.getName()).log(Level.SEVERE, null, ex);
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
        JFreeChart chart = ChartFactory.createPieChart3D("Vehicle Quantity Rate", // chart title
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
    private JPanel activePanel;

    private void changePanelReport(JPanel panel) {
        this.removeAll();
        this.add(panel);
        activePanel = panel;
        this.revalidate();
        this.repaint();
    }

    public void showStatistic(int showwat) {
        switch (showwat) {
            case StatisticLib.CATEGORY_IMPORTORDER_VEHICLE_QUANTITY_PERIOD:
                showQuantityPeriod();
                break;
            case StatisticLib.CATEGORY_IMPORTORDER_VEHICLE_QUANTITY_RATE:
                showQuantityRate();
                break;
            case StatisticLib.CATEGORY_IMPORTORDER_VEHICLE_VALUE_PERIOD:
                showValuePeriod();
                break;
            case StatisticLib.CATEGORY_IMPORTORDER_VEHICLE_VALUE_RATE:
                showValueRate();
                break;
            default:
                break;
        }
    }
    private ImportOrderService importOrderService;
    private VehicleService vehicleService;

    /**
     * Creates new form StatisticImportOrder
     */
    public StatisticImportOrder() {
        initComponents();
        importOrderService = ImportOrderService.getInstance();
        vehicleService = VehicleService.getInstance();
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
