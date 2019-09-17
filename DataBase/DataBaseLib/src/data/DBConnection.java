/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jonathan
 */
public class DBConnection {
     private  Connection cnx;
     private final String driver = "com.mysql.jdbc.Driver";
     private final String server ="localhost";
     private final String port = "3306";
     private final String user = "root";
     private final String password = "root";
     private final String database = "KRONOS";
     private final String URL_connection="jdbc:mysql://"+ server+":"+port+"/"+
     database+"?user="+user+"&password="+password+"&zeroDateTimeBehavior=convertToNull&useSSL=false";
     
    public DBConnection(){
        this.cnx=null;
    }
    
 
    public void connect(){
       /*
        Create a Mysql connection everytime this method is called
      */
        try {
            Class.forName(driver).newInstance();
           this.cnx = DriverManager.getConnection(URL_connection);
           this.cnx.setAutoCommit(false);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.exit(-1);
        } 
    }
    
  
    public void disconnect(){
          /*
        
        close the connection everytime this method is called
          */
        
        
        try {
            if(!cnx.isClosed()){
            this.cnx.close();
            this.cnx=null;
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
     public int executeUpdate(String statement) {
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(statement);
            cnx.commit();
            return stm.getUpdateCount();
        } catch (SQLException ex) {
            return 0;
        }
    }
    public ResultSet executeQuery(String statement){
        try {
            Statement stm = cnx.createStatement();
            ResultSet rs= stm.executeQuery(statement);
            cnx.commit();
            return rs;
        } catch (SQLException ex) {
        }
        return null;
    }
    
    public int executeUpdateWithKeys(String statement) {
        try {
            Statement stm = cnx.createStatement();
            stm.executeUpdate(statement,Statement.RETURN_GENERATED_KEYS);
            ResultSet keys = stm.getGeneratedKeys();
            keys.next();
            int a= keys.getInt(1);
            cnx.commit();
            return a;
            
        } catch (SQLException ex) {
            return -1;
        }
    }    
    public Connection getConnection(){
        return this.cnx;
    }
}
