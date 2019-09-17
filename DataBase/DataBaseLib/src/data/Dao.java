/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.CallableStatement;
import java.sql.Date;
import java.sql.SQLException;

/**
 *
 * @author jonathan
 */
public class Dao {
     private DBConnection db;
    
    public Dao(){
        this.db=new DBConnection();
    }
    
    public void insertAccord(String accNumber, Date incorDate,
            Date deadline, String type, String observations, boolean publics,
            boolean notified, char state ) throws SQLException{
        
             this.db.connect();
             
             CallableStatement statement = this.db.getConnection().prepareCall("{call insertAccord(?, ?, ?, ?, ?, ?, ?, ?)}");
                statement.setString(1, accNumber);
                statement.setDate(2, incorDate);
                statement.setDate(3, deadline);
                statement.setString(4, type);
                statement.setString(5, observations);
                statement.setBoolean(6, publics);
                statement.setBoolean(7, notified);
                statement.setString(8, String.valueOf(state));
                statement.execute();
                statement.close();
                this.db.disconnect();
    }           
}
