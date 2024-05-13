/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Assignment2;

import java.sql.*;

/**
 *
 * @author ACER
 */
public class Connector {
    String DBurl = "jdbc:mysql://localhost/student_db";
    String DBusername = "root";
    String DBpassword = "";
    
    public Connection conn;
    Statement statement;
    
    public Connector(){
        try{

            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("connection success");
        }
        catch(Exception ex){
            System.out.println("failed" + ex.getMessage());
        }
    }
    
    

   
    


    public Object createStatement() {
        
        throw new UnsupportedOperationException("Unimplemented method 'createStatement'");
        
    }
    
}
 