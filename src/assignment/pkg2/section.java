/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import java.util.ArrayList;

/**
 *
 * @author Akhir
 */
public class section {
    private String name;
    private ArrayList<student> s;
    private int seats;
    private int mseats;
    
    public section(String name, int mseats) {
        this.name = name;
        this.mseats = mseats;
        seats = 0;
        s = new ArrayList<student>();
    }
    
    public String getname(){
        return name;
    }
    
    public int getseats(){
        return mseats;
    }
    
    public boolean addstudents(student s){
        if(seats <= mseats){
            this.s.add(s);
            seats++;
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean removestudents(student s){
        if(seats > 0){
            this.s.remove(s);
            seats--;
            return true;
        }
        else{
            return false;
        }
    }
    
    public ArrayList getstudents(){
        return s;
    }
    
    public void print(){
        System.out.println(name);
    }
}
