/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest.accord;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import logic.Accord;

/**
 *
 * @author jonathan
 */
public class ToRestAccord {
    /*
    
        All the parameters that logic.Accords has in type Date, has to de setted in
        String because the java serializer cannot parse the class java.util.Date
    
    */
    
    private String accNumber;
    private String incorporatedDate;
    private String deadline;
    private  String sessionDate; 
    private char type;
    private String observations;
    private boolean published;
    private boolean notified;
    private int state;
    List<String> URL= new ArrayList();

    public ToRestAccord() {
        List<String> URL= new ArrayList();
    }

    
    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getIncorporatedDate() {
        return incorporatedDate;
    }

    public void setIncorporatedDate(String incorporatedDate) {
        this.incorporatedDate = incorporatedDate;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    public String getSessionDate() {
        return sessionDate;
    }

    public void setSessionDate(String sessionDate) {
        this.sessionDate = sessionDate;
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

    public List<String> getURL() {
        return URL;
    }

    public void setURL(List<String> URL) {
        this.URL = URL;
    }

    
    //static method to convert a normal accord to a "Rest" accord that
    // not has java.util.Date as atributte
    public static ToRestAccord toRestAcc(Accord a) {
       ToRestAccord rest= new ToRestAccord();
       rest.setAccNumber(a.getAccNumber());
       rest.setNotified(a.isNotified());
       rest.setPublished(a.isPublished());
       rest.setState(a.getState());
       rest.setType(a.getType());
       rest.setURL(a.getURL());
       DateFormat format= new SimpleDateFormat("yyyy-MM-dd");
       rest.setDeadline(format.format(a.getDeadline()));
       rest.setIncorporatedDate(format.format(a.getIncorporatedDate()));
       rest.setSessionDate(format.format(a.getSessionDate()));
       rest.setObservations(a.getObservations());
       return rest;
    }
}
