/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

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
    
    System.out.print(d.getAllType().toString());
    
    
   
    
    }
    
}
