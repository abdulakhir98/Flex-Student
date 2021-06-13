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
public class user {
    private String name;
    private String username;
    private String password;

    public user(String name, String username, String password) {
        this.name = name;
        this.username = username;
        this.password = password;
    }
    
    public String getname(){
        
        return name;
    }
   
    public String getusername(){
        return username;
    }
    
    public String getpassword(){
        return password;
    }
}
