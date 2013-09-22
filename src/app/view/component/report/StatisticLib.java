/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.view.component.report;

import app.view.Main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class StatisticLib {

    private HashMap<Integer, String> map = new HashMap<Integer, String>();

    public StatisticLib() {
        initMap();
    }
    public static final int STEP_DATE = 1;
    public static final int STEP_MONTH = 2;
    public static final int STEP_YEAR = 3;
    //constant category
    public static final int CATEGORY_VEHICLE = 1;
    public static final int CATEGORY_ORDER = 2;
    public static final int CATEGORY_IMPORTORDER = 3;
    public static final int CATEGORY_CUSTOMER = 4;
    public static final int CATEGORY_DEALER = 5;
    //constant label statistic
    public static final int CATEGORY_VEHICLE_IN_STORE = 6;
    public static final int CATEGORY_VEHICLE_SELL = 7;
    public static final int CATEGORY_ORDER_REVENUE = 11;
    public static final int CATEGORY_ORDER_STATUS = 12;
    public static final int CATEGORY_IMPORTORDER_VEHICLE_QUANTITY_PERIOD = 16;
    public static final int CATEGORY_IMPORTORDER_VEHICLE_VALUE_PERIOD = 17;
    public static final int CATEGORY_IMPORTORDER_VEHICLE_QUANTITY_RATE = 18;
    public static final int CATEGORY_IMPORTORDER_VEHICLE_VALUE_RATE = 19;
    public static final int CATEGORY_CUSTOMER_BUY = 21;
    public static final int CATEGORY_CUSTOMER_BUY_ALL = 22;
    public static final int CATEGORY_DEALER_SELL = 26;
    public static final int CATEGORY_DEALER_SELL_ALL = 27;

    //change this when change constant
    private void initMap() {
        HashMap<Integer, String> lst = new HashMap<Integer, String>();
        lst.put(CATEGORY_VEHICLE, getStringForConstant(CATEGORY_VEHICLE));
        lst.put(CATEGORY_ORDER, getStringForConstant(CATEGORY_ORDER));
        lst.put(CATEGORY_IMPORTORDER, getStringForConstant(CATEGORY_IMPORTORDER));
        lst.put(CATEGORY_CUSTOMER, getStringForConstant(CATEGORY_CUSTOMER));
        lst.put(CATEGORY_DEALER, getStringForConstant(CATEGORY_DEALER));

        lst.put(CATEGORY_VEHICLE_IN_STORE, getStringForConstant(CATEGORY_VEHICLE_IN_STORE));
        lst.put(CATEGORY_VEHICLE_SELL, getStringForConstant(CATEGORY_VEHICLE_SELL));

        lst.put(CATEGORY_ORDER_REVENUE, getStringForConstant(CATEGORY_ORDER_REVENUE));
        lst.put(CATEGORY_ORDER_STATUS, getStringForConstant(CATEGORY_ORDER_STATUS));

        lst.put(CATEGORY_IMPORTORDER_VEHICLE_QUANTITY_PERIOD, getStringForConstant(CATEGORY_IMPORTORDER_VEHICLE_QUANTITY_PERIOD));
        lst.put(CATEGORY_IMPORTORDER_VEHICLE_VALUE_PERIOD, getStringForConstant(CATEGORY_IMPORTORDER_VEHICLE_VALUE_PERIOD));
        lst.put(CATEGORY_IMPORTORDER_VEHICLE_QUANTITY_RATE, getStringForConstant(CATEGORY_IMPORTORDER_VEHICLE_QUANTITY_RATE));
        lst.put(CATEGORY_IMPORTORDER_VEHICLE_VALUE_RATE, getStringForConstant(CATEGORY_IMPORTORDER_VEHICLE_VALUE_RATE));

        lst.put(CATEGORY_CUSTOMER_BUY, getStringForConstant(CATEGORY_CUSTOMER_BUY));
        lst.put(CATEGORY_CUSTOMER_BUY_ALL, getStringForConstant(CATEGORY_CUSTOMER_BUY_ALL));

        lst.put(CATEGORY_DEALER_SELL, getStringForConstant(CATEGORY_DEALER_SELL));
        lst.put(CATEGORY_DEALER_SELL_ALL, getStringForConstant(CATEGORY_DEALER_SELL_ALL));
        map = lst;
    }

    //change this when change constant
    public String getStringForConstant(int constant) {
        switch (constant) {
            case CATEGORY_VEHICLE:
                return "Statistic Vehicle";
            case CATEGORY_ORDER:
                return "Statistic Order";
            case CATEGORY_IMPORTORDER:
                return "Statistic Import";
            case CATEGORY_CUSTOMER:
                return "Statistic Customer";
            case CATEGORY_DEALER:
                return "Statistic Dealer";

            case CATEGORY_VEHICLE_IN_STORE:
                return "Vehicle in Store";
            case CATEGORY_VEHICLE_SELL:
                return "Vehicle Sell";
            case CATEGORY_ORDER_REVENUE:
                return "Revenue Over Period";
            case CATEGORY_ORDER_STATUS:
                return "View Order Status";
            case CATEGORY_IMPORTORDER_VEHICLE_QUANTITY_PERIOD:
                return "Vehicle Import Quantity(Bar Chart)";
            case CATEGORY_IMPORTORDER_VEHICLE_VALUE_PERIOD:
                return "Vehicle Import Value(Bar Chart)";
            case CATEGORY_IMPORTORDER_VEHICLE_QUANTITY_RATE:
                return "Vehicle Import Quantity(Pie Chart)";
            case CATEGORY_IMPORTORDER_VEHICLE_VALUE_RATE:
                return "Vehicle Import value(Pie Chart)";
            case CATEGORY_CUSTOMER_BUY:
                return "Top " + Main.LIMIT + " Customer By Order Price";
            case CATEGORY_CUSTOMER_BUY_ALL:
                return "All Customer By Order Price";
            case CATEGORY_DEALER_SELL:
                return "Top " + Main.LIMIT + " Dealer By Order Price";
            case CATEGORY_DEALER_SELL_ALL:
                return "All Dealer By Order Price";
            default:
                return "";
        }
    }

    public List<String> getListCategory() {
        List<String> lst = new ArrayList<String>();
        lst.add(getStringForConstant(CATEGORY_VEHICLE));
        lst.add(getStringForConstant(CATEGORY_ORDER));
        lst.add(getStringForConstant(CATEGORY_IMPORTORDER));
        lst.add(getStringForConstant(CATEGORY_CUSTOMER));
        lst.add(getStringForConstant(CATEGORY_DEALER));
        return lst;
    }

    public List<String> getSubListofCategory(int category) {
        List<String> lst = new ArrayList<String>();
        switch (category) {
            case CATEGORY_VEHICLE:
                lst.add(getStringForConstant(CATEGORY_VEHICLE_IN_STORE));
                lst.add(getStringForConstant(CATEGORY_VEHICLE_SELL));
                break;
            case CATEGORY_ORDER:
                lst.add(getStringForConstant(CATEGORY_ORDER_REVENUE));
                lst.add(getStringForConstant(CATEGORY_ORDER_STATUS));
                break;
            case CATEGORY_IMPORTORDER:
                lst.add(getStringForConstant(CATEGORY_IMPORTORDER_VEHICLE_QUANTITY_PERIOD));
                lst.add(getStringForConstant(CATEGORY_IMPORTORDER_VEHICLE_QUANTITY_RATE));
                lst.add(getStringForConstant(CATEGORY_IMPORTORDER_VEHICLE_VALUE_PERIOD));
                lst.add(getStringForConstant(CATEGORY_IMPORTORDER_VEHICLE_VALUE_RATE));
                break;
            case CATEGORY_CUSTOMER:
                lst.add(getStringForConstant(CATEGORY_CUSTOMER_BUY));
                lst.add(getStringForConstant(CATEGORY_CUSTOMER_BUY_ALL));
                break;
            case CATEGORY_DEALER:
                lst.add(getStringForConstant(CATEGORY_DEALER_SELL));
                lst.add(getStringForConstant(CATEGORY_DEALER_SELL_ALL));
                break;
            default:
                break;
        }
        return lst;
    }

    public int getConstantByString(String pattern) {
        Set<Entry<Integer, String>> entrySet = map.entrySet();
        for (Entry<Integer, String> entry : entrySet) {
            if (entry.getValue().equals(pattern)) {
                return entry.getKey();
            }
        }
        return -1;
    }
}
