package Connector;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connector {
    String DBurl = "jdbc:mysql://localhost/recruit_db?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
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
            System.out.println("\nfailed " + ex.getMessage());
        }
    }
}
