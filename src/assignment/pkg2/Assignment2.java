/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import java.util.ArrayList;
import javax.swing.JFrame;

/**
 *
 * @author Akhir
 */
public class Assignment2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        dbconnectivity db = new dbconnectivity();
        admin a;
        a = new admin("Saifullah", "saifullah123", "12345");
        db.ad(a);
        
        a = db.getcourses(a);
        
        
//        int i = 0;
//        int x =0;
//        while(i < a.getcourses().size()){
//            while(x < a.getcourses().get(i).getsec().size()){
//                System.out.println(a.getcourses().get(i).getsec().get(x).getname());
//                x++;
//            }
//            x = 0;
//            i++;
//        }
        
        mainpage mp = new mainpage(a);
        mp.setVisible(true);
        mp.pack();
        mp.setLocationRelativeTo(null);
        mp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
}
