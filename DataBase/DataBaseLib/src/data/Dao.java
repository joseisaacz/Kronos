/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.CallableStatement;
import java.sql.SQLException;
import logic.Accord;
import java.sql.Date;

/**
 *
 * @author jonathan
 */
public class Dao {
     private DBConnection db;
    
    public Dao(){
        this.db=new DBConnection();
    }
    
    public void insertAccord(Accord acc) throws SQLException{
        
             this.db.connect();
             
             CallableStatement statement = this.db.getConnection().prepareCall("{call insertAccord(?, ?, ?, ?, ?, ?, ?, ?)}");
                statement.setString(1, acc.getAccNumber());
                statement.setDate(2, new Date(acc.getIncorporatedDate().getTime()));
                statement.setDate(3, new Date(acc.getDeadline().getTime()));
                statement.setString(4, acc.getType());
                statement.setString(5, acc.getObservations());
                statement.setBoolean(6, acc.isPublished());
                statement.setBoolean(7, acc.isNotified());
                statement.setString(8, String.valueOf(acc.getState()));
                statement.execute();
                statement.close();
                this.db.disconnect();
    }           
}
