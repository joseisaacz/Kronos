/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logicWeb;

/**
 *
 * @author jose
 */
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Singleton;
 
   @Singleton
public class Scheduled {
@Schedules({

   @Schedule(dayOfMonth="*"),
   @Schedule(dayOfWeek="Fri", minute="00" , hour="12",persistent = false)
    })
  //@Schedule(second = "*/5", minute = "*", hour = "*", persistent = false) 
// 
 public void atSchedule() throws Exception {
    SendEmail email=new SendEmail("la pura papa", "la papa", "djenane114@gmail.com");
     email.send();
        System.out.println("hola");
    }
 

 
   // @Schedule(second = "*/5", minute = "*", hour = "*", persistent = false)
   // public void atSchedule() throws InterruptedException {
        //System.out.println("DeclarativeScheduler:: In atSchedule()");
    
//}
}
