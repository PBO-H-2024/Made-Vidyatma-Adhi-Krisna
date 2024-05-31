package Model;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Connector.Connector;
import Controller.Controller;

public class RecruitModel extends Connector {
    private String name, path, status;
    private double writing, coding, interview, totalScore;
    private Statement statement;

    public RecruitModel(String name, String path, double writing, double coding, double interview, double totalScore , String status){
        this.name = name;
        this.path = path;
        this.writing = writing;
        this.coding = coding;
        this.interview = interview;
        this.totalScore = totalScore;
        this.status = status;
    }

    //constuctor kosong biar instance model bisa di panggil di controller
    public RecruitModel(Controller controller) {
        
    }

    // method untuk membaca data mahasiswa dari database
    @SuppressWarnings("finally")
    public String[][] readData() {
        String data[][] = new String[100][7];
        try {
            int totalData = 0;
            String query = "SELECT * FROM recruitment;";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data[totalData][0] = resultSet.getString("name");
                data[totalData][1] = resultSet.getString("path");
                data[totalData][2] = resultSet.getString("writing");
                data[totalData][3] = resultSet.getString("coding");
                data[totalData][4] = resultSet.getString("interview");
                data[totalData][5] = resultSet.getString("score");
                data[totalData][6] = resultSet.getString("status");
                totalData++;
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("SQL Error : " + e.getMessage());
        } finally {
            return data;
        }
    }

     // method untuk insert data baru ke dalam database
     public void insertData(String name, String path, double writing, double coding, double interview, double totalScore, String status ) {
        System.out.println(name + path + writing + coding + interview + totalScore + status);
        try {
            String query = "INSERT INTO `recruitment`(`name`,`path`,`writing`,`coding`,`interview`,`score`,`status`) VALUES ('" + name + "','" + path + "','" + writing + "','" + coding + "','" + interview + "','" + totalScore + "','" + status + "')"; 
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println("failed" + ex.getMessage());
        }
    }

    // method untuk update data di dalam database
    public void updateData(String name, String path, double writing, double coding, double interview, double totalScore, String status){
        try{
            String query = "UPDATE `recruitment` SET path= '" + path + "',"
            + " writing= '" + writing + "',"
            + " coding= '" + coding + "',"
            + " interview= '" + interview + "',"
            + " score= '" + totalScore + "',"
            + " status= '" + status + "' WHERE name = '" + name + "'";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            System.out.println("update success");

        }catch(Exception ex){
            System.out.println("failed" + ex.getMessage());
        }
    }

    // Metode untuk menghapus data dari database berdasarkan ID
    public void deleteData(String name){
        try{
            String query = "DELETE FROM recruitment WHERE name = '" + name + "'";
            System.out.println(query);
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            System.out.println("Delete Success");
        }catch(Exception ex){
            System.out.println("Delete Failed : " + ex.getMessage());
        }
    }


    public String getName(){
        return name;
    }
    public String getPath(){
        return path;
    }
    public String getStatus(){
        return status;
    }
    public double getWriting(){
        return writing;
    }
    public double getCoding(){
        return coding;
    }
    public double getInterview(){
        return interview;
    }
    public double getTotalScore(){
        return totalScore;
    }
   
}
