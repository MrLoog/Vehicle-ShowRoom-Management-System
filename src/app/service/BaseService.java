/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app.service;

import app.utility.AppUtility;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Administrator
 */
public abstract class BaseService {

    protected Connection conn;
    protected Statement stmt;
    protected PreparedStatement insertStmt;
    protected PreparedStatement updateStmt;
    protected PreparedStatement deleteStmt;
    protected ResultSet rs;

    public BaseService() {
        conn = AppUtility.getConnection();
        try {
            insertStmt = conn.prepareStatement(getQueryInsert(), Statement.RETURN_GENERATED_KEYS);
            updateStmt = conn.prepareStatement(getQueryUpdate());
            deleteStmt = conn.prepareStatement(getQueryDelete());
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public <T> T getById(int id) {
        List<T> output = new ArrayList<T>();
        try {
            stmt = conn.createStatement();
            String sql = "select * from " + getTableName() + " where ID=" + id;
            rs = stmt.executeQuery(sql);
            output = ResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        if (output.size() > 0) {
            return output.get(0);
        }
        return null;
    }

    public <T> List<T> getAll() {
        List<T> output = new ArrayList<T>();
        try {
            stmt = conn.createStatement();
            String sql = "select * from " + getTableName();
            rs = stmt.executeQuery(sql);
            output = ResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return output;
    }

    public <T> int add(T newobject) {
        int newId = -1;
        try {
            setParameterForInsert(newobject);
            insertStmt.executeUpdate();
            rs = insertStmt.getGeneratedKeys();
            if (rs.next()) {
                newId = rs.getInt(1);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return newId;
    }

    public <T> boolean update(T updateobject) {
        boolean output = false;
        try {
            setParameterForUpdate(updateobject);
            int result = updateStmt.executeUpdate();
            if (result > 0) {
                output = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    public boolean delete(Object delobject) {
        boolean output = false;
        try {
            setParameterForDelete(delobject);
            int result = deleteStmt.executeUpdate();
            if (result > 0) {
                output = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
    

    public <T> List<T> executeQuery(String query) {
        List<T> output = new ArrayList<T>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            output = ResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return output;
    }

    public List<Integer> executeQueryGetListID(String query) {
        List<Integer> output = new ArrayList<Integer>();
        try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);
            while (rs.next()) {
                output.add(rs.getInt("ID"));
            }
            output = ResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return output;
    }

    public <T> List<T> executePrepareStmt(PreparedStatement ps) {
        List<T> output = new ArrayList<T>();
        try {
            rs = ps.executeQuery();
            output = ResultSetToList(rs);
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return output;
    }

    public int executePrepareStmtCount(PreparedStatement ps) {
        int output = 0;
        try {
            rs = ps.executeQuery();
            if (rs.next()) {
                output = rs.getInt("total");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return output;
    }

    public abstract String getTableName();

    protected abstract <T> List<T> ResultSetToList(ResultSet rs);

    protected abstract String getQueryInsert();

    protected abstract void setParameterForInsert(Object obj);

    protected abstract String getQueryUpdate();

    protected abstract void setParameterForUpdate(Object obj);

    protected abstract String getQueryDelete();

    protected abstract void setParameterForDelete(Object obj);

    public String BuildPagingSql(String tablename, String condition, int perpage, int page, AtomicReference<Integer> total) {
        String output = "";
        output = "select * from ( select *,ROW_NUMBER() OVER (ORDER BY ID) AS RowNum from "
                + tablename;
        String count = "select COUNT(*) as total from " + tablename;
        if (condition != null) {
            output += " where " + condition;
            count += " where " + condition;
        }
        output += " ) as SOD Where SOD.RowNum BETWEEN ((" + page + "-1)*" + perpage + ")+1 AND " + perpage + "*" + page;
        try {
            total.set(executePrepareStmtCount(conn.prepareStatement(count)));
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }

    public String BuildPagingSql(String how, int perpage, int page, AtomicReference<Integer> total) {
        String output = "";
        output = "select * from ( select *,ROW_NUMBER() OVER (ORDER BY ID) AS RowNum "
                + how;
        String count = "select COUNT(*) as total " + how;
        output += " ) as SOD Where SOD.RowNum BETWEEN ((" + page + "-1)*" + perpage + ")+1 AND " + perpage + "*" + page;
        try {
            total.set(executePrepareStmtCount(conn.prepareStatement(count)));
        } catch (SQLException ex) {
            Logger.getLogger(BaseService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return output;
    }
}
