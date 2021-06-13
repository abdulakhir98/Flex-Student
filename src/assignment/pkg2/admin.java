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
public class admin extends user{
    private ArrayList <courses> cl;
    private registration r;
    private ArrayList <student> sl;
    private ArrayList <teacher> tl;

    public admin(String name, String username, String password) {
        super(name, username, password);
        r = new registration();
        cl = new ArrayList<courses>();
        sl = new ArrayList<student>();
        tl = new ArrayList<teacher>();
    }
    
    public void setreg(){
        r.setregistrationon();
    }
    
    public void setregoff(){
        r.setregistrationoff();
    }
    
    public void addstudent(String name, String uname, String password){
        student s = new student(name, uname, password);
        sl.add(s);
        s.getadmin(this);
        s.getregistration(r);
    }
    
    public void addteacher(String name, String uname, String password, courses c){
        teacher t = new teacher(name, uname, password, c);
        tl.add(t);
    }
    
    public void addcourse(String cname, String sname, int seats){
        courses c = new courses(cname, sname, seats);
        cl.add(c);
    }
    
//    public void newsection(String cname, String sname, int seats){
//        int count = 0;
//        while(!cl.get(count).getname().equals(cname)){
//            count++;
//        }
//        cl.get(count).newsection(sname, seats);
//    }
    
    public ArrayList<student> getstudents(){
        return sl;
    }
    
    public ArrayList<courses> getcourses(){
        return cl;
    }
    
}