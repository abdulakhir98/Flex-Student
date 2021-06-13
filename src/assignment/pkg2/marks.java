/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

/**
 *
 * @author Akhir
 */
public class marks {
    private int quizs;
    private int assignments;
    private int mids;
    private int finals;
    private courses c;

    public marks(int quizs, int assignments, int mids, int finals, courses c) {
        this.quizs = quizs;
        this.assignments = assignments;
        this.mids = mids;
        this.finals = finals;
        this.c = c;
    }
    
    public void setquizs(int quizs){
        this.quizs = quizs;
    }
    
    public void setassignments(int assignments){
        this.assignments = assignments;
    }
    
    public void setmids(int mids){
        this.mids = mids;
    }
    
    public void setfinals(int finals){
        this.finals = finals;
    }
    
    public courses getcourse(){
        return c;
    }
    
    
}
