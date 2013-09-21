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
public class Dealer {
    private int id;
    private String name;
    private String loginName;
    private String password;
    private boolean isManager;
    private Date created;
    private Date modified;
    private boolean isDeleted;

    public boolean isIsManager() {
        return isManager;
    }

    public void setIsManager(boolean isManager) {
        this.isManager = isManager;
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

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}
