/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.sql.Date;

/**
 *
 * @author Administrator
 */
public class ImportOrder {

    private Integer id;
    private Integer price;
    private int vehicleID;
    private int quantity;
    private int dealerId;
    private Date created;
    private Date modified;
    private boolean isDeleted;
    private Vehicle vehicle;
    private Dealer dealer;
    private int DealerModifiedID;
    private Dealer DealerModified;

    public int getDealerModifiedID() {
        return DealerModifiedID;
    }

    public void setDealerModifiedID(int DealerModifiedID) {
        this.DealerModifiedID = DealerModifiedID;
    }

    public Dealer getDealerModified() {
        return DealerModified;
    }

    public void setDealerModified(Dealer DealerModified) {
        this.DealerModified = DealerModified;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public boolean isIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    public int getDealerId() {
        return dealerId;
    }

    public void setDealerId(int dealerId) {
        this.dealerId = dealerId;
    }

    public int getVehicleID() {
        return vehicleID;
    }

    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
