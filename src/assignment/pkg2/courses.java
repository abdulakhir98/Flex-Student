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
public class courses {
    private String name;
    private ArrayList<section> sec;

    public courses(String name, String sname, int seats) {
        this.name = name;
        sec = new ArrayList<section>();
        newsection(sname, seats);
    }
    
    public void newsection(String sname, int seats){
        section sec1 = new section(sname, seats);
        sec.add(sec1);
    }
    
    public void setsections (ArrayList<section> s){
        this.sec = s;
    }
    
    public void addstudents(String sname, student s){
        int count = 0;
        while(!sec.get(count).getname().equals(sname)){
            count++;
        }
        if(sec.get(count).addstudents(s));
    }
    
    public void removestudents(String sname, student s){
        int count = 0;
        while(!sec.get(count).getname().equals(sname)){
            count++;
        }
        if(sec.get(count).removestudents(s));
    }
    
    public String getname(){
        return name;
    }
    
    public ArrayList<section> getsec(){
        return sec;
    }
    
    public void print(){
        System.out.println(name);
    }
    
}
