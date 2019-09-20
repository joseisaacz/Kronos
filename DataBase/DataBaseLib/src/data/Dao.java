/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.CallableStatement;
import java.sql.SQLException;
import logic.Accord;
import java.util.Date;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import logic.TempUser;

/**
 *
 * @author jonathan
 */
public class Dao {

    private DBConnection db;
    private static Dao dao=null;
    
    private Dao() {
        
        this.db = new DBConnection();
    }
    public static Dao getDao(){
        if(dao==null)
           return new Dao();
        else return dao;
           
    }
    public void insertAccord(Accord acc) throws Exception {

        this.db.connect();

        CallableStatement statement = this.db.getConnection().prepareCall("{call insertAccord(?, ?, ?, ?, ?, ?, ?, ?)}");
        statement.setString(1, acc.getAccNumber());
        statement.setDate(2, new java.sql.Date(acc.getIncorporatedDate().getTime()));
        statement.setDate(3, new java.sql.Date(acc.getDeadline().getTime()));
        statement.setString(4, acc.getType());
        statement.setString(5, acc.getObservations());
        statement.setBoolean(6, acc.isPublished());
        statement.setBoolean(7, acc.isNotified());
        statement.setString(8, String.valueOf(acc.getState()));
        statement.executeUpdate();
        statement.close();
        for (String item : acc.getURL()) {
            CallableStatement statement2 = this.db.getConnection().prepareCall("{call insertAccPdf(?, ?)}");
            statement2.setString(1, acc.getAccNumber());
            statement2.setString(2, item);
            statement2.executeUpdate();

            statement2.close();
        }

        this.db.disconnect();
    }

    public void insertTempUser(TempUser tmp) throws Exception {

        this.db.connect();
        CallableStatement statement = this.db.getConnection().prepareCall("{call insertTempUser(?, ?)}");
        statement.setString(1, tmp.getName());
        statement.setString(2, tmp.getEmail());
        statement.executeUpdate();
        statement.close();
        this.db.disconnect();
    }

    public void insertUserAccord(TempUser usr, Accord acc) throws Exception {
        this.db.connect();
        CallableStatement statement = this.db.getConnection().prepareCall("{call insertUserAcc(?, ?)}");
        statement.setString(1, usr.getEmail());
        statement.setString(2, acc.getAccNumber());
        statement.executeUpdate();
        statement.close();
        this.db.disconnect();

    }

    
    public List<Accord> searchAccordByType(String type) throws Exception{
        this.db.connect();
         CallableStatement statement = this.db.getConnection().prepareCall("{call searchAccordType(? )}");
         statement.setString(1, type);
        ResultSet rs =statement.executeQuery();
        List<Accord> list=new ArrayList();
    
        while(rs.next()){
            Accord a=new Accord();
            a.setAccNumber(rs.getString("ACCNUMBER"));
            a.setIncorporatedDate(rs.getDate("INCORDATE"));
            a.setDeadline(rs.getDate("DEADLINE"));
            a.setSessionDate(rs.getDate("SESSIONDATE"));
            a.setType("SESSIONTYPE");
            a.setObservations(rs.getString("OBSERVATIONS"));
            a.setNotified(rs.getBoolean("NOTIFIED"));
            a.setPublished(rs.getBoolean("PUBLIC"));
            a.setState(rs.getString("STATE").charAt(0));
            list.add(a);
        }
        statement.close();
        this.db.disconnect();
        return list;
    }
    
        public List<Accord> searchAccordByAccNumber(String AccNumber) throws Exception{
        this.db.connect();
         CallableStatement statement = this.db.getConnection().prepareCall("{call searchAccordNumber(? )}");
         statement.setString(1, AccNumber);
        ResultSet rs =statement.executeQuery();
        List<Accord> list=new ArrayList();
    
        while(rs.next()){
            Accord a=new Accord();
            a.setAccNumber(rs.getString("ACCNUMBER"));
            a.setIncorporatedDate(rs.getDate("INCORDATE"));
            a.setDeadline(rs.getDate("DEADLINE"));
            a.setSessionDate(rs.getDate("SESSIONDATE"));
            a.setType("SESSIONTYPE");
            a.setObservations(rs.getString("OBSERVATIONS"));
            a.setNotified(rs.getBoolean("NOTIFIED"));
            a.setPublished(rs.getBoolean("PUBLIC"));
            a.setState(rs.getString("STATE").charAt(0));
            list.add(a);
        }
          statement.close();
        this.db.disconnect();
        return list;
    }
    
          public List<Accord> searchAccordByIncorDate(Date incorDate) throws Exception{
        this.db.connect();
         CallableStatement statement = this.db.getConnection().prepareCall("{call searchAccordNumber(? )}");
         statement.setDate(1, new java.sql.Date(incorDate.getTime()));
        ResultSet rs =statement.executeQuery();
        List<Accord> list=new ArrayList();
    
        while(rs.next()){
            Accord a=new Accord();
            a.setAccNumber(rs.getString("ACCNUMBER"));
            a.setIncorporatedDate(rs.getDate("INCORDATE"));
            a.setDeadline(rs.getDate("DEADLINE"));
            a.setSessionDate(rs.getDate("SESSIONDATE"));
            a.setType("SESSIONTYPE");
            a.setObservations(rs.getString("OBSERVATIONS"));
            a.setNotified(rs.getBoolean("NOTIFIED"));
            a.setPublished(rs.getBoolean("PUBLIC"));
            a.setState(rs.getString("STATE").charAt(0));
            list.add(a);
        }
          statement.close();
        this.db.disconnect();
        return list;
    }
    
                public List<Accord> searchAccordBySessionDate(Date SessionDate) throws Exception{
        this.db.connect();
         CallableStatement statement = this.db.getConnection().prepareCall("{call searchAccordNumber(? )}");
         statement.setDate(1, new java.sql.Date(SessionDate.getTime()));
        ResultSet rs =statement.executeQuery();
        List<Accord> list=new ArrayList();
    
        while(rs.next()){
            Accord a=new Accord();
            a.setAccNumber(rs.getString("ACCNUMBER"));
            a.setIncorporatedDate(rs.getDate("INCORDATE"));
            a.setDeadline(rs.getDate("DEADLINE"));
            a.setSessionDate(rs.getDate("SESSIONDATE"));
            a.setType("SESSIONTYPE");
            a.setObservations(rs.getString("OBSERVATIONS"));
            a.setNotified(rs.getBoolean("NOTIFIED"));
            a.setPublished(rs.getBoolean("PUBLIC"));
            a.setState(rs.getString("STATE").charAt(0));
            list.add(a);
        }
          statement.close();
        this.db.disconnect();
        return list;
    }  
          
          
          
}
