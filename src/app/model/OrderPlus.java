/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

/**
 *
 * @author kiendv
 */
public class OrderPlus {
    int oid;
    String cname;
    int oprice;
    String dname;
    String vname;
    String brand;
    int stt;

    public OrderPlus(int oid, String cname, int oprice, String dname, String vname, String brand, int stt) {
        this.oid = oid;
        this.cname = cname;
        this.oprice = oprice;
        this.dname = dname;
        this.vname = vname;
        this.brand = brand;
        this.stt = stt;
    }

    public OrderPlus() {
    }

    public int getOid() {
        return oid;
    }

    public void setOid(int oid) {
        this.oid = oid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getOprice() {
        return oprice;
    }

    public void setOprice(int oprice) {
        this.oprice = oprice;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname;
    }

    public String getVname() {
        return vname;
    }

    public void setVname(String vname) {
        this.vname = vname;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getStt() {
        return stt;
    }

    public void setStt(int stt) {
        this.stt = stt;
    }
    
}
