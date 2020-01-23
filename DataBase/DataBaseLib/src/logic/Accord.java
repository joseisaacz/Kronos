/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class Accord {

    private String accNumber;
    private Date incorporatedDate;
    private LocalTime incorporatedTime;
    private Date deadline;
    private  Date sessionDate; 
    private char type;
    private String observations;
    private boolean published;
    private boolean notified;
    private int state;
    List<String> URL;

     public Accord() {
         this.URL=new ArrayList();
         this.type='Z';
         this.accNumber=null;
         this.deadline=null;
         this.incorporatedDate=null;
         this.incorporatedTime=null;
         this.sessionDate=null;
         this.state=-1;
         this.incorporatedTime=null;
    }


    public Accord(String accNumber, Date incorporatedDate, LocalTime incorporatedTime, Date deadline, char type, String observations, boolean published, boolean notified, int state, Date sessionDate) {
        this.accNumber = accNumber;
        this.incorporatedDate = incorporatedDate;
        this.incorporatedTime=incorporatedTime;
        this.deadline = deadline;
        this.type = type;
        this.observations = observations;
        this.published = published;
        this.notified = notified;
        this.state = state;
        this.sessionDate=sessionDate;
        this.URL= new ArrayList();
        this.incorporatedTime=incorporatedTime;
    }
    
    
    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public Date getIncorporatedDate() {
        return incorporatedDate;
    }
    
    public LocalTime getIncorporatedTime() {
        return incorporatedTime;
    }

    public void setIncorporatedDate(Date incorporatedDate) {
        this.incorporatedDate = incorporatedDate;
    }
    
    public void setIncorporatedTime(LocalTime incorporatedTime) {
        this.incorporatedTime = incorporatedTime;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public char getType() {
        return type;
    }

    public void setType(char type) {
        this.type = type;
    }

    public String getObservations() {
        return observations;
    }

    public void setObservations(String observations) {
        this.observations = observations;
    }

    public boolean isPublished() {
        return published;
    }

    public void setPublished(boolean published) {
        this.published = published;
    }

    public boolean isNotified() {
        return notified;
    }

    public void setNotified(boolean notified) {
        this.notified = notified;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Date getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(Date sessionDate) {
        this.sessionDate = sessionDate;
    }

    public List<String> getURL() {
        return URL;
    }

    public void setURL(List<String> URL) {
        this.URL = URL;
    }

    //This method validates if the important fields of the accord are seted
    public static boolean isValidAccord(Accord a){
        
        if(a.getAccNumber()==null || a.getDeadline()==null || a.getSessionDate()==null 
         || a.getIncorporatedDate()==null || a.getObservations()==null )
            return false;
        
        return true;
    }
    
    
    @Override
    public String toString(){
    return String.format("%s", getAccNumber());
    }
}
    