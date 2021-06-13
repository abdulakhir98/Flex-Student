/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment.pkg2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Akhir
 */
public class dbconnectivity {
    teacher t;
    student s;
    Connection con;
    Statement stat;
    admin a;
    
    public dbconnectivity(){
        try{
            String s1 = "jdbc:sqlserver://localhost:1433;databaseName=manage";
            con = DriverManager.getConnection(s1, "shan", "51214" );
            
            stat = con.createStatement();
        }
        catch(Exception e){
             System.out.println(e);
        }
    }
    
    public void setregistration(){
        try{
            String Query = "UPDATE ADMINCHECK SET REGCHECK = 1 WHERE SERIAL = 1";        
            stat.executeUpdate(Query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public void stopregistration(){
        try{
            String Query = "UPDATE ADMINCHECK SET REGCHECK = 0 WHERE SERIAL = 1";        
            stat.executeUpdate(Query);
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public ResultSet checkregistration(){
        try{
            String s2 = "select * from admincheck";
            ResultSet rs = stat.executeQuery(s2);
            return rs;
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public int adminlogin(String user, String pass){
        try{
            String s2 = "select username,password from adminlogin where username = '" + user + "'";
            ResultSet rs = stat.executeQuery(s2);
            if(rs.next()){
                if(rs.getString("password").equals(pass)){
                    return 1;
                }
                else{
                    return -1;
                }
            }
            return 0;
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }   
    
    public int studentlogin(String user, String pass){
        try{
            String s2 = "select username,password from studentlogin where username = '" + user + "'";
            ResultSet rs = stat.executeQuery(s2);
            if(rs.next()){
                if(rs.getString("password").equals(pass)){
                    return 1;
                }
                else{
                    return -1;
                }
            }
            return 0;
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
    
    public int teacherlogin(String user, String pass){
        try{
            String s2 = "select username,password from teacherlogin where username = '" + user + "'";
            ResultSet rs = stat.executeQuery(s2);
            if(rs.next()){
                if(rs.getString("password").equals(pass)){
                    return 1;
                }
                else{
                    return -1;
                }
            }
            return 0;
        }
        catch(Exception e){
            System.out.println(e);
            return 0;
        }
    }
    
    public admin getad(String username){
        try{
            admin temp;
            String s2 = "select name, username, password from adminlogin where username = '" + username + "'";
            ResultSet rs = stat.executeQuery(s2);
            while(rs.next()){
                temp = new admin(rs.getString("name"),rs.getString("username"),rs.getString("password"));
                return temp;
            }
            return null;
            
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }   
    
    public student getst(String username){
        try{
            student temp;
            String s2 = "select name, username, password from studentlogin where username = '" + username + "'";
            ResultSet rs = stat.executeQuery(s2);
            while(rs.next()){
                temp = new student(rs.getString("name"),rs.getString("username"), rs.getString("password"));
                return temp;
            }
            return null;
            
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }   
    
    public teacher gett(String username){
        try{
            teacher temp;
            String s1 = "select course from teacherlogin where username = '" + username + "'";
            ResultSet rs1 = stat.executeQuery(s1);
            int count = 0;
            while(!a.getcourses().get(count).getname().equals(rs1.getString(1))){
                count++;
            }
            courses c = a.getcourses().get(count);
            String s2 = "select name, username, password, course from teacherlogin where username = '" + username + "'";
            ResultSet rs = stat.executeQuery(s2);
            System.out.println(2);
            while(rs.next()){
                temp = new teacher(rs.getString("name"),rs.getString("username"), rs.getString("password"), c);
                return temp;
            }
            return null;
            
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }   
    
    public String getteacher(String username){
        try{
            String s2 = "select name, username, password, course from teacherlogin where username = '" + username + "'";
            ResultSet rs = stat.executeQuery(s2);
            while(rs.next()){
                return (String) rs.getString("course");
            }
            return null;
            
        }
        catch(Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public void ad(admin a){
        try{
            String s2 = "Insert into adminlogin values ('" + a.getname() + "'," + "'" + a.getusername() + "'," + "'" + a.getpassword() + "')";
            ResultSet rs = stat.executeQuery(s2);
            
        }
        catch(Exception e){
            System.out.println(e);
        }
    } 
   
    public admin getcourses(admin a){
        try{
            ArrayList <String> list = new ArrayList();
            this.a = a;
            String temp = null;
            String s = "select name from courselist";
            ResultSet rs = stat.executeQuery(s);
            while(rs.next()){
                if(!rs.getString("name").equals(temp))
                    list.add(rs.getString("name"));
                    temp = rs.getString("name");
            }
            int i = 0;
            while(i < list.size()){
                String s2 = "Select name,section,seats from courselist where name = '" + list.get(i) + "'";
                stat = con.createStatement();
                ResultSet rs2 = stat.executeQuery(s2);
                if(rs2.next()){
                    this.a.addcourse((String) rs2.getString("name"),(String) rs2.getString("section"), rs2.getInt("seats"));
                }
                while(rs2.next()){
                    int count = 0;
                    while(!this.a.getcourses().get(count).getname().equals(rs2.getString("name"))){
                        count++;
                    }
                    this.a.getcourses().get(count).newsection(rs2.getString("section"), rs2.getInt("seats"));
                }
                i++;
            }
            
//            while (rs.next()) {
//               if(rs.getString("name").equals(temp)){
//                   this.a.newsection((String) rs.getString("name"),(String) rs.getString("section"), rs.getInt("seats"));
//                   System.out.println(temp);
//               }
//               else{
//                    this.a.addcourse((String) rs.getString("name"),(String) rs.getString("section"), rs.getInt("seats"));
//                    temp = rs.getString("name");
//               }
//               
//            }
            return this.a;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public student getstdcourses(student st){
        try{
            a = getad("saifullah123");
            a = getcourses(a);
            s = st;
            s.getadmin(a);
            String s1 = "select course, section from registration where username = '" + s.getusername() + "'";
            ResultSet rs = stat.executeQuery(s1);
            while (rs.next()) {
               s.addcourses((String) rs.getString("course"), (String) rs.getString("section"));
            }
            return s;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public ResultSet getsections(String cname){
        try{
            String s = "select section from courselist where name = '" + cname + "'";
            ResultSet rs = stat.executeQuery(s);
            return rs;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public ArrayList setcourses(){
        try{
            ArrayList<String> a = new ArrayList();
            String s = "select course from courselist";
            ResultSet rs = stat.executeQuery(s);
            while (rs.next()) {
               a.add(rs.getString("course"));
            }
            return a;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public ResultSet subject(String b){
        try{
            String a = b;
            String s = "select section from sectionlist join courselist on sectionlist.courseid = courselist.courseid where course = '" + a + "'";
            ResultSet rs = stat.executeQuery(s);
            return rs;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public void dbsave(student st){
        s = st;
        try{
            ArrayList <courses> c = new ArrayList();
            c = s.getcourses();
            String r = s.getusername();
            for(int i = 0; i < c.size(); i++){
                String s1 = "INSERT INTO registration (username, course, section) values ('" + r + "' ,'" + s.getcourses().get(i).getname() + "','" + s.getcourses().get(i).getsec().get(0).getname() +  "')";
                stat.executeUpdate(s1);
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
    public ResultSet show(student st){
        try{
            s = st;
            String a = s.getusername();
            String s = "select username from registration where username = '" + a + "'";
            ResultSet rs = stat.executeQuery(s);
            return rs;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public void dbremove(student st, String course){
        s = st;
        ResultSet rs;
        try{
            String s1 = "select username from registration where course = '" + course + "'";
            rs = stat.executeQuery(s1);
            if(rs.next()){
                String s2 = "Delete from registration where username = '" + s.getusername() + "' and course = '" + course + "'";
                stat.executeUpdate(s2);
            }
        }
        catch(Exception e){
            
            System.out.println(e);
        }
    }
         
    public ArrayList<String> gettcourse(teacher t){
        try{
            ArrayList<String> tcourse = new ArrayList();
            this.t = t;
            System.out.println(t.getusername());
            String s1 = "select course from teacherlogin where username = '" + t.getusername() + "'";
            ResultSet rs = stat.executeQuery(s1);
            while (rs.next()) {
               tcourse.add(rs.getString(0));
            }
            return tcourse;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public ResultSet getstudents(String cname, String sname){
        try{
            String s = "select username from registration where course = '" + cname + "' and section = '" + sname + "'";
            
            stat = con.createStatement();
            ResultSet rs = stat.executeQuery(s);
            return rs;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public void insertmarks(String rollno, String course, String quizzes, String mid1, String mid2, String final1){
        try{
            
            String s1 = "INSERT INTO markstable (username, course, quizzes, mid1, mid2, final) values ('" + rollno + "' ,'" + course + "','" + quizzes + "','" + mid1 + "','" + mid2 + "','" + final1 +  "')";
            stat.executeUpdate(s1);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
    
    public ResultSet getmarks(String rollno, String course){
        try{
            ResultSet rs;
            String s1 = "Select quizzes, mid1, mid2, final from markstable where username ='" + rollno + "' and course = '" + course + "'";
            rs = stat.executeQuery(s1);
            return rs;
        }
        catch (Exception e){
            System.out.println(e);
            return null;
        }
    }
    
    public void insertgrade(String rollno, String course, String grade){
        try{
            String s1 = "INSERT INTO grade (username, course, grade) values ('" + rollno + "' ,'" + course + "','" + grade + "')";
            stat.executeUpdate(s1);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
