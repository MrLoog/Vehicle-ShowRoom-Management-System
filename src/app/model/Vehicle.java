/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

/**
 *
 * @author Administrator
 */
public class Vehicle {
    private Integer id;
    private String name;
    private String brand;
    private Integer price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
