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
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import logic.TempUser;

/**
 *
 * @author jonathan
 */
public class Dao {

    private DBConnection db;
    private static Dao dao = null;

    private Dao() {

        this.db = new DBConnection();
    }

    public static Dao getDao() {
        if (dao == null) {
            return new Dao();
        } else {
            return dao;
        }

    }

    public void insertAccord(Accord acc) throws Exception {

        this.db.connect();

        CallableStatement statement = this.db.getConnection().prepareCall("{call insertAccord(?, ?, ?, ?, ?, ?, ?, ?)}");
        statement.setString(1, acc.getAccNumber());
        statement.setDate(2, new java.sql.Date(acc.getIncorporatedDate().getTime()));
        statement.setDate(3, new java.sql.Date(acc.getDeadline().getTime()));
        statement.setString(4, String.valueOf(acc.getType()));
        statement.setString(5, acc.getObservations());
        statement.setBoolean(6, acc.isPublished());
        statement.setBoolean(7, acc.isNotified());
        statement.setInt(8, acc.getState());
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

    public List<Accord> searchAccordByType(char type) throws Exception {
        this.db.connect();
        CallableStatement statement = this.db.getConnection().prepareCall("{call searchAccordsessionDate(? )}");
        statement.setString(1,String.valueOf(type));
        ResultSet rs = statement.executeQuery();
        Map<String, Accord> map = new HashMap();

        while (rs.next()) {
            
            String accNumber = rs.getString("ACCNUMBER");
            if (map.isEmpty() || ! map.containsKey(accNumber)) { //if the map is empty or the result isn't
                Accord a = new Accord();                                           //in the map
                a.setAccNumber(accNumber);
                a.setIncorporatedDate(rs.getDate("INCORDATE"));
                a.setDeadline(rs.getDate("DEADLINE"));
                a.setSessionDate(rs.getDate("SESSIONDATE"));
                a.setType(rs.getString("TYPE_ID").charAt(0));
                a.setObservations(rs.getString("OBSERVATIONS"));
                a.setNotified(rs.getBoolean("NOTIFIED"));
                a.setPublished(rs.getBoolean("PUBLIC"));
                a.setState(rs.getInt("STATE"));
                a.getURL().add(rs.getString("URL"));
                map.put(accNumber, a);
            }
            else {
                    //if the result isn't  in the map or the map isn't empty, just add the URL into result
                    map.get(accNumber).getURL().add(rs.getString("URL"));
                
            }
        }
       
        statement.close();
        this.db.disconnect();
       return new ArrayList<Accord>(map.values());
    }

    public Accord getAccordByAccNumber(String AccNumber) throws Exception {
        this.db.connect();
        CallableStatement statement = this.db.getConnection().prepareCall("{call searchAccordNumber(? )}");
        statement.setString(1, AccNumber);
        ResultSet rs = statement.executeQuery();
        List<Accord> list = new ArrayList();
        boolean flag = false;
        Accord a = null;
        while (rs.next()) {
            if (!flag) {
                a = new Accord();
                a.setAccNumber(rs.getString("ACCNUMBER"));
                a.setIncorporatedDate(rs.getDate("INCORDATE"));
                a.setDeadline(rs.getDate("DEADLINE"));
                a.setSessionDate(rs.getDate("SESSIONDATE"));
                a.setType(rs.getString("TYPE_ID").charAt(0));
                a.setObservations(rs.getString("OBSERVATIONS"));
                a.setNotified(rs.getBoolean("NOTIFIED"));
                a.setPublished(rs.getBoolean("PUBLIC"));
                a.setState(rs.getInt("STATE"));
                a.getURL().add(rs.getString("URL"));
            } else {
                a.getURL().add(rs.getString("URL"));
            }

            flag = true;
        }

        statement.close();
        this.db.disconnect();   

        return a;
    }

      public List<Accord> searchAccordBySessionDate(Date SessionDate) throws Exception {
        this.db.connect();
        CallableStatement statement = this.db.getConnection().prepareCall("{call searchAccordsessionDate(? )}");
        statement.setDate(1, new java.sql.Date(SessionDate.getTime()));
        ResultSet rs = statement.executeQuery();
        Map<String, Accord> map = new HashMap();

        while (rs.next()) {
            
            String accNumber = rs.getString("ACCNUMBER");
            if (map.isEmpty() || ! map.containsKey(accNumber)) { //if the map is empty or the result isn't
                Accord a = new Accord();                                                 //in the map
                a.setAccNumber(accNumber);
                a.setIncorporatedDate(rs.getDate("INCORDATE"));
                a.setDeadline(rs.getDate("DEADLINE"));
                a.setSessionDate(rs.getDate("SESSIONDATE"));
                a.setType(rs.getString("TYPE_ID").charAt(0));
                a.setObservations(rs.getString("OBSERVATIONS"));
                a.setNotified(rs.getBoolean("NOTIFIED"));
                a.setPublished(rs.getBoolean("PUBLIC"));
                a.setState(rs.getInt("STATE"));
                a.getURL().add(rs.getString("URL"));
                map.put(accNumber, a);
            }
            else {
                    //if the result isn't  in the map or the map isn't empty, just add the URL into result
                    map.get(accNumber).getURL().add(rs.getString("URL"));
                
            }
        }
       
        statement.close();
        this.db.disconnect();
       return new ArrayList<>(map.values());
    }

    public List<Accord> searchAccordByIcorporatedDate(Date Incorporated) throws Exception {
        this.db.connect();
        CallableStatement statement = this.db.getConnection().prepareCall("{call searchAccordIncorDate(? )}");
        statement.setDate(1, new java.sql.Date(Incorporated.getTime()));
        ResultSet rs = statement.executeQuery();
        Map<String, Accord> map = new HashMap();

        while (rs.next()) {
       
            String accNumber = rs.getString("ACCNUMBER");
            if (map.isEmpty() || ! map.containsKey(accNumber)) { //if the map is empty or the result isn't
                Accord a = new Accord();                                                 //in the map
                a.setAccNumber(accNumber);
                a.setIncorporatedDate(rs.getDate("INCORDATE"));
                a.setDeadline(rs.getDate("DEADLINE"));
                a.setSessionDate(rs.getDate("SESSIONDATE"));
                a.setType(rs.getString("TYPE_ID").charAt(0));
                a.setObservations(rs.getString("OBSERVATIONS"));
                a.setNotified(rs.getBoolean("NOTIFIED"));
                a.setPublished(rs.getBoolean("PUBLIC"));
                a.setState(rs.getInt("STATE"));
                a.getURL().add(rs.getString("URL"));
                map.put(accNumber, a);
            }
            else {
                    //if the result isn't  in the map or the map isn't empty, just add the URL into result
                    map.get(accNumber).getURL().add(rs.getString("URL"));
                
            }
        }
       
        statement.close();
        this.db.disconnect();
       return new ArrayList<>(map.values());
    }

}
