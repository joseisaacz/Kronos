/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.Date;

/**
 *
 * @author djenane
 */
public class pruebas {
    
    
    public static void main(String[] args) throws Exception{
    DBConnection db = new DBConnection();
    db.connect();
    Dao d= Dao.getDao();
    System.out.print(db.getConnection());
    System.out.println("\n");
    Date date1 = new Date(2019,8,11);
    Date today = new Date();
    System.out.print(d.searchAccordByExpiredDate(date1, today).toString());
    System.out.println("\n");
   // System.out.println(d.getAllType().toString());
    
    
    
   
    
    }
    
}
