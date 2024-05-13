package Assignment2.Model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Assignment2.Connector;
import Assignment2.Controller.Controller;

public class StudentModel extends Connector {
    private int nim, age;
    private String name;
    private Statement statement;

    public StudentModel(int nim, String name, int age) {
        this.nim = nim;
        this.name = name;
        this.age = age;
    }

    //constuctor kosong biar instance model bisa di panggil di controller
    public StudentModel(Controller controller) {
        
    }

    // method untuk membaca data mahasiswa dari database
    @SuppressWarnings("finally")
    public String[][] readData() {
        String data[][] = new String[100][4];
        try {
            int totalData = 0;
            String query = "SELECT * FROM student";
            statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                data[totalData][0] = resultSet.getString("id");
                data[totalData][1] = resultSet.getString("nim");
                data[totalData][2] = resultSet.getString("name");
                data[totalData][3] = resultSet.getString("age");
                totalData++;
            }
            statement.close();
        } catch (SQLException e) {
            System.out.println("SQL Error : " + e.getMessage());
        } finally {
            return data;
        }
    }

    // method untuk insert data mahasiswa baru ke dalam database
    public void insertData(int nim, String name, int age) {
        try {
            String query = "INSERT INTO `student`(`nim`,`name`,`age`) VALUES ('" + nim + "','" + name + "','" + age
                    + "')";
            statement = conn.createStatement();
            statement.executeUpdate(query);
        } catch (Exception ex) {
            System.out.println("failed" + ex.getMessage());
        }
    }

    // method untuk update data mahasiswa di dalam database
    public void updateData(int  id, int nim, String name, int age){
        try{
            String query = "UPDATE `student` SET nim= '" + nim+ "',"
                    + " name= '" + name+ "',"
                    + " age= '" + age+ "' WHERE id = '" + id + "'";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            System.out.println("update success");

        }catch(Exception ex){
            System.out.println("failed" + ex.getMessage());
        }
    }

    // Metode untuk menghapus data mahasiswa dari database berdasarkan ID
    public void deleteData(int id){
        try{
            String query = "DELETE FROM `student` WHERE id='" + id + "'";
            
            statement = conn.createStatement();
            statement.executeUpdate(query);
            
            System.out.println("Delete Success");
        }catch(Exception ex){
            System.out.println("Delete Failed : " + ex.getMessage());
        }
    }

    // getter dan setter jika diperlukan
    public int getNim() {
        return nim;
    }

    public void setNim(int nim) {
        this.nim = nim;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
