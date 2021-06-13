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
public class teacher extends user{
    private courses c;
    private ArrayList<section> s;
    
    public teacher(String name, String username, String password, courses c) {
        super(name, username, password);
        this.c = c;
        s = new ArrayList<section>();
    }
    
    public void addsection(String sname){
        int count = 0;
        while(c.getsec().get(count).getname() != sname){
            count++;
        }
        s.add(c.getsec().get(count));
    }
}
