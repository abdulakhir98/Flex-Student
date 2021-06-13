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

public class student extends user {
    admin a;
    registration r;
    private ArrayList <courses> c;
    private ArrayList <marks> m;
    
    public student(String name, String uname, String password) {
        super(name, uname, password);
        c = new ArrayList<>();
        m = new ArrayList<>();
        r = null;
    }
    
    public void addcourses(String cname, String sname){
        int count = 0;
        while(!a.getcourses().get(count).getname().equals(cname)){
            count++;
        }
        System.out.println(1);
        courses co = a.getcourses().get(count);
        c.add(co);
        co.addstudents(sname,this);
        marks e = new marks(0,0,0,0,co);
        m.add(e);
    }
    
    public void dropcourse(courses c){
//        int count = 0;
//        while(!a.getcourses().get(count).getname().equals(c.getname())){
//            count++;
//        }
//        this.c.get(count).getsec().get(0).removestudents(this);
        this.c.remove(c);
    }
    
    public void getadmin(admin a){
        this.a = a;
    }
    
    public void getregistration(registration r){
        this.r = r;
    }
    
    public ArrayList<courses> getcourses(){
        return c;
    }
    
    public void print(){
       
    }
    
}