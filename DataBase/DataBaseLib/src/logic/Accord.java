/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;




public class Accord {

    private String accNumber;
    private Date incorporatedDate;
    private Date deadline;
    private  Date sessionDate; 
    private String type;
    private String observations;
    private boolean published;
    private boolean notified;
    private char state;
    List<String> URL;

     public Accord() {
    }

    public Accord(String accNumber, Date incorporatedDate, Date deadline, String type, String observations, boolean published, boolean notified, char state, Date sessionDate) {
        this.accNumber = accNumber;
        this.incorporatedDate = incorporatedDate;
        this.deadline = deadline;
        this.type = type;
        this.observations = observations;
        this.published = published;
        this.notified = notified;
        this.state = state;
        this.sessionDate=sessionDate;
        this.URL= new ArrayList();
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

    public void setIncorporatedDate(Date incorporatedDate) {
        this.incorporatedDate = incorporatedDate;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
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

    public char getState() {
        return state;
    }

    public void setState(char state) {
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
    
}
    