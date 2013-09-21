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
public class Customer {
    private int id;
    private String name;
    private String address;
    private String phone;
    private int dealerId;
    private Date created;
    private Date modified;
    private boolean isDeleted;
    private Dealer dealer;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
}
