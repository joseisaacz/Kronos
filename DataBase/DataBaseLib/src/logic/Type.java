/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logic;

/**
 *
 * @author djnane
 */
public class Type {

    private char id;
    private String description;

    public Type(char id, String description) {
        this.id = id;
        this.description = description;
    }
    
    public Type(){
    
    }
    

    public char getId() {
        return id;
    }

    public void setId(char id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return String.format("%c - %s", id, description);
    }


}
